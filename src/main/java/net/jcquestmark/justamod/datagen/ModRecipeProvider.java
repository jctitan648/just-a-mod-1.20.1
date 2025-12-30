package net.jcquestmark.justamod.datagen;

import net.jcquestmark.justamod.init.ModBlocks;
import net.jcquestmark.justamod.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    private final RecipeLines recipeLines = new RecipeLines();

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COMPRESSED_PLANKS.get())
                .pattern("000")
                .pattern("010")
                .pattern("000")
                .define('0',ItemTags.PLANKS).define('1',ItemTags.LOGS)
                .unlockedBy(getHasName(Blocks.OAK_PLANKS), has(Blocks.OAK_PLANKS))
                .save(pWriter);     // Compressed Planks
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DOUBLE_COMPRESSED_WOOD.get())
                .pattern("000")
                .pattern("010")
                .pattern("000")
                .define('0',ModBlocks.COMPRESSED_PLANKS.get()).define('1',ItemTags.LOGS)
                .unlockedBy(getHasName(ModBlocks.COMPRESSED_PLANKS.get()), has(ModBlocks.COMPRESSED_PLANKS.get()))
                .save(pWriter);     // Double Compressed Wood
        SimpleCookingRecipeBuilder.blasting(
                Ingredient.of(ModBlocks.DOUBLE_COMPRESSED_WOOD.get()), RecipeCategory.MISC,
                ModBlocks.WOOD_CONGLOMERATE.get(), 1.5f, 400)
                .unlockedBy(getHasName(ModBlocks.DOUBLE_COMPRESSED_WOOD.get()), has(ModBlocks.DOUBLE_COMPRESSED_WOOD.get()))
                .save(pWriter);     // Wood Conglomerate (Blasting)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COBBLED_STONE_BRICKS.get())
                .pattern("010")
                .pattern("101")
                .pattern("010")
                .define('0',ItemTags.STONE_TOOL_MATERIALS).define('1',ItemTags.STONE_BRICKS)
                .unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS))
                .save(pWriter);     // Cobbled Stone Bricks
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COMPRESSED_STONE.get())
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .define('0',ModBlocks.COBBLED_STONE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.COBBLED_STONE_BRICKS.get()), has(ModBlocks.COBBLED_STONE_BRICKS.get()))
                .save(pWriter);     // Compressed Stone

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
                .requires(ModItems.STEEL_INGOT.get(), 9)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                .save(pWriter);     // Steel Ingot -> Steel Block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT.get())
                .requires(ModItems.STEEL_NUGGET.get(), 9)
                .unlockedBy(getHasName(ModItems.STEEL_NUGGET.get()), has(ModItems.STEEL_NUGGET.get()))
                .save(pWriter);     // Steel Nugget -> Steel Ingot
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_NUGGET.get(), 9)
                .requires(ModItems.STEEL_INGOT.get())
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                .save(pWriter);     // Steel Ingot -> Steel Nugget

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STEEL_SPIKE_BUNCH.get())
                .pattern("111")
                .pattern("111")
                .pattern("000")
                .define('0',ModBlocks.STEEL_BLOCK.get()).define('1',ModItems.SMALL_STEEL_SPIKE.get())
                .unlockedBy(getHasName(ModItems.SMALL_STEEL_SPIKE.get()), has(ModItems.SMALL_STEEL_SPIKE.get()))
                .save(pWriter);     // Steel Spike Bunch

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROUGH_POWER_COAL.get())
                .pattern("101")
                .pattern("010")
                .pattern("101")
                .define('0',Items.COAL).define('1',Items.REDSTONE)
                .unlockedBy(getHasName(ModBlocks.MACHINE_BASE.get()), has(ModBlocks.MACHINE_BASE.get()))
                .save(pWriter);     // Rough Power Coal

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MACHINE_BASE.get())
                .pattern("010")
                .pattern("121")
                .pattern("010")
                .define('0',Blocks.STONE_BRICKS).define('1', Items.IRON_INGOT).define('2',Blocks.IRON_BLOCK)
                .unlockedBy(getHasName(Blocks.IRON_BLOCK), has(Blocks.IRON_BLOCK))
                .save(pWriter);     // Machine Base

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COMPRESSOR_T1_MACHINE.get())
                .pattern("010")
                .pattern("0B0")
                .pattern("020")
                .define('0',Items.REDSTONE).define('1', Blocks.ANVIL).define('2', Blocks.IRON_BLOCK)
                .define('B',ModBlocks.MACHINE_BASE.get())
                .unlockedBy(getHasName(ModBlocks.MACHINE_BASE.get()), has(ModBlocks.MACHINE_BASE.get()))
                .save(pWriter);     // Material Compressor (Tier 1)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.INFUSER_T1_MACHINE.get())
                .pattern("000")
                .pattern("1B1")
                .pattern("020")
                .define('0',Items.REDSTONE).define('1', Blocks.IRON_BLOCK).define('2', Blocks.MAGMA_BLOCK)
                .define('B',ModBlocks.MACHINE_BASE.get())
                .unlockedBy(getHasName(ModBlocks.MACHINE_BASE.get()), has(ModBlocks.MACHINE_BASE.get()))
                .save(pWriter);     // Material Infuser (Tier 1)

        for (int i = 0; i < recipeLines.getTierSetLength(RecipeLines.TierSet.WoodT2Set); i++) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.WoodT2Set[i])
                    .pattern("010")
                    .pattern("1T1")
                    .pattern("010")
                    .define('0', ItemTags.PLANKS).define('1', ItemTags.LOGS)
                    .define('T', recipeLines.WoodT1Set[i])
                    .unlockedBy(getHasName(recipeLines.WoodT1Set[i]), has(recipeLines.WoodT1Set[i]))
                    .save(pWriter);
        }   // Wood Tools Lv1 -> Lv2
        for (int i = 0; i < recipeLines.getTierSetLength(RecipeLines.TierSet.WoodT3Set); i++) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.WoodT3Set[i])
                    .pattern("010")
                    .pattern("1T1")
                    .pattern("010")
                    .define('0', ItemTags.LOGS).define('1', ModBlocks.COMPRESSED_PLANKS.get())
                    .define('T', recipeLines.WoodT2Set[i])
                    .unlockedBy(getHasName(recipeLines.WoodT2Set[i]), has(recipeLines.WoodT2Set[i]))
                    .save(pWriter);
        }   // Wood Tools Lv2 -> Lv3
        for (int i = 0; i < recipeLines.getTierSetLength(RecipeLines.TierSet.WoodT4Set); i++) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.WoodT4Set[i])
                    .pattern("000")
                    .pattern("1T1")
                    .pattern("000")
                    .define('0', ModBlocks.COMPRESSED_PLANKS.get()).define('1', ModBlocks.DOUBLE_COMPRESSED_WOOD.get())
                    .define('T', recipeLines.WoodT3Set[i])
                    .unlockedBy(getHasName(recipeLines.WoodT3Set[i]), has(recipeLines.WoodT3Set[i]))
                    .save(pWriter);
        }   // Wood Tools Lv3 -> Lv4
        for (int i = 0; i < recipeLines.getTierSetLength(RecipeLines.TierSet.WoodT5Set); i++) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.WoodT5Set[i])
                    .pattern(" 0 ")
                    .pattern("0T0")
                    .pattern(" 0 ")
                    .define('0', ModBlocks.WOOD_CONGLOMERATE.get())
                    .define('T', recipeLines.WoodT4Set[i])
                    .unlockedBy(getHasName(recipeLines.WoodT4Set[i]), has(recipeLines.WoodT4Set[i]))
                    .save(pWriter);
        }   // Wood Tools Lv4 -> Lv5

        for (int i = 0; i < recipeLines.getTierSetLength(RecipeLines.TierSet.StoneT2Set); i++) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.StoneT2Set[i])
                    .pattern("000")
                    .pattern("0T0")
                    .pattern("000")
                    .define('0', ItemTags.STONE_TOOL_MATERIALS)
                    .define('T', recipeLines.StoneT1Set[i])
                    .unlockedBy(getHasName(recipeLines.StoneT1Set[i]), has(recipeLines.StoneT1Set[i]))
                    .save(pWriter);
        }   // Stone Tools Lv1 -> Lv2
        for (int i = 0; i < recipeLines.getTierSetLength(RecipeLines.TierSet.StoneT3Set); i++) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.StoneT3Set[i])
                    .pattern("000")
                    .pattern("0T0")
                    .pattern("000")
                    .define('0', ModBlocks.COBBLED_STONE_BRICKS.get())
                    .define('T', recipeLines.StoneT2Set[i])
                    .unlockedBy(getHasName(recipeLines.StoneT2Set[i]), has(recipeLines.StoneT2Set[i]))
                    .save(pWriter);
        }   // Stone Tools Lv2 -> Lv3
        for (int i = 0; i < recipeLines.getTierSetLength(RecipeLines.TierSet.StoneT4Set); i++) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.StoneT4Set[i])
                    .pattern("010")
                    .pattern("1T1")
                    .pattern("010")
                    .define('0', ModBlocks.COBBLED_STONE_BRICKS.get()).define('1', ModBlocks.COMPRESSED_STONE.get())
                    .define('T', recipeLines.StoneT3Set[i])
                    .unlockedBy(getHasName(recipeLines.StoneT3Set[i]), has(recipeLines.StoneT3Set[i]))
                    .save(pWriter);
        }   // Stone Tools Lv3 -> Lv4
        for (int i = 0; i < recipeLines.getTierSetLength(RecipeLines.TierSet.StoneT5Set); i++) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.StoneT5Set[i])
                    .pattern(" 1 ")
                    .pattern("0T0")
                    .pattern(" 0 ")
                    .define('0', ModBlocks.COMPRESSED_STONE.get()).define('1', ModBlocks.STONE_CORE_BLOCK.get())
                    .define('T', recipeLines.StoneT4Set[i])
                    .unlockedBy(getHasName(recipeLines.StoneT4Set[i]), has(recipeLines.StoneT4Set[i]))
                    .save(pWriter);
        }   // Stone Tools Lv4 -> Lv5

        for (int i = 0; i < recipeLines.getTierSetLength(RecipeLines.TierSet.IronT8Set); i++) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.IronT2Set[i])
                    .pattern("000")
                    .pattern("0T0")
                    .pattern("000")
                    .define('0', Items.IRON_INGOT)
                    .define('T', recipeLines.IronT1Set[i])
                    .unlockedBy(getHasName(recipeLines.IronT1Set[i]), has(recipeLines.IronT1Set[i]))
                    .save(pWriter); // Lv1 -> Lv2
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.IronT3Set[i])
                    .pattern("010")
                    .pattern("1T1")
                    .pattern("010")
                    .define('0', Items.IRON_INGOT).define('1', Blocks.IRON_BLOCK)
                    .define('T', recipeLines.IronT2Set[i])
                    .unlockedBy(getHasName(recipeLines.IronT2Set[i]), has(recipeLines.IronT2Set[i]))
                    .save(pWriter); // Lv2 -> Lv3
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.IronT4Set[i])
                    .pattern("000")
                    .pattern("0T0")
                    .pattern("000")
                    .define('0', Items.IRON_BLOCK)
                    .define('T', recipeLines.IronT3Set[i])
                    .unlockedBy(getHasName(recipeLines.IronT3Set[i]), has(recipeLines.IronT3Set[i]))
                    .save(pWriter); // Lv3 -> Lv4
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.IronT5Set[i])
                    .pattern("000")
                    .pattern("0T0")
                    .pattern("000")
                    .define('0', ModBlocks.STEEL_BLOCK.get())
                    .define('T', recipeLines.IronT4Set[i])
                    .unlockedBy(getHasName(recipeLines.IronT4Set[i]), has(recipeLines.IronT4Set[i]))
                    .save(pWriter); // Lv4 -> Lv5
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.IronT6Set[i])
                    .pattern("010")
                    .pattern("0T0")
                    .pattern("010")
                    .define('0', ModItems.STEEL_SPIKE_BUNCH.get()).define('1', ModItems.CARBON_STEEL_INGOT.get())
                    .define('T', recipeLines.IronT5Set[i])
                    .unlockedBy(getHasName(recipeLines.IronT5Set[i]), has(recipeLines.IronT5Set[i]))
                    .save(pWriter); // Lv5 -> Lv6
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.IronT7Set[i])
                    .pattern("000")
                    .pattern("1T1")
                    .pattern("000")
                    .define('0', ModItems.CARBON_STEEL_INGOT.get()).define('1', ModBlocks.CARBON_STEEL_BLOCK.get())
                    .define('T', recipeLines.IronT6Set[i])
                    .unlockedBy(getHasName(recipeLines.IronT6Set[i]), has(recipeLines.IronT6Set[i]))
                    .save(pWriter); // Lv6 -> Lv7
        }   // Iron Tool Line
    }
}
