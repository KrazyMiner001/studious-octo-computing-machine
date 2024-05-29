package com.goggaguys;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.blockentity.ModBlockEntities;
import com.goggaguys.commands.ModCommands;
import com.goggaguys.compat.Mods;
import com.goggaguys.compat.geckolib.GeckoLib;
import com.goggaguys.config.OctoComputingConfig;
import com.goggaguys.effects.ModStatusEffects;
import com.goggaguys.enchantments.ModEnchantments;
import com.goggaguys.entity.ModEntities;
import com.goggaguys.entity.custom.LeafGodEntity;
import com.goggaguys.entity.custom.LeafMonsterEntity;
import com.goggaguys.item.ModDataComponentTypes;
import com.goggaguys.item.ModItemGroups;
import com.goggaguys.item.ModItemTags;
import com.goggaguys.item.ModItems;
import com.goggaguys.networking.ModS2CPackets;
import com.goggaguys.recipe.ModRecipes;
import com.goggaguys.statistic.ModStatistics;
import com.goggaguys.world.customFeatures.ModFeatures;
import com.goggaguys.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.Heightmap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OctoComputing implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("octocomputing");
	public static final String MOD_ID = "octocomputing";
	public static final OctoComputingConfig CONFIG = OctoComputingConfig.createAndLoad();
	public static MinecraftServer SERVER;

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();
		ModEnchantments.registerModEnchantments();
		ModStatusEffects.registerModStatusEffects();
		ModCommands.register();
		ModDataComponentTypes.register();
		ModFeatures.registerModFeatures();
		ModBlockEntities.registerModBlocksEntities();
		ModRecipes.registerRecipes();
		ModStatistics.registerStatistics();

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(ModItems.LEAF_MONSTER_SPAWN_EGG));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content ->
				content.addAfter(Items.NETHERITE_HOE,
						ModItems.LEAFITE_SHOVEL, ModItems.LEAFITE_PICKAXE,
						ModItems.LEAFITE_AXE, ModItems.LEAFITE_HOE,
						ModItems.CHLOROPHYTE_SHOVEL, ModItems.CHLOROPHYTE_PICKAXE,
						ModItems.CHLOROPHYTE_AXE, ModItems.CHLOROPHYTE_HOE));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
			content.addAfter(Items.NETHERITE_AXE, ModItems.LEAFITE_AXE, ModItems.CHLOROPHYTE_AXE);
			content.addAfter(Items.NETHERITE_SWORD, ModItems.LEAFITE_SWORD, ModItems.CHLOROPHYTE_SWORD);
			content.addAfter(Items.NETHERITE_BOOTS,
					ModItems.LEAFITE_HELMET, ModItems.LEAFITE_CHESTPLATE, ModItems.LEAFITE_LEGGINGS, ModItems.LEAFITE_BOOTS,
					ModItems.CHLOROPHYTE_HELMET, ModItems.CHLOROPHYTE_CHESTPLATE, ModItems.CHLOROPHYTE_LEGGINGS, ModItems.CHLOROPHYTE_BOOTS);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content ->
				content.addAfter(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.LEAFITE_UPGRADE_SMITHING_TEMPLATE)
		);

		leafLootTable(Blocks.OAK_LEAVES, ModItems.OAK_LEAF);
		leafLootTable(Blocks.SPRUCE_LEAVES, ModItems.SPRUCE_LEAF);
		leafLootTable(Blocks.BIRCH_LEAVES, ModItems.BIRCH_LEAF);
		leafLootTable(Blocks.JUNGLE_LEAVES, ModItems.JUNGLE_LEAF);
		leafLootTable(Blocks.ACACIA_LEAVES, ModItems.ACACIA_LEAF);
		leafLootTable(Blocks.DARK_OAK_LEAVES, ModItems.DARK_OAK_LEAF);
		leafLootTable(Blocks.AZALEA_LEAVES, ModItems.AZALEA_LEAF);
		leafLootTable(Blocks.MANGROVE_LEAVES, ModItems.MANGROVE_LEAF);
		leafLootTable(Blocks.CHERRY_LEAVES, ModItems.CHERRY_LEAF);
		leafLootTable(ModBlocks.MYSTERY_LEAVES, ModItems.MYSTERY_LEAF);

		FuelRegistry.INSTANCE.add(ModItemTags.LEAF, 1);
		FuelRegistry.INSTANCE.add(ModItemTags.LEAF_COMPRESSED, 10);
		FuelRegistry.INSTANCE.add(ModItemTags.LEAF_DOUBLE_COMPRESSED, 100);
		FuelRegistry.INSTANCE.add(ModBlocks.MYSTERY_LOG, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.MYSTERY_WOOD, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_MYSTERY_LOG, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_MYSTERY_WOOD, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.MYSTERY_PLANKS, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.MYSTERY_SAPLING, 100);

		ServerLifecycleEvents.SERVER_STARTED.register(server -> SERVER = server);
		ServerLifecycleEvents.SERVER_STOPPED.register(server -> SERVER = null);

		PayloadTypeRegistry.playS2C().register(ModS2CPackets.PlayLeafShrineCraftingInProgressParticlePacket.PACKET_ID, ModS2CPackets.PlayLeafShrineCraftingInProgressParticlePacket.PACKET_CODEC);
		PayloadTypeRegistry.playS2C().register(ModS2CPackets.PlayLeafShrineCraftingFinishedParticlePacket.PACKET_ID, ModS2CPackets.PlayLeafShrineCraftingFinishedParticlePacket.PACKET_CODEC);

		FabricDefaultAttributeRegistry.register(ModEntities.LEAF_MONSTER, LeafMonsterEntity.createLeafMonsterAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.LEAF_GOD, LeafGodEntity.createLeafGodAttributes());

		SpawnRestriction.register(ModEntities.LEAF_MONSTER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnIgnoreLightLevel);

		StrippableBlockRegistry.register(ModBlocks.MYSTERY_LOG, ModBlocks.STRIPPED_MYSTERY_LOG);
		StrippableBlockRegistry.register(ModBlocks.MYSTERY_WOOD, ModBlocks.STRIPPED_MYSTERY_WOOD);

		ModWorldGeneration.generateModWorldGen();
		BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(),
				SpawnGroup.MONSTER, ModEntities.LEAF_MONSTER, 10, 1, 3);

		Mods.GECKOLIB.executeIfInstalled(() -> GeckoLib::init);

		LOGGER.info("Mod Starting");
	}

	private static void leafLootTable(Block leafBlock, Item leafItem) {
		LootTableEvents.MODIFY.register((lootTableRegistryKey, builder, source) -> {
			if (source.isBuiltin() && leafBlock.getLootTableKey() == lootTableRegistryKey) {
				LootPool.Builder leafPoolBuilder = LootPool.builder()
						.rolls(BinomialLootNumberProvider.create(125, 0.2f))
						.with(ItemEntry.builder(leafItem))
						.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.LEAF_PICKER)))
						.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(5)));

				LootPool.Builder mysteryLeafPoolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.with(ItemEntry.builder(ModItems.MYSTERY_LEAF))
						.conditionally(RandomChanceLootCondition.builder(0.001f))
						.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.LEAF_PICKER)));

				builder.pool(leafPoolBuilder);
				builder.pool(mysteryLeafPoolBuilder);
			}
		});
	}
}