package com.goggaguys.world;

import com.goggaguys.OctoComputing;
import com.goggaguys.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> STONE_LEAF_ORE_KEY = registerKey("stone_leaf_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEPSLATE_LEAF_ORE_KEY = registerKey("deepslate_leaf_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MYSTERY_KEY = registerKey("mystery");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> stoneLeafOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.LEAF_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> deepSlateLeafOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_LEAF_ORE.getDefaultState()));

        register(context, STONE_LEAF_ORE_KEY, Feature.ORE, new OreFeatureConfig(stoneLeafOres, 1));
        register(context, DEEPSLATE_LEAF_ORE_KEY, Feature.ORE, new OreFeatureConfig(deepSlateLeafOres, 3));

        register(context, MYSTERY_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
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
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(OctoComputing.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
