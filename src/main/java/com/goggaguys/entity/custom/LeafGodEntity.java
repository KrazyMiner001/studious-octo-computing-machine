package com.goggaguys.entity.custom;

import com.goggaguys.entity.ModEntityGroups;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class LeafGodEntity extends HostileEntity implements RangedAttackMob {

    public final AnimationState leafGodAnimationState = new AnimationState();
    public final AnimationState leafGodCoreSpin = new AnimationState();
    private final ServerBossBar bossBar;
    private static final Predicate<LivingEntity> CAN_ATTACK_PREDICATE;
    public LeafGodEntity(EntityType<? extends LeafGodEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = (ServerBossBar)(new ServerBossBar(this.getDisplayName(), BossBar.Color.GREEN, BossBar.Style.PROGRESS)).setDarkenSky(true);
        this.moveControl = new FlightMoveControl(this, 10, true);
        this.setHealth(this.getMaxHealth());
        this.experiencePoints = 50;
    }

    public static DefaultAttributeContainer.Builder createLeafGodAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 500)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.75f)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.75f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 40)
                .add(EntityAttributes.GENERIC_ARMOR, 17f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15);
    }

    public void onSummoned() {
        this.bossBar.setPercent(1F);
    }

    @Override
    protected void mobTick() {
        super.mobTick();
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        this.leafGodAnimationState.startIfNotRunning(this.age);
        this.leafGodCoreSpin.startIfNotRunning(this.age);
    }

    @Override
    public void shootAt(LivingEntity target, float pullProgress) {

    }

    @Override
    public void setCustomName(@Nullable Text name) {
        super.setCustomName(name);
        this.bossBar.setName(this.getDisplayName());
    }

    @Override
    public EntityGroup getGroup() {
        return ModEntityGroups.LEAFY;
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        BirdNavigation leafGodNavigation = new BirdNavigation(this, world);
        leafGodNavigation.setCanPathThroughDoors(false);
        leafGodNavigation.setCanSwim(true);
        leafGodNavigation.setCanEnterOpenDoors(true);
        return leafGodNavigation;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new ProjectileAttackGoal(this, 1.0, 40, 20.0F));
        this.goalSelector.add(5, new FlyGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    static {
        CAN_ATTACK_PREDICATE = LivingEntity::isMobOrPlayer;
    }
}
