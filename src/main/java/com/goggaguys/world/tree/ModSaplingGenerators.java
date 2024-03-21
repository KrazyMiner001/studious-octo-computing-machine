package com.goggaguys.world.tree;

import net.minecraft.block.sapling.SaplingGenerator;

import com.goggaguys.world.ModConfiguredFeatures;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class ModSaplingGenerators {
    public static final SaplingGenerator FINNIAN_TREE =
            new SaplingGenerator(
            ) {
                @Nullable
                @Override
                protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
                    return ModConfiguredFeatures.FINNIAN_TREE_KEY;
                }
            };

}
