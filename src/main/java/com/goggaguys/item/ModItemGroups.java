package com.goggaguys.item;

import com.goggaguys.OctoComputing;
import com.goggaguys.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    private static final ItemGroup LEAF_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.MIXED_LEAF))
            .entries((context, entries) -> {
                addLeaves(entries); //Just did this because it's so long

                entries.add(ModItems.LEAFSTONE);

                entries.add(ModItems.LEAF_HELMET);
                entries.add(ModItems.LEAF_CHESTPLATE);
                entries.add(ModItems.LEAF_LEGGINGS);
                entries.add(ModItems.LEAF_BOOTS);

                entries.add(ModItems.COMPRESSED_LEAF_HELMET);
                entries.add(ModItems.COMPRESSED_LEAF_CHESTPLATE);
                entries.add(ModItems.COMPRESSED_LEAF_LEGGINGS);
                entries.add(ModItems.COMPRESSED_LEAF_BOOTS);

                entries.add(ModItems.DOUBLE_COMPRESSED_LEAF_HELMET);
                entries.add(ModItems.DOUBLE_COMPRESSED_LEAF_CHESTPLATE);
                entries.add(ModItems.DOUBLE_COMPRESSED_LEAF_LEGGINGS);
                entries.add(ModItems.DOUBLE_COMPRESSED_LEAF_BOOTS);

                entries.add(ModBlocks.MYSTERY_SAPLING);
                entries.add(ModBlocks.LEAF_ORE);
                entries.add(ModBlocks.DEEPSLATE_LEAF_ORE);
                entries.add(ModBlocks.LEAFSTONE_BLOCK);
                entries.add(ModBlocks.MYSTERY_LOG);
                entries.add(ModBlocks.MYSTERY_WOOD);
                entries.add(ModBlocks.STRIPPED_MYSTERY_LOG);
                entries.add(ModBlocks.STRIPPED_MYSTERY_WOOD);
                entries.add(ModBlocks.MYSTERY_LEAVES);
                entries.add(ModBlocks.MYSTERY_PLANKS);
            })
            .displayName(Text.translatable("itemgroup.leaf_group"))
            .build();

    private static void addLeaves(ItemGroup.Entries entries) {
        entries.add(ModItems.OAK_LEAF);
        entries.add(ModItems.COMPRESSED_OAK_LEAF);
        entries.add(ModItems.DOUBLE_COMPRESSED_OAK_LEAF);

        entries.add(ModItems.SPRUCE_LEAF);
        entries.add(ModItems.COMPRESSED_SPRUCE_LEAF);
        entries.add(ModItems.DOUBLE_COMPRESSED_SPRUCE_LEAF);

        entries.add(ModItems.BIRCH_LEAF);
        entries.add(ModItems.COMPRESSED_BIRCH_LEAF);
        entries.add(ModItems.DOUBLE_COMPRESSED_BIRCH_LEAF);

        entries.add(ModItems.JUNGLE_LEAF);
        entries.add(ModItems.COMPRESSED_JUNGLE_LEAF);
        entries.add(ModItems.DOUBLE_COMPRESSED_JUNGLE_LEAF);

        entries.add(ModItems.ACACIA_LEAF);
        entries.add(ModItems.COMPRESSED_ACACIA_LEAF);
        entries.add(ModItems.DOUBLE_COMPRESSED_ACACIA_LEAF);

        entries.add(ModItems.DARK_OAK_LEAF);
        entries.add(ModItems.COMPRESSED_DARK_OAK_LEAF);
        entries.add(ModItems.DOUBLE_COMPRESSED_DARK_OAK_LEAF);

        entries.add(ModItems.AZALEA_LEAF);
        entries.add(ModItems.COMPRESSED_AZALEA_LEAF);
        entries.add(ModItems.DOUBLE_COMPRESSED_AZALEA_LEAF);

        entries.add(ModItems.MANGROVE_LEAF);
        entries.add(ModItems.COMPRESSED_MANGROVE_LEAF);
        entries.add(ModItems.DOUBLE_COMPRESSED_MANGROVE_LEAF);

        entries.add(ModItems.CHERRY_LEAF);
        entries.add(ModItems.COMPRESSED_CHERRY_LEAF);
        entries.add(ModItems.DOUBLE_COMPRESSED_CHERRY_LEAF);

        entries.add(ModItems.MIXED_LEAF);
        entries.add(ModItems.COMPRESSED_MIXED_LEAF);
        entries.add(ModItems.DOUBLE_COMPRESSED_MIXED_LEAF);

        entries.add(ModItems.MYSTERY_LEAF);
        entries.add(ModItems.COMPRESSED_MYSTERY_LEAF);
        entries.add(ModItems.DOUBLE_COMPRESSED_MYSTERY_LEAF);
    }

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(OctoComputing.MOD_ID, "leaf_group"), LEAF_GROUP);
        OctoComputing.LOGGER.info("Registering Item Groups");
    }
}
