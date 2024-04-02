package com.goggaguys.effects.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;


public class LeafedResistanceEffect extends StatusEffect {
    public LeafedResistanceEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x244234);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
    }
}
