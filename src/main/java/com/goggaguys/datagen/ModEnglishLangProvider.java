package com.goggaguys.datagen;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.enchantments.ModEnchantments;
import com.goggaguys.entity.ModEntities;
import com.goggaguys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.util.Identifier;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }
    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        leafTranslations(translationBuilder);

        translationBuilder.add(ModItems.LEAFSTONE, "Leafstone");
        translationBuilder.add(ModItems.LEAF_CORE, "Leaf Core");
        translationBuilder.add(ModItems.LEAFITE_UPGRADE_TEMPLATE, "Leafite Upgrade Template");

        translationBuilder.add(ModItems.LEAF_MONSTER_SPAWN_EGG, "Leaf Monster Spawn Egg");

        translationBuilder.add(ModItems.LEAFITE_HELMET, "Leafite Helmet");
        translationBuilder.add(ModItems.LEAFITE_CHESTPLATE, "Leafite Chestplate");
        translationBuilder.add(ModItems.LEAFITE_LEGGINGS, "Leafite Leggings");
        translationBuilder.add(ModItems.LEAFITE_BOOTS, "Leafite Boots");
        translationBuilder.add(ModItems.LEAFITE_SWORD, "Leafite Sword");
        translationBuilder.add(ModItems.LEAFITE_PICKAXE, "Leafite Pickaxe");
        translationBuilder.add(ModItems.LEAFITE_AXE, "Leafite Axe");
        translationBuilder.add(ModItems.LEAFITE_SHOVEL, "Leafite Shovel");
        translationBuilder.add(ModItems.LEAFITE_HOE, "Leafite Hoe");

        translationBuilder.add(ModItems.LEAF_HELMET, "Leaf Helmet");
        translationBuilder.add(ModItems.LEAF_CHESTPLATE, "Leaf Chestplate");
        translationBuilder.add(ModItems.LEAF_LEGGINGS, "Leaf Leggings");
        translationBuilder.add(ModItems.LEAF_BOOTS, "Leaf Boots");
        translationBuilder.add(ModItems.LEAF_SWORD, "Leaf Sword");
        translationBuilder.add(ModItems.LEAF_PICKAXE, "Leaf Pickaxe");
        translationBuilder.add(ModItems.LEAF_AXE, "Leaf Axe");
        translationBuilder.add(ModItems.LEAF_SHOVEL, "Leaf Shovel");
        translationBuilder.add(ModItems.LEAF_HOE, "Leaf Hoe");

        translationBuilder.add(ModItems.COMPRESSED_LEAF_HELMET, "Compressed Leaf Helmet");
        translationBuilder.add(ModItems.COMPRESSED_LEAF_CHESTPLATE, "Compressed Leaf Chestplate");
        translationBuilder.add(ModItems.COMPRESSED_LEAF_LEGGINGS, "Compressed Leaf Leggings");
        translationBuilder.add(ModItems.COMPRESSED_LEAF_BOOTS, "Compressed Leaf Boots");
        translationBuilder.add(ModItems.COMPRESSED_LEAF_SWORD, "Compressed Leaf Sword");
        translationBuilder.add(ModItems.COMPRESSED_LEAF_PICKAXE, "Compressed Leaf Pickaxe");
        translationBuilder.add(ModItems.COMPRESSED_LEAF_AXE, "Compressed Leaf Axe");
        translationBuilder.add(ModItems.COMPRESSED_LEAF_SHOVEL, "Compressed Leaf Shovel");
        translationBuilder.add(ModItems.COMPRESSED_LEAF_HOE, "Compressed Leaf Hoe");

        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_LEAF_HELMET, "Double Compressed Leaf Helmet");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_LEAF_CHESTPLATE, "Double Compressed Leaf Chestplate");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_LEAF_LEGGINGS, "Double Compressed Leaf Leggings");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_LEAF_BOOTS, "Double Compressed Leaf Boots");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_LEAF_SWORD, "Double Compressed Leaf Sword");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_LEAF_PICKAXE, "Double Compressed Leaf Pickaxe");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_LEAF_AXE, "Double Compressed Leaf Axe");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_LEAF_SHOVEL, "Double Compressed Leaf Shovel");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_LEAF_HOE, "Double Compressed Leaf Hoe");

        translationBuilder.add(ModBlocks.MYSTERY_SAPLING, "Mystery Sapling");
        translationBuilder.add(ModBlocks.MYSTERY_LOG, "Mystery Log");
        translationBuilder.add(ModBlocks.MYSTERY_WOOD, "Mystery Wood");
        translationBuilder.add(ModBlocks.STRIPPED_MYSTERY_LOG, "Stripped Mystery Log");
        translationBuilder.add(ModBlocks.STRIPPED_MYSTERY_WOOD,  "Stripped Mystery Wood");
        translationBuilder.add(ModBlocks.MYSTERY_PLANKS, "Mystery Planks");
        translationBuilder.add(ModBlocks.MYSTERY_LEAVES, "Mystery Leaves");
        translationBuilder.add(ModBlocks.LEAF_ORE, "Leaf Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_LEAF_ORE, "Deepslate Leaf Ore");
        translationBuilder.add(ModBlocks.LEAFSTONE_BLOCK, "Leafstone Block");

        translationBuilder.add(ModEnchantments.LEAF_PROTECTION, "Leaf Protection");
        translationBuilder.add(ModEnchantments.GARDEN_SHEARS, "Garden Shears");

        translationBuilder.add(ModEntities.LEAF_MONSTER, "Leaf Monster");

        translationBuilder.add(new Identifier("itemgroup", "leaf_group"), "Leaves");

        translationBuilder.add(new Identifier("death.attack", "leaf"), "%1$s leafed too much");
    }

    private static void leafTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.OAK_LEAF, "Oak Leaf");
        translationBuilder.add(ModItems.COMPRESSED_OAK_LEAF, "Compressed Oak Leaf");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_OAK_LEAF, "Double Compressed Oak Leaf");

        translationBuilder.add(ModItems.SPRUCE_LEAF, "Spruce Leaf");
        translationBuilder.add(ModItems.COMPRESSED_SPRUCE_LEAF, "Compressed Spruce Leaf");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_SPRUCE_LEAF, "Double Compressed Spruce Leaf");

        translationBuilder.add(ModItems.BIRCH_LEAF, "Birch Leaf");
        translationBuilder.add(ModItems.COMPRESSED_BIRCH_LEAF, "Compressed Birch Leaf");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_BIRCH_LEAF, "Double Compressed Birch Leaf");

        translationBuilder.add(ModItems.JUNGLE_LEAF, "Jungle Leaf");
        translationBuilder.add(ModItems.COMPRESSED_JUNGLE_LEAF, "Compressed Jungle Leaf");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_JUNGLE_LEAF, "Double Compressed Jungle Leaf");

        translationBuilder.add(ModItems.ACACIA_LEAF, "Acacia Leaf");
        translationBuilder.add(ModItems.COMPRESSED_ACACIA_LEAF, "Compressed Acacia Leaf");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_ACACIA_LEAF, "Double Compressed Acacia Leaf");

        translationBuilder.add(ModItems.DARK_OAK_LEAF, "Dark Oak Leaf");
        translationBuilder.add(ModItems.COMPRESSED_DARK_OAK_LEAF, "Compressed Dark Oak Leaf");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_DARK_OAK_LEAF, "Double Compressed Dark Oak Leaf");

        translationBuilder.add(ModItems.AZALEA_LEAF, "Azalea Leaf");
        translationBuilder.add(ModItems.COMPRESSED_AZALEA_LEAF, "Compressed Azalea Leaf");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_AZALEA_LEAF, "Double Compressed AzalMangroveLeaf");

        translationBuilder.add(ModItems.MANGROVE_LEAF, "Mangrove Leaf");
        translationBuilder.add(ModItems.COMPRESSED_MANGROVE_LEAF, "Compressed Mangrove Leaf");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_MANGROVE_LEAF, "Double Compressed Oak Leaf");

        translationBuilder.add(ModItems.CHERRY_LEAF, "Cherry Leaf");
        translationBuilder.add(ModItems.COMPRESSED_CHERRY_LEAF, "Compressed Cherry Leaf");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_CHERRY_LEAF, "Double Compressed Cherry Leaf");

        translationBuilder.add(ModItems.MIXED_LEAF, "Mixed Leaf");
        translationBuilder.add(ModItems.COMPRESSED_MIXED_LEAF, "Compressed Mixed Leaf");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_MIXED_LEAF, "Double Compressed Mixed Leaf");

        translationBuilder.add(ModItems.MYSTERY_LEAF, "Mystery Leaf");
        translationBuilder.add(ModItems.COMPRESSED_MYSTERY_LEAF, "Compressed Mystery Leaf");
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_MYSTERY_LEAF, "Double Compressed Mystery Leaf");
    }
}
