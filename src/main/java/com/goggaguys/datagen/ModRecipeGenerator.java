package com.goggaguys.datagen;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

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
    }

    private static void reversibleCompactingRecipesBetter(RecipeExporter exporter, Item baseItem, Item compactItem)
    {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, baseItem, RecipeCategory.MISC, compactItem, getRecipeName(compactItem) + "_from_" + getRecipeName(baseItem), null, getRecipeName(baseItem) + "_from_" + getRecipeName(compactItem), null);
    }
}
