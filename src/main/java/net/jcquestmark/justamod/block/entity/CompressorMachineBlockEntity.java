package net.jcquestmark.justamod.block.entity;

import net.jcquestmark.justamod.init.ModBlockEntities;
import net.jcquestmark.justamod.init.ModBlocks;
import net.jcquestmark.justamod.init.ModItems;
import net.jcquestmark.justamod.recipe.CompressingRecipe;
import net.jcquestmark.justamod.screen.CompressorMachineMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CompressorMachineBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(6);

    private static final int FUEL_SLOT = 0;
    private static final int INPUT_SLOT_1 = 1;
    private static final int INPUT_SLOT_2 = 2;
    private static final int INPUT_SLOT_3 = 3;
    private static final int INPUT_SLOT_4 = 4;
    private static final int OUTPUT_SLOT = 5;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private double progress = 0.0;
    private double maxProgress = 400.0;
    private double fuelAmount = 0.0;
    private double fuelCapacity = 8000.0;
    private int tier = 1;

    public CompressorMachineBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.COMPRESSOR_MACHINE_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> (int)CompressorMachineBlockEntity.this.progress;
                    case 1 -> (int)CompressorMachineBlockEntity.this.maxProgress;
                    case 2 -> (int)CompressorMachineBlockEntity.this.fuelAmount;
                    case 3 -> (int)CompressorMachineBlockEntity.this.fuelCapacity;
                    case 4 -> CompressorMachineBlockEntity.this.tier;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> CompressorMachineBlockEntity.this.progress = pValue;
                    case 1 -> CompressorMachineBlockEntity.this.maxProgress = pValue;
                    case 2 -> CompressorMachineBlockEntity.this.fuelAmount = pValue;
                    case 3 -> CompressorMachineBlockEntity.this.fuelCapacity = pValue;
                    case 4 -> CompressorMachineBlockEntity.this.tier = pValue;
                }
            }

            @Override
            public int getCount() {
                return 5;
            }
        };
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.justamod.material_compressor");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new CompressorMachineMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putDouble("compressor_block.progress", progress);
        pTag.putDouble("compressor_block.fuel_amount", fuelAmount);
        pTag.putInt("compressor_block.tier", tier);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getDouble("compressor_block.progress");
        fuelAmount = pTag.getDouble("compressor_block.fuel_amount");
        tier = pTag.getInt("compressor_block.tier");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(hasRecipe()) {
            increaseCompressingProgress();
            setChanged(pLevel, pPos, pState);

            if(hasProgressFinished()) {
                compressItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private boolean hasRecipe() {
        Optional<CompressingRecipe> recipe = getCurrentRecipe();

        if(recipe.isEmpty()) {
            return false;
        }
        ItemStack result = recipe.get().getResultItem(null);

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private Optional<CompressingRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(CompressingRecipe.Type.INSTANCE, inventory, level);
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    private void compressItem() {
        Optional<CompressingRecipe> recipe = getCurrentRecipe();
        ItemStack result = recipe.get().getResultItem(null);

        this.itemHandler.extractItem(INPUT_SLOT_1, recipe.get().getIngredientAmount(0), false);
        this.itemHandler.extractItem(INPUT_SLOT_2, recipe.get().getIngredientAmount(1), false);
        this.itemHandler.extractItem(INPUT_SLOT_3, recipe.get().getIngredientAmount(2), false);
        this.itemHandler.extractItem(INPUT_SLOT_4, recipe.get().getIngredientAmount(3), false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private void increaseCompressingProgress() {
        progress += 1.0;
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void resetProgress() {
        progress = 0.0;
    }

    private void loseProgress() {
        progress -= progress > 0 ? Math.min(progress, maxProgress * 0.005) : 0;
    }
}
