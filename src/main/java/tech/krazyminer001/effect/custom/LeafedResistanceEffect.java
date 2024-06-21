package tech.krazyminer001.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;


public class LeafedResistanceEffect extends StatusEffect {
    public LeafedResistanceEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x244234);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        return super.applyUpdateEffect(entity, amplifier);
    }
}