package tech.krazyminer001.world.noise;

import tech.krazyminer001.OctoComputing;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.noise.InterpolatedNoiseSampler;
import net.minecraft.world.gen.densityfunction.DensityFunction;

public class ModDensityFunctions {
    public static final RegistryKey<DensityFunction> BASE_3D_NOISE_LEAFY = registerKey("base_3d_noise_leafy");

    private static RegistryKey<DensityFunction> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.DENSITY_FUNCTION, new Identifier(OctoComputing.MOD_ID, name));
    }

    public static void bootstrap(Registerable<DensityFunction> context) {
        context.register(BASE_3D_NOISE_LEAFY, InterpolatedNoiseSampler.createBase3dNoiseFunction(
                0.25, // xz scale
                0.25, // y scale
                80.0, // xz factor
                160.0, // y factor
                8.0)); // smear scale multiplier, capped at 8
    }
}
