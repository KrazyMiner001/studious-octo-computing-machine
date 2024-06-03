package tech.krazyminer001.utilities;

import tech.krazyminer001.item.ModItems;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class CompressedChainMap {
    public final Map<Item, Item> regularToCompressed = new HashMap<>();
    public final Map<Item, Item> compressedToDoubleCompressed = new HashMap<>();
    public static final CompressedChainMap compressedChainMap = new CompressedChainMap();

    private CompressedChainMap() {
        this.regularToCompressed.put(ModItems.OAK_LEAF, ModItems.COMPRESSED_OAK_LEAF);
        this.regularToCompressed.put(ModItems.SPRUCE_LEAF, ModItems.COMPRESSED_SPRUCE_LEAF);
        this.regularToCompressed.put(ModItems.BIRCH_LEAF, ModItems.COMPRESSED_BIRCH_LEAF);
        this.regularToCompressed.put(ModItems.JUNGLE_LEAF, ModItems.COMPRESSED_JUNGLE_LEAF);
        this.regularToCompressed.put(ModItems.ACACIA_LEAF, ModItems.COMPRESSED_ACACIA_LEAF);
        this.regularToCompressed.put(ModItems.DARK_OAK_LEAF, ModItems.COMPRESSED_DARK_OAK_LEAF);
        this.regularToCompressed.put(ModItems.AZALEA_LEAF, ModItems.COMPRESSED_AZALEA_LEAF);
        this.regularToCompressed.put(ModItems.MANGROVE_LEAF, ModItems.COMPRESSED_MANGROVE_LEAF);
        this.regularToCompressed.put(ModItems.CHERRY_LEAF, ModItems.COMPRESSED_CHERRY_LEAF);
        this.regularToCompressed.put(ModItems.MYSTERY_LEAF, ModItems.COMPRESSED_MYSTERY_LEAF);
        this.regularToCompressed.put(ModItems.MIXED_LEAF, ModItems.COMPRESSED_MIXED_LEAF);

        this.compressedToDoubleCompressed.put(ModItems.COMPRESSED_OAK_LEAF, ModItems.DOUBLE_COMPRESSED_OAK_LEAF);
        this.compressedToDoubleCompressed.put(ModItems.COMPRESSED_SPRUCE_LEAF, ModItems.DOUBLE_COMPRESSED_SPRUCE_LEAF);
        this.compressedToDoubleCompressed.put(ModItems.COMPRESSED_BIRCH_LEAF, ModItems.DOUBLE_COMPRESSED_BIRCH_LEAF);
        this.compressedToDoubleCompressed.put(ModItems.COMPRESSED_JUNGLE_LEAF, ModItems.DOUBLE_COMPRESSED_JUNGLE_LEAF);
        this.compressedToDoubleCompressed.put(ModItems.COMPRESSED_ACACIA_LEAF, ModItems.DOUBLE_COMPRESSED_ACACIA_LEAF);
        this.compressedToDoubleCompressed.put(ModItems.COMPRESSED_DARK_OAK_LEAF, ModItems.DOUBLE_COMPRESSED_DARK_OAK_LEAF);
        this.compressedToDoubleCompressed.put(ModItems.COMPRESSED_AZALEA_LEAF, ModItems.DOUBLE_COMPRESSED_AZALEA_LEAF);
        this.compressedToDoubleCompressed.put(ModItems.COMPRESSED_MANGROVE_LEAF, ModItems.DOUBLE_COMPRESSED_MANGROVE_LEAF);
        this.compressedToDoubleCompressed.put(ModItems.COMPRESSED_CHERRY_LEAF, ModItems.DOUBLE_COMPRESSED_CHERRY_LEAF);
        this.compressedToDoubleCompressed.put(ModItems.COMPRESSED_MYSTERY_LEAF, ModItems.DOUBLE_COMPRESSED_MYSTERY_LEAF);
        this.compressedToDoubleCompressed.put(ModItems.COMPRESSED_MIXED_LEAF, ModItems.DOUBLE_COMPRESSED_MIXED_LEAF);
    }
}
