package com.goggaguys.block;

import com.goggaguys.OctoComputing;
import com.goggaguys.world.tree.ModSaplingGenerators;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block FINNIAN_SAPLING = registerBlock("finnian_sapling",
            new SaplingBlock(ModSaplingGenerators.FINNIAN_TREE, FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block LEAF_ORE = registerBlock("leaf_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.STONE).strength(2f)));
    public static final Block DEEPSLATE_LEAF_ORE = registerBlock("deepslate_leaf_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(3f)));
    public static final Block LEAFSTONE_BLOCK = registerBlock("leafstone_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block FINNIAN_LOG = registerBlock("finnian_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f)));
    public static final Block FINNIAN_WOOD = registerBlock("finnian_wood",
        new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_FINNIAN_LOG = registerBlock("stripped_finnian_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public static final Block STRIPPED_FINNIAN_WOOD = registerBlock("stripped_finnian_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f)));

    public static final Block FINNIAN_PLANKS = registerBlock("finnian_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)));
    public static final Block FINNIAN_LEAVES = registerBlock("finnian_leaves",
        new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(4f).nonOpaque()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(OctoComputing.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(OctoComputing.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        OctoComputing.LOGGER.info("Registering Blocks");
    }
}
