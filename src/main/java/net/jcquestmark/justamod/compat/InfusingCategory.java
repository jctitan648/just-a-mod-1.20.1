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
import net.jcquestmark.justamod.recipe.InfusingRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class InfusingCategory implements IRecipeCategory<InfusingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(JustAMod.MOD_ID, "material_infusing");
    public static final ResourceLocation TEXTURE = new ResourceLocation(JustAMod.MOD_ID,
            "textures/gui/material_infuser_gui.png");

    public static final RecipeType<InfusingRecipe> INFUSING_RECIPE_TYPE =
            new RecipeType<>(UID, InfusingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public InfusingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.INFUSER_T1_MACHINE.get()));
    }

    @Override
    public RecipeType<InfusingRecipe> getRecipeType() {
        return INFUSING_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.justamod.material_infuser");
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
    public void setRecipe(IRecipeLayoutBuilder builder, InfusingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 27).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 116, 27).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 61).addItemStack(recipe.getResultItem(null));
    }
}
