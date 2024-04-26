package com.goggaguys.entity.custom;

import com.goggaguys.entity.ai.LeafMonsterAttackGoal;
import com.goggaguys.item.custom.LeafiteSword;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class LeafMonsterEntity extends HostileEntity implements Angerable {
    private boolean ANGRY;
    private int angerTime;
    private final UniformIntProvider ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);
    private UUID angryAt;

    public LeafMonsterEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createLeafMonsterAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f)
                .add(EntityAttributes.GENERIC_ARMOR, 1f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(5, new LeafMonsterAttackGoal(this, 1, true));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
    }

    @Override
    public void setTarget(@Nullable LivingEntity target) {
        super.setTarget(target);

        this.ANGRY = target != null;
    }

    @Override
    public int getAngerTime() {
        return this.angerTime;
    }

    @Override
    public void setAngerTime(int angerTime) {
        this.angerTime = angerTime;
    }

    @Nullable
    @Override
    public UUID getAngryAt() {
        return this.angryAt;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {
        this.angryAt = angryAt;
    }

    @Override
    public void chooseRandomAngerTime() {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (source.getAttacker() instanceof PlayerEntity player) {
            if (player.getMainHandStack().getItem() instanceof LeafiteSword) {
                return super.damage(source, amount * 1.1f);
            }
        }
        return super.damage(source, amount);
    }
}
