package com.goggaguys.item;

import com.goggaguys.OctoComputing;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;
import java.util.List;

public class ModItemTags {
    public static final TagKey<Item> LEAF_DOUBLE_COMPRESSED = TagKey.of(RegistryKeys.ITEM, new Identifier(OctoComputing.MOD_ID, "leaf_double_compressed"));
    public static final TagKey<Item> LEAF_COMPRESSED = TagKey.of(RegistryKeys.ITEM, new Identifier(OctoComputing.MOD_ID, "leaf_compressed"));
    public static final TagKey<Item> LEAF = TagKey.of(RegistryKeys.ITEM, new Identifier(OctoComputing.MOD_ID, "leaf"));
    public static final TagKey<Item> MYSTERY_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(OctoComputing.MOD_ID, "mystery_logs"));

    //Not tags but useful for the tags
    public static final Item [] leaves = new Item[] {
            ModItems.OAK_LEAF,
            ModItems.SPRUCE_LEAF,
            ModItems.BIRCH_LEAF,
            ModItems.JUNGLE_LEAF,
            ModItems.ACACIA_LEAF,
            ModItems.DARK_OAK_LEAF,
            ModItems.AZALEA_LEAF,
            ModItems.MANGROVE_LEAF,
            ModItems.CHERRY_LEAF,
            ModItems.MIXED_LEAF,
            ModItems.MYSTERY_LEAF
    };

    public static final Item[] compressedLeaves = new Item[] {
            ModItems.COMPRESSED_OAK_LEAF,
            ModItems.COMPRESSED_SPRUCE_LEAF,
            ModItems.COMPRESSED_BIRCH_LEAF,
            ModItems.COMPRESSED_JUNGLE_LEAF,
            ModItems.COMPRESSED_ACACIA_LEAF,
            ModItems.COMPRESSED_DARK_OAK_LEAF,
            ModItems.COMPRESSED_AZALEA_LEAF,
            ModItems.COMPRESSED_MANGROVE_LEAF,
            ModItems.COMPRESSED_CHERRY_LEAF,
            ModItems.COMPRESSED_MIXED_LEAF,
            ModItems.COMPRESSED_MYSTERY_LEAF
    };

    public static final Item[] doubleCompressedLeaves = new Item[] {
            ModItems.DOUBLE_COMPRESSED_OAK_LEAF,
            ModItems.DOUBLE_COMPRESSED_SPRUCE_LEAF,
            ModItems.DOUBLE_COMPRESSED_BIRCH_LEAF,
            ModItems.DOUBLE_COMPRESSED_JUNGLE_LEAF,
            ModItems.DOUBLE_COMPRESSED_ACACIA_LEAF,
            ModItems.DOUBLE_COMPRESSED_DARK_OAK_LEAF,
            ModItems.DOUBLE_COMPRESSED_AZALEA_LEAF,
            ModItems.DOUBLE_COMPRESSED_MANGROVE_LEAF,
            ModItems.DOUBLE_COMPRESSED_CHERRY_LEAF,
            ModItems.DOUBLE_COMPRESSED_MIXED_LEAF,
            ModItems.DOUBLE_COMPRESSED_MYSTERY_LEAF
    };
}
