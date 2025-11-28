package net.jcquestmark.justamod.item;

import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.block.ModBlocks;
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
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
