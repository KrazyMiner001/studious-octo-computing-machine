package com.goggaguys.world.biome;

import com.goggaguys.OctoComputing;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomeTags {
    public static TagKey<Biome> FALL_TO_OVERWORLD = TagKey.of(RegistryKeys.BIOME, new Identifier(OctoComputing.MOD_ID, "fall_to_overworld"));

    public static TagKey<Biome> HAS_ETERNALWOOD_TREE = TagKey.of(RegistryKeys.BIOME,
            new Identifier(OctoComputing.MOD_ID, "has_structure/eternalwood_tree"));
}
