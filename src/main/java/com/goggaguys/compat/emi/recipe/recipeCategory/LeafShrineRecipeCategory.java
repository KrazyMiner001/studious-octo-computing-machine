package com.goggaguys.compat.emi.recipe.recipeCategory;

import com.goggaguys.OctoComputing;
import com.goggaguys.block.ModBlocks;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiRenderable;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.util.Identifier;

import java.util.Comparator;

public class LeafShrineRecipeCategory extends EmiRecipeCategory {

    public LeafShrineRecipeCategory() {
        super(new Identifier(OctoComputing.MOD_ID, "leaf_shrine"), EmiStack.of(ModBlocks.LEAF_SHRINE), EmiStack.of(ModBlocks.LEAF_SHRINE));
    }

    public LeafShrineRecipeCategory(Comparator<EmiRecipe> sorter) {
        super(new Identifier(OctoComputing.MOD_ID, "leaf_shrine"), EmiStack.of(ModBlocks.LEAF_SHRINE), EmiStack.of(ModBlocks.LEAF_SHRINE), sorter);
    }
}
