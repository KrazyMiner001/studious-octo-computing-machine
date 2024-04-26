package com.goggaguys.item;

import com.goggaguys.OctoComputing;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials extends ArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> LEAF;
    public static final RegistryEntry<ArmorMaterial> COMPRESSED_LEAF;
    public static final RegistryEntry<ArmorMaterial> DOUBLE_COMPRESSED_LEAF;
    public static final RegistryEntry<ArmorMaterial> LEAFITE;
    public static final RegistryEntry<ArmorMaterial> CHLOROPHYTE;

    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(new Identifier(id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);
        ArmorItem.Type[] values = ArmorItem.Type.values();

        for (ArmorItem.Type type : values) {
            enumMap.put(type, defense.get(type));
        }

        return Registry.registerReference(Registries.ARMOR_MATERIAL, new Identifier(OctoComputing.MOD_ID, id), new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance));
    }

    static {
        LEAF = register("leaf", Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 1);
            map.put(ArmorItem.Type.LEGGINGS, 1);
            map.put(ArmorItem.Type.CHESTPLATE, 1);
            map.put(ArmorItem.Type.HELMET, 1);
            map.put(ArmorItem.Type.BODY, 1);
        }), 20,
                SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
                0.0F, 0.0F,
                () -> Ingredient.fromTag(ModItemTags.LEAF));

        COMPRESSED_LEAF = register("compressed_leaf", Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
                    map.put(ArmorItem.Type.BOOTS, 1);
                    map.put(ArmorItem.Type.LEGGINGS, 2);
                    map.put(ArmorItem.Type.CHESTPLATE, 3);
                    map.put(ArmorItem.Type.HELMET, 1);
                    map.put(ArmorItem.Type.BODY, 4);
                }), 30,
                SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
                0.0F, 0.0F,
                () -> Ingredient.fromTag(ModItemTags.LEAF_COMPRESSED));

        DOUBLE_COMPRESSED_LEAF = register("double_compressed_leaf", Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
                    map.put(ArmorItem.Type.BOOTS, 1);
                    map.put(ArmorItem.Type.LEGGINGS, 3);
                    map.put(ArmorItem.Type.CHESTPLATE, 5);
                    map.put(ArmorItem.Type.HELMET, 2);
                    map.put(ArmorItem.Type.BODY, 4);
                }), 40,
                SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
                0.0F, 0.0F,
                () -> Ingredient.fromTag(ModItemTags.LEAF_DOUBLE_COMPRESSED));

        LEAFITE = register("leafite", Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
                    map.put(ArmorItem.Type.BOOTS, 4);
                    map.put(ArmorItem.Type.LEGGINGS, 7);
                    map.put(ArmorItem.Type.CHESTPLATE, 10);
                    map.put(ArmorItem.Type.HELMET, 5);
                    map.put(ArmorItem.Type.BODY, 4);
                }), 25,
                SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                4.0F, 0.2F,
                () -> Ingredient.ofItems(ModItems.LEAF_CORE));

        CHLOROPHYTE = register("chlorophyte", Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
                    map.put(ArmorItem.Type.BOOTS, 6);
                    map.put(ArmorItem.Type.LEGGINGS, 9);
                    map.put(ArmorItem.Type.CHESTPLATE, 12);
                    map.put(ArmorItem.Type.HELMET, 7);
                    map.put(ArmorItem.Type.BODY, 4);
                }), 32,
                SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                6.0F, 0.25F,
                () -> Ingredient.ofItems(ModItems.CHLOROPHYTE_INGOT));
    }
}