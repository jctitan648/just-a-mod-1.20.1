package net.jcquestmark.justamod.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.jcquestmark.justamod.JustAMod;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class InfusingRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final int infusingTime;
    private final ResourceLocation id;

    public InfusingRecipe(NonNullList<Ingredient> inputItems, ItemStack output, int infusingTime, ResourceLocation id) {
        this.inputItems = inputItems;
        this.output = output;
        this.infusingTime = infusingTime;
        this.id = id;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()){
            return false;
        }

        boolean input_1 = inputItems.get(0).test(pContainer.getItem(1)) &&
                pContainer.getItem(1).getCount() >= getIngredientAmount(0);
        boolean input_2 = inputItems.get(1).test(pContainer.getItem(2)) &&
                pContainer.getItem(2).getCount() >= getIngredientAmount(1);

        return input_1 && input_2;
    }

    public int getIngredientAmount(int index) {
        ItemStack[] stacks = inputItems.get(index).getItems();
        for(ItemStack stack : stacks) {
            return stack.getCount();
        }
        return 0;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return inputItems;
    }

    public int getMaxProgress() {
        return this.infusingTime;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<InfusingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "material_infusing";
    }

    public static class Serializer implements RecipeSerializer<InfusingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(JustAMod.MOD_ID, "material_infusing");


        @Override
        public InfusingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result"));

            for(int i = 0; i < inputs.size(); i++) {
                Ingredient ingredient = getIngredient(ingredients.get(i).getAsJsonObject());
                inputs.set(i, ingredient);
            }

            int infusingTime = GsonHelper.getAsInt(pSerializedRecipe, "infusing_time", 600);

            return new InfusingRecipe(inputs, output, infusingTime, pRecipeId);
        }

        private Ingredient getIngredient(JsonObject jsonObject) {
            Ingredient ingredient = Ingredient.fromJson(jsonObject);
            int count = 1;

            if (jsonObject.getAsJsonObject().has("count")) {
                count = GsonHelper.getAsInt(jsonObject, "count");
            }

            ItemStack itemStack = ingredient.getItems()[0];
            itemStack.setCount(count);

            return ingredient;
        }

        @Override
        public @Nullable InfusingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            int infusingTime = pBuffer.readInt();
            ItemStack output = pBuffer.readItem();
            return new InfusingRecipe(inputs, output, infusingTime, pRecipeId);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, InfusingRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.inputItems.size());

            for (Ingredient ingredient : pRecipe.getIngredients()) {
                ingredient.toNetwork(pBuffer);
            }

            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
        }
    }
}
