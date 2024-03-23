package com.goggaguys.world.tree;

import net.minecraft.block.SaplingGenerator;

import com.goggaguys.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator MYSTERY_TREE =
            new SaplingGenerator("mystery", 0f,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.MYSTERY_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());

}
