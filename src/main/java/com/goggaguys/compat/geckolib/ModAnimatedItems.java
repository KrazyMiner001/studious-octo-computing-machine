package com.goggaguys.compat.geckolib;

import com.goggaguys.OctoComputing;
import com.goggaguys.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModAnimatedItems {
    public static final Item ANIMATED_LEAF_CORE = registerItem("animated_leaf_core",
            new AnimatedItem(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(OctoComputing.MOD_ID, name), item);
    }

    public static void registerModAnimatedItems() {
        OctoComputing.LOGGER.info("Registering GeckoLib Animated Items");
    }
}
