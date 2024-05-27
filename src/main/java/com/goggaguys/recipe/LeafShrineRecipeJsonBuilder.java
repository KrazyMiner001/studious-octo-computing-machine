package com.goggaguys.recipe;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LeafShrineRecipeJsonBuilder implements CraftingRecipeJsonBuilder {
    private final RecipeCategory category;
    private final Item output;
    private final int outputCount;
    private final int craftingTime;
    private final DefaultedList<Ingredient> inputs = DefaultedList.of();
    private final Map<String, AdvancementCriterion<?>> advancementBuilder = new LinkedHashMap<>();
    @Nullable
    private String group;

    public LeafShrineRecipeJsonBuilder(RecipeCategory category, ItemConvertible output, int outputCount, int craftingTime) {
        this.category = category;
        this.output = output.asItem();
        this.outputCount = outputCount;
        this.craftingTime = craftingTime;
    }

    public static LeafShrineRecipeJsonBuilder create(RecipeCategory category, ItemConvertible output) {
        return new LeafShrineRecipeJsonBuilder(category, output, 1, 20);
    }

    public static LeafShrineRecipeJsonBuilder create(RecipeCategory category, ItemConvertible output, int count) {
        return new LeafShrineRecipeJsonBuilder(category, output, count, 20);
    }

    public static LeafShrineRecipeJsonBuilder create(RecipeCategory category, ItemConvertible output, int count, int craftingTime) {
        return new LeafShrineRecipeJsonBuilder(category, output, count, craftingTime);
    }

    //region Inputs
    public LeafShrineRecipeJsonBuilder centerInput(TagKey<Item> tag) {
        return this.centerInput(Ingredient.fromTag(tag));
    }

    public LeafShrineRecipeJsonBuilder centerInput(ItemConvertible itemProvider) {
        this.centerInput(Ingredient.ofItems(itemProvider));

        return this;
    }

    public LeafShrineRecipeJsonBuilder centerInput(Ingredient ingredient) {
        this.inputs.add(ingredient);

        return this;
    }

    public LeafShrineRecipeJsonBuilder northInput(TagKey<Item> tag) {
        return this.northInput(Ingredient.fromTag(tag));
    }

    public LeafShrineRecipeJsonBuilder northInput(ItemConvertible itemProvider) {
        this.northInput(Ingredient.ofItems(itemProvider));

        return this;
    }

    public LeafShrineRecipeJsonBuilder northInput(Ingredient ingredient) {
        this.inputs.add(ingredient);

        return this;
    }

    public LeafShrineRecipeJsonBuilder eastInput(TagKey<Item> tag) {
        return this.eastInput(Ingredient.fromTag(tag));
    }

    public LeafShrineRecipeJsonBuilder eastInput(ItemConvertible itemProvider) {
        this.eastInput(Ingredient.ofItems(itemProvider));

        return this;
    }

    public LeafShrineRecipeJsonBuilder eastInput(Ingredient ingredient) {
        this.inputs.add(ingredient);

        return this;
    }

    public LeafShrineRecipeJsonBuilder southInput(TagKey<Item> tag) {
        return this.southInput(Ingredient.fromTag(tag));
    }

    public LeafShrineRecipeJsonBuilder southInput(ItemConvertible itemProvider) {
        this.southInput(Ingredient.ofItems(itemProvider));

        return this;
    }

    public LeafShrineRecipeJsonBuilder southInput(Ingredient ingredient) {
        this.inputs.add(ingredient);

        return this;
    }

    public LeafShrineRecipeJsonBuilder westInput(TagKey<Item> tag) {
        return this.westInput(Ingredient.fromTag(tag));
    }

    public LeafShrineRecipeJsonBuilder westInput(ItemConvertible itemProvider) {
        this.westInput(Ingredient.ofItems(itemProvider));

        return this;
    }

    public LeafShrineRecipeJsonBuilder westInput(Ingredient ingredient) {
        this.inputs.add(ingredient);

        return this;
    }
    //endregion

    @Override
    public CraftingRecipeJsonBuilder criterion(String name, AdvancementCriterion<?> criterion) {
        this.advancementBuilder.put(name, criterion);
        return this;
    }

    @Override
    public CraftingRecipeJsonBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getOutputItem() {
        return this.output;
    }

    @Override
    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        this.validate(recipeId);
        Advancement.Builder builder = exporter.getAdvancementBuilder().criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
        Map<String, AdvancementCriterion<?>> map = this.advancementBuilder;
        Objects.requireNonNull(builder);
        map.forEach(builder::criterion);
        LeafShrineRecipe recipe = new LeafShrineRecipe(CraftingRecipeJsonBuilder.toCraftingCategory(this.category), this.inputs, this.output, this.outputCount, this.craftingTime);
        exporter.accept(recipeId, recipe, builder.build(recipeId.withPrefixedPath("recipes/" + this.category.getName() + "/")));
    }

    private void validate(Identifier recipeId) {
        if (this.advancementBuilder.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + String.valueOf(recipeId));
        }
    }
}
