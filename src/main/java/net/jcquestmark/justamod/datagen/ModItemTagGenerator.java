package net.jcquestmark.justamod.datagen;

import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.init.ModItems;
import net.jcquestmark.justamod.init.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, JustAMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(Tags.Items.INGOTS).add(ModItems.STEEL_INGOT.get(), ModItems.CARBON_STEEL_INGOT.get());
        this.tag(Tags.Items.NUGGETS).add(ModItems.STEEL_NUGGET.get());

        this.tag(ModTags.Items.FUEL_800)
                .add(ModItems.ROUGH_POWER_COAL.get())
                ;
        this.tag(ModTags.Items.FUEL_4000)
                .add(ModItems.POWER_COAL.get())
                ;
        this.tag(ModTags.Items.FUEL_8000)
                ;
    }
}
