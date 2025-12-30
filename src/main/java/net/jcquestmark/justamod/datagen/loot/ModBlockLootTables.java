package net.jcquestmark.justamod.datagen.loot;

import net.jcquestmark.justamod.init.ModBlocks;
import net.jcquestmark.justamod.init.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
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

        this.dropSelf(ModBlocks.COBBLED_STONE_BRICKS.get());
        this.dropSelf(ModBlocks.COMPRESSED_STONE.get());

        this.dropSelf(ModBlocks.STEEL_BLOCK.get());
        this.dropSelf(ModBlocks.CARBON_STEEL_BLOCK.get());

        this.dropSelf(ModBlocks.COMPRESSOR_T1_MACHINE.get());
        this.dropSelf(ModBlocks.INFUSER_T1_MACHINE.get());

        this.add(ModBlocks.STONE_CORE_BLOCK.get(),
                block -> createChippedDrops(ModBlocks.STONE_CORE_BLOCK.get(), ModItems.CHIPPED_STONE_CORE.get(), 3));
    }

    protected LootTable.Builder createChippedDrops(Block pBlock, Item pItem, int amount) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(amount)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
