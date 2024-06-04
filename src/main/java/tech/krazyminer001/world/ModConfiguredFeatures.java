package tech.krazyminer001.world;

import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.block.ModBlocks;
import tech.krazyminer001.world.customFeatures.CustomTreeFeatureConfig;
import tech.krazyminer001.world.customFeatures.ModFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.UpwardsBranchingTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> STONE_LEAF_ORE_KEY = registerKey("stone_leaf_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEPSLATE_LEAF_ORE_KEY = registerKey("deepslate_leaf_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LEAF_DIMENSION_LEAF_ORE_KEY = registerKey("leaf_dimension_leaf_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> EXTRATERRESTRIAL_LEAF_DEBRIS_KEY = registerKey("extraterrestrial_leaf_debris");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CUSTOM_TREE_FEATURE_KEY = registerKey("custom_tree_feature");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MYSTERY_TREE_KEY = registerKey("mystery_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRANSIENTWOOD_TREE_KEY = registerKey("transientwood_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDERGLEAM_TREE_KEY = registerKey("endergleam_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> stoneLeafOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.LEAF_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> extraterrestrialDebris =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.EXTRATERRESTRIAL_LEAF_DEBRIS.getDefaultState()));

        List<OreFeatureConfig.Target> deepSlateLeafOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_LEAF_ORE.getDefaultState()));

        register(context, STONE_LEAF_ORE_KEY, Feature.ORE, new OreFeatureConfig(stoneLeafOres, 1));
        register(context, DEEPSLATE_LEAF_ORE_KEY, Feature.ORE, new OreFeatureConfig(deepSlateLeafOres, 3));
        register(context, LEAF_DIMENSION_LEAF_ORE_KEY, Feature.ORE, new OreFeatureConfig(stoneLeafOres, 5));
        register(context, EXTRATERRESTRIAL_LEAF_DEBRIS_KEY, Feature.SCATTERED_ORE, new OreFeatureConfig(extraterrestrialDebris, 1, 0.5f));

        register(context, MYSTERY_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MYSTERY_LOG),
                new CherryTrunkPlacer(6, 2, 4,
                        UniformIntProvider.create(1, 2),
                        UniformIntProvider.create(3, 5),
                        UniformIntProvider.create(-2, -1),
                        UniformIntProvider.create(-1, 0)),

                BlockStateProvider.of(ModBlocks.MYSTERY_LEAVES),
                new CherryFoliagePlacer(UniformIntProvider.create(2, 4),
                        ConstantIntProvider.create(0),
                        UniformIntProvider.create(4, 6),
                        0.25f, 0.25f, 0.5f, 0.25f),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, TRANSIENTWOOD_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.TRANSIENTWOOD_LOG),
                new UpwardsBranchingTrunkPlacer(
                        6,
                        2,
                        4,
                        UniformIntProvider.create(2, 4),
                        0.25f,
                        UniformIntProvider.create(1, 3),
                        RegistryEntryList.empty()
                ),

                BlockStateProvider.of(ModBlocks.TRANSIENTWOOD_LEAVES),
                new BlobFoliagePlacer(
                        UniformIntProvider.create(2, 3),
                        UniformIntProvider.create(1, 2),
                        3
                ),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, ENDERGLEAM_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ENDERGLEAM_LOG),
                new UpwardsBranchingTrunkPlacer(
                        12,
                        3,
                        6,
                        UniformIntProvider.create(3, 5),
                        0.25f,
                        UniformIntProvider.create(2, 5),
                        RegistryEntryList.empty()
                ),

                BlockStateProvider.of(ModBlocks.ENDERGLEAM_LEAVES),
                new BlobFoliagePlacer(
                        UniformIntProvider.create(2, 4),
                        UniformIntProvider.create(2, 4),
                        2
                ),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, CUSTOM_TREE_FEATURE_KEY, ModFeatures.CUSTOM_TREE_FEATURE, new CustomTreeFeatureConfig(
                150,
                8,
                15,
                new Identifier(OctoComputing.MOD_ID, "eternalwood"),
                new Identifier(OctoComputing.MOD_ID, "eternalleaves")
        ));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(OctoComputing.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}