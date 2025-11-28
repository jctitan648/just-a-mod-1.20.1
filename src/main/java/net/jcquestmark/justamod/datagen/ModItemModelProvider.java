package net.jcquestmark.justamod.datagen;

import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.item.ModItems;
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

        handheldItem(ModItems.WOODEN_SWORD_T2);
        handheldItem(ModItems.WOODEN_AXE_T2);
        handheldItem(ModItems.WOODEN_PICKAXE_T2);
        handheldItem(ModItems.WOODEN_SHOVEL_T2);
        handheldItem(ModItems.WOODEN_HOE_T2);

        handheldItem(ModItems.WOODEN_SWORD_T3);
        handheldItem(ModItems.WOODEN_AXE_T3);
        handheldItem(ModItems.WOODEN_PICKAXE_T3);
        handheldItem(ModItems.WOODEN_SHOVEL_T3);
        handheldItem(ModItems.WOODEN_HOE_T3);

        handheldItem(ModItems.WOODEN_SWORD_T4);
        handheldItem(ModItems.WOODEN_AXE_T4);
        handheldItem(ModItems.WOODEN_PICKAXE_T4);
        handheldItem(ModItems.WOODEN_SHOVEL_T4);
        handheldItem(ModItems.WOODEN_HOE_T4);

        handheldItem(ModItems.WOODEN_SWORD_T5);
        handheldItem(ModItems.WOODEN_AXE_T5);
        handheldItem(ModItems.WOODEN_PICKAXE_T5);
        handheldItem(ModItems.WOODEN_SHOVEL_T5);
        handheldItem(ModItems.WOODEN_HOE_T5);
    }

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
