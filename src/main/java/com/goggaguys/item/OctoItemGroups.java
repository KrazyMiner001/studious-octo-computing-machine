package com.goggaguys.item;

import com.goggaguys.OctoComputing;
import com.goggaguys.block.OctoBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class OctoItemGroups {
    private static final ItemGroup LEAF_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(OctoItems.OAK_LEAF))
            .entries((context, entries) -> {
                entries.add(OctoItems.OAK_LEAF);
                entries.add(OctoItems.COMPRESSED_OAK_LEAF);
                entries.add(OctoItems.DOUBLE_COMPRESSED_OAK_LEAF);
                entries.add(OctoItems.FINNIAN_LEAF);

                entries.add(OctoBlocks.FINNIAN_SAPLING);
                entries.add(OctoBlocks.LEAF_ORE);
                entries.add(OctoBlocks.DEEPSLATE_LEAF_ORE);
            })
            .displayName(Text.translatable("itemgroup.leaf_group"))
            .build();
    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(OctoComputing.MOD_ID, "leaf_group"), LEAF_GROUP);
        OctoComputing.LOGGER.info("Registering Item Groups");
    }
}