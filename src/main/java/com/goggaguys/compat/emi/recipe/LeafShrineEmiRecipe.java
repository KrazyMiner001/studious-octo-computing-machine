package com.goggaguys.compat.emi.recipe;

import com.goggaguys.OctoComputing;
import com.goggaguys.compat.emi.OctoComputingEmiPlugin;
import com.goggaguys.compat.emi.recipe.recipeCategory.LeafShrineRecipeCategory;
import com.goggaguys.recipe.LeafShrineRecipe;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class LeafShrineEmiRecipe implements EmiRecipe {
    private final Identifier id;
    private final List<EmiIngredient> input;
    private final List<EmiStack> output;
    public static final LeafShrineRecipeCategory CATEGORY = new LeafShrineRecipeCategory();

    public LeafShrineEmiRecipe(RecipeEntry<LeafShrineRecipe> recipe) {
        this.id = recipe.id();
        this.input = new ArrayList<>();
        recipe.value().getIngredients().forEach(ingredient -> this.input.add(EmiIngredient.of(ingredient)));
        this.output = List.of(EmiStack.of(recipe.value().getOutput()));
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return CATEGORY;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return input;
    }

    @Override
    public List<EmiStack> getOutputs() {
        return output;
    }

    @Override
    public int getDisplayWidth() {
        return 118;
    }

    @Override
    public int getDisplayHeight() {
        return 58;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        // Add an arrow texture to indicate processing
        widgets.addTexture(EmiTexture.EMPTY_ARROW, 66, 21);

        // Adds an input slot on the left
        widgets.addSlot(input.get(0), 20, 20);
        widgets.addSlot(input.get(1), 20, 0);
        widgets.addSlot(input.get(2), 40, 20);
        widgets.addSlot(input.get(3), 20, 40);
        widgets.addSlot(input.get(4), 0, 20);


        // Adds an output slot on the right
        // Note that output slots need to call `recipeContext` to inform EMI about their recipe context
        // This includes being able to resolve recipe trees, favorite stacks with recipe context, and more
        widgets.addSlot(output.getFirst(), 98, 20).recipeContext(this);
    }
}
