package tech.krazyminer001.item;

import tech.krazyminer001.OctoComputing;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import static tech.krazyminer001.utility.Util.of;


public class ModItemTags {
    public static final TagKey<Item> LEAF_DOUBLE_COMPRESSED = TagKey.of(RegistryKeys.ITEM, of("leaf_double_compressed"));
    public static final TagKey<Item> LEAF_COMPRESSED = TagKey.of(RegistryKeys.ITEM, of("leaf_compressed"));
    public static final TagKey<Item> LEAF = TagKey.of(RegistryKeys.ITEM, of("leaf"));
    public static final TagKey<Item> MYSTERY_LOGS = TagKey.of(RegistryKeys.ITEM, of("mystery_logs"));
}
