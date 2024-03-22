package com.goggaguys.datagen;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.item.ModItemGroups;
import com.goggaguys.item.ModItemTags;
import com.goggaguys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.util.Identifier;

import java.nio.file.Path;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }
    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.OAK_LEAF, "Oak Leaf");
        translationBuilder.add(ModItems.COMPRESSED_OAK_LEAF, "Compressed Oak Leaf");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_OAK_LEAF, "Double Compressed Oak Leaf");
        translationBuilder.add(ModItems.FINNIAN_LEAF, "Finnian Leaf");
        translationBuilder.add(ModItems.LEAFSTONE, "Leafstone");
        translationBuilder.add(ModItems.LEAF_HELMET, "Leaf Helmet");
        translationBuilder.add(ModItems.LEAF_CHESTPLATE, "Leaf Chestplate");
        translationBuilder.add(ModItems.LEAF_LEGGINGS, "Leaf Leggins");
        translationBuilder.add(ModItems.LEAF_BOOTS, "Leaf Boots");

        translationBuilder.add(ModBlocks.FINNIAN_SAPLING, "Finnian Sapling");
        translationBuilder.add(ModBlocks.FINNIAN_LOG, "Finnian Log");
        translationBuilder.add(ModBlocks.FINNIAN_WOOD, "Finnian Wood");
        translationBuilder.add(ModBlocks.STRIPPED_FINNIAN_LOG, "Stripped Finnian Log");
        translationBuilder.add(ModBlocks.STRIPPED_FINNIAN_WOOD,  "Stripped Finnian Wood");
        translationBuilder.add(ModBlocks.FINNIAN_PLANKS, "Finnian Planks");
        translationBuilder.add(ModBlocks.FINNIAN_LEAVES, "Finnian Leaves");
        translationBuilder.add(ModBlocks.LEAF_ORE, "Leaf Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_LEAF_ORE, "Deepslate Leaf Ore");
        translationBuilder.add(ModBlocks.LEAFSTONE_BLOCK, "Leafstone Block");

        translationBuilder.add(new Identifier("itemgroup", "leaf_group"), "Leaves");
    }
}
