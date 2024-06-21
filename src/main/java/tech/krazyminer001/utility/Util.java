package tech.krazyminer001.utility;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.item.ModItems;
import net.minecraft.item.Item;
import tech.krazyminer001.item.custom.ChlorophyteArmor;
import tech.krazyminer001.item.custom.LeafiteArmor;

import java.util.HashMap;
import java.util.Map;

public abstract class Util {
    public static final Map<Item, Item> regularToCompressed = regularToCompressedMap();
    public static final Map<Item, Item> compressedToDoubleCompressed = compressedToDoubleCompressedMap();

    private static Map<Item, Item> regularToCompressedMap() {
        Map<Item, Item> map = new HashMap<>();
       map.put(ModItems.OAK_LEAF, ModItems.COMPRESSED_OAK_LEAF);
       map.put(ModItems.SPRUCE_LEAF, ModItems.COMPRESSED_SPRUCE_LEAF);
       map.put(ModItems.BIRCH_LEAF, ModItems.COMPRESSED_BIRCH_LEAF);
       map.put(ModItems.JUNGLE_LEAF, ModItems.COMPRESSED_JUNGLE_LEAF);
       map.put(ModItems.ACACIA_LEAF, ModItems.COMPRESSED_ACACIA_LEAF);
       map.put(ModItems.DARK_OAK_LEAF, ModItems.COMPRESSED_DARK_OAK_LEAF);
       map.put(ModItems.AZALEA_LEAF, ModItems.COMPRESSED_AZALEA_LEAF);
       map.put(ModItems.MANGROVE_LEAF, ModItems.COMPRESSED_MANGROVE_LEAF);
       map.put(ModItems.CHERRY_LEAF, ModItems.COMPRESSED_CHERRY_LEAF);
       map.put(ModItems.MYSTERY_LEAF, ModItems.COMPRESSED_MYSTERY_LEAF);
       map.put(ModItems.MIXED_LEAF, ModItems.COMPRESSED_MIXED_LEAF);
       return map;
    }
    private static Map<Item, Item> compressedToDoubleCompressedMap() {
        Map<Item, Item> map = new HashMap<>();
        map.put(ModItems.COMPRESSED_OAK_LEAF, ModItems.DOUBLE_COMPRESSED_OAK_LEAF);
        map.put(ModItems.COMPRESSED_SPRUCE_LEAF, ModItems.DOUBLE_COMPRESSED_SPRUCE_LEAF);
        map.put(ModItems.COMPRESSED_BIRCH_LEAF, ModItems.DOUBLE_COMPRESSED_BIRCH_LEAF);
        map.put(ModItems.COMPRESSED_JUNGLE_LEAF, ModItems.DOUBLE_COMPRESSED_JUNGLE_LEAF);
        map.put(ModItems.COMPRESSED_ACACIA_LEAF, ModItems.DOUBLE_COMPRESSED_ACACIA_LEAF);
        map.put(ModItems.COMPRESSED_DARK_OAK_LEAF, ModItems.DOUBLE_COMPRESSED_DARK_OAK_LEAF);
        map.put(ModItems.COMPRESSED_AZALEA_LEAF, ModItems.DOUBLE_COMPRESSED_AZALEA_LEAF);
        map.put(ModItems.COMPRESSED_MANGROVE_LEAF, ModItems.DOUBLE_COMPRESSED_MANGROVE_LEAF);
        map.put(ModItems.COMPRESSED_CHERRY_LEAF, ModItems.DOUBLE_COMPRESSED_CHERRY_LEAF);
        map.put(ModItems.COMPRESSED_MYSTERY_LEAF, ModItems.DOUBLE_COMPRESSED_MYSTERY_LEAF);
        map.put(ModItems.COMPRESSED_MIXED_LEAF, ModItems.DOUBLE_COMPRESSED_MIXED_LEAF);
        return map;
    }

    public static int getLeafResistancePotency(PlayerEntity player) {
        int potency = 0;
        for (ItemStack armorPiece : player.getInventory().armor) {
            if (armorPiece.getItem() instanceof ChlorophyteArmor) {
                potency += 2;
            } else if (armorPiece.getItem() instanceof LeafiteArmor) {
                potency++;
            }
        }
        return potency;
    }

    public static Identifier of(String path) {
        return Identifier.of(OctoComputing.MOD_ID, path);
    }
}
