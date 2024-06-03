package tech.krazyminer001.datagen;


import tech.krazyminer001.world.biome.ModBiomeTags;
import tech.krazyminer001.world.biome.ModBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends FabricTagProvider<Biome> {
    public ModBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BIOME, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModBiomeTags.FALL_TO_OVERWORLD)
                .add(ModBiomes.LEAF_BIOME);

        getOrCreateTagBuilder(ModBiomeTags.HAS_ETERNALWOOD_TREE)
                .add(BiomeKeys.CHERRY_GROVE)
                .add(BiomeKeys.WINDSWEPT_FOREST)
                .add(BiomeKeys.FOREST)
                .add(BiomeKeys.FLOWER_FOREST)
                .add(BiomeKeys.TAIGA)
                .add(BiomeKeys.OLD_GROWTH_PINE_TAIGA)
                .add(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA)
                .add(BiomeKeys.SNOWY_TAIGA)
                .add(BiomeKeys.BIRCH_FOREST)
                .add(BiomeKeys.OLD_GROWTH_BIRCH_FOREST)
                .add(BiomeKeys.DARK_FOREST)
                .add(BiomeKeys.JUNGLE)
                .add(BiomeKeys.SPARSE_JUNGLE)
                .add(BiomeKeys.BAMBOO_JUNGLE)
                .add(BiomeKeys.SWAMP)
                .add(BiomeKeys.MANGROVE_SWAMP)
                .add(BiomeKeys.SAVANNA)
                .add(BiomeKeys.SAVANNA_PLATEAU)
                .add(BiomeKeys.WINDSWEPT_SAVANNA)
                .add(BiomeKeys.WOODED_BADLANDS)
                .add(ModBiomes.LEAF_BIOME);
    }
}
