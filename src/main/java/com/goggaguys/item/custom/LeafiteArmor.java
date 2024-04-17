package com.goggaguys.item.custom;

import com.goggaguys.effects.ModStatusEffects;
import com.goggaguys.item.ModArmorMaterials;
import com.goggaguys.utilities.LeafResistancePotency;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LeafiteArmor extends ArmorItem {
    public LeafiteArmor(Type type) {
        super(ModArmorMaterials.LEAFITE, type, new FabricItemSettings());
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity playerEntity) {
            int effectPotency = LeafResistancePotency.getPotency(playerEntity) - 1;
            if (effectPotency >= 0) {
                playerEntity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.LEAFED_RESISTANCE_EFFECT, 1, effectPotency, true, false, false));
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
