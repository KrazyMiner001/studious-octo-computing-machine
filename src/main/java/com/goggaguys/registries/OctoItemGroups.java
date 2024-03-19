package com.goggaguys.registries;

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
            })
            .displayName(Text.translatable("itemGroup.octocomputing.leaves"))
            .build();
    public static void register() {
        Registry.register(Registries.ITEM_GROUP, new Identifier("octocomputing", "leaf_group"), LEAF_GROUP);
    }
}
