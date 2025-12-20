package net.jcquestmark.justamod.datagen;

import net.jcquestmark.justamod.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
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
        for (int i = 0; i < recipeLines.getSetLength(RecipeLines.TierSet.WoodT2Set); i++) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.WoodT2Set[i])
                    .pattern("010")
                    .pattern("1T1")
                    .pattern("010")
                    .define('0', ItemTags.PLANKS).define('1', ItemTags.LOGS)
                    .define('T', recipeLines.WoodT1Set[i])
                    .unlockedBy(getHasName(recipeLines.WoodT1Set[i]), has(recipeLines.WoodT1Set[i]))
                    .save(pWriter);
        }   // Wood Tools Lv1 -> Lv2
        for (int i = 0; i < recipeLines.getSetLength(RecipeLines.TierSet.WoodT3Set); i++) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.WoodT3Set[i])
                    .pattern("010")
                    .pattern("1T1")
                    .pattern("010")
                    .define('0', ItemTags.LOGS).define('1', ModBlocks.COMPRESSED_PLANKS.get())
                    .define('T', recipeLines.WoodT2Set[i])
                    .unlockedBy(getHasName(recipeLines.WoodT2Set[i]), has(recipeLines.WoodT2Set[i]))
                    .save(pWriter);
        }   // Wood Tools Lv2 -> Lv3
        for (int i = 0; i < recipeLines.getSetLength(RecipeLines.TierSet.WoodT4Set); i++) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.WoodT4Set[i])
                    .pattern("000")
                    .pattern("1T1")
                    .pattern("000")
                    .define('0', ModBlocks.COMPRESSED_PLANKS.get()).define('1', ModBlocks.DOUBLE_COMPRESSED_WOOD.get())
                    .define('T', recipeLines.WoodT3Set[i])
                    .unlockedBy(getHasName(recipeLines.WoodT3Set[i]), has(recipeLines.WoodT3Set[i]))
                    .save(pWriter);
        }   // Wood Tools Lv3 -> Lv4
        for (int i = 0; i < recipeLines.getSetLength(RecipeLines.TierSet.WoodT5Set); i++) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.WoodT5Set[i])
                    .pattern(" 0 ")
                    .pattern("0T0")
                    .pattern(" 0 ")
                    .define('0', ModBlocks.WOOD_CONGLOMERATE.get())
                    .define('T', recipeLines.WoodT4Set[i])
                    .unlockedBy(getHasName(recipeLines.WoodT4Set[i]), has(recipeLines.WoodT4Set[i]))
                    .save(pWriter);
        }   // Wood Tools Lv4 -> Lv5
    }
}
