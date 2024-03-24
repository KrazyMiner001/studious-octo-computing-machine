package com.goggaguys.datagen;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
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
        registerLeafModels(itemModelGenerator);

        itemModelGenerator.register(ModItems.LEAFSTONE, Models.GENERATED);

        itemModelGenerator.register(ModItems.LEAF_MONSTER_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAF_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAF_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAF_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAF_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.COMPRESSED_LEAF_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.COMPRESSED_LEAF_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.COMPRESSED_LEAF_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.COMPRESSED_LEAF_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.DOUBLE_COMPRESSED_LEAF_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DOUBLE_COMPRESSED_LEAF_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DOUBLE_COMPRESSED_LEAF_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DOUBLE_COMPRESSED_LEAF_BOOTS);

    }

    private void registerLeafModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.OAK_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_COMPRESSED_OAK_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_OAK_LEAF, Models.GENERATED);

        itemModelGenerator.register(ModItems.SPRUCE_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_COMPRESSED_SPRUCE_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_SPRUCE_LEAF, Models.GENERATED);

        itemModelGenerator.register(ModItems.BIRCH_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_COMPRESSED_BIRCH_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_BIRCH_LEAF, Models.GENERATED);

        itemModelGenerator.register(ModItems.JUNGLE_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_COMPRESSED_JUNGLE_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_JUNGLE_LEAF, Models.GENERATED);

        itemModelGenerator.register(ModItems.ACACIA_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_COMPRESSED_ACACIA_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_ACACIA_LEAF, Models.GENERATED);

        itemModelGenerator.register(ModItems.DARK_OAK_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_COMPRESSED_DARK_OAK_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_DARK_OAK_LEAF, Models.GENERATED);

        itemModelGenerator.register(ModItems.AZALEA_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_COMPRESSED_AZALEA_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_AZALEA_LEAF, Models.GENERATED);

        itemModelGenerator.register(ModItems.MANGROVE_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_COMPRESSED_MANGROVE_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_MANGROVE_LEAF, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHERRY_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_COMPRESSED_CHERRY_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_CHERRY_LEAF, Models.GENERATED);

        itemModelGenerator.register(ModItems.MIXED_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_COMPRESSED_MIXED_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_MIXED_LEAF, Models.GENERATED);

        itemModelGenerator.register(ModItems.MYSTERY_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_COMPRESSED_MYSTERY_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPRESSED_MYSTERY_LEAF, Models.GENERATED);
    }
}
