package tech.krazyminer001.datagen;

import tech.krazyminer001.block.ModBlocks;
import tech.krazyminer001.item.ModItemTags;
import tech.krazyminer001.item.ModItems;
import tech.krazyminer001.utilities.CompressedChainMap;
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
                .add(ModItems.LEAFITE_HELMET, ModItems.LEAFITE_CHESTPLATE, ModItems.LEAFITE_LEGGINGS, ModItems.LEAFITE_BOOTS)
                .add(ModItems.CHLOROPHYTE_HELMET, ModItems.CHLOROPHYTE_CHESTPLATE, ModItems.CHLOROPHYTE_LEGGINGS, ModItems.CHLOROPHYTE_BOOTS);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.LEAF_HELMET)
                .add(ModItems.COMPRESSED_LEAF_HELMET)
                .add(ModItems.DOUBLE_COMPRESSED_LEAF_HELMET)
                .add(ModItems.LEAFITE_HELMET)
                .add(ModItems.CHLOROPHYTE_HELMET);

        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.LEAF_CHESTPLATE)
                .add(ModItems.COMPRESSED_LEAF_CHESTPLATE)
                .add(ModItems.DOUBLE_COMPRESSED_LEAF_CHESTPLATE)
                .add(ModItems.LEAFITE_CHESTPLATE)
                .add(ModItems.CHLOROPHYTE_CHESTPLATE);

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.LEAF_LEGGINGS)
                .add(ModItems.COMPRESSED_LEAF_LEGGINGS)
                .add(ModItems.DOUBLE_COMPRESSED_LEAF_LEGGINGS)
                .add(ModItems.LEAFITE_LEGGINGS)
                .add(ModItems.CHLOROPHYTE_LEGGINGS);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.LEAF_BOOTS)
                .add(ModItems.COMPRESSED_LEAF_BOOTS)
                .add(ModItems.DOUBLE_COMPRESSED_LEAF_BOOTS)
                .add(ModItems.LEAFITE_BOOTS)
                .add(ModItems.CHLOROPHYTE_BOOTS);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.LEAF_SWORD)
                .add(ModItems.COMPRESSED_LEAF_SWORD)
                .add(ModItems.DOUBLE_COMPRESSED_LEAF_SWORD)
                .add(ModItems.LEAFITE_SWORD)
                .add(ModItems.CHLOROPHYTE_SWORD);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.LEAF_AXE)
                .add(ModItems.COMPRESSED_LEAF_AXE)
                .add(ModItems.DOUBLE_COMPRESSED_LEAF_AXE)
                .add(ModItems.LEAFITE_AXE)
                .add(ModItems.CHLOROPHYTE_AXE);

        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.LEAF_PICKER);

        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(ModBlocks.MYSTERY_SAPLING.asItem())
                .add(ModBlocks.TRANSIENTWOOD_SAPLING.asItem());
    }
}
