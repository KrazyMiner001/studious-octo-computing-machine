package com.goggaguys.datagen;

import com.goggaguys.world.noise.ModDensityFunctions;
import com.goggaguys.world.noise.ModNoiseSettings;
import com.goggaguys.world.noise.ModNoises;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModWorldGenerator extends FabricDynamicRegistryProvider {
    public ModWorldGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.BIOME));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.DIMENSION_TYPE));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.NOISE_PARAMETERS));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.DENSITY_FUNCTION));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CHUNK_GENERATOR_SETTINGS));
    }

    @Override
    public String getName() {
        return "World Gen";
    }

}
