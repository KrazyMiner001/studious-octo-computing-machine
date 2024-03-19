package com.goggaguys;

import com.goggaguys.registries.OctoItemGroups;
import com.goggaguys.registries.OctoItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OctoComputing implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("octocomputing");
	private static final Identifier OAK_LEAVES_LOOT_TABLE_ID = Blocks.OAK_LEAVES.getLootTableId();


	@Override
	public void onInitialize() {
		OctoItems.register();
		OctoItemGroups.register();

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> content.add(OctoItems.OAK_LEAF));

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && OAK_LEAVES_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(BinomialLootNumberProvider.create(250, 0.5f))
						.with(ItemEntry.builder(OctoItems.OAK_LEAF))
						.conditionally(RandomChanceLootCondition.builder(1f));

				tableBuilder.pool(poolBuilder);
			}
		});
	}
}