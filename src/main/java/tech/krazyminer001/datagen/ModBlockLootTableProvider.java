package tech.krazyminer001.datagen;

import tech.krazyminer001.block.ModBlocks;
import tech.krazyminer001.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    @Override
    public void generate() {
        addDrop(ModBlocks.MYSTERY_SAPLING);
        addDrop(ModBlocks.MYSTERY_LOG);
        addDrop(ModBlocks.MYSTERY_WOOD);
        addDrop(ModBlocks.STRIPPED_MYSTERY_LOG);
        addDrop(ModBlocks.STRIPPED_MYSTERY_WOOD);
        addDrop(ModBlocks.LEAFSTONE_BLOCK);
        addDrop(ModBlocks.EXTRATERRESTRIAL_LEAF_DEBRIS);

        addDrop(ModBlocks.LEAF_ORE, oreDrops(ModBlocks.LEAF_ORE, ModItems.LEAFSTONE));
        addDrop(ModBlocks.DEEPSLATE_LEAF_ORE, oreDrops(ModBlocks.DEEPSLATE_LEAF_ORE, ModItems.LEAFSTONE));

        addDrop(ModBlocks.MYSTERY_LEAVES, leavesDrops(ModBlocks.MYSTERY_LEAVES, ModBlocks.MYSTERY_SAPLING, BlockLootTableGenerator.SAPLING_DROP_CHANCE));
    }
}
