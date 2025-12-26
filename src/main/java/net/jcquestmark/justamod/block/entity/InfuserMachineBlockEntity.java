package net.jcquestmark.justamod.block.entity;

import net.jcquestmark.justamod.block.machines.CompressorT1MachineBlock;
import net.jcquestmark.justamod.init.ModBlockEntities;
import net.jcquestmark.justamod.init.ModTags;
import net.jcquestmark.justamod.recipe.InfusingRecipe;
import net.jcquestmark.justamod.screen.InfuserMachineMenu;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class InfuserMachineBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4);

    private static final int FUEL_SLOT = 0;
    private static final int INPUT_SLOT_1 = 1;
    private static final int INPUT_SLOT_2 = 2;
    private static final int OUTPUT_SLOT = 3;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private double progress = 0.0;
    private double maxProgress = 400.0;
    private double fuelAmount = 0.0;
    private double fuelCapacity = 8000.0;
    private double fuelConsumption = 1.0;
    private int tier = 1;

    public InfuserMachineBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.INFUSER_MACHINE_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> (int) InfuserMachineBlockEntity.this.progress;
                    case 1 -> (int) InfuserMachineBlockEntity.this.maxProgress;
                    case 2 -> (int) InfuserMachineBlockEntity.this.fuelAmount;
                    case 3 -> (int) InfuserMachineBlockEntity.this.fuelCapacity;
                    case 4 -> InfuserMachineBlockEntity.this.tier;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> InfuserMachineBlockEntity.this.progress = pValue;
                    case 1 -> InfuserMachineBlockEntity.this.maxProgress = pValue;
                    case 2 -> InfuserMachineBlockEntity.this.fuelAmount = pValue;
                    case 3 -> InfuserMachineBlockEntity.this.fuelCapacity = pValue;
                    case 4 -> InfuserMachineBlockEntity.this.tier = pValue;
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
        return Component.translatable("block.justamod.material_infuser");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new InfuserMachineMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putDouble("infuser_block.progress", progress);
        pTag.putDouble("infuser_block.max_progress", maxProgress);
        pTag.putDouble("infuser_block.fuel_amount", fuelAmount);
        pTag.putDouble("infuser_block.fuel_consumption", fuelConsumption);
        pTag.putInt("infuser_block.tier", tier);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getDouble("infuser_block.progress");
        maxProgress = pTag.getDouble("infuser_block.max_progress");
        fuelAmount = pTag.getDouble("infuser_block.fuel_amount");
        fuelConsumption = pTag.getDouble("infuser_block.fuel_consumption");
        tier = pTag.getInt("infuser_block.tier");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(hasRecipe()) {
            if(checkFuel()) {
                increaseInfusingProgress();
                setLit(pState, true);
                setChanged(pLevel, pPos, pState);
            } else {
                loseProgress();
                setLit(pState, false);
            }

            if(hasProgressFinished()) {
                infuseItem();
                resetProgress();
                setLit(pState, false);
            }
        } else {
            resetProgress();
            setLit(pState, false);
        }

        int fuelItem = fuelSlothasFuel();
        if(fuelItem > 0 && fuelAmount + fuelItem <= fuelCapacity) {
            this.itemHandler.extractItem(FUEL_SLOT, 1, false);
            fuelAmount += fuelItem;
        }
    }

    private void setLit(BlockState pState, boolean litState) {
        switch(tier) {
            case 1 -> pState.setValue(CompressorT1MachineBlock.LIT, litState);
        }
    }

    private boolean checkFuel() {
        return fuelAmount > 0;
    }

    private int fuelSlothasFuel() {
        if(this.itemHandler.getStackInSlot(FUEL_SLOT).getItemHolder().containsTag(ModTags.Items.FUEL_800)) {
            return 800;
        }

        return 0;
    }

    private boolean hasRecipe() {
        Optional<InfusingRecipe> recipe = getCurrentRecipe();

        if(recipe.isEmpty()) {
            return false;
        }
        ItemStack result = recipe.get().getResultItem(null);
        maxProgress = recipe.get().getMaxProgress();

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private Optional<InfusingRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(InfusingRecipe.Type.INSTANCE, inventory, level);
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    private void infuseItem() {
        Optional<InfusingRecipe> recipe = getCurrentRecipe();
        ItemStack result = recipe.get().getResultItem(null);

        this.itemHandler.extractItem(INPUT_SLOT_1, recipe.get().getIngredientAmount(0), false);
        this.itemHandler.extractItem(INPUT_SLOT_2, recipe.get().getIngredientAmount(1), false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private void increaseInfusingProgress() {
        progress += 1.0 * Math.max((tier^2) / 2, 1);
        fuelAmount -= Math.min(fuelAmount, fuelConsumption);
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

    public void setTier(int newTier) {
        tier = newTier;
    }
}
