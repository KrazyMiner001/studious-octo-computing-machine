package com.goggaguys.enchantments;

import com.goggaguys.entity.ModEntityTypeTags;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

public class GardenShearsEnchantment extends Enchantment {
    protected GardenShearsEnchantment() {
        super(Enchantment.properties(ItemTags.WEAPON_ENCHANTABLE, ItemTags.SWORD_ENCHANTABLE, 5, 5, Enchantment.leveledCost(5, 10), Enchantment.leveledCost(25, 8), 2, EquipmentSlot.MAINHAND));
    }

    @Override
    public float getAttackDamage(int level, @Nullable EntityType<?> entityType) {
        return entityType.isIn(ModEntityTypeTags.LEAFY) ? level * 2.5f : 0.0f;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && !(other instanceof DamageEnchantment);
    }
}
