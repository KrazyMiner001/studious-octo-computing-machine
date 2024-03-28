package com.goggaguys.effects.custom;

import com.goggaguys.damagetype.ModDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

import java.awt.*;

public class LeafedStatusEffect extends StatusEffect {
    public LeafedStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x085611);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(entity.getWorld().getDamageSources().create(ModDamageTypes.LEAF), 1 << amplifier);
    }
}
