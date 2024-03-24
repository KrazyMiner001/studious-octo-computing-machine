package com.goggaguys.datagen;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }
    @Override
    public void generate() {
        addDrop(ModBlocks.MYSTERY_SAPLING);
        addDrop(ModBlocks.MYSTERY_LOG);
        addDrop(ModBlocks.MYSTERY_WOOD);
        addDrop(ModBlocks.STRIPPED_MYSTERY_LOG);
        addDrop(ModBlocks.STRIPPED_MYSTERY_WOOD);
        addDrop(ModBlocks.LEAFSTONE_BLOCK);

        addDrop(ModBlocks.LEAF_ORE, oreDrops(ModBlocks.LEAF_ORE, ModItems.LEAFSTONE));
        addDrop(ModBlocks.DEEPSLATE_LEAF_ORE, oreDrops(ModBlocks.DEEPSLATE_LEAF_ORE, ModItems.LEAFSTONE));

        addDrop(ModBlocks.MYSTERY_LEAVES, leavesDrops(ModBlocks.MYSTERY_LEAVES, ModBlocks.MYSTERY_SAPLING, BlockLootTableGenerator.SAPLING_DROP_CHANCE));
    }
}
