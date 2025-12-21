package net.jcquestmark.justamod.datagen.loot;

import net.jcquestmark.justamod.init.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.COMPRESSED_PLANKS.get());
        this.dropSelf(ModBlocks.DOUBLE_COMPRESSED_WOOD.get());
        this.dropSelf(ModBlocks.WOOD_CONGLOMERATE.get());
        this.dropSelf(ModBlocks.MACHINE_BASE.get());

        this.dropSelf(ModBlocks.COMPRESSOR_T1_MACHINE.get());
        this.dropSelf(ModBlocks.INFUSER_T1_MACHINE.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
