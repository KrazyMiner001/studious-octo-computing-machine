package tech.krazyminer001.datagen.lang;

import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.block.ModBlocks;
import tech.krazyminer001.entity.ModEntities;
import tech.krazyminer001.item.ModItemTags;
import tech.krazyminer001.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.concurrent.CompletableFuture;
import static tech.krazyminer001.utility.Util.of;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataGenerator, "en_us", registryLookup);
    }
    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        leafTranslations(translationBuilder);

        translationBuilder.add(ModItems.LEAFSTONE, "Leafstone");
        translationBuilder.add(ModItems.LEAF_CORE, "Leaf Core");
        translationBuilder.add(ModItems.BROKEN_LEAF_CORE, "Broken Leaf Core");
        translationBuilder.add(ModItems.TOKEN_OF_THE_LEAF_GOD, "Token of the Leaf God");
        translationBuilder.add(ModItems.LEAFITE_UPGRADE_SMITHING_TEMPLATE, "Smithing Template");
        translationBuilder.add(ModItems.CHLOROPHYTE_UPGRADE_SMITHING_TEMPLATE, "Smithing Template");

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

        translationBuilder.add(ModItems.CHLOROPHYTE_HELMET, "Chlorophyte Helmet");
        translationBuilder.add(ModItems.CHLOROPHYTE_CHESTPLATE, "Chlorophyte Chestplate");
        translationBuilder.add(ModItems.CHLOROPHYTE_LEGGINGS, "Chlorophyte Leggings");
        translationBuilder.add(ModItems.CHLOROPHYTE_BOOTS, "Chlorophyte Boots");
        translationBuilder.add(ModItems.CHLOROPHYTE_SWORD, "Chlorophyte Sword");
        translationBuilder.add(ModItems.CHLOROPHYTE_PICKAXE, "Chlorophyte Pickaxe");
        translationBuilder.add(ModItems.CHLOROPHYTE_AXE, "Chlorophyte Axe");
        translationBuilder.add(ModItems.CHLOROPHYTE_SHOVEL, "Chlorophyte Shovel");
        translationBuilder.add(ModItems.CHLOROPHYTE_HOE, "Chlorophyte Hoe");

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



        translationBuilder.add(ModEntities.LEAF_MONSTER, "Leaf Monster");
        translationBuilder.add(ModEntities.LEAF_GOD, "Leaf God");
        translationBuilder.add(ModEntities.LEAF_PROJECTILE, "Leaf Projectile");

        translationBuilder.add("item.octocomputing.leaf_god_spawn_item.tooltip", "Energy is charging through this");

        translationBuilder.add("item.octocomputing.chlorophyte.chlorophyte_sword.tooltip", "Deals extra damage to leafy monsters");
        translationBuilder.add("item.octocomputing.leafite_sword.tooltip", "Deals extra damage to leafy monsters");

        translationBuilder.add("item.octocomputing.chlorophyte.toggleable_ability", "Sneak and use to toggle abilities");

        translationBuilder.add("item.octocomputing.chlorophyte.chlorophyte_axe.treecapitator_ability.disabled", "[§4✘§r] Treecapitator");
        translationBuilder.add("item.octocomputing.chlorophyte.chlorophyte_axe.treecapitator_ability.enabled", "[§2✔§r] Treecapitator");

        translationBuilder.add("item.octocomputing.chlorophyte.chlorophyte_pickaxe.3x3_ability.disabled", "[§4✘§r] 3x3 Mining");
        translationBuilder.add("item.octocomputing.chlorophyte.chlorophyte_pickaxe.3x3_ability.enabled", "[§2✔§r] 3x3 Mining");

        translationBuilder.add("item.octocomputing.chlorophyte.chlorophyte_shovel.3x3_ability.disabled", "[§4✘§r] 3x3 Digging");
        translationBuilder.add("item.octocomputing.chlorophyte.chlorophyte_shovel.3x3_ability.enabled", "[§2✔§r] 3x3 Digging");

        translationBuilder.add("item.octocomputing.chlorophyte.chlorophyte_hoe.3x3_ability.disabled", "[§4✘§r] 3x3 Tilling");
        translationBuilder.add("item.octocomputing.chlorophyte.chlorophyte_hoe.3x3_ability.enabled", "[§2✔§r] 3x3 Tilling");

        translationBuilder.add("itemGroup.octocomputing.main", "OctoComputing");
        translationBuilder.add("itemGroup.octocomputing.leaves", "Leaves");
        translationBuilder.add("itemGroup.octocomputing.equipment", "Equipment");
        translationBuilder.add("itemGroup.octocomputing.resources", "Resources");
        translationBuilder.add("itemGroup.octocomputing.natural", "Natural");
        translationBuilder.add("itemGroup.octocomputing.functional", "Functional");
        translationBuilder.add("itemGroup.octocomputing.blocks", "Blocks");

        translationBuilder.add(Identifier.of("death.attack", "leaf"), "%1$s leafed too much");

        translationBuilder.add(ModItemTags.LEAF.id().toTranslationKey("tag"), "Leaves");
        translationBuilder.add(ModItemTags.LEAF_COMPRESSED.id().toTranslationKey("tag"), "Compressed Leaves");
        translationBuilder.add(ModItemTags.LEAF_DOUBLE_COMPRESSED.id().toTranslationKey("tag"), "Double Compressed Leaves");
        translationBuilder.add(ModItemTags.MYSTERY_LOGS.id().toTranslationKey("tag"), "Mystery Logs");

        translationBuilder.add("text.config." + OctoComputing.CONFIG.name() + ".title", "Octo Computing Config");
        translationBuilder.add("text.config." + OctoComputing.CONFIG.name() + ".option." + OctoComputing.CONFIG.keys.fancyTree.asString(), "Fancy Tree");
        translationBuilder.add("text.config." + OctoComputing.CONFIG.name() + ".option." + OctoComputing.CONFIG.keys.fancyTree.asString() + ".tooltip", "If true, the custom tree feature will generate a more complex tree.\nIf false, the custom tree feature will generate a simple tree.\n\nThe Fancy tree looks nicer but is slower to generate.\n\nDefault: true");

        translationBuilder.add(Util.createTranslationKey("item", of("smithing_template.leafite_upgrade.applies_to")), "Netherite Equipment");
        translationBuilder.add(Util.createTranslationKey("item", of("smithing_template.leafite_upgrade.ingredients")), "Leaf Core");
        translationBuilder.add(Util.createTranslationKey("upgrade", of("leafite_upgrade")), "Leafite Upgrade");
        translationBuilder.add(Util.createTranslationKey("item", of("smithing_template.leafite_upgrade.base_slot_description")), "Add netherite armor, weapon, or tool");
        translationBuilder.add(Util.createTranslationKey("item", of("smithing_template.leafite_upgrade.additions_slot_description")),"Add Leaf Core");

        translationBuilder.add(Util.createTranslationKey("item", of("smithing_template.chlorophyte_upgrade.applies_to")), "Leafite Equipment");
        translationBuilder.add(Util.createTranslationKey("item", of("smithing_template.chlorophyte_upgrade.ingredients")), "Chlorophyte Ingot");
        translationBuilder.add(Util.createTranslationKey("upgrade", of("chlorophyte_upgrade")), "Chlorophyte Upgrade");
        translationBuilder.add(Util.createTranslationKey("item", of("smithing_template.chlorophyte_upgrade.base_slot_description")), "Add leafite armor, weapon, or tool");
        translationBuilder.add(Util.createTranslationKey("item", of("smithing_template.chlorophyte_upgrade.additions_slot_description")),"Add Chlorophyte ingot");
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
        translationBuilder.add(ModItems.DOUBLE_COMPRESSED_AZALEA_LEAF, "Double Compressed Azalea Leaf");

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
