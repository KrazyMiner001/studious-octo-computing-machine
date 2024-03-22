package com.goggaguys.datagen;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.item.ModItemTags;
import com.goggaguys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Arrays;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        reversibleCompactingRecipesBetter(exporter, ModItems.OAK_LEAF, ModItems.COMPRESSED_OAK_LEAF);
        reversibleCompactingRecipesBetter(exporter, ModItems.COMPRESSED_OAK_LEAF, ModItems.DOUBLE_COMPRESSED_OAK_LEAF);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FINNIAN_SAPLING)
                .pattern("LLL")
                .pattern("LSL")
                .pattern(" S ")
                .input('L', ModItems.FINNIAN_LEAF)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.FINNIAN_LEAF), conditionsFromItem(ModItems.FINNIAN_LEAF))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FINNIAN_SAPLING)));

        offerBarkBlockRecipe(exporter, ModBlocks.FINNIAN_WOOD, ModBlocks.FINNIAN_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_FINNIAN_WOOD, ModBlocks.STRIPPED_FINNIAN_LOG);

        offerPlanksRecipe(exporter, ModBlocks.FINNIAN_PLANKS, ModItemTags.finnian_logs, 4);

        armorRecipes(exporter, ModItems.LEAFSTONE,
                ModItems.LEAF_HELMET, ModItems.LEAF_CHESTPLATE, ModItems.LEAF_LEGGINGS, ModItems.LEAF_BOOTS);


    }

    private static void reversibleCompactingRecipesBetter(RecipeExporter exporter, Item baseItem, Item compactItem)
    {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, baseItem, RecipeCategory.MISC, compactItem, getRecipeName(compactItem) + "_from_" + getRecipeName(baseItem), null, getRecipeName(baseItem) + "_from_" + getRecipeName(compactItem), null);
    }

    private static void armorRecipes(RecipeExporter exporter, Item armorIngredient, Item helmet, Item chestplate, Item leggings, Item boots) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, helmet)
                .pattern("LLL")
                .pattern("L L")
                .input('L', armorIngredient)
                .criterion(hasItem(armorIngredient), conditionsFromItem(armorIngredient))
                .offerTo(exporter, new Identifier(getRecipeName(helmet)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, chestplate)
                .pattern("L L")
                .pattern("LLL")
                .pattern("LLL")
                .input('L', armorIngredient)
                .criterion(hasItem(armorIngredient), conditionsFromItem(armorIngredient))
                .offerTo(exporter, new Identifier(getRecipeName(chestplate)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, leggings)
                .pattern("LLL")
                .pattern("L L")
                .pattern("L L")
                .input('L', armorIngredient)
                .criterion(hasItem(armorIngredient), conditionsFromItem(armorIngredient))
                .offerTo(exporter, new Identifier(getRecipeName(leggings)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, boots)
                .pattern("L L")
                .pattern("L L")
                .input('L', armorIngredient)
                .criterion(hasItem(armorIngredient), conditionsFromItem(armorIngredient))
                .offerTo(exporter, new Identifier(getRecipeName(boots)));
    }
}
