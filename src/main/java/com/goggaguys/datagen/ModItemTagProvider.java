package com.goggaguys.datagen;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.item.ModItemTags;
import com.goggaguys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModItemTags.leaf)
                .add(ModItems.OAK_LEAF)
                .add(ModItems.SPRUCE_LEAF)
                .add(ModItems.BIRCH_LEAF)
                .add(ModItems.JUNGLE_LEAF)
                .add(ModItems.ACACIA_LEAF)
                .add(ModItems.DARK_OAK_LEAF)
                .add(ModItems.AZALEA_LEAF)
                .add(ModItems.MANGROVE_LEAF)
                .add(ModItems.CHERRY_LEAF)
                .add(ModItems.MIXED_LEAF)
                .add(ModItems.MYSTERY_LEAF);

        getOrCreateTagBuilder(ModItemTags.leaf_compressed)
                .add(ModItems.COMPRESSED_OAK_LEAF)
                .add(ModItems.COMPRESSED_SPRUCE_LEAF)
                .add(ModItems.COMPRESSED_BIRCH_LEAF)
                .add(ModItems.COMPRESSED_JUNGLE_LEAF)
                .add(ModItems.COMPRESSED_ACACIA_LEAF)
                .add(ModItems.COMPRESSED_DARK_OAK_LEAF)
                .add(ModItems.COMPRESSED_AZALEA_LEAF)
                .add(ModItems.COMPRESSED_MANGROVE_LEAF)
                .add(ModItems.COMPRESSED_CHERRY_LEAF)
                .add(ModItems.COMPRESSED_MIXED_LEAF)
                .add(ModItems.COMPRESSED_MYSTERY_LEAF);

        getOrCreateTagBuilder(ModItemTags.leaf_double_compressed)
                .add(ModItems.DOUBLE_COMPRESSED_OAK_LEAF)
                .add(ModItems.DOUBLE_COMPRESSED_SPRUCE_LEAF)
                .add(ModItems.DOUBLE_COMPRESSED_BIRCH_LEAF)
                .add(ModItems.DOUBLE_COMPRESSED_JUNGLE_LEAF)
                .add(ModItems.DOUBLE_COMPRESSED_ACACIA_LEAF)
                .add(ModItems.DOUBLE_COMPRESSED_DARK_OAK_LEAF)
                .add(ModItems.DOUBLE_COMPRESSED_AZALEA_LEAF)
                .add(ModItems.DOUBLE_COMPRESSED_MANGROVE_LEAF)
                .add(ModItems.DOUBLE_COMPRESSED_CHERRY_LEAF)
                .add(ModItems.DOUBLE_COMPRESSED_MIXED_LEAF)
                .add(ModItems.DOUBLE_COMPRESSED_MYSTERY_LEAF);

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.MYSTERY_PLANKS.asItem());

        getOrCreateTagBuilder(ModItemTags.mystery_logs)
                .add(ModBlocks.MYSTERY_LOG.asItem())
                .add(ModBlocks.MYSTERY_WOOD.asItem())
                .add(ModBlocks.STRIPPED_MYSTERY_LOG.asItem())
                .add(ModBlocks.STRIPPED_MYSTERY_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.LEAF_HELMET, ModItems.LEAF_CHESTPLATE, ModItems.LEAF_LEGGINGS, ModItems.LEAF_BOOTS);
    }
}
