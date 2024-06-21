package tech.krazyminer001.world.noise;

import tech.krazyminer001.OctoComputing;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import static tech.krazyminer001.utility.Util.of;


public class ModNoiseSettings {
    public static final RegistryKey<ChunkGeneratorSettings> LEAFY = registerKey("leafy");

    public static void bootstrap(Registerable<ChunkGeneratorSettings> context) {
        RegistryEntryLookup<DensityFunction> densityFunctions = context.getRegistryLookup(RegistryKeys.DENSITY_FUNCTION);
        RegistryEntryLookup<DoublePerlinNoiseSampler.NoiseParameters> noise = context.getRegistryLookup(RegistryKeys.NOISE_PARAMETERS);
        context.register(LEAFY, ModNoiseBuilders.leafyChunkSettings(densityFunctions, noise));
    }

    public static RegistryKey<ChunkGeneratorSettings> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CHUNK_GENERATOR_SETTINGS, of(name));
    }
}
