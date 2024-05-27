package com.goggaguys.entity;

import com.goggaguys.OctoComputing;
import com.goggaguys.entity.custom.LeafGodEntity;
import com.goggaguys.entity.custom.LeafMonsterEntity;
import com.goggaguys.entity.custom.LeafProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModEntities {
    public static final EntityType<LeafMonsterEntity> LEAF_MONSTER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(OctoComputing.MOD_ID, "leaf_monster"),
            EntityType.Builder.create(LeafMonsterEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.7f, 2.1f)
                    .build());

    public static final EntityType<LeafGodEntity> LEAF_GOD = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(OctoComputing.MOD_ID, "leaf_god"),
            EntityType.Builder.create(LeafGodEntity::new, SpawnGroup.MISC)
                    .dimensions(2f, 6f)
                    .build());

    public static final EntityType<LeafProjectileEntity> LEAF_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(OctoComputing.MOD_ID, "leaf_projectile"),
            EntityType.Builder.create((EntityType<LeafProjectileEntity> entityType, World world) -> new LeafProjectileEntity(entityType, world), SpawnGroup.MISC)
                    .dimensions(0.3125f, 0.3125f)
                    .build());

    public static void registerModEntities() {
        OctoComputing.LOGGER.info("Registering Entities for " + OctoComputing.MOD_ID);

    }
}
