package com.goggaguys.item;

import com.goggaguys.OctoComputing;
import com.goggaguys.entity.ModEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
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

    public static final Item LEAF_MONSTER_SPAWN_EGG = registerItem("leaf_spawn_egg",
            new SpawnEggItem(ModEntities.LEAF_MONSTER_ENTITY, 0x0BA40B, 0x5D4A09, new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(OctoComputing.MOD_ID, name), item);
    }

    public static void registerModItems() {
        OctoComputing.LOGGER.info("Registering Items");
    }
}
