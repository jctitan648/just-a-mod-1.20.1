package net.jcquestmark.justamod.datagen;

import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JustAMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.WOODEN_CORE);
        simpleItem(ModItems.CHIPPED_STONE_CORE);
        simpleItem(ModItems.GILDED_STONE_CORE);
        simpleItem(ModItems.STEEL_INGOT);
        simpleItem(ModItems.STEEL_NUGGET);
        simpleItem(ModItems.CARBON_STEEL_INGOT);
        simpleItem(ModItems.CARBON_STEEL_PIECE);
        simpleItem(ModItems.SMALL_STEEL_SPIKE);
        simpleItem(ModItems.STEEL_SPIKE_BUNCH);
        simpleItem(ModItems.REINFORCED_STEEL_CORE);

        simpleItem(ModItems.ROUGH_POWER_COAL);
        simpleItem(ModItems.POWER_COAL);

        for (RegistryObject<Item> item : toolItemArray) {
            handheldItem(item);
        }
    }

    @SuppressWarnings("unchecked")
    RegistryObject<Item>[] toolItemArray = new RegistryObject[]{
            ModItems.WOODEN_SWORD_T2, ModItems.WOODEN_AXE_T2, ModItems.WOODEN_PICKAXE_T2, ModItems.WOODEN_SHOVEL_T2, ModItems.WOODEN_HOE_T2,
            ModItems.WOODEN_SWORD_T3, ModItems.WOODEN_AXE_T3, ModItems.WOODEN_PICKAXE_T3, ModItems.WOODEN_SHOVEL_T3, ModItems.WOODEN_HOE_T3,
            ModItems.WOODEN_SWORD_T4, ModItems.WOODEN_AXE_T4, ModItems.WOODEN_PICKAXE_T4, ModItems.WOODEN_SHOVEL_T4, ModItems.WOODEN_HOE_T4,
            ModItems.WOODEN_SWORD_T5, ModItems.WOODEN_AXE_T5, ModItems.WOODEN_PICKAXE_T5, ModItems.WOODEN_SHOVEL_T5, ModItems.WOODEN_HOE_T5,
            ModItems.WOODEN_SWORD_T6, ModItems.WOODEN_AXE_T6, ModItems.WOODEN_PICKAXE_T6, ModItems.WOODEN_SHOVEL_T6, ModItems.WOODEN_HOE_T6,

            ModItems.STONE_SWORD_T2, ModItems.STONE_AXE_T2, ModItems.STONE_PICKAXE_T2, ModItems.STONE_SHOVEL_T2, ModItems.STONE_HOE_T2,
            ModItems.STONE_SWORD_T3, ModItems.STONE_AXE_T3, ModItems.STONE_PICKAXE_T3, ModItems.STONE_SHOVEL_T3, ModItems.STONE_HOE_T3,
            ModItems.STONE_SWORD_T4, ModItems.STONE_AXE_T4, ModItems.STONE_PICKAXE_T4, ModItems.STONE_SHOVEL_T4, ModItems.STONE_HOE_T4,
            ModItems.STONE_SWORD_T5, ModItems.STONE_AXE_T5, ModItems.STONE_PICKAXE_T5, ModItems.STONE_SHOVEL_T5, ModItems.STONE_HOE_T5,
            ModItems.STONE_SWORD_T6, ModItems.STONE_AXE_T6, ModItems.STONE_PICKAXE_T6, ModItems.STONE_SHOVEL_T6, ModItems.STONE_HOE_T6,

            ModItems.IRON_SWORD_T2, ModItems.IRON_AXE_T2, ModItems.IRON_PICKAXE_T2, ModItems.IRON_SHOVEL_T2, ModItems.IRON_HOE_T2,
            ModItems.IRON_SWORD_T3, ModItems.IRON_AXE_T3, ModItems.IRON_PICKAXE_T3, ModItems.IRON_SHOVEL_T3, ModItems.IRON_HOE_T3,
            ModItems.IRON_SWORD_T4, ModItems.IRON_AXE_T4, ModItems.IRON_PICKAXE_T4, ModItems.IRON_SHOVEL_T4, ModItems.IRON_HOE_T4,
            ModItems.IRON_SWORD_T5, ModItems.IRON_AXE_T5, ModItems.IRON_PICKAXE_T5, ModItems.IRON_SHOVEL_T5, ModItems.IRON_HOE_T5,
            ModItems.IRON_SWORD_T6, ModItems.IRON_AXE_T6, ModItems.IRON_PICKAXE_T6, ModItems.IRON_SHOVEL_T6, ModItems.IRON_HOE_T6,
            ModItems.IRON_SWORD_T7, ModItems.IRON_AXE_T7, ModItems.IRON_PICKAXE_T7, ModItems.IRON_SHOVEL_T7, ModItems.IRON_HOE_T7,
            ModItems.IRON_SWORD_T8, ModItems.IRON_AXE_T8, ModItems.IRON_PICKAXE_T8, ModItems.IRON_SHOVEL_T8, ModItems.IRON_HOE_T8,
    };

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(JustAMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(JustAMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
