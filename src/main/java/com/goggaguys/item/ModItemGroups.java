package com.goggaguys.item;

import com.goggaguys.OctoComputing;
import com.goggaguys.block.ModBlocks;
import com.goggaguys.utilities.CompressedChainMap;
import de.dafuqs.fractal.api.ItemSubGroup;
import de.dafuqs.fractal.interfaces.ItemGroupParent;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    private static final Identifier GROUP_ID = new Identifier(OctoComputing.MOD_ID, "main");
    private static final ItemGroup MAIN = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.MIXED_LEAF))
            .entries((context, entries) -> {
                entries.add(ModItems.PHYLLONOMICON, ItemGroup.StackVisibility.PARENT_TAB_ONLY);
                ItemGroupParent parent = ModItemGroups.MAIN;
                for (ItemSubGroup subGroup : parent.fractal$getChildren()) {
                    entries.addAll(subGroup.getSearchTabStacks(), ItemGroup.StackVisibility.SEARCH_TAB_ONLY);
                }

            })
            .displayName(Text.translatable("itemGroup.octocomputing.main"))
            .noRenderedName()
            .build();

    private static ItemGroup LEAVES = new ItemSubGroup.Builder(
            MAIN,
            new Identifier(OctoComputing.MOD_ID, "leaves"),
            Text.translatable("itemGroup.octocomputing.leaves")
    ).entries(
            ((displayContext, entries) -> {
                CompressedChainMap.compressedChainMap.regularToCompressed.keySet().forEach((Item item) -> {
                    entries.add(item);
                    entries.add(CompressedChainMap.compressedChainMap.regularToCompressed.get(item));
                    entries.add(CompressedChainMap.compressedChainMap.compressedToDoubleCompressed.get(CompressedChainMap.compressedChainMap.regularToCompressed.get(item)));
                });
            })
    ).build();

    private static ItemGroup EQUIPMENT = new ItemSubGroup.Builder(
            MAIN,
            new Identifier(OctoComputing.MOD_ID, "equipment"),
            Text.translatable("itemGroup.octocomputing.equipment")
    ).entries(
            ((displayContext, entries) -> {
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

                entries.add(ModItems.LEAFITE_HELMET);
                entries.add(ModItems.LEAFITE_CHESTPLATE);
                entries.add(ModItems.LEAFITE_LEGGINGS);
                entries.add(ModItems.LEAFITE_BOOTS);
                entries.add(ModItems.LEAFITE_SWORD);
                entries.add(ModItems.LEAFITE_PICKAXE);
                entries.add(ModItems.LEAFITE_AXE);
                entries.add(ModItems.LEAFITE_SHOVEL);
                entries.add(ModItems.LEAFITE_HOE);

                entries.add(ModItems.CHLOROPHYTE_HELMET);
                entries.add(ModItems.CHLOROPHYTE_CHESTPLATE);
                entries.add(ModItems.CHLOROPHYTE_LEGGINGS);
                entries.add(ModItems.CHLOROPHYTE_BOOTS);
                entries.add(ModItems.CHLOROPHYTE_SWORD);
                entries.add(ModItems.CHLOROPHYTE_PICKAXE);
                entries.add(ModItems.CHLOROPHYTE_AXE);
                entries.add(ModItems.CHLOROPHYTE_SHOVEL);
                entries.add(ModItems.CHLOROPHYTE_HOE);
            })
    ).build();

    private static ItemGroup RESOURCES = new ItemSubGroup.Builder(
            MAIN,
            new Identifier(OctoComputing.MOD_ID, "resources"),
            Text.translatable("itemGroup.octocomputing.resources")
    ).entries(
            ((displayContext, entries) -> {
                entries.addAll(LEAVES.getSearchTabStacks());
                entries.add(ModBlocks.LEAF_ORE);
                entries.add(ModBlocks.DEEPSLATE_LEAF_ORE);
                entries.add(ModItems.LEAFSTONE);
                entries.add(ModBlocks.LEAFSTONE_BLOCK);
                entries.add(ModItems.LEAF_CORE);
                entries.add(ModItems.BROKEN_LEAF_CORE);
                entries.add(ModBlocks.EXTRATERRESTRIAL_LEAF_DEBRIS);
                entries.add(ModItems.CHLOROPHYTE_DEBRIS);
                entries.add(ModItems.CHLOROPHYTE_INGOT);
                entries.add(ModBlocks.CHLOROPHYTE_BLOCK);
            })
    ).build();

    private static ItemGroup NATURAL = new ItemSubGroup.Builder(
            MAIN,
            new Identifier(OctoComputing.MOD_ID, "natural"),
            Text.translatable("itemGroup.octocomputing.natural")
    ).entries(
            ((displayContext, entries) -> {
                entries.add(ModBlocks.MYSTERY_LEAVES);
                entries.add(ModBlocks.MYSTERY_PLANKS);
                entries.add(ModBlocks.MYSTERY_LOG);
                entries.add(ModBlocks.MYSTERY_SAPLING);
                entries.add(ModBlocks.MYSTERY_WOOD);
                entries.add(ModBlocks.STRIPPED_MYSTERY_LOG);
                entries.add(ModBlocks.STRIPPED_MYSTERY_WOOD);

                entries.add(ModBlocks.ETERNALWOOD);
                entries.add(ModBlocks.ETERNALLEAVES);

                entries.add(ModBlocks.TRANSIENTWOOD_LEAVES);
                entries.add(ModBlocks.TRANSIENTWOOD_PLANKS);
                entries.add(ModBlocks.TRANSIENTWOOD_LOG);
                entries.add(ModBlocks.TRANSIENTWOOD_SAPLING);
                entries.add(ModBlocks.TRANSIENTWOOD);
                entries.add(ModBlocks.STRIPPED_TRANSIENTWOOD_LOG);
                entries.add(ModBlocks.STRIPPED_TRANSIENTWOOD);

                entries.add(ModBlocks.ENDERGLEAM_LEAVES);
                entries.add(ModBlocks.ENDERGLEAM_PLANKS);
                entries.add(ModBlocks.ENDERGLEAM_LOG);
                entries.add(ModBlocks.ENDERGLEAM_SAPLING);
                entries.add(ModBlocks.ENDERGLEAM_WOOD);
                entries.add(ModBlocks.STRIPPED_ENDERGLEAM_LOG);
                entries.add(ModBlocks.STRIPPED_ENDERGLEAM_WOOD);

                entries.addAll(LEAVES.getSearchTabStacks());
            })
            )
    .build();

    private static ItemGroup FUNCTIONAL = new ItemSubGroup.Builder(
            MAIN,
            new Identifier(OctoComputing.MOD_ID, "functional"),
            Text.translatable("itemGroup.octocomputing.functional")
    ).entries(
            ((displayContext, entries) -> {
                entries.add(ModBlocks.LEAF_SHRINE);
                entries.add(ModBlocks.LEAF_PLINTH);
                entries.add(ModBlocks.LEAF_PEDESTAL);
                entries.add(ModBlocks.VOIDSPAWN_GENERATOR);
            })
    ).build();

    private static ItemGroup BLOCKS = new ItemSubGroup.Builder(
            MAIN,
            new Identifier(OctoComputing.MOD_ID, "blocks"),
            Text.translatable("itemGroup.octocomputing.blocks")
    ).entries(
            ((displayContext, entries) -> {
                entries.add(ModBlocks.LEAF_ORE);
                entries.add(ModBlocks.DEEPSLATE_LEAF_ORE);
                entries.add(ModBlocks.LEAFSTONE_BLOCK);
                entries.add(ModBlocks.CHLOROPHYTE_BLOCK);
                entries.add(ModBlocks.EXTRATERRESTRIAL_LEAF_DEBRIS);
                entries.add(ModBlocks.MYSTERY_LEAVES);
                entries.add(ModBlocks.MYSTERY_LOG);
                entries.add(ModBlocks.MYSTERY_PLANKS);
                entries.add(ModBlocks.MYSTERY_SAPLING);
                entries.add(ModBlocks.MYSTERY_WOOD);
                entries.add(ModBlocks.STRIPPED_MYSTERY_LOG);
                entries.add(ModBlocks.STRIPPED_MYSTERY_WOOD);
                entries.add(ModBlocks.ETERNALWOOD);
                entries.add(ModBlocks.ETERNALLEAVES);
                entries.add(ModBlocks.TRANSIENTWOOD);
                entries.add(ModBlocks.TRANSIENTWOOD_LEAVES);
                entries.add(ModBlocks.TRANSIENTWOOD_LOG);
                entries.add(ModBlocks.TRANSIENTWOOD_PLANKS);
                entries.add(ModBlocks.TRANSIENTWOOD_SAPLING);
                entries.add(ModBlocks.STRIPPED_TRANSIENTWOOD);
                entries.add(ModBlocks.STRIPPED_TRANSIENTWOOD_LOG);
                entries.add(ModBlocks.ENDERGLEAM_LEAVES);
                entries.add(ModBlocks.ENDERGLEAM_LOG);
                entries.add(ModBlocks.ENDERGLEAM_PLANKS);
                entries.add(ModBlocks.ENDERGLEAM_SAPLING);
                entries.add(ModBlocks.ENDERGLEAM_WOOD);
                entries.add(ModBlocks.STRIPPED_ENDERGLEAM_LOG);
                entries.add(ModBlocks.STRIPPED_ENDERGLEAM_WOOD);
                entries.add(ModBlocks.LEAF_SHRINE);
                entries.add(ModBlocks.LEAF_PLINTH);
                entries.add(ModBlocks.LEAF_PEDESTAL);
                entries.add(ModBlocks.VOIDSPAWN_GENERATOR);
            })
    ).build();

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, GROUP_ID, MAIN);
        OctoComputing.LOGGER.info("Registering Item Groups for " + OctoComputing.MOD_ID);
    }
}
