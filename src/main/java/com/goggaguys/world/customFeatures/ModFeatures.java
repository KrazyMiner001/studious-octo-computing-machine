package com.goggaguys.world.customFeatures;

import com.goggaguys.OctoComputing;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;

public class ModFeatures {
    public static final Identifier CUSTOM_TREE_FEATURE_ID = new Identifier(OctoComputing.MOD_ID, "custom_tree_feature");
    public static final CustomTreeFeature CUSTOM_TREE_FEATURE = register(CUSTOM_TREE_FEATURE_ID,
            new CustomTreeFeature(CustomTreeFeatureConfig.CODEC));

    public static <T extends Feature<?>> T register(Identifier id, T feature) {
        return Registry.register(Registries.FEATURE, id, feature);
    }

    public static void registerModFeatures() {
        OctoComputing.LOGGER.info("Registering Features for " + OctoComputing.MOD_ID);
    }
}
