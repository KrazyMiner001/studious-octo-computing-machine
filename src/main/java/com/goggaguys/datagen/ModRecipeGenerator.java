package com.goggaguys.datagen;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.item.ModItemTags;
import com.goggaguys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        reversibleCompactingRecipesBetter(exporter, ModItems.OAK_LEAF, ModItems.COMPRESSED_OAK_LEAF);
        reversibleCompactingRecipesBetter(exporter, ModItems.COMPRESSED_OAK_LEAF, ModItems.DOUBLE_COMPRESSED_OAK_LEAF);

        reversibleCompactingRecipesBetter(exporter, ModItems.SPRUCE_LEAF, ModItems.COMPRESSED_SPRUCE_LEAF);
        reversibleCompactingRecipesBetter(exporter, ModItems.COMPRESSED_SPRUCE_LEAF, ModItems.DOUBLE_COMPRESSED_SPRUCE_LEAF);

        reversibleCompactingRecipesBetter(exporter, ModItems.BIRCH_LEAF, ModItems.COMPRESSED_BIRCH_LEAF);
        reversibleCompactingRecipesBetter(exporter, ModItems.COMPRESSED_BIRCH_LEAF, ModItems.DOUBLE_COMPRESSED_BIRCH_LEAF);

        reversibleCompactingRecipesBetter(exporter, ModItems.JUNGLE_LEAF, ModItems.COMPRESSED_JUNGLE_LEAF);
        reversibleCompactingRecipesBetter(exporter, ModItems.COMPRESSED_JUNGLE_LEAF, ModItems.DOUBLE_COMPRESSED_JUNGLE_LEAF);

        reversibleCompactingRecipesBetter(exporter, ModItems.ACACIA_LEAF, ModItems.COMPRESSED_ACACIA_LEAF);
        reversibleCompactingRecipesBetter(exporter, ModItems.COMPRESSED_ACACIA_LEAF, ModItems.DOUBLE_COMPRESSED_ACACIA_LEAF);

        reversibleCompactingRecipesBetter(exporter, ModItems.DARK_OAK_LEAF, ModItems.COMPRESSED_DARK_OAK_LEAF);
        reversibleCompactingRecipesBetter(exporter, ModItems.COMPRESSED_DARK_OAK_LEAF, ModItems.DOUBLE_COMPRESSED_DARK_OAK_LEAF);

        reversibleCompactingRecipesBetter(exporter, ModItems.AZALEA_LEAF, ModItems.COMPRESSED_AZALEA_LEAF);
        reversibleCompactingRecipesBetter(exporter, ModItems.COMPRESSED_AZALEA_LEAF, ModItems.DOUBLE_COMPRESSED_AZALEA_LEAF);

        reversibleCompactingRecipesBetter(exporter, ModItems.MANGROVE_LEAF, ModItems.COMPRESSED_MANGROVE_LEAF);
        reversibleCompactingRecipesBetter(exporter, ModItems.COMPRESSED_MANGROVE_LEAF, ModItems.DOUBLE_COMPRESSED_MANGROVE_LEAF);

        reversibleCompactingRecipesBetter(exporter, ModItems.CHERRY_LEAF, ModItems.COMPRESSED_CHERRY_LEAF);
        reversibleCompactingRecipesBetter(exporter, ModItems.COMPRESSED_CHERRY_LEAF, ModItems.DOUBLE_COMPRESSED_CHERRY_LEAF);

        reversibleCompactingRecipesBetter(exporter, ModItems.MIXED_LEAF, ModItems.COMPRESSED_MIXED_LEAF);
        reversibleCompactingRecipesBetter(exporter, ModItems.COMPRESSED_MIXED_LEAF, ModItems.DOUBLE_COMPRESSED_MIXED_LEAF);

        reversibleCompactingRecipesBetter(exporter, ModItems.MYSTERY_LEAF, ModItems.COMPRESSED_MYSTERY_LEAF);
        reversibleCompactingRecipesBetter(exporter, ModItems.COMPRESSED_MYSTERY_LEAF, ModItems.DOUBLE_COMPRESSED_MYSTERY_LEAF);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MIXED_LEAF)
                .input(ModItems.OAK_LEAF)
                .input(ModItems.SPRUCE_LEAF)
                .input(ModItems.BIRCH_LEAF)
                .input(ModItems.JUNGLE_LEAF)
                .input(ModItems.ACACIA_LEAF)
                .input(ModItems.DARK_OAK_LEAF)
                .input(ModItems.AZALEA_LEAF)
                .input(ModItems.MANGROVE_LEAF)
                .input(ModItems.CHERRY_LEAF)
                .criterion("has_leaf", conditionsFromTag(ModItemTags.LEAF))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MIXED_LEAF) + "_from_mixing_leaves"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COMPRESSED_MIXED_LEAF)
                .input(ModItems.COMPRESSED_OAK_LEAF)
                .input(ModItems.COMPRESSED_SPRUCE_LEAF)
                .input(ModItems.COMPRESSED_BIRCH_LEAF)
                .input(ModItems.COMPRESSED_JUNGLE_LEAF)
                .input(ModItems.COMPRESSED_ACACIA_LEAF)
                .input(ModItems.COMPRESSED_DARK_OAK_LEAF)
                .input(ModItems.COMPRESSED_AZALEA_LEAF)
                .input(ModItems.COMPRESSED_MANGROVE_LEAF)
                .input(ModItems.COMPRESSED_CHERRY_LEAF)
                .criterion("has_compressed_leaf", conditionsFromTag(ModItemTags.LEAF_COMPRESSED))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COMPRESSED_MIXED_LEAF) + "_from_mixing_compressed_leaves"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DOUBLE_COMPRESSED_MIXED_LEAF)
                .input(ModItems.DOUBLE_COMPRESSED_OAK_LEAF)
                .input(ModItems.DOUBLE_COMPRESSED_SPRUCE_LEAF)
                .input(ModItems.DOUBLE_COMPRESSED_BIRCH_LEAF)
                .input(ModItems.DOUBLE_COMPRESSED_JUNGLE_LEAF)
                .input(ModItems.DOUBLE_COMPRESSED_ACACIA_LEAF)
                .input(ModItems.DOUBLE_COMPRESSED_DARK_OAK_LEAF)
                .input(ModItems.DOUBLE_COMPRESSED_AZALEA_LEAF)
                .input(ModItems.DOUBLE_COMPRESSED_MANGROVE_LEAF)
                .input(ModItems.DOUBLE_COMPRESSED_CHERRY_LEAF)
                .criterion("has_double_compressed_leaf", conditionsFromTag(ModItemTags.LEAF_DOUBLE_COMPRESSED))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DOUBLE_COMPRESSED_MIXED_LEAF) + "_from_mixing_double_compressed_leaves"));

        makeSaplingRecipe(exporter, ModBlocks.MYSTERY_SAPLING.asItem(), ModItems.COMPRESSED_MYSTERY_LEAF);
        makeSaplingRecipe(exporter, Blocks.OAK_SAPLING.asItem(), ModItems.COMPRESSED_OAK_LEAF);
        makeSaplingRecipe(exporter, Blocks.SPRUCE_SAPLING.asItem(), ModItems.COMPRESSED_SPRUCE_LEAF);
        makeSaplingRecipe(exporter, Blocks.BIRCH_SAPLING.asItem(), ModItems.COMPRESSED_BIRCH_LEAF);
        makeSaplingRecipe(exporter, Blocks.JUNGLE_SAPLING.asItem(), ModItems.COMPRESSED_JUNGLE_LEAF);
        makeSaplingRecipe(exporter, Blocks.ACACIA_SAPLING.asItem(), ModItems.COMPRESSED_ACACIA_LEAF);
        makeSaplingRecipe(exporter, Blocks.DARK_OAK_SAPLING.asItem(), ModItems.COMPRESSED_DARK_OAK_LEAF);
        makeSaplingRecipe(exporter, Blocks.AZALEA.asItem(), ModItems.COMPRESSED_AZALEA_LEAF);
        makeSaplingRecipe(exporter, Blocks.MANGROVE_PROPAGULE.asItem(), ModItems.COMPRESSED_MANGROVE_LEAF);
        makeSaplingRecipe(exporter, Blocks.CHERRY_SAPLING.asItem(), ModItems.COMPRESSED_CHERRY_LEAF);

        offerBarkBlockRecipe(exporter, ModBlocks.MYSTERY_WOOD, ModBlocks.MYSTERY_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_MYSTERY_WOOD, ModBlocks.STRIPPED_MYSTERY_LOG);

        offerPlanksRecipe(exporter, ModBlocks.MYSTERY_PLANKS, ModItemTags.MYSTERY_LOGS, 4);

        armorRecipes(exporter, ModItemTags.LEAF,
                ModItems.LEAF_HELMET,
                ModItems.LEAF_CHESTPLATE,
                ModItems.LEAF_LEGGINGS,
                ModItems.LEAF_BOOTS);

        armorRecipes(exporter, ModItemTags.LEAF,
                ModItems.COMPRESSED_LEAF_HELMET,
                ModItems.COMPRESSED_LEAF_CHESTPLATE,
                ModItems.COMPRESSED_LEAF_LEGGINGS,
                ModItems.COMPRESSED_LEAF_BOOTS);

        armorRecipes(exporter, ModItemTags.LEAF,
                ModItems.DOUBLE_COMPRESSED_LEAF_HELMET,
                ModItems.DOUBLE_COMPRESSED_LEAF_CHESTPLATE,
                ModItems.DOUBLE_COMPRESSED_LEAF_LEGGINGS,
                ModItems.DOUBLE_COMPRESSED_LEAF_BOOTS);

        offerLeafUpgradeRecipe(exporter, Items.NETHERITE_HELMET, ModItems.LEAFITE_HELMET, RecipeCategory.COMBAT);
        offerLeafUpgradeRecipe(exporter, Items.NETHERITE_CHESTPLATE, ModItems.LEAFITE_CHESTPLATE, RecipeCategory.COMBAT);
        offerLeafUpgradeRecipe(exporter, Items.NETHERITE_LEGGINGS, ModItems.LEAFITE_LEGGINGS, RecipeCategory.COMBAT);
        offerLeafUpgradeRecipe(exporter, Items.NETHERITE_BOOTS, ModItems.LEAFITE_BOOTS, RecipeCategory.COMBAT);

        offerLeafUpgradeRecipe(exporter, Items.NETHERITE_SWORD, ModItems.LEAFITE_SWORD, RecipeCategory.COMBAT);
        offerLeafUpgradeRecipe(exporter, Items.NETHERITE_PICKAXE, ModItems.LEAFITE_PICKAXE, RecipeCategory.TOOLS);
        offerLeafUpgradeRecipe(exporter, Items.NETHERITE_AXE, ModItems.LEAFITE_AXE, RecipeCategory.TOOLS);
        offerLeafUpgradeRecipe(exporter, Items.NETHERITE_SHOVEL, ModItems.LEAFITE_SHOVEL, RecipeCategory.TOOLS);
        offerLeafUpgradeRecipe(exporter, Items.NETHERITE_HOE, ModItems.LEAFITE_HOE, RecipeCategory.TOOLS);
    }

    private static void offerLeafUpgradeRecipe(RecipeExporter exporter, Item baseItem, Item resultItem, RecipeCategory category) {
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.LEAFITE_UPGRADE_TEMPLATE),
                Ingredient.ofItems(baseItem),
                Ingredient.ofItems(ModItems.LEAF_CORE),
                category,
                resultItem
        ).criterion("has_leaf_core", conditionsFromItem(ModItems.LEAF_CORE))
        .offerTo(exporter, getItemPath(resultItem) + "_smithing");
    }

    private static void makeSaplingRecipe(RecipeExporter exporter, Item sapling, Item leaf) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, sapling)
                .pattern("LLL")
                .pattern("LSL")
                .pattern(" S ")
                .input('L', leaf)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(leaf), conditionsFromItem(leaf))
                .offerTo(exporter, new Identifier(getRecipeName(sapling)));
    }

    private static void reversibleCompactingRecipesBetter(RecipeExporter exporter, Item baseItem, Item compactItem)
    {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, baseItem, RecipeCategory.MISC, compactItem, getRecipeName(compactItem) + "_from_" + getRecipeName(baseItem), null, getRecipeName(baseItem) + "_from_" + getRecipeName(compactItem), null);
    }

    private static void armorRecipes(RecipeExporter exporter, TagKey armorIngredient, Item helmet, Item chestplate, Item leggings, Item boots) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, helmet)
                .pattern("LLL")
                .pattern("L L")
                .input('L', armorIngredient)
                .criterion("has_" + armorIngredient.id().getPath(), conditionsFromTag(armorIngredient))
                .offerTo(exporter, new Identifier(getRecipeName(helmet)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, chestplate)
                .pattern("L L")
                .pattern("LLL")
                .pattern("LLL")
                .input('L', armorIngredient)
                .criterion("has_" + armorIngredient.id().getPath(), conditionsFromTag(armorIngredient))
                .offerTo(exporter, new Identifier(getRecipeName(chestplate)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, leggings)
                .pattern("LLL")
                .pattern("L L")
                .pattern("L L")
                .input('L', armorIngredient)
                .criterion("has_" + armorIngredient.id().getPath(), conditionsFromTag(armorIngredient))
                .offerTo(exporter, new Identifier(getRecipeName(leggings)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, boots)
                .pattern("L L")
                .pattern("L L")
                .input('L', armorIngredient)
                .criterion("has_" + armorIngredient.id().getPath(), conditionsFromTag(armorIngredient))
                .offerTo(exporter, new Identifier(getRecipeName(boots)));
    }

}
