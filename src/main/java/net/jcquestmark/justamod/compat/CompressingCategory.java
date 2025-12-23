package net.jcquestmark.justamod.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.init.ModBlocks;
import net.jcquestmark.justamod.recipe.CompressingRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class CompressingCategory implements IRecipeCategory<CompressingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(JustAMod.MOD_ID, "material_compressing");
    public static final ResourceLocation TEXTURE = new ResourceLocation(JustAMod.MOD_ID,
            "textures/gui/material_compressor_gui.png");

    public static final RecipeType<CompressingRecipe> COMPRESSING_RECIPE_TYPE =
            new RecipeType<>(UID, CompressingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public CompressingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.COMPRESSOR_T1_MACHINE.get()));
    }

    @Override
    public RecipeType<CompressingRecipe> getRecipeType() {
        return COMPRESSING_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.justamod.material_compressor");
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CompressingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 38, 26).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 57, 26).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 38, 45).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 57, 45).addIngredients(recipe.getIngredients().get(3));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 117, 35).addItemStack(recipe.getResultItem(null));
    }
}
