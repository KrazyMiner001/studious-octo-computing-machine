package tech.krazyminer001;

import tech.krazyminer001.damagetype.ModDamageTypes;
import tech.krazyminer001.datagen.*;
import tech.krazyminer001.datagen.lang.ModEnglishLangProvider;
import tech.krazyminer001.world.ModConfiguredFeatures;
import tech.krazyminer001.world.ModPlacedFeatures;
import tech.krazyminer001.world.biome.ModBiomes;
import tech.krazyminer001.world.dimension.ModDimensions;
import tech.krazyminer001.world.noise.ModDensityFunctions;
import tech.krazyminer001.world.noise.ModNoiseSettings;
import tech.krazyminer001.world.noise.ModNoises;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import tech.krazyminer001.datagen.*;


public class OctoComputingDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModDamageTypeProvider::new);
        pack.addProvider(ModBlockLootTableProvider::new);
        pack.addProvider(ModEntityLootTableProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeGenerator::new);
        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModBiomeTagProvider::new);
        pack.addProvider(ModEntityTypeTagProvider::new);
        pack.addProvider(ModDamageTypeTagProvider::new);
        pack.addProvider(ModEnglishLangProvider::new);
        pack.addProvider(ModWorldGenerator::new);
        pack.addProvider(ModAdvancementProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.DAMAGE_TYPE, ModDamageTypes::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, ModDimensions::bootstrapType);
        registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.NOISE_PARAMETERS, ModNoises::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.DENSITY_FUNCTION, ModDensityFunctions::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.CHUNK_GENERATOR_SETTINGS, ModNoiseSettings::bootstrap);
    }
}
