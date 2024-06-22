package tech.krazyminer001.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.util.collection.DefaultedList;

public class VoidspawnGeneratorRecipeInput implements RecipeInput {
    public static final VoidspawnGeneratorRecipeInput EMPTY = new VoidspawnGeneratorRecipeInput(DefaultedList.ofSize(0, ItemStack.EMPTY));
    private final RecipeMatcher matcher = new RecipeMatcher();
    private DefaultedList<ItemStack> items;

    private VoidspawnGeneratorRecipeInput(DefaultedList<ItemStack> items) {
        this.items = items;
    }

    public static VoidspawnGeneratorRecipeInput of(DefaultedList<ItemStack> items) {
        return new VoidspawnGeneratorRecipeInput(items);
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return items.get(slot);
    }

    @Override
    public int getSize() {
        return items.size();
    }

    public RecipeMatcher getMatcher() {
        return matcher;
    }
}
