package tech.krazyminer001.block;

import tech.krazyminer001.OctoComputing;
import static tech.krazyminer001.utility.Util.of;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> INCORRECT_FOR_LEAFITE_TOOL = TagKey.of(RegistryKeys.BLOCK, of("incorrect_for_leafite_tool"));
    public static final TagKey<Block> INCORRECT_FOR_CHLOROPHYTE_TOOL = TagKey.of(RegistryKeys.BLOCK, of("incorrect_for_chlorophyte_tool"));
}
