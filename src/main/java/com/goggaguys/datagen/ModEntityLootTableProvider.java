package com.goggaguys.datagen;

import com.goggaguys.entity.ModEntities;
import com.goggaguys.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModEntityLootTableProvider extends SimpleFabricLootTableProvider {
    public ModEntityLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup, LootContextTypes.ENTITY);
    }

    @Override
    public void accept(RegistryWrapper.WrapperLookup registryLookup, BiConsumer<RegistryKey<LootTable>, LootTable.Builder> exporter) {
        exporter.accept(ModEntities.LEAF_MONSTER.getLootTableId(), LootTable.builder()
                .pool(LootPool.builder().
                        rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.MYSTERY_LEAF))
                        .with(ItemEntry.builder(ModItems.COMPRESSED_MYSTERY_LEAF))
                        .with(ItemEntry.builder(ModItems.DOUBLE_COMPRESSED_MYSTERY_LEAF))
                        .conditionally(RandomChanceLootCondition.builder(1f)))
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.LEAFITE_UPGRADE_SMITHING_TEMPLATE))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.01f, 3))));
    }
}
