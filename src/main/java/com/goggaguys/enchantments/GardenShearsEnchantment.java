package com.goggaguys.enchantments;

import com.goggaguys.entity.ModEntityGroups;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class GardenShearsEnchantment extends Enchantment {
    protected GardenShearsEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 10 * level;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        return group == ModEntityGroups.LEAFY ? level * 2.5f : 0.0f;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity livingEntity) {
        }
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && !(other instanceof DamageEnchantment);
    }
}
