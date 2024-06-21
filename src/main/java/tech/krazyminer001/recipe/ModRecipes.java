package tech.krazyminer001.recipe;

import tech.krazyminer001.OctoComputing;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;import static tech.krazyminer001.utility.Util.of;


public class ModRecipes {
    public static RecipeType<LeafShrineRecipe> LEAF_SHRINE_RECIPE_TYPE = registerRecipeType(LeafShrineRecipe.Type.INSTANCE, LeafShrineRecipe.Type.ID);
    public static RecipeSerializer<LeafShrineRecipe> LEAF_SHRINE_RECIPE_SERIALIZER = registerRecipeSerializer(LeafShrineRecipe.Serializer.INSTANCE, LeafShrineRecipe.Serializer.ID);
    public static RecipeType<VoidspawnGeneratorRecipe> VOIDSPAWN_GENERATOR_RECIPE_TYPE = registerRecipeType(VoidspawnGeneratorRecipe.Type.INSTANCE, VoidspawnGeneratorRecipe.Type.ID);
    public static RecipeSerializer<VoidspawnGeneratorRecipe> VOIDSPAWN_GENERATOR_RECIPE_SERIALIZER = registerRecipeSerializer(VoidspawnGeneratorRecipe.Serializer.INSTANCE, VoidspawnGeneratorRecipe.Serializer.ID);

    public static<T extends Recipe<?>> RecipeType<T> registerRecipeType(RecipeType<T> recipeType, String ID) {
        return Registry.register(Registries.RECIPE_TYPE, of(ID), recipeType);
    }

    public static<T extends Recipe<?>> RecipeSerializer<T> registerRecipeSerializer(RecipeSerializer<T> recipeSerializer, String ID) {
        return Registry.register(Registries.RECIPE_SERIALIZER, of(ID), recipeSerializer);
    }

    public static void registerRecipes() {
        OctoComputing.LOGGER.info("Registering recipes for " + OctoComputing.MOD_ID);
    }
}
