package com.goggaguys.entity.custom;

import com.goggaguys.entity.ModEntityGroups;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class LeafEntity extends PathAwareEntity {
    public LeafEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public EntityGroup getGroup() {
        return ModEntityGroups.LEAFY;
    }

    public static DefaultAttributeContainer.Builder createLeafAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f)
                .add(EntityAttributes.GENERIC_ARMOR, 1f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5);
    }
}
