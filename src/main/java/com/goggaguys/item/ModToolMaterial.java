package com.goggaguys.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    LEAF(1, 1, 40f, 0f, 20,
            () -> Ingredient.fromTag(ModItemTags.LEAF)),
    COMPRESSED_LEAF(2, 5, 60f, 1f, 30,
            () -> Ingredient.fromTag(ModItemTags.LEAF_COMPRESSED)),
    DOUBLE_COMPRESSED_LEAF(3, 15, 80f, 2f, 40,
            () -> Ingredient.fromTag(ModItemTags.LEAF_DOUBLE_COMPRESSED)),

    LEAFITE(5, 3000, 17f, 5f, 22,
            () -> Ingredient.ofItems(ModItems.LEAF_CORE));


    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
