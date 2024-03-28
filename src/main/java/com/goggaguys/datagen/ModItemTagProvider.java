package com.goggaguys.datagen;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.item.ModItemTags;
import com.goggaguys.item.ModItems;
import com.goggaguys.utilities.CompressedChainMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModItemTags.LEAF)
                .add(CompressedChainMap.compressedChainMap.regularToCompressed.keySet().toArray(new Item[]{}));

        getOrCreateTagBuilder(ModItemTags.LEAF_COMPRESSED)
                .add(CompressedChainMap.compressedChainMap.regularToCompressed.values().toArray(new Item[]{}));

        getOrCreateTagBuilder(ModItemTags.LEAF_DOUBLE_COMPRESSED)
                .add(CompressedChainMap.compressedChainMap.compressedToDoubleCompressed.values().toArray(new Item[]{}));

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.MYSTERY_PLANKS.asItem());

        getOrCreateTagBuilder(ModItemTags.MYSTERY_LOGS)
                .add(ModBlocks.MYSTERY_LOG.asItem())
                .add(ModBlocks.MYSTERY_WOOD.asItem())
                .add(ModBlocks.STRIPPED_MYSTERY_LOG.asItem())
                .add(ModBlocks.STRIPPED_MYSTERY_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.LEAF_HELMET, ModItems.LEAF_CHESTPLATE, ModItems.LEAF_LEGGINGS, ModItems.LEAF_BOOTS);
    }
}
