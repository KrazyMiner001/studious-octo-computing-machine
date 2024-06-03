package tech.krazyminer001.world.tree;

import tech.krazyminer001.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator MYSTERY_TREE =
            new SaplingGenerator("mystery", 0f,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.MYSTERY_TREE_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());

    public static final SaplingGenerator TRANSIENTWOOD_TREE =
            new SaplingGenerator("transientwood", 0f,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.TRANSIENTWOOD_TREE_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());

    public static final SaplingGenerator ENDERGLEAM_TREE =
            new SaplingGenerator("endergleam", 0f,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.ENDERGLEAM_TREE_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
}
