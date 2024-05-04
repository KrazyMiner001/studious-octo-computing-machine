package com.goggaguys.block;

import com.goggaguys.OctoComputing;
import com.goggaguys.block.custom.*;
import com.goggaguys.world.tree.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block MYSTERY_SAPLING = registerBlockAndItem("mystery_sapling",
            new SaplingBlock(ModSaplingGenerators.MYSTERY_TREE, Block.Settings.copy(Blocks.OAK_SAPLING)));
    public static final Block LEAF_ORE = registerBlockAndItem("leaf_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), Block.Settings.copy(Blocks.STONE).strength(2f)));
    public static final Block DEEPSLATE_LEAF_ORE = registerBlockAndItem("deepslate_leaf_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), Block.Settings.copy(Blocks.DEEPSLATE).strength(3f)));
    public static final Block EXTRATERRESTRIAL_LEAF_DEBRIS = registerBlockAndItem("extraterrestrial_leaf_debris",
            new Block(Block.Settings.copy(Blocks.ANCIENT_DEBRIS)));
    public static final Block LEAFSTONE_BLOCK = registerBlockAndItem("leafstone_block", new Block(Block.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block CHLOROPHYTE_BLOCK = registerBlockAndItem("chlorophyte_block",
            new Block(Block.Settings.copy(Blocks.NETHERITE_BLOCK)));

    public static final Block MYSTERY_LOG = registerBlockAndItem("mystery_log",
            new PillarBlock(Block.Settings.copy(Blocks.OAK_LOG).strength(4f)));
    public static final Block MYSTERY_WOOD = registerBlockAndItem("mystery_wood",
        new PillarBlock(Block.Settings.copy(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_MYSTERY_LOG = registerBlockAndItem("stripped_mystery_log",
            new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public static final Block STRIPPED_MYSTERY_WOOD = registerBlockAndItem("stripped_mystery_wood",
            new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_WOOD).strength(4f)));
    public static final Block MYSTERY_PLANKS = registerBlockAndItem("mystery_planks",
            new Block(Block.Settings.copy(Blocks.OAK_PLANKS).strength(4f)));
    public static final Block MYSTERY_LEAVES = registerBlockAndItem("mystery_leaves",
        new Block(Block.Settings.copy(Blocks.OAK_LEAVES).strength(4f).nonOpaque()));

    public static final Block TRANSIENTWOOD_SAPLING = registerBlockAndItem("transientwood_sapling",
            new SaplingBlock(ModSaplingGenerators.TRANSIENTWOOD_TREE, Block.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block TRANSIENTWOOD_LOG = registerBlockAndItem("transientwood_log",
            new PillarBlock(Block.Settings.copy(Blocks.OAK_LOG).strength(4f)));
    public static final Block TRANSIENTWOOD = registerBlockAndItem("transientwood",
            new PillarBlock(Block.Settings.copy(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_TRANSIENTWOOD_LOG = registerBlockAndItem("stripped_transientwood_log",
            new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public static final Block STRIPPED_TRANSIENTWOOD = registerBlockAndItem("stripped_transientwood",
            new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_WOOD).strength(4f)));
    public static final Block TRANSIENTWOOD_PLANKS = registerBlockAndItem("transientwood_planks",
            new Block(Block.Settings.copy(Blocks.OAK_PLANKS).strength(4f)));
    public static final Block TRANSIENTWOOD_LEAVES = registerBlockAndItem("transientwood_leaves",
            new Block(Block.Settings.copy(Blocks.OAK_LEAVES).strength(4f).nonOpaque()));

    public static final Block ENDERGLEAM_SAPLING = registerBlockAndItem("endergleam_sapling",
            new SaplingBlock(ModSaplingGenerators.ENDERGLEAM_TREE, Block.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block ENDERGLEAM_LOG = registerBlockAndItem("endergleam_log",
            new EndergleamPillarBlock(Block.Settings.copy(Blocks.OAK_LOG).strength(4f)));
    public static final Block ENDERGLEAM_WOOD = registerBlockAndItem("endergleam_wood",
            new EndergleamPillarBlock(Block.Settings.copy(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_ENDERGLEAM_LOG = registerBlockAndItem("stripped_endergleam_log",
            new EndergleamPillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public static final Block STRIPPED_ENDERGLEAM_WOOD = registerBlockAndItem("stripped_endergleam_wood",
            new EndergleamPillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_WOOD).strength(4f)));
    public static final Block ENDERGLEAM_PLANKS = registerBlockAndItem("endergleam_planks",
            new EndergleamBlock(Block.Settings.copy(Blocks.OAK_PLANKS).strength(4f)));
    public static final Block ENDERGLEAM_LEAVES = registerBlockAndItem("endergleam_leaves",
            new EndergleamBlock(Block.Settings.copy(Blocks.OAK_LEAVES).strength(4f).nonOpaque()));

    public static final Block ETERNALWOOD = registerBlockAndItem("eternalwood",
            new PillarBlock(Block.Settings.copy(Blocks.OAK_WOOD).strength(-1.0F, 3600000.0F).dropsNothing().allowsSpawning(Blocks::never).luminance((state) -> 7)));
    public static final Block ETERNALLEAVES = registerBlockAndItem("eternalleaves",
            new LightNotBlockingBlock(Block.Settings.copy(Blocks.OAK_LEAVES).strength(-1.0F, 3600000.0F).dropsNothing().allowsSpawning(Blocks::never).luminance((state) -> 7).nonOpaque().notSolid().blockVision(Blocks::never)));

    public static final Block LEAF_PORTAL = registerBlock("leaf_portal",
            new LeafPortalBlock(Block.Settings.copy(Blocks.NETHER_PORTAL)));
    public static final Block LEAF_PEDESTAL = registerBlockAndItem("leaf_pedestal",
            new LeafPedestalBlock(Block.Settings.copy(Blocks.END_PORTAL_FRAME)));



    private static Block registerBlockAndItem(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(OctoComputing.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(OctoComputing.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(OctoComputing.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        OctoComputing.LOGGER.info("Registering Blocks for " + OctoComputing.MOD_ID);
    }
}
