package com.goggaguys.datagen;

import com.goggaguys.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.LEAFSTONE_BLOCK)
                .add(ModBlocks.LEAF_ORE)
                .add(ModBlocks.DEEPSLATE_LEAF_ORE);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.MYSTERY_LEAVES);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.MYSTERY_LOG)
                .add(ModBlocks.MYSTERY_WOOD)
                .add(ModBlocks.STRIPPED_MYSTERY_LOG)
                .add(ModBlocks.STRIPPED_MYSTERY_WOOD)
                .add(ModBlocks.MYSTERY_PLANKS);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.MYSTERY_SAPLING);

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.LEAFSTONE_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.MYSTERY_LEAVES)
                .add(ModBlocks.MYSTERY_LOG)
                .add(ModBlocks.MYSTERY_WOOD)
                .add(ModBlocks.STRIPPED_MYSTERY_LOG)
                .add(ModBlocks.STRIPPED_MYSTERY_WOOD)
                .add(ModBlocks.MYSTERY_PLANKS);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LEAF_ORE)
                .add(ModBlocks.LEAFSTONE_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_LEAF_ORE);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MYSTERY_LOG)
                .add(ModBlocks.MYSTERY_WOOD)
                .add(ModBlocks.STRIPPED_MYSTERY_LOG)
                .add(ModBlocks.STRIPPED_MYSTERY_WOOD);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.MYSTERY_PLANKS);
    }
}