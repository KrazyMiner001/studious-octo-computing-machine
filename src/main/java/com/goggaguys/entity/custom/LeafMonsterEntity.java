package com.goggaguys.entity.custom;

import com.goggaguys.entity.ModEntityGroups;
import com.goggaguys.entity.ai.LeafMonsterAttackGoal;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class LeafMonsterEntity extends HostileEntity {
    public LeafMonsterEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createLeafMonsterAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f)
                .add(EntityAttributes.GENERIC_ARMOR, 1f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5);
    }

    @Override
    public EntityGroup getGroup() {
        return ModEntityGroups.LEAFY;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(5, new LeafMonsterAttackGoal(this, 1, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));


        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(6, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this));
    }
}
