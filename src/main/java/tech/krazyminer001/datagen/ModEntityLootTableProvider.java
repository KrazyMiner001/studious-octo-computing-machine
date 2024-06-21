package tech.krazyminer001.datagen;

import net.minecraft.loot.condition.RandomChanceWithEnchantedBonusLootCondition;
import tech.krazyminer001.entity.ModEntities;
import tech.krazyminer001.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;

public class ModEntityLootTableProvider extends SimpleFabricLootTableProvider {
    private final CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup;

    public ModEntityLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup, LootContextTypes.ENTITY);
        this.registryLookup = registryLookup;
    }

    @Override
    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {
        try {
            lootTableBiConsumer.accept(ModEntities.LEAF_MONSTER.getLootTableId(), LootTable.builder()
                    .pool(LootPool.builder().
                            rolls(ConstantLootNumberProvider.create(1))
                            .with(ItemEntry.builder(ModItems.MYSTERY_LEAF))
                            .with(ItemEntry.builder(ModItems.COMPRESSED_MYSTERY_LEAF))
                            .with(ItemEntry.builder(ModItems.DOUBLE_COMPRESSED_MYSTERY_LEAF))
                            .conditionally(RandomChanceLootCondition.builder(1f)))
                    .pool(LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .with(ItemEntry.builder(ModItems.LEAFITE_UPGRADE_SMITHING_TEMPLATE))
                            .conditionally(RandomChanceWithEnchantedBonusLootCondition.builder(registryLookup.get(), 0.01f, 3))));
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
