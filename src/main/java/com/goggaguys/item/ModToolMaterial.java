package com.goggaguys.item;

import com.goggaguys.block.ModBlockTags;
import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.Objects;
import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    LEAF(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 1, 40f, 0f, 20,
            () -> Ingredient.fromTag(ModItemTags.LEAF)),
    COMPRESSED_LEAF(BlockTags.INCORRECT_FOR_STONE_TOOL, 5, 60f, 1f, 30,
            () -> Ingredient.fromTag(ModItemTags.LEAF_COMPRESSED)),
    DOUBLE_COMPRESSED_LEAF(BlockTags.INCORRECT_FOR_IRON_TOOL, 15, 80f, 2f, 40,
            () -> Ingredient.fromTag(ModItemTags.LEAF_DOUBLE_COMPRESSED)),

    LEAFITE(ModBlockTags.INCORRECT_FOR_LEAFITE_TOOL, 3000, 17f, 5f, 22,
            () -> Ingredient.ofItems(ModItems.LEAF_CORE)),
    CHLOROPHYTE(ModBlockTags.INCORRECT_FOR_CHLOROPHYTE_TOOL, 5000, 21F,
            7F, 30,
            () -> Ingredient.ofItems(ModItems.CHLOROPHYTE_INGOT));


    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(final TagKey inverseTag, final int itemDurability, final float miningSpeed, final float attackDamage, final int enchantability, final Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        Objects.requireNonNull(repairIngredient);
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
