package com.goggaguys.world.biome;

import com.goggaguys.OctoComputing;
import com.goggaguys.entity.ModEntities;
import com.goggaguys.world.ModPlacedFeatures;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class ModBiomes {
    public static final RegistryKey<Biome> LEAF_BIOME = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(OctoComputing.MOD_ID, "leaf_biome"));

    public static void bootstrap(Registerable<Biome> context) {
        context.register(LEAF_BIOME, leafBiome(context));
    }

    private static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    private static Biome leafBiome(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ModEntities.LEAF_MONSTER, 1, 2, 4));

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(
                        context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.LEAF_DIMENSION_LEAF_ORE_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MYSTERY_PLACED_KEY);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(1f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x123456)
                        .waterFogColor(0x123456)
                        .skyColor(0x123456)
                        .grassColor(0x123456)
                        .foliageColor(0x123456)
                        .fogColor(0x123456).build())
                .build();
    }
}
