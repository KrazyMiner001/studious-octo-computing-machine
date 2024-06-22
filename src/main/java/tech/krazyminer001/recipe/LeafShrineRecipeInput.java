package tech.krazyminer001.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.util.collection.DefaultedList;

public class LeafShrineRecipeInput implements RecipeInput {
    public static final LeafShrineRecipeInput EMPTY = new LeafShrineRecipeInput(DefaultedList.ofSize(0, ItemStack.EMPTY));
    private DefaultedList<ItemStack> items;
    private final RecipeMatcher matcher = new RecipeMatcher();

    private LeafShrineRecipeInput(DefaultedList<ItemStack> items) {
        this.items = items;
    }

    public static LeafShrineRecipeInput of(DefaultedList<ItemStack> items) {
        return new LeafShrineRecipeInput(items);
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
