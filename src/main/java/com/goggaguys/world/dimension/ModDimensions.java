package com.goggaguys.world.dimension;

import com.goggaguys.OctoComputing;
import com.goggaguys.world.biome.ModBiomes;
import com.goggaguys.world.noise.ModNoiseSettings;
import com.ibm.icu.impl.CollectionSet;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.FixedBiomeSource;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;

import java.util.*;

public class ModDimensions {
    private static final Map<RegistryKey<DimensionOptions>, DimensionOptions> DIMENSION_OPTIONS = new HashMap<>();
    public static final RegistryKey<DimensionOptions> LEAF_KEY = optionsRegistryKey("leaf");
    public static final RegistryKey<World> LEAF_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(OctoComputing.MOD_ID, "leaf"));
    public static final RegistryKey<DimensionType> LEAF_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(OctoComputing.MOD_ID, "leaf_type"));

    private static RegistryKey<DimensionOptions> optionsRegistryKey (String name) {
        return RegistryKey.of(RegistryKeys.DIMENSION,
                new Identifier(OctoComputing.MOD_ID, name));
    }

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(LEAF_DIM_TYPE, new DimensionType(
                OptionalLong.empty(), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                true, // respawnAnchorWorks
                320, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 5), 15)));
    }
}
