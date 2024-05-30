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

public class VoidspawnGeneratorRecipeJsonBuilder implements CraftingRecipeJsonBuilder {

    private final RecipeCategory category;
    private final Item output;
    private final int outputCount;
    private final int craftingTime;
    private final DefaultedList<Ingredient> inputs = DefaultedList.of();
    private final Map<String, AdvancementCriterion<?>> advancementBuilder = new LinkedHashMap<>();
    @Nullable
    private String group;

    public VoidspawnGeneratorRecipeJsonBuilder(RecipeCategory category, ItemConvertible output, int outputCount, int craftingTime) {
        this.category = category;
        this.output = output.asItem();
        this.outputCount = outputCount;
        this.craftingTime = craftingTime;
    }

    public static VoidspawnGeneratorRecipeJsonBuilder create(RecipeCategory category, ItemConvertible output) {
        return new VoidspawnGeneratorRecipeJsonBuilder(category, output, 1, 20);
    }

    public static VoidspawnGeneratorRecipeJsonBuilder create(RecipeCategory category, ItemConvertible output, int count) {
        return new VoidspawnGeneratorRecipeJsonBuilder(category, output, count, 20);
    }

    public static VoidspawnGeneratorRecipeJsonBuilder create(RecipeCategory category, ItemConvertible output, int count, int craftingTime) {
        return new VoidspawnGeneratorRecipeJsonBuilder(category, output, count, craftingTime);
    }

    public VoidspawnGeneratorRecipeJsonBuilder input(ItemConvertible itemProvider) {
        return this.input(Ingredient.ofItems(itemProvider));
    }

    public VoidspawnGeneratorRecipeJsonBuilder input(Ingredient ingredient) {
        this.inputs.set(0, ingredient);
        return this;
    }

    public VoidspawnGeneratorRecipeJsonBuilder input(TagKey<Item> tag) {
        return this.input(Ingredient.fromTag(tag));
    }

    public VoidspawnGeneratorRecipeJsonBuilder fuel(ItemConvertible itemProvider) {
        return this.fuel(Ingredient.ofItems(itemProvider));
    }

    public VoidspawnGeneratorRecipeJsonBuilder fuel(Ingredient ingredient) {
        this.inputs.set(1, ingredient);
        return this;
    }

    public VoidspawnGeneratorRecipeJsonBuilder fuel(TagKey<Item> tag) {
        return this.fuel(Ingredient.fromTag(tag));
    }

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
        VoidspawnGeneratorRecipe recipe = new VoidspawnGeneratorRecipe(CraftingRecipeJsonBuilder.toCraftingCategory(this.category), this.inputs, this.output, this.outputCount, this.craftingTime);
        exporter.accept(recipeId, recipe, builder.build(recipeId.withPrefixedPath("recipes/" + this.category.getName() + "/")));
    }

    private void validate(Identifier recipeId) {
        if (this.advancementBuilder.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeId);
        }
    }
}
