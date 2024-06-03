package tech.krazyminer001.world.noise;

import tech.krazyminer001.OctoComputing;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;

public class ModNoises {
    public static final RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> TEMPERATURE = registerKey("temperature");
    public static final RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> VEGETATION = registerKey("vegetation");

    public static void bootstrap(Registerable<DoublePerlinNoiseSampler.NoiseParameters> context) {
        register(context, TEMPERATURE, -8, 1.5, 0.0, 1.0, 0.0, 0.0, 0.0);
        register(context, VEGETATION, -7, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0);
    }

    private static void register(Registerable<DoublePerlinNoiseSampler.NoiseParameters> context,
                                 RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> key, int firstOctave,
                                 double firstAmplitude, double... amplitudes) {
        context.register(key, new DoublePerlinNoiseSampler.NoiseParameters(firstOctave, firstAmplitude, amplitudes));
    }


    private static RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.NOISE_PARAMETERS, new Identifier(OctoComputing.MOD_ID, name));
    }
}
