package com.goggaguys.datagen;

import com.goggaguys.entity.ModEntities;
import com.goggaguys.item.ModItemTags;
import com.goggaguys.item.ModItems;
import com.goggaguys.utilities.CompressedChainMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
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
        exporter.accept(ModEntities.LEAF_MONSTER.getLootTableId(), LootTable.builder()
                .pool(LootPool.builder().
                        rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.MYSTERY_LEAF))
                        .with(ItemEntry.builder(ModItems.COMPRESSED_MYSTERY_LEAF))
                        .with(ItemEntry.builder(ModItems.DOUBLE_COMPRESSED_MYSTERY_LEAF))
                        .conditionally(RandomChanceLootCondition.builder(1f)))
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.LEAFITE_UPGRADE_TEMPLATE))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.01f, 3))));
    }
}
