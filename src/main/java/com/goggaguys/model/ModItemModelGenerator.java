package com.goggaguys.model;

import com.goggaguys.OctoComputing;
import com.google.gson.JsonElement;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureMap;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class ModItemModelGenerator extends ItemModelGenerator {
    private static final List<TrimMaterial> TRIM_MATERIALS;
    private static final Identifier COMPRESSED_OVERLAY = new Identifier(OctoComputing.MOD_ID ,"item/compressed");
    private static final Identifier DOUBLE_COMPRESSED_OVERLAY = new Identifier(OctoComputing.MOD_ID ,"item/double_compressed");

    public ModItemModelGenerator(BiConsumer<Identifier, Supplier<JsonElement>> writer) {
        super(writer);
    }
    public void registerCompressedChain(Item baseItem, Item compressedItem, Item doubleCompressedItem) {
        super.register(baseItem, Models.GENERATED);
        Models.GENERATED_TWO_LAYERS.upload(ModelIds.getItemModelId(compressedItem), TextureMap.layered(TextureMap.getId(baseItem), COMPRESSED_OVERLAY), this.writer);
        Models.GENERATED_TWO_LAYERS.upload(ModelIds.getItemModelId(doubleCompressedItem), TextureMap.layered(TextureMap.getId(baseItem), DOUBLE_COMPRESSED_OVERLAY), this.writer);
    }

    public final void registerCompressedArmorChain(ArmorItem armor, ArmorItem compressedArmor, ArmorItem doubleCompressedArmor) {
        Identifier armorModelId = ModelIds.getItemModelId(armor);
        Identifier armorTextureId = TextureMap.getId(armor);

        registerArmor(armor, armorModelId, armorTextureId);
        trimArmor(armor, armorModelId, armorTextureId);

        Identifier compressedArmorModelId = ModelIds.getItemModelId(compressedArmor);

        registerArmor(compressedArmor, compressedArmorModelId, TextureMap.layered(armorTextureId, COMPRESSED_OVERLAY));
        trimArmor(compressedArmor, compressedArmorModelId, armorTextureId, COMPRESSED_OVERLAY);

        Identifier doubleCompressedArmorModelId = ModelIds.getItemModelId(doubleCompressedArmor);

        registerArmor(doubleCompressedArmor, doubleCompressedArmorModelId, TextureMap.layered(armorTextureId, DOUBLE_COMPRESSED_OVERLAY));
        trimArmor(doubleCompressedArmor, doubleCompressedArmorModelId, armorTextureId);

    }

    private void registerArmor(ArmorItem armor, Identifier armorModelId, Identifier armorTextureId) {
        Models.GENERATED.upload(armorModelId, TextureMap.layer0(armorTextureId), this.writer,
                (id, textures) -> this.createArmorJson(id, textures, armor.getMaterial()));
    }

    private void registerArmor(ArmorItem armor, Identifier armorModelId, TextureMap textureMap) {
        Models.GENERATED_TWO_LAYERS.upload(armorModelId, textureMap, this.writer,
                (id, textures) -> this.createArmorJson(id, textures, armor.getMaterial()));
    }

    private void trimArmor(ArmorItem armor, Identifier armorModelId, Identifier armorTextureId) {
        for (TrimMaterial trimMaterial : TRIM_MATERIALS) {
            String trimMaterialAppliedName = trimMaterial.getAppliedName(armor.getMaterial());
            Identifier trimId = this.suffixTrim(armorModelId, trimMaterialAppliedName);
            String armorTrimmedName = armor.getType().getName() + "_trim_" + trimMaterialAppliedName;
            Identifier armorTrimmedId = (new Identifier(armorTrimmedName)).withPrefixedPath("trims/items/");
            this.uploadArmor(trimId, armorTextureId, armorTrimmedId);
        }
    }

    private void trimArmor(ArmorItem armor, Identifier armorModelId, Identifier armorTextureId, Identifier overlayId) {
        for (TrimMaterial trimMaterial : TRIM_MATERIALS) {
            String trimMaterialAppliedName = trimMaterial.getAppliedName(armor.getMaterial());
            Identifier trimId = this.suffixTrim(armorModelId, trimMaterialAppliedName);
            String armorTrimmedName = armor.getType().getName() + "_trim_" + trimMaterialAppliedName;
            Identifier armorTrimmedId = (new Identifier(armorTrimmedName)).withPrefixedPath("trims/items/");
            this.uploadArmor(trimId, armorTextureId, armorTrimmedId, overlayId);
        }
    }

    static {
        TRIM_MATERIALS = List.of(new TrimMaterial("quartz", 0.1F, Map.of()), new TrimMaterial("iron", 0.2F, Map.of(ArmorMaterials.IRON, "iron_darker")), new TrimMaterial("netherite", 0.3F, Map.of(ArmorMaterials.NETHERITE, "netherite_darker")), new TrimMaterial("redstone", 0.4F, Map.of()), new TrimMaterial("copper", 0.5F, Map.of()), new TrimMaterial("gold", 0.6F, Map.of(ArmorMaterials.GOLD, "gold_darker")), new TrimMaterial("emerald", 0.7F, Map.of()), new TrimMaterial("diamond", 0.8F, Map.of(ArmorMaterials.DIAMOND, "diamond_darker")), new TrimMaterial("lapis", 0.9F, Map.of()), new TrimMaterial("amethyst", 1.0F, Map.of()));
    }

    private record TrimMaterial(String name, float itemModelIndex, Map<ArmorMaterial, String> overrideArmorMaterials) {
        TrimMaterial(String name, float itemModelIndex, Map<ArmorMaterial, String> overrideArmorMaterials) {
            this.name = name;
            this.itemModelIndex = itemModelIndex;
            this.overrideArmorMaterials = overrideArmorMaterials;
        }

        public String getAppliedName(ArmorMaterial armorMaterial) {
            return this.overrideArmorMaterials.getOrDefault(armorMaterial, this.name);
        }

        public String name() {
            return this.name;
        }

        public float itemModelIndex() {
            return this.itemModelIndex;
        }

        public Map<ArmorMaterial, String> overrideArmorMaterials() {
            return this.overrideArmorMaterials;
        }
    }
}
