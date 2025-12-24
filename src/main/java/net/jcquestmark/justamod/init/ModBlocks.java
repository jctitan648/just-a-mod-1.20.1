package net.jcquestmark.justamod.init;

import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.block.machines.CompressorT1MachineBlock;
import net.jcquestmark.justamod.block.machines.InfuserT1MachineBlock;
import net.jcquestmark.justamod.block.materials.MachineBaseBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("Convert2MethodRef")
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, JustAMod.MOD_ID);

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> COMPRESSED_PLANKS = registerBlock("compressed_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(3F, 7.5F)));
    public static final RegistryObject<Block> DOUBLE_COMPRESSED_WOOD = registerBlock("double_compressed_wood",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(5.5F, 14.5F)));
    public static final RegistryObject<Block> WOOD_CONGLOMERATE = registerBlock("wood_conglomerate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_HYPHAE).strength(10F, 30F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MACHINE_BASE = registerBlock("material_machine_base",
            () -> new MachineBaseBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> COBBLED_STONE_BRICKS = registerBlock("cobbled_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).strength(3F, 9F)));
    public static final RegistryObject<Block> COMPRESSED_STONE = registerBlock("compressed_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(7F, 18F)));
    public static final RegistryObject<Block> STONE_CORE_BLOCK = registerBlock("stone_core_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(20F, 90F)));

    public static final RegistryObject<Block> COMPRESSOR_T1_MACHINE = registerBlock("material_compressor",
            () -> new CompressorT1MachineBlock());
    public static final RegistryObject<Block> INFUSER_T1_MACHINE = registerBlock("material_infuser",
            () -> new InfuserT1MachineBlock());

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
