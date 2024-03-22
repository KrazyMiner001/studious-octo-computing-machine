package com.goggaguys.item;

import com.goggaguys.OctoComputing;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item OAK_LEAF = registerItem("oak_leaf", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_OAK_LEAF = registerItem("compressed_oak_leaf", new Item(new FabricItemSettings()));
    public static final Item DOUBLE_COMPRESSED_OAK_LEAF = registerItem("double_compressed_oak_leaf", new Item(new FabricItemSettings()));
    public static final Item FINNIAN_LEAF = registerItem("finnian_leaf", new Item(new FabricItemSettings()));
    public static final Item LEAFSTONE = registerItem("leafstone", new Item(new FabricItemSettings()));

    public static final Item LEAF_HELMET = registerItem("leaf_helmet",
            new ArmorItem(ModArmorMaterials.LEAF, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item LEAF_CHESTPLATE = registerItem("leaf_chestplate",
            new ArmorItem(ModArmorMaterials.LEAF, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item LEAF_LEGGINGS = registerItem("leaf_leggings",
            new ArmorItem(ModArmorMaterials.LEAF, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item LEAF_BOOTS = registerItem("leaf_boots",
            new ArmorItem(ModArmorMaterials.LEAF, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(OctoComputing.MOD_ID, name), item);
    }

    public static void registerModItems() {
        OctoComputing.LOGGER.info("Registering Items");
    }
}
