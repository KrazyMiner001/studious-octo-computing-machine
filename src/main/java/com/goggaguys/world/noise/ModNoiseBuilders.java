package com.goggaguys.world.noise;

import com.goggaguys.OctoComputing;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.GenerationShapeConfig;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import net.minecraft.world.gen.densityfunction.DensityFunctionTypes;
import net.minecraft.world.gen.noise.NoiseRouter;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

import java.util.List;

public class ModNoiseBuilders {
    private static final MaterialRules.MaterialRule GRASS_BLOCK = MaterialRules.block(Blocks.GRASS_BLOCK.getDefaultState());
    private static final MaterialRules.MaterialRule DIRT = MaterialRules.block(Blocks.DIRT.getDefaultState());

    public static ChunkGeneratorSettings leafyChunkSettings(RegistryEntryLookup<DensityFunction> densityFunctions, RegistryEntryLookup<DoublePerlinNoiseSampler.NoiseParameters> noise) {
        return new ChunkGeneratorSettings(
                new GenerationShapeConfig(320, 128, 2 ,1),
                Blocks.STONE.getDefaultState(),
                Blocks.WATER.getDefaultState(),
                makeNoiseRouter(densityFunctions, noise),
                leafySurfaceRules(),
                List.of(),
                -64,
                false,
                false,
                false,
                false
        );
    }

    public static MaterialRules.MaterialRule leafySurfaceRules() {
        MaterialRules.MaterialRule surface = MaterialRules.sequence(MaterialRules.condition(MaterialRules.water(-1, 0), GRASS_BLOCK), DIRT);
        return MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, surface), MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, DIRT));
    }

    private static NoiseRouter makeNoiseRouter(RegistryEntryLookup<DensityFunction> densityFunctions, RegistryEntryLookup<DoublePerlinNoiseSampler.NoiseParameters> noise) {
        return createNoiseRouter(densityFunctions, noise, buildFinalDensity(densityFunctions));
    }

    private static DensityFunction slide(DensityFunction density, int minY, int maxY, int fromYTop, int toYTop, double offset1, int fromYBottom, int toYBottom, double offset2) {
        DensityFunction topSlide = DensityFunctionTypes.yClampedGradient(maxY + minY - fromYTop, maxY + minY - toYTop, 1, 0);
        density = DensityFunctionTypes.lerp(topSlide, offset1, density);
        DensityFunction bottomSlide = DensityFunctionTypes.yClampedGradient(minY + fromYBottom, minY + toYBottom, 0, 1);
        return DensityFunctionTypes.lerp(bottomSlide, offset2, density);
    }

    private static NoiseRouter createNoiseRouter(RegistryEntryLookup<DensityFunction> densityFunctions, RegistryEntryLookup<DoublePerlinNoiseSampler.NoiseParameters> noise, DensityFunction finalDensity) {
        DensityFunction shiftX = getFunction(densityFunctions, RegistryKey.of(RegistryKeys.DENSITY_FUNCTION, new Identifier("shift_x")));
        DensityFunction shiftZ = getFunction(densityFunctions, RegistryKey.of(RegistryKeys.DENSITY_FUNCTION, new Identifier("shift_z")));
        DensityFunction temperature = DensityFunctionTypes.shiftedNoise(shiftX, shiftZ, 0.25, noise.getOrThrow(ModNoises.TEMPERATURE));
        DensityFunction vegetation = DensityFunctionTypes.shiftedNoise(shiftX, shiftZ, 0.25, noise.getOrThrow(ModNoises.VEGETATION));
        return new NoiseRouter(
                DensityFunctionTypes.zero(), // barrier noise
                DensityFunctionTypes.zero(), // fluid level floodedness noise
                DensityFunctionTypes.zero(), // fluid level spread noise
                DensityFunctionTypes.zero(), // lava noise
                temperature, // temperature
                vegetation, // vegetation
                DensityFunctionTypes.zero(), // continentalness noise
                DensityFunctionTypes.zero(), // erosion noise
                DensityFunctionTypes.zero(), // depth
                DensityFunctionTypes.zero(), // ridges
                DensityFunctionTypes.zero(), // initial density without jaggedness, not sure if this is needed. Some vanilla dimensions use this while others don't.
                finalDensity, // finaldensity
                DensityFunctionTypes.zero(), // veinToggle
                DensityFunctionTypes.zero(), // veinRidged
                DensityFunctionTypes.zero()); // veinGap
    }

    private static DensityFunction buildFinalDensity(RegistryEntryLookup<DensityFunction> densityFunctions) {
        DensityFunction density = getFunction(densityFunctions, RegistryKey.of(RegistryKeys.DENSITY_FUNCTION, new Identifier(OctoComputing.MOD_ID,"base_3d_noise_leafy")));
        density = DensityFunctionTypes.add(density, DensityFunctionTypes.constant(-0.13));
        density = slide(density, 320, 128, 72, 0, -0.2, 8, 40, -0.1);
        density = DensityFunctionTypes.add(density, DensityFunctionTypes.constant(-0.05));
        density = DensityFunctionTypes.blendDensity(density);
        density = DensityFunctionTypes.interpolated(density);
        density = density.squeeze();
        return density;
    }

    private static DensityFunction getFunction(RegistryEntryLookup<DensityFunction> densityFunctions, RegistryKey<DensityFunction> key) {
        return new DensityFunctionTypes.RegistryEntryHolder(densityFunctions.getOrThrow(key));
    }
}
