package net.jcquestmark.justamod.init;

import net.jcquestmark.justamod.JustAMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JustAMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> JUSTAMOD_ITEM_TAB = CREATIVE_MODE_TABS.register("justamod_item_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.justamod_item_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());

                        pOutput.accept(ModBlocks.COMPRESSED_PLANKS.get());
                        pOutput.accept(ModBlocks.DOUBLE_COMPRESSED_WOOD.get());
                        pOutput.accept(ModBlocks.WOOD_CONGLOMERATE.get());
                        pOutput.accept(ModItems.WOODEN_CORE.get());

                        pOutput.accept(ModBlocks.COBBLED_STONE_BRICKS.get());
                        pOutput.accept(ModBlocks.COMPRESSED_STONE.get());
                        pOutput.accept(ModBlocks.STONE_CORE_BLOCK.get());
                        pOutput.accept(ModItems.CHIPPED_STONE_CORE.get());
                        pOutput.accept(ModItems.GILDED_STONE_CORE.get());

                        pOutput.accept(ModItems.STEEL_INGOT.get());
                        pOutput.accept(ModItems.STEEL_NUGGET.get());
                        pOutput.accept(ModBlocks.STEEL_BLOCK.get());
                        pOutput.accept(ModItems.CARBON_STEEL_PIECE.get());
                        pOutput.accept(ModItems.CARBON_STEEL_INGOT.get());
                        pOutput.accept(ModBlocks.CARBON_STEEL_BLOCK.get());
                        pOutput.accept(ModItems.SMALL_STEEL_SPIKE.get());
                        pOutput.accept(ModItems.STEEL_SPIKE_BUNCH.get());
                        pOutput.accept(ModItems.REINFORCED_STEEL_CORE.get());

                        pOutput.accept(ModItems.ROUGH_POWER_COAL.get());
                        pOutput.accept(ModItems.POWER_COAL.get());

                        pOutput.accept(ModBlocks.MACHINE_BASE.get());
                        pOutput.accept(ModBlocks.COMPRESSOR_T1_MACHINE.get());
                        pOutput.accept(ModBlocks.INFUSER_T1_MACHINE.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> JUSTAMOD_TOOL_TAB = CREATIVE_MODE_TABS.register("justamod_tool_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WOODEN_SWORD_T2.get()))
                    .title(Component.translatable("creativetab.justamod_tool_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.WOODEN_SWORD_T2.get());
                        pOutput.accept(ModItems.WOODEN_AXE_T2.get());
                        pOutput.accept(ModItems.WOODEN_PICKAXE_T2.get());
                        pOutput.accept(ModItems.WOODEN_SHOVEL_T2.get());
                        pOutput.accept(ModItems.WOODEN_HOE_T2.get());

                        pOutput.accept(ModItems.WOODEN_SWORD_T3.get());
                        pOutput.accept(ModItems.WOODEN_AXE_T3.get());
                        pOutput.accept(ModItems.WOODEN_PICKAXE_T3.get());
                        pOutput.accept(ModItems.WOODEN_SHOVEL_T3.get());
                        pOutput.accept(ModItems.WOODEN_HOE_T3.get());

                        pOutput.accept(ModItems.WOODEN_SWORD_T4.get());
                        pOutput.accept(ModItems.WOODEN_AXE_T4.get());
                        pOutput.accept(ModItems.WOODEN_PICKAXE_T4.get());
                        pOutput.accept(ModItems.WOODEN_SHOVEL_T4.get());
                        pOutput.accept(ModItems.WOODEN_HOE_T4.get());

                        pOutput.accept(ModItems.WOODEN_SWORD_T5.get());
                        pOutput.accept(ModItems.WOODEN_AXE_T5.get());
                        pOutput.accept(ModItems.WOODEN_PICKAXE_T5.get());
                        pOutput.accept(ModItems.WOODEN_SHOVEL_T5.get());
                        pOutput.accept(ModItems.WOODEN_HOE_T5.get());

                        pOutput.accept(ModItems.WOODEN_SWORD_T6.get());
                        pOutput.accept(ModItems.WOODEN_AXE_T6.get());
                        pOutput.accept(ModItems.WOODEN_PICKAXE_T6.get());
                        pOutput.accept(ModItems.WOODEN_SHOVEL_T6.get());
                        pOutput.accept(ModItems.WOODEN_HOE_T6.get());

                        pOutput.accept(ModItems.STONE_SWORD_T2.get());
                        pOutput.accept(ModItems.STONE_AXE_T2.get());
                        pOutput.accept(ModItems.STONE_PICKAXE_T2.get());
                        pOutput.accept(ModItems.STONE_SHOVEL_T2.get());
                        pOutput.accept(ModItems.STONE_HOE_T2.get());

                        pOutput.accept(ModItems.STONE_SWORD_T3.get());
                        pOutput.accept(ModItems.STONE_AXE_T3.get());
                        pOutput.accept(ModItems.STONE_PICKAXE_T3.get());
                        pOutput.accept(ModItems.STONE_SHOVEL_T3.get());
                        pOutput.accept(ModItems.STONE_HOE_T3.get());

                        pOutput.accept(ModItems.STONE_SWORD_T4.get());
                        pOutput.accept(ModItems.STONE_AXE_T4.get());
                        pOutput.accept(ModItems.STONE_PICKAXE_T4.get());
                        pOutput.accept(ModItems.STONE_SHOVEL_T4.get());
                        pOutput.accept(ModItems.STONE_HOE_T4.get());

                        pOutput.accept(ModItems.STONE_SWORD_T5.get());
                        pOutput.accept(ModItems.STONE_AXE_T5.get());
                        pOutput.accept(ModItems.STONE_PICKAXE_T5.get());
                        pOutput.accept(ModItems.STONE_SHOVEL_T5.get());
                        pOutput.accept(ModItems.STONE_HOE_T5.get());

                        pOutput.accept(ModItems.STONE_SWORD_T6.get());
                        pOutput.accept(ModItems.STONE_AXE_T6.get());
                        pOutput.accept(ModItems.STONE_PICKAXE_T6.get());
                        pOutput.accept(ModItems.STONE_SHOVEL_T6.get());
                        pOutput.accept(ModItems.STONE_HOE_T6.get());

                        pOutput.accept(ModItems.IRON_SWORD_T2.get());
                        pOutput.accept(ModItems.IRON_AXE_T2.get());
                        pOutput.accept(ModItems.IRON_PICKAXE_T2.get());
                        pOutput.accept(ModItems.IRON_SHOVEL_T2.get());
                        pOutput.accept(ModItems.IRON_HOE_T2.get());
                        
                        pOutput.accept(ModItems.IRON_SWORD_T3.get());
                        pOutput.accept(ModItems.IRON_AXE_T3.get());
                        pOutput.accept(ModItems.IRON_PICKAXE_T3.get());
                        pOutput.accept(ModItems.IRON_SHOVEL_T3.get());
                        pOutput.accept(ModItems.IRON_HOE_T3.get());

                        pOutput.accept(ModItems.IRON_SWORD_T4.get());
                        pOutput.accept(ModItems.IRON_AXE_T4.get());
                        pOutput.accept(ModItems.IRON_PICKAXE_T4.get());
                        pOutput.accept(ModItems.IRON_SHOVEL_T4.get());
                        pOutput.accept(ModItems.IRON_HOE_T4.get());

                        pOutput.accept(ModItems.IRON_SWORD_T5.get());
                        pOutput.accept(ModItems.IRON_AXE_T5.get());
                        pOutput.accept(ModItems.IRON_PICKAXE_T5.get());
                        pOutput.accept(ModItems.IRON_SHOVEL_T5.get());
                        pOutput.accept(ModItems.IRON_HOE_T5.get());

                        pOutput.accept(ModItems.IRON_SWORD_T6.get());
                        pOutput.accept(ModItems.IRON_AXE_T6.get());
                        pOutput.accept(ModItems.IRON_PICKAXE_T6.get());
                        pOutput.accept(ModItems.IRON_SHOVEL_T6.get());
                        pOutput.accept(ModItems.IRON_HOE_T6.get());

                        pOutput.accept(ModItems.IRON_SWORD_T7.get());
                        pOutput.accept(ModItems.IRON_AXE_T7.get());
                        pOutput.accept(ModItems.IRON_PICKAXE_T7.get());
                        pOutput.accept(ModItems.IRON_SHOVEL_T7.get());
                        pOutput.accept(ModItems.IRON_HOE_T7.get());

                        pOutput.accept(ModItems.IRON_SWORD_T8.get());
                        pOutput.accept(ModItems.IRON_AXE_T8.get());
                        pOutput.accept(ModItems.IRON_PICKAXE_T8.get());
                        pOutput.accept(ModItems.IRON_SHOVEL_T8.get());
                        pOutput.accept(ModItems.IRON_HOE_T8.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
