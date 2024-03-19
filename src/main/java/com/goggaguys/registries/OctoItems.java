package com.goggaguys.registries;

import com.goggaguys.items.Oak_Leaf;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class OctoItems {
    public static final Oak_Leaf OAK_LEAF = new Oak_Leaf(new FabricItemSettings());

    public static void register() {
        //Register Items
        Registry.register(Registries.ITEM, new Identifier("octocomputing", "oak_leaf"), OAK_LEAF);

        //Register Fuel of Items
        FuelRegistry.INSTANCE.add(OAK_LEAF, 1);
    }
}
