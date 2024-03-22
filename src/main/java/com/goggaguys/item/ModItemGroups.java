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
            .icon(() -> new ItemStack(ModItems.OAK_LEAF))
            .entries((context, entries) -> {
                entries.add(ModItems.OAK_LEAF);
                entries.add(ModItems.COMPRESSED_OAK_LEAF);
                entries.add(ModItems.DOUBLE_COMPRESSED_OAK_LEAF);
                entries.add(ModItems.FINNIAN_LEAF);
                entries.add(ModItems.LEAFSTONE);

                entries.add(ModBlocks.FINNIAN_SAPLING);
                entries.add(ModBlocks.LEAF_ORE);
                entries.add(ModBlocks.DEEPSLATE_LEAF_ORE);
                entries.add(ModBlocks.LEAFSTONE_BLOCK);
            })
            .displayName(Text.translatable("itemgroup.leaf_group"))
            .build();
    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(OctoComputing.MOD_ID, "leaf_group"), LEAF_GROUP);
        OctoComputing.LOGGER.info("Registering Item Groups");
    }
}
