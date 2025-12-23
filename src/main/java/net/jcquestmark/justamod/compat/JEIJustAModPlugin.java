package net.jcquestmark.justamod.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.recipe.CompressingRecipe;
import net.jcquestmark.justamod.recipe.InfusingRecipe;
import net.jcquestmark.justamod.screen.CompressorMachineScreen;
import net.jcquestmark.justamod.screen.InfuserMachineScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIJustAModPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(JustAMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CompressingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new InfusingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<CompressingRecipe> compressingRecipes = recipeManager.getAllRecipesFor(CompressingRecipe.Type.INSTANCE);
        registration.addRecipes(CompressingCategory.COMPRESSING_RECIPE_TYPE, compressingRecipes);
        List<InfusingRecipe> infusingRecipes = recipeManager.getAllRecipesFor(InfusingRecipe.Type.INSTANCE);
        registration.addRecipes(InfusingCategory.INFUSING_RECIPE_TYPE, infusingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(CompressorMachineScreen.class, 82, 36, 28, 16,
                CompressingCategory.COMPRESSING_RECIPE_TYPE);
        registration.addRecipeClickArea(InfuserMachineScreen.class, 65, 31, 46, 26,
                InfusingCategory.INFUSING_RECIPE_TYPE);
    }
}
