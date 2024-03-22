package com.goggaguys.item;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> leaf = TagKey.of(RegistryKeys.ITEM, new Identifier("octocomputing", "leaf"));
    public static final TagKey<Item> finnian_logs = TagKey.of(RegistryKeys.ITEM, new Identifier("octocomputing", "finnian_logs"));
}
