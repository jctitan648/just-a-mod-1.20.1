package net.jcquestmark.justamod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    private final RecipeLines recipeLines = new RecipeLines();

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        for (int i = 0; i < recipeLines.getSetLength(); i++) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, recipeLines.WoodT2Set[i])
                    .pattern("010")
                    .pattern("1T1")
                    .pattern("010")
                    .define('0', ItemTags.PLANKS).define('1', ItemTags.LOGS).define('T', recipeLines.WoodT1Set[i])
                    .unlockedBy(getHasName(recipeLines.WoodT1Set[i]), has(recipeLines.WoodT1Set[i]))
                    .save(pWriter);
        }   // Wood Tools Lv1 -> Lv2
    }
}
