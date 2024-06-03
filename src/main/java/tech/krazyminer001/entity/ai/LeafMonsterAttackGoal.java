package tech.krazyminer001.entity.ai;

import tech.krazyminer001.damagetype.ModDamageTypes;
import tech.krazyminer001.entity.custom.LeafMonsterEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;

public class LeafMonsterAttackGoal extends MeleeAttackGoal {
    private final LeafMonsterEntity entity;
    private final float attackRange = 1f;
    public LeafMonsterAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = (LeafMonsterEntity) mob;
    }

    @Override
    protected void attack(LivingEntity target) {
        if (isEnemyWithinAttackDistance(target)) {
            target.damage(mob.getWorld().getDamageSources().create(ModDamageTypes.LEAF), (float) entity.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE));
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy) {
        return this.entity.distanceTo(pEnemy) <= attackRange;
    }
}
