package com.goggaguys.item;

import com.goggaguys.OctoComputing;
import com.goggaguys.compat.Mods;
import com.goggaguys.compat.geckolib.AnimatedLeafCore;
import com.goggaguys.entity.ModEntities;
import com.goggaguys.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class ModItems {
    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = new Identifier("item/empty_armor_slot_helmet");
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = new Identifier("item/empty_armor_slot_chestplate");
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = new Identifier("item/empty_armor_slot_leggings");
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = new Identifier("item/empty_armor_slot_boots");
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE = new Identifier("item/empty_slot_hoe");
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE = new Identifier("item/empty_slot_axe");
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE = new Identifier("item/empty_slot_sword");
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = new Identifier("item/empty_slot_shovel");
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = new Identifier("item/empty_slot_pickaxe");
    private static final Identifier EMPTY_SLOT_INGOT_TEXTURE = new Identifier("item/empty_slot_ingot");

    public static final Item OAK_LEAF = registerItem("oak_leaf", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_OAK_LEAF = registerItem("compressed_oak_leaf", new Item(new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_OAK_LEAF = registerItem("double_compressed_oak_leaf", new Item(new FabricItemSettings()));

    public static final Item BIRCH_LEAF = registerItem("birch_leaf", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_BIRCH_LEAF = registerItem("compressed_birch_leaf", new Item(new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_BIRCH_LEAF = registerItem("double_compressed_birch_leaf", new Item(new FabricItemSettings()));

    public static final Item SPRUCE_LEAF = registerItem("spruce_leaf", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_SPRUCE_LEAF = registerItem("compressed_spruce_leaf", new Item(new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_SPRUCE_LEAF = registerItem("double_compressed_spruce_leaf", new Item(new FabricItemSettings()));

    public static final Item JUNGLE_LEAF = registerItem("jungle_leaf", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_JUNGLE_LEAF = registerItem("compressed_jungle_leaf", new Item(new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_JUNGLE_LEAF = registerItem("double_compressed_jungle_leaf", new Item(new FabricItemSettings()));

    public static final Item ACACIA_LEAF = registerItem("acacia_leaf", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_ACACIA_LEAF = registerItem("compressed_acacia_leaf", new Item(new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_ACACIA_LEAF = registerItem("double_compressed_acacia_leaf", new Item(new FabricItemSettings()));

    public static final Item DARK_OAK_LEAF = registerItem("dark_oak_leaf", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_DARK_OAK_LEAF = registerItem("compressed_dark_oak_leaf", new Item(new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_DARK_OAK_LEAF = registerItem("double_compressed_dark_oak_leaf", new Item(new FabricItemSettings()));

    public static final Item AZALEA_LEAF = registerItem("azalea_leaf", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_AZALEA_LEAF = registerItem("compressed_azalea_leaf", new Item(new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_AZALEA_LEAF = registerItem("double_compressed_azalea_leaf", new Item(new FabricItemSettings()));

    public static final Item MANGROVE_LEAF = registerItem("mangrove_leaf", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_MANGROVE_LEAF = registerItem("compressed_mangrove_leaf", new Item(new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_MANGROVE_LEAF = registerItem("double_compressed_mangrove_leaf", new Item(new FabricItemSettings()));

    public static final Item CHERRY_LEAF = registerItem("cherry_leaf", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_CHERRY_LEAF = registerItem("compressed_cherry_leaf", new Item(new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_CHERRY_LEAF = registerItem("double_compressed_cherry_leaf", new Item(new FabricItemSettings()));

    public static final Item MIXED_LEAF = registerItem("mixed_leaf", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_MIXED_LEAF = registerItem("compressed_mixed_leaf", new Item(new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_MIXED_LEAF = registerItem("double_compressed_mixed_leaf", new Item(new FabricItemSettings()));

    public static final Item MYSTERY_LEAF = registerItem("mystery_leaf", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_MYSTERY_LEAF = registerItem("compressed_mystery_leaf", new Item(new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_MYSTERY_LEAF = registerItem("double_compressed_mystery_leaf", new Item(new FabricItemSettings()));

    public static final Item LEAFSTONE = registerItem("leafstone", new Item(new FabricItemSettings()));

    public static final Item LEAF_HELMET = registerItem("leaf_helmet",
            new ArmorItem(ModArmorMaterials.LEAF, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item LEAF_CHESTPLATE = registerItem("leaf_chestplate",
            new ArmorItem(ModArmorMaterials.LEAF, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item LEAF_LEGGINGS = registerItem("leaf_leggings",
            new ArmorItem(ModArmorMaterials.LEAF, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item LEAF_BOOTS = registerItem("leaf_boots",
            new ArmorItem(ModArmorMaterials.LEAF, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item COMPRESSED_LEAF_HELMET = registerItem("compressed_leaf_helmet",
            new ArmorItem(ModArmorMaterials.COMPRESSED_LEAF, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item COMPRESSED_LEAF_CHESTPLATE = registerItem("compressed_leaf_chestplate",
            new ArmorItem(ModArmorMaterials.COMPRESSED_LEAF, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item COMPRESSED_LEAF_LEGGINGS = registerItem("compressed_leaf_leggings",
            new ArmorItem(ModArmorMaterials.COMPRESSED_LEAF, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item COMPRESSED_LEAF_BOOTS = registerItem("compressed_leaf_boots",
            new ArmorItem(ModArmorMaterials.COMPRESSED_LEAF, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item DOUBLE_COMPRESSED_LEAF_HELMET = registerItem("double_compressed_leaf_helmet",
            new ArmorItem(ModArmorMaterials.DOUBLE_COMPRESSED_LEAF, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_LEAF_CHESTPLATE = registerItem("double_compressed_leaf_chestplate",
            new ArmorItem(ModArmorMaterials.DOUBLE_COMPRESSED_LEAF, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_LEAF_LEGGINGS = registerItem("double_compressed_leaf_leggings",
            new ArmorItem(ModArmorMaterials.DOUBLE_COMPRESSED_LEAF, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_LEAF_BOOTS = registerItem("double_compressed_leaf_boots",
            new ArmorItem(ModArmorMaterials.DOUBLE_COMPRESSED_LEAF, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item LEAF_SWORD = registerItem("leaf_sword",
            new SwordItem(ModToolMaterial.LEAF, 3, 100f, new FabricItemSettings()));
    public static final Item LEAF_PICKAXE = registerItem("leaf_pickaxe",
            new PickaxeItem(ModToolMaterial.LEAF, 1, 0f, new FabricItemSettings()));
    public static final Item LEAF_AXE = registerItem("leaf_axe",
            new AxeItem(ModToolMaterial.LEAF, 4, 20f, new FabricItemSettings()));
    public static final Item LEAF_SHOVEL = registerItem("leaf_shovel",
            new ShovelItem(ModToolMaterial.LEAF, 1, 0f, new FabricItemSettings()));
    public static final Item LEAF_HOE = registerItem("leaf_hoe",
            new HoeItem(ModToolMaterial.LEAF, 1, 0f, new FabricItemSettings()));

    public static final Item COMPRESSED_LEAF_SWORD = registerItem("compressed_leaf_sword",
            new SwordItem(ModToolMaterial.COMPRESSED_LEAF, 3, 200f, new FabricItemSettings()));
    public static final Item COMPRESSED_LEAF_PICKAXE = registerItem("compressed_leaf_pickaxe",
            new PickaxeItem(ModToolMaterial.COMPRESSED_LEAF, 1, 0f, new FabricItemSettings()));
    public static final Item COMPRESSED_LEAF_AXE = registerItem("compressed_leaf_axe",
            new AxeItem(ModToolMaterial.COMPRESSED_LEAF, 4, 40f, new FabricItemSettings()));
    public static final Item COMPRESSED_LEAF_SHOVEL = registerItem("compressed_leaf_shovel",
            new ShovelItem(ModToolMaterial.COMPRESSED_LEAF, 1, 0f, new FabricItemSettings()));
    public static final Item COMPRESSED_LEAF_HOE = registerItem("compressed_leaf_hoe",
            new HoeItem(ModToolMaterial.COMPRESSED_LEAF, 1, 0f, new FabricItemSettings()));

    public static final Item DOUBLE_COMPRESSED_LEAF_SWORD = registerItem("double_compressed_leaf_sword",
            new SwordItem(ModToolMaterial.DOUBLE_COMPRESSED_LEAF, 3, 300f, new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_LEAF_PICKAXE = registerItem("double_compressed_leaf_pickaxe",
            new PickaxeItem(ModToolMaterial.DOUBLE_COMPRESSED_LEAF, 1, 0f, new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_LEAF_AXE = registerItem("double_compressed_leaf_axe",
            new AxeItem(ModToolMaterial.DOUBLE_COMPRESSED_LEAF, 4, 60f, new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_LEAF_SHOVEL = registerItem("double_compressed_leaf_shovel",
            new ShovelItem(ModToolMaterial.DOUBLE_COMPRESSED_LEAF, 1, 0f, new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_LEAF_HOE = registerItem("double_compressed_leaf_hoe",
            new HoeItem(ModToolMaterial.DOUBLE_COMPRESSED_LEAF, 1, 0f, new FabricItemSettings()));

    public static final Item LEAF_MONSTER_SPAWN_EGG = registerItem("leaf_spawn_egg",
            new SpawnEggItem(ModEntities.LEAF_MONSTER, 0x0BA40B, 0x5D4A09, new FabricItemSettings()));

    public static Item TOKEN_OF_THE_LEAF_GOD = registerItem("token_of_the_leaf_god",
            new TokenOfTheLeafGodItem());

    public static final Item LEAF_CORE = registerLeafCore();
    private static Item registerLeafCore() {
        if (Mods.GECKOLIB.isLoaded()) {
            return Registry.register(Registries.ITEM, new Identifier(OctoComputing.MOD_ID, "leaf_core"), new AnimatedLeafCore(new FabricItemSettings()));
        }
        return Registry.register(Registries.ITEM, new Identifier(OctoComputing.MOD_ID, "leaf_core"), new Item(new FabricItemSettings()));
    }
    public static final Item CHLOROPHYTE_DEBRIS = registerItem("chlorophyte_debris",
            new Item(new FabricItemSettings()));
    public static final Item CHLOROPHYTE_INGOT = registerItem("chlorophyte_ingot",
            new Item(new FabricItemSettings()));
    public static final Item BROKEN_LEAF_CORE = registerItem("broken_leaf_core",
            new Item(new FabricItemSettings()));

    public static final Item LEAFITE_UPGRADE_SMITHING_TEMPLATE = registerItem("leafite_upgrade_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable(Util.createTranslationKey("item", new Identifier(OctoComputing.MOD_ID, "smithing_template.leafite_upgrade.applies_to"))).formatted(Formatting.BLUE),
                    Text.translatable(Util.createTranslationKey("item", new Identifier(OctoComputing.MOD_ID, "smithing_template.leafite_upgrade.ingredients"))).formatted(Formatting.BLUE),
                    Text.translatable(Util.createTranslationKey("upgrade", new Identifier(OctoComputing.MOD_ID, "leafite_upgrade"))).formatted(Formatting.GRAY),
                    Text.translatable(Util.createTranslationKey("item", new Identifier(OctoComputing.MOD_ID ,"smithing_template.leafite_upgrade.base_slot_description"))),
                    Text.translatable(Util.createTranslationKey("item", new Identifier(OctoComputing.MOD_ID ,"smithing_template.leafite_upgrade.additions_slot_description"))),
                    List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE),
                    List.of(EMPTY_SLOT_INGOT_TEXTURE)
            ));
    public static final Item CHLOROPHYTE_UPGRADE_SMITHING_TEMPLATE = registerItem("chlorophyte_upgrade_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable(Util.createTranslationKey("item", new Identifier(OctoComputing.MOD_ID, "smithing_template.chlorophyte_upgrade.applies_to"))).formatted(Formatting.BLUE),
                    Text.translatable(Util.createTranslationKey("item", new Identifier(OctoComputing.MOD_ID, "smithing_template.chlorophyte_upgrade.ingredients"))).formatted(Formatting.BLUE),
                    Text.translatable(Util.createTranslationKey("upgrade", new Identifier(OctoComputing.MOD_ID, "chlorophyte_upgrade"))).formatted(Formatting.GRAY),
                    Text.translatable(Util.createTranslationKey("item", new Identifier(OctoComputing.MOD_ID ,"smithing_template.chlorophyte_upgrade.base_slot_description"))),
                    Text.translatable(Util.createTranslationKey("item", new Identifier(OctoComputing.MOD_ID ,"smithing_template.chlorophyte_upgrade.additions_slot_description"))),
                    List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE),
                    List.of(EMPTY_SLOT_INGOT_TEXTURE)
            ));

    public static final Item LEAFITE_HELMET = registerItem("leafite_helmet",
            new LeafiteArmor(ArmorItem.Type.HELMET));
    public static final Item LEAFITE_CHESTPLATE = registerItem("leafite_chestplate",
            new LeafiteArmor(ArmorItem.Type.CHESTPLATE));
    public static final Item LEAFITE_LEGGINGS = registerItem("leafite_leggings",
            new LeafiteArmor(ArmorItem.Type.LEGGINGS));
    public static final Item LEAFITE_BOOTS = registerItem("leafite_boots",
            new LeafiteArmor(ArmorItem.Type.BOOTS));

    public static final Item LEAFITE_SWORD = registerItem("leafite_sword",
            new LeafiteSword(ModToolMaterial.LEAFITE, 5, -1.5f, new FabricItemSettings()));
    public static final Item LEAFITE_PICKAXE = registerItem("leafite_pickaxe",
            new PickaxeItem(ModToolMaterial.LEAFITE, 1, -2.0f, new FabricItemSettings()));
    public static final Item LEAFITE_AXE = registerItem("leafite_axe",
            new AxeItem(ModToolMaterial.LEAFITE, 7, -2.5f, new FabricItemSettings()));
    public static final Item LEAFITE_SHOVEL = registerItem("leafite_shovel",
            new ShovelItem(ModToolMaterial.LEAFITE, 1, -2.5f, new FabricItemSettings()));
    public static final Item LEAFITE_HOE = registerItem("leafite_hoe",
            new HoeItem(ModToolMaterial.LEAFITE, 1, 0.0f, new FabricItemSettings()));

    public static final Item CHLOROPHYTE_HELMET = registerItem("chlorophyte_helmet",
            new ChlorophiteArmor(ArmorItem.Type.HELMET));
    public static final Item CHLOROPHYTE_CHESTPLATE = registerItem("chlorophyte_chestplate",
            new ChlorophiteArmor(ArmorItem.Type.CHESTPLATE));
    public static final Item CHLOROPHYTE_LEGGINGS = registerItem("chlorophyte_leggings",
            new ChlorophiteArmor(ArmorItem.Type.LEGGINGS));
    public static final Item CHLOROPHYTE_BOOTS = registerItem("chlorophyte_boots",
            new ChlorophiteArmor(ArmorItem.Type.BOOTS));
    public static final Item CHLOROPHYTE_SWORD = registerItem("chlorophyte_sword",
            new ChlorophiteSword());
    public static final Item CHLOROPHYTE_PICKAXE = registerItem("chlorophyte_pickaxe",
            new PickaxeItem(ModToolMaterial.CHLOROPHYTE, 1, -1.5f, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_AXE = registerItem("chlorophyte_axe",
            new ChlorophyteAxe());
    public static final Item CHLOROPHYTE_SHOVEL = registerItem("chlorophyte_shovel",
            new ShovelItem(ModToolMaterial.CHLOROPHYTE, 1, -2.0f, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_HOE = registerItem("chlorophyte_hoe",
            new HoeItem(ModToolMaterial.CHLOROPHYTE, 1, 0.5f, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(OctoComputing.MOD_ID, name), item);
    }

    public static void registerModItems() {
        OctoComputing.LOGGER.info("Registering Items for " + OctoComputing.MOD_ID);
    }

}
