package tech.krazyminer001.world.biome;

import tech.krazyminer001.OctoComputing;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import static tech.krazyminer001.utility.Util.of;


public class ModBiomeTags {
    public static TagKey<Biome> FALL_TO_OVERWORLD = TagKey.of(RegistryKeys.BIOME, of("fall_to_overworld"));

    public static TagKey<Biome> HAS_ETERNALWOOD_TREE = TagKey.of(RegistryKeys.BIOME,
            of("has_structure/eternalwood_tree"));
}
