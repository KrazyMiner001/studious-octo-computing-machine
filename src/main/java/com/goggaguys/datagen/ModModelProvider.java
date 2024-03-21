package com.goggaguys.datagen;

import com.goggaguys.block.OctoBlocks;
import com.goggaguys.item.OctoItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerTintableCross(OctoBlocks.FINNIAN_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(OctoBlocks.LEAF_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(OctoBlocks.DEEPSLATE_LEAF_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(OctoItems.OAK_LEAF, Models.GENERATED);
        itemModelGenerator.register(OctoItems.DOUBLE_COMPRESSED_OAK_LEAF, Models.GENERATED);
        itemModelGenerator.register(OctoItems.COMPRESSED_OAK_LEAF, Models.GENERATED);
        itemModelGenerator.register(OctoItems.FINNIAN_LEAF, Models.GENERATED);
    }
}
