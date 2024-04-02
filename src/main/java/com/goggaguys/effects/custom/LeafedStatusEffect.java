package com.goggaguys.effects.custom;

import com.goggaguys.damagetype.ModDamageTypes;
import com.goggaguys.effects.ModStatusEffects;
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
        int leafedResistanceAmplifier = entity.getActiveStatusEffects().containsKey(ModStatusEffects.LEAFED_RESISTANCE_EFFECT) ?
                entity.getStatusEffect(ModStatusEffects.LEAFED_RESISTANCE_EFFECT).getAmplifier() + 1 :
                0;

        entity.damage(entity.getWorld().getDamageSources().create(ModDamageTypes.LEAF), (float) ((1 << amplifier) * Math.pow(0.75, leafedResistanceAmplifier)));
    }
}
