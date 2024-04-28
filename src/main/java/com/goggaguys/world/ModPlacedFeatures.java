package com.goggaguys.world;

import com.goggaguys.OctoComputing;
import com.goggaguys.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.ArrayList;
import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> MYSTERY_PLACED_KEY = registerKey("mystery_placed");

    public static final RegistryKey<PlacedFeature> CUSTOM_TREE_FEATURE_PLACED_KEY = registerKey("custom_tree_feature_placed");

    public static final RegistryKey<PlacedFeature> STONE_LEAF_ORE_PLACED_KEY = registerKey("stone_leaf_ore_placed");
    public static final RegistryKey<PlacedFeature> DEEPSLATE_LEAF_ORE_PLACED_KEY = registerKey("deepslate_leaf_ore_placed");
    public static final RegistryKey<PlacedFeature> LEAF_DIMENSION_LEAF_ORE_PLACED_KEY = registerKey("leaf_dimension_leaf_ore_placed");
    public static final RegistryKey<PlacedFeature> EXTRATERRESTRIAL_LEAF_DEBRIS_PLACED_KEY = registerKey("extraterrestrial_leaf_debris_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, STONE_LEAF_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.STONE_LEAF_ORE_KEY),
                ModOrePlacement.modifiersWithCount(1,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(20))));

        register(context, DEEPSLATE_LEAF_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DEEPSLATE_LEAF_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8,
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-40), YOffset.aboveBottom(40))));

        register(context, LEAF_DIMENSION_LEAF_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LEAF_DIMENSION_LEAF_ORE_KEY),
                ModOrePlacement.modifiersWithCount(12,
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-40), YOffset.TOP)));
        register(context, EXTRATERRESTRIAL_LEAF_DEBRIS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.EXTRATERRESTRIAL_LEAF_DEBRIS_KEY),
                ModOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(30), YOffset.aboveBottom(60))));

        register(context, MYSTERY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MYSTERY_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2),
                        ModBlocks.MYSTERY_SAPLING));

        register(context, CUSTOM_TREE_FEATURE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CUSTOM_TREE_FEATURE_KEY),
                new ArrayList<>());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(OctoComputing.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
