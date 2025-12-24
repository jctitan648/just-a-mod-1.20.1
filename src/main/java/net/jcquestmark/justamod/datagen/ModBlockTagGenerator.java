package net.jcquestmark.justamod.datagen;

import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.init.ModBlocks;
import net.jcquestmark.justamod.init.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, JustAMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SAPPHIRE_BLOCK.get())
                .add(ModBlocks.MACHINE_BASE.get())
                .add(ModBlocks.COMPRESSOR_T1_MACHINE.get())
                .add(ModBlocks.INFUSER_T1_MACHINE.get())

                .add(ModBlocks.COBBLED_STONE_BRICKS.get())
                .add(ModBlocks.COMPRESSED_STONE.get())
                .add(ModBlocks.STONE_CORE_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.COMPRESSED_PLANKS.get())
                .add(ModBlocks.DOUBLE_COMPRESSED_WOOD.get())
                .add(ModBlocks.WOOD_CONGLOMERATE.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                ;
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.MACHINE_BASE.get())
                .add(ModBlocks.COMPRESSOR_T1_MACHINE.get())
                .add(ModBlocks.INFUSER_T1_MACHINE.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAPPHIRE_BLOCK.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                ;
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                ;
        this.tag(ModTags.Blocks.NEEDS_TOOL_LV5)
                ;
    }
}
