package com.goggaguys.datagen;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.item.ModItems;
import com.goggaguys.model.ModItemModelGenerator;
import com.goggaguys.utilities.CompressedChainMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerTintableCross(ModBlocks.MYSTERY_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAF_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_LEAF_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAFSTONE_BLOCK);

        blockStateModelGenerator.registerLog(ModBlocks.MYSTERY_LOG).log(ModBlocks.MYSTERY_LOG).wood(ModBlocks.MYSTERY_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MYSTERY_LOG).log(ModBlocks.STRIPPED_MYSTERY_LOG).wood(ModBlocks.STRIPPED_MYSTERY_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MYSTERY_LEAVES);

        BlockStateModelGenerator.BlockTexturePool mystery_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MYSTERY_PLANKS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        ModItemModelGenerator modItemModelGenerator = new ModItemModelGenerator(itemModelGenerator.writer);

        CompressedChainMap compressedChainMap = new CompressedChainMap();

        for (Item i : compressedChainMap.regularToCompressed.keySet()) {
            Item compressed = compressedChainMap.regularToCompressed.get(i);
            Item doubleCompressed = compressedChainMap.compressedToDoubleCompressed.get(compressed);
            modItemModelGenerator.registerCompressedChain(i, compressed, doubleCompressed);
        }

        itemModelGenerator.register(ModItems.LEAFSTONE, Models.GENERATED);

        itemModelGenerator.register(ModItems.LEAF_MONSTER_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

        modItemModelGenerator.registerCompressedArmorChain(
                (ArmorItem) ModItems.LEAF_HELMET,
                (ArmorItem) ModItems.COMPRESSED_LEAF_HELMET,
                (ArmorItem) ModItems.DOUBLE_COMPRESSED_LEAF_HELMET);
        modItemModelGenerator.registerCompressedArmorChain(
                (ArmorItem) ModItems.LEAF_CHESTPLATE,
                (ArmorItem) ModItems.COMPRESSED_LEAF_CHESTPLATE,
                (ArmorItem) ModItems.DOUBLE_COMPRESSED_LEAF_CHESTPLATE);
        modItemModelGenerator.registerCompressedArmorChain(
                (ArmorItem) ModItems.LEAF_LEGGINGS,
                (ArmorItem) ModItems.COMPRESSED_LEAF_LEGGINGS,
                (ArmorItem) ModItems.DOUBLE_COMPRESSED_LEAF_LEGGINGS);
        modItemModelGenerator.registerCompressedArmorChain(
                (ArmorItem) ModItems.LEAF_BOOTS,
                (ArmorItem) ModItems.COMPRESSED_LEAF_BOOTS,
                (ArmorItem) ModItems.DOUBLE_COMPRESSED_LEAF_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAFITE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAFITE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAFITE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAFITE_BOOTS);

        itemModelGenerator.register(ModItems.LEAFITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAFITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAFITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAFITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAFITE_HOE, Models.HANDHELD);

        modItemModelGenerator.registerCompressedHandheldChain(ModItems.LEAF_SWORD, ModItems.COMPRESSED_LEAF_SWORD, ModItems.DOUBLE_COMPRESSED_LEAF_SWORD);
        modItemModelGenerator.registerCompressedHandheldChain(ModItems.LEAF_PICKAXE, ModItems.COMPRESSED_LEAF_PICKAXE, ModItems.DOUBLE_COMPRESSED_LEAF_PICKAXE);
        modItemModelGenerator.registerCompressedHandheldChain(ModItems.LEAF_AXE, ModItems.COMPRESSED_LEAF_AXE, ModItems.DOUBLE_COMPRESSED_LEAF_AXE);
        modItemModelGenerator.registerCompressedHandheldChain(ModItems.LEAF_SHOVEL, ModItems.COMPRESSED_LEAF_SHOVEL, ModItems.DOUBLE_COMPRESSED_LEAF_SHOVEL);
        modItemModelGenerator.registerCompressedHandheldChain(ModItems.LEAF_HOE, ModItems.COMPRESSED_LEAF_HOE, ModItems.DOUBLE_COMPRESSED_LEAF_HOE);

    }
}
