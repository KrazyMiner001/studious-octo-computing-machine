package com.goggaguys.datagen;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.item.ModItemTags;
import com.goggaguys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModItemTags.leaf)
                .add(ModItems.OAK_LEAF)
                .add(ModItems.COMPRESSED_OAK_LEAF)
                .add(ModItems.DOUBLE_COMPRESSED_OAK_LEAF)
                .add(ModItems.FINNIAN_LEAF);

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.FINNIAN_PLANKS.asItem());

        getOrCreateTagBuilder(ModItemTags.finnian_logs)
                .add(ModBlocks.FINNIAN_LOG.asItem())
                .add(ModBlocks.FINNIAN_WOOD.asItem())
                .add(ModBlocks.STRIPPED_FINNIAN_LOG.asItem())
                .add(ModBlocks.STRIPPED_FINNIAN_WOOD.asItem());
    }
}
