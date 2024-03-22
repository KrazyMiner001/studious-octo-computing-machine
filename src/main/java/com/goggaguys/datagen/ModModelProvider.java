package com.goggaguys.datagen;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerTintableCross(ModBlocks.FINNIAN_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAF_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_LEAF_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAFSTONE_BLOCK);

        blockStateModelGenerator.registerLog(ModBlocks.FINNIAN_LOG).log(ModBlocks.FINNIAN_LOG).wood(ModBlocks.FINNIAN_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_FINNIAN_LOG).log(ModBlocks.STRIPPED_FINNIAN_LOG).wood(ModBlocks.STRIPPED_FINNIAN_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FINNIAN_LEAVES);

        BlockStateModelGenerator.BlockTexturePool finnian_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FINNIAN_PLANKS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.OAK_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_COMPRESSED_OAK_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_OAK_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.FINNIAN_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAFSTONE, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAF_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAF_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAF_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAF_BOOTS);

    }
}
