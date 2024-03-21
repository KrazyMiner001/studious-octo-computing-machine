package com.goggaguys.datagen;

import com.goggaguys.block.OctoBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }
    @Override
    public void generate() {
        addDrop(OctoBlocks.FINNIAN_SAPLING);
        addDrop(OctoBlocks.LEAF_ORE);
        addDrop(OctoBlocks.DEEPSLATE_LEAF_ORE);
    }
}
