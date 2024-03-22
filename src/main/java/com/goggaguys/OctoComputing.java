package com.goggaguys;

import com.goggaguys.block.OctoBlocks;
import com.goggaguys.item.OctoItemGroups;
import com.goggaguys.item.OctoItems;
import com.goggaguys.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.*;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OctoComputing implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("octocomputing");
	public static final String MOD_ID = "octocomputing";


	@Override
	public void onInitialize() {
		OctoItems.registerModItems();
		OctoItemGroups.registerItemGroups();
		OctoBlocks.registerModBlocks();

		leafLootTable(Blocks.OAK_LEAVES, OctoItems.OAK_LEAF);

		FuelRegistry.INSTANCE.add(OctoItems.OAK_LEAF, 1);
		FuelRegistry.INSTANCE.add(OctoItems.COMPRESSED_OAK_LEAF, 10);
		FuelRegistry.INSTANCE.add(OctoItems.DOUBLE_COMPRESSED_OAK_LEAF, 100);

		ModWorldGeneration.generateModWorldGen();

		LOGGER.info("Mod Starting");
	}

	private static void leafLootTable(Block leafBlock, Item leafItem) {
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && leafBlock.getLootTableId().equals(id)) {
				LootPool.Builder leafPoolBuilder = LootPool.builder()
						.rolls(BinomialLootNumberProvider.create(10, 0.5f))
						.with(ItemEntry.builder(leafItem))
						.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
								.enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.ANY))).invert())
						.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
								.items(Items.SHEARS)).invert())
						.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(25)));

				LootPool.Builder finnianLeafPoolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.with(ItemEntry.builder(OctoItems.FINNIAN_LEAF))
						.conditionally(RandomChanceLootCondition.builder(0.01f))
						.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
								.enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.ANY))).invert())
						.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
								.items(Items.SHEARS)).invert());

				tableBuilder.pool(leafPoolBuilder);
				tableBuilder.pool(finnianLeafPoolBuilder);
			}
		});
	}
}