package com.goggaguys.block;

import com.goggaguys.OctoComputing;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> INCORRECT_FOR_LEAFITE_TOOL = TagKey.of(RegistryKeys.BLOCK, new Identifier(OctoComputing.MOD_ID, "incorrect_for_leafite_tool"));
    public static final TagKey<Block> INCORRECT_FOR_CHLOROPHYTE_TOOL = TagKey.of(RegistryKeys.BLOCK, new Identifier(OctoComputing.MOD_ID, "incorrect_for_chlorophyte_tool"));
}
