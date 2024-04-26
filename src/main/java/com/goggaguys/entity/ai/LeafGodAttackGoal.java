package com.goggaguys.entity.ai;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;

public class LeafGodAttackGoal extends MeleeAttackGoal {

    public LeafGodAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
    }
}
