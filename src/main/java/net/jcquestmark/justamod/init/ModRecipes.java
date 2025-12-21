package net.jcquestmark.justamod.init;

import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.recipe.CompressingRecipe;
import net.jcquestmark.justamod.recipe.InfusingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, JustAMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<CompressingRecipe>> COMPRESSING_SERIALIZER =
            SERIALIZERS.register("material_compressing", () -> CompressingRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<InfusingRecipe>> INFUSING_SERIALIZER =
            SERIALIZERS.register("material_infusing", () -> InfusingRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
