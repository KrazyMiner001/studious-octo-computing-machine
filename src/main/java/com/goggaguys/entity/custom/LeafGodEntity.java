package com.goggaguys.entity.custom;

import com.goggaguys.damagetype.ModDamageTypeTags;
import com.goggaguys.entity.ModEntityGroups;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public class LeafGodEntity extends HostileEntity implements RangedAttackMob {

    public final AnimationState leafGodAnimationState = new AnimationState();
    public final AnimationState leafGodCoreSpin = new AnimationState();
    private final ServerBossBar bossBar;
    private int leafCooldown = 0;
    private int chargedLeafCooldown = 0;
    private static final TrackedData<Integer> TRACKED_ENTITY_ID;
    private static final Predicate<LivingEntity> CAN_ATTACK_PREDICATE;
    private static final TargetPredicate CORE_TARGET_PREDICATE;
    public LeafGodEntity(EntityType<? extends LeafGodEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = (ServerBossBar)(new ServerBossBar(this.getDisplayName(), BossBar.Color.GREEN, BossBar.Style.PROGRESS)).setDarkenSky(true);
        this.moveControl = new FlightMoveControl(this, 15, true);
        this.setHealth(this.getMaxHealth());
        this.experiencePoints = 75;
    }

    public static DefaultAttributeContainer.Builder createLeafGodAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 750)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.75f)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 2f)
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

        if (this.age >= this.leafCooldown) {
            this.leafCooldown = this.age + 10 + this.random.nextInt(10);
            if (this.getWorld().getDifficulty() == Difficulty.NORMAL || this.getWorld().getDifficulty() == Difficulty.HARD) {
                this.chargedLeafCooldown += 1;
                if (chargedLeafCooldown > 15) {
                    double randomTargetX = MathHelper.nextDouble(this.random, this.getX() - 10.0, this.getX() + 10.0);
                    double randomTargetY = MathHelper.nextDouble(this.random, this.getY() - 5.0, this.getY() + 5.0);
                    double randomTargetZ = MathHelper.nextDouble(this.random, this.getZ() - 10.0, this.getZ() + 10.0);
                    this.shootLeafAt(randomTargetX, randomTargetY, randomTargetZ, true);
                    this.chargedLeafCooldown = 0;
                }
            }
        }
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

    public int getTrackedEntityId() {
        return this.dataTracker.get(TRACKED_ENTITY_ID);
    }

    public void setTrackedEntityId(int id) {
        this.dataTracker.set(TRACKED_ENTITY_ID, id);
    }

    @Override
    public void shootAt(LivingEntity target, float pullProgress) {
        shootLeafAt(target);
        shootLeafNear(target);
        shootLeafNear(target);
        shootLeafNear(target);
        shootLeafNear(target);
    }

    private void shootLeafNear(LivingEntity target) {
        this.shootLeafAt(target.getX() + 6*random.nextDouble()-3, target.getY() + (double)target.getStandingEyeHeight() * 0.5 + 6*random.nextDouble()-3, target.getZ() + 6*random.nextDouble()-3, this.random.nextFloat() < 0.001F);
    }

    private void shootLeafAt(double targetX, double targetY, double targetZ, boolean charged) {
        double coreX = this.getCoreX();
        double coreY = this.getCoreY();
        double coreZ = this.getCoreZ();
        double distanceX = targetX - coreX;
        double distanceY = targetY - coreY;
        double distanceZ = targetZ - coreZ;
        WitherSkullEntity witherSkullEntity = new WitherSkullEntity(this.getWorld(), this, distanceX, distanceY, distanceZ);
        witherSkullEntity.setOwner(this);
        if (charged) {
            witherSkullEntity.setCharged(true);
        }

        witherSkullEntity.setPos(coreX, coreY, coreZ);
        this.getWorld().spawnEntity(witherSkullEntity);
    }

    private void shootLeafAt(LivingEntity target) {
        this.shootLeafAt(target.getX(), target.getY() + (double)target.getStandingEyeHeight() * 0.5, target.getZ(), this.random.nextFloat() < 0.001F);
    }

    private double getCoreX() {
        return this.getX();
    }

    private double getCoreY() {
        return this.getY() + 3;
    }

    private double getCoreZ() {
        return this.getZ();
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (source.isIn(ModDamageTypeTags.LEAF_GOD_IMMUNE)) {
            return false;
        }
        return super.damage(source, amount);
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
        this.goalSelector.add(2, new ProjectileAttackGoal(this, 2.0, 15, 30.0F));
        this.goalSelector.add(5, new FlyGoal(this, 2.0));
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
        TRACKED_ENTITY_ID = DataTracker.registerData(LeafGodEntity.class, TrackedDataHandlerRegistry.INTEGER);
        CAN_ATTACK_PREDICATE = LivingEntity::isMobOrPlayer;
        CORE_TARGET_PREDICATE = TargetPredicate.createAttackable().setBaseMaxDistance(20.0).setPredicate(CAN_ATTACK_PREDICATE);
    }
}
