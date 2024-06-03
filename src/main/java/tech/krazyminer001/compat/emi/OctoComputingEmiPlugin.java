package tech.krazyminer001.compat.emi;

import tech.krazyminer001.block.ModBlocks;
import tech.krazyminer001.compat.emi.recipe.LeafShrineEmiRecipe;
import tech.krazyminer001.recipe.LeafShrineRecipe;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;

public class OctoComputingEmiPlugin implements EmiPlugin {
    @Override
    public void register(EmiRegistry registry) {
        registry.addCategory(LeafShrineEmiRecipe.CATEGORY);
        registry.addWorkstation(LeafShrineEmiRecipe.CATEGORY, EmiStack.of(ModBlocks.LEAF_SHRINE));
        registry.addWorkstation(LeafShrineEmiRecipe.CATEGORY, EmiStack.of(ModBlocks.LEAF_PLINTH));

        RecipeManager manager = registry.getRecipeManager();

        for (RecipeEntry<LeafShrineRecipe> recipe : manager.listAllOfType(LeafShrineRecipe.Type.INSTANCE)) {
            registry.addRecipe(new LeafShrineEmiRecipe(recipe));
        }
    }
}
