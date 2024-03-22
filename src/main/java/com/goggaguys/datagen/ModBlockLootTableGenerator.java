package com.goggaguys.datagen;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }
    @Override
    public void generate() {
        addDrop(ModBlocks.FINNIAN_SAPLING);
        addDrop(ModBlocks.LEAF_ORE, oreDrops(ModBlocks.LEAF_ORE, ModItems.LEAFSTONE));
        addDrop(ModBlocks.DEEPSLATE_LEAF_ORE, oreDrops(ModBlocks.DEEPSLATE_LEAF_ORE, ModItems.LEAFSTONE));
    }
}
