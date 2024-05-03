package com.goggaguys.entity.custom;

import com.goggaguys.damagetype.ModDamageTypes;
import com.goggaguys.effects.ModStatusEffects;
import com.goggaguys.entity.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class LeafProjectileEntity extends ExplosiveProjectileEntity {
    private static boolean CHARGED;
    public LeafProjectileEntity(EntityType<? extends LeafProjectileEntity> entityType, World world) {
        super(entityType, world);
    }
    public LeafProjectileEntity(double x, double y, double z, double directionX, double directionY, double directionZ, World world) {
        super(ModEntities.LEAF_PROJECTILE, x, y, z, directionX, directionY, directionZ, world);
    }

    public LeafProjectileEntity(World world, LivingEntity owner, double directionX, double directionY, double directionZ) {
        super(ModEntities.LEAF_PROJECTILE, owner, directionX, directionY, directionZ, world);
    }
//
//    public LeafProjectileEntity(EntityType<? extends LeafProjectileEntity> entityType, World world) {
//        super(entityType, world);
//    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().createExplosion(this, this.getWorld().getDamageSources().create(ModDamageTypes.LEAF), null, this.getX(), this.getY(), this.getZ(), 1.0F, false, World.ExplosionSourceType.MOB);
            this.discard();
        }
    }

    @Override
    protected float getDrag() {

        return this.isCharged() ? 0.9f : 0.995f;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (!this.getWorld().isClient) {
            Entity hitEntity = entityHitResult.getEntity();
            Entity owner = this.getOwner();
            boolean entityHit;
            if (owner instanceof LivingEntity ownerLivingEntity) {
                entityHit = hitEntity.damage(this.getDamageSources().create(ModDamageTypes.LEAF), 20.0F);
                if (entityHit && hitEntity.isAlive()) {
                    this.applyDamageEffects(ownerLivingEntity, hitEntity);
                } else if (entityHit) {
                    ownerLivingEntity.heal(7.5f);
                }
            } else {
                entityHit = hitEntity.damage(this.getDamageSources().magic(), 10.0F);
            }

            if (entityHit && hitEntity instanceof LivingEntity livingEntity) {
                int effectDurationSeconds = 0;
                if (this.getWorld().getDifficulty() == Difficulty.NORMAL) {
                    effectDurationSeconds = 10;
                } else if (this.getWorld().getDifficulty() == Difficulty.HARD) {
                    effectDurationSeconds = 40;
                }

                if (effectDurationSeconds > 0) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.LEAFED_EFFECT, 20 * effectDurationSeconds, 1), this.getEffectCause());
                }
            }

        }
    }

    @Override
    public boolean canHit() {
        return false;
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    public boolean isCharged() {
        return CHARGED;
    }

    public void setCharged(boolean charged) {
        CHARGED = charged;
    }
}
