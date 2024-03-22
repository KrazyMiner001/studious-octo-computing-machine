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
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> LEAF_ORE_KEY = registerKey("leaf_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> FINNIAN_KEY = registerKey("finnian");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldLeafOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.LEAF_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_LEAF_ORE.getDefaultState()));

        register(context, LEAF_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldLeafOres, 3));

        register(context, FINNIAN_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.FINNIAN_LOG),
                new CherryTrunkPlacer(5, 2, 4,
                        UniformIntProvider.create(2, 3),
                        UniformIntProvider.create(3, 5),
                        UniformIntProvider.create(-2, -1),
                        UniformIntProvider.create(-1, 0)),

                BlockStateProvider.of(ModBlocks.FINNIAN_LEAVES),
                new CherryFoliagePlacer(UniformIntProvider.create(3, 5),
                        ConstantIntProvider.create(0),
                        UniformIntProvider.create(5, 7),
                        0.25f, 0.25f, 0.25f, 0.25f),

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
