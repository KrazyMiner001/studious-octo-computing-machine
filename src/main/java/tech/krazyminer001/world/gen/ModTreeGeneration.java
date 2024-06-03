package tech.krazyminer001.world.gen;

import tech.krazyminer001.world.ModPlacedFeatures;
import tech.krazyminer001.world.biome.ModBiomeTags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_ETERNALWOOD_TREE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TRANSIENTWOOD_TREE_PLACED_KEY);
    }
}
