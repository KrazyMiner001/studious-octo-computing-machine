package com.goggaguys.world.gen;

import com.goggaguys.world.ModPlacedFeatures;
import com.goggaguys.world.biome.ModBiomeTags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_ETERNALWOOD_TREE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TRANSIENTWOOD_TREE_PLACED_KEY);
    }
}
