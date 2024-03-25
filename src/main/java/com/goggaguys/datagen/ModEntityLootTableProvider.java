package com.goggaguys.datagen;

import com.goggaguys.entity.ModEntities;
import com.goggaguys.item.ModItemTags;
import com.goggaguys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class ModEntityLootTableProvider extends SimpleFabricLootTableProvider {
    public ModEntityLootTableProvider(FabricDataOutput output) {
        super(output, LootContextTypes.ENTITY);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> exporter) {
        exporter.accept(ModEntities.LEAF_MONSTER_ENTITY.getLootTableId(), LootTable.builder()
                .pool(poolFromList(combine3ItemArraysToList(ModItemTags.leaves, ModItemTags.compressedLeaves, ModItemTags.doubleCompressedLeaves), ConstantLootNumberProvider.create(1f), 1f))
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.LEAFITE_UPGRADE_TEMPLATE))
                        .conditionally(RandomChanceLootCondition.builder(0.0025f))));
    }

    private LootPool.Builder poolFromList (List<Item> itemList, LootNumberProvider rolls, float chance) {
        LootPool.Builder pool = new LootPool.Builder().rolls(rolls);
        for (Item i : itemList) {
            pool.with(ItemEntry.builder(i));
        }
        return pool.conditionally(RandomChanceLootCondition.builder(chance));
    }

    private List<Item> combine3ItemArraysToList(Item[] array1, Item[] array2, Item[] array3) {
        List<Item> combinedList = new ArrayList<>(){};
        combinedList.addAll(Arrays.stream(array1).toList());
        combinedList.addAll(Arrays.stream(array2).toList());
        combinedList.addAll(Arrays.stream(array3).toList());
        return combinedList;
    }
}
