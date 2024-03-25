package com.goggaguys.item;

import com.goggaguys.OctoComputing;
import com.goggaguys.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
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
                for (Item i : ModItemTags.leaves) entries.add(i);
                for (Item i : ModItemTags.compressedLeaves) entries.add(i);
                for (Item i : ModItemTags.doubleCompressedLeaves) entries.add(i);

                entries.add(ModItems.LEAFSTONE);

                entries.add(ModItems.LEAF_HELMET);
                entries.add(ModItems.LEAF_CHESTPLATE);
                entries.add(ModItems.LEAF_LEGGINGS);
                entries.add(ModItems.LEAF_BOOTS);

                entries.add(ModItems.LEAF_SWORD);
                entries.add(ModItems.LEAF_PICKAXE);
                entries.add(ModItems.LEAF_AXE);
                entries.add(ModItems.LEAF_SHOVEL);
                entries.add(ModItems.LEAF_HOE);

                entries.add(ModItems.COMPRESSED_LEAF_HELMET);
                entries.add(ModItems.COMPRESSED_LEAF_CHESTPLATE);
                entries.add(ModItems.COMPRESSED_LEAF_LEGGINGS);
                entries.add(ModItems.COMPRESSED_LEAF_BOOTS);

                entries.add(ModItems.COMPRESSED_LEAF_SWORD);
                entries.add(ModItems.COMPRESSED_LEAF_PICKAXE);
                entries.add(ModItems.COMPRESSED_LEAF_AXE);
                entries.add(ModItems.COMPRESSED_LEAF_SHOVEL);
                entries.add(ModItems.COMPRESSED_LEAF_HOE);

                entries.add(ModItems.DOUBLE_COMPRESSED_LEAF_HELMET);
                entries.add(ModItems.DOUBLE_COMPRESSED_LEAF_CHESTPLATE);
                entries.add(ModItems.DOUBLE_COMPRESSED_LEAF_LEGGINGS);
                entries.add(ModItems.DOUBLE_COMPRESSED_LEAF_BOOTS);

                entries.add(ModItems.DOUBLE_COMPRESSED_LEAF_SWORD);
                entries.add(ModItems.DOUBLE_COMPRESSED_LEAF_PICKAXE);
                entries.add(ModItems.DOUBLE_COMPRESSED_LEAF_AXE);
                entries.add(ModItems.DOUBLE_COMPRESSED_LEAF_SHOVEL);
                entries.add(ModItems.DOUBLE_COMPRESSED_LEAF_HOE);

                entries.add(ModItems.LEAF_CORE);
                entries.add(ModItems.LEAFITE_UPGRADE_TEMPLATE);

                entries.add(ModItems.LEAF_MONSTER_SPAWN_EGG);

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

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(OctoComputing.MOD_ID, "leaf_group"), LEAF_GROUP);
        OctoComputing.LOGGER.info("Registering Item Groups");
    }
}
