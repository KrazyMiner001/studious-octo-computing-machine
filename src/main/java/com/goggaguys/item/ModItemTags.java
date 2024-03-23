package com.goggaguys.item;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> leaf_double_compressed = TagKey.of(RegistryKeys.ITEM, new Identifier("octocomputing", "leaf_double_compressed"));
    public static final TagKey<Item> leaf_compressed = TagKey.of(RegistryKeys.ITEM, new Identifier("octocomputing", "leaf_compressed"));
    public static final TagKey<Item> leaf = TagKey.of(RegistryKeys.ITEM, new Identifier("octocomputing", "leaf"));
    public static final TagKey<Item> mystery_logs = TagKey.of(RegistryKeys.ITEM, new Identifier("octocomputing", "mystery_logs"));
}
