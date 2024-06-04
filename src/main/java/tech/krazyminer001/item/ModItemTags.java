package tech.krazyminer001.item;

import tech.krazyminer001.OctoComputing;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> LEAF_DOUBLE_COMPRESSED = TagKey.of(RegistryKeys.ITEM, new Identifier(OctoComputing.MOD_ID, "leaf_double_compressed"));
    public static final TagKey<Item> LEAF_COMPRESSED = TagKey.of(RegistryKeys.ITEM, new Identifier(OctoComputing.MOD_ID, "leaf_compressed"));
    public static final TagKey<Item> LEAF = TagKey.of(RegistryKeys.ITEM, new Identifier(OctoComputing.MOD_ID, "leaf"));
    public static final TagKey<Item> MYSTERY_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(OctoComputing.MOD_ID, "mystery_logs"));
}