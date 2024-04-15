package com.goggaguys.entity;

import com.goggaguys.OctoComputing;
import com.goggaguys.entity.custom.LeafGodEntity;
import com.goggaguys.entity.custom.LeafMonsterEntity;
import com.goggaguys.entity.custom.LeafProjectileEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModEntities {
    public static final EntityType<LeafMonsterEntity> LEAF_MONSTER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(OctoComputing.MOD_ID, "leaf_monster"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LeafMonsterEntity::new)
                    .dimensions(EntityDimensions.fixed(0.7f, 2.1f))
                    .build());

    public static final EntityType<LeafGodEntity> LEAF_GOD = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(OctoComputing.MOD_ID, "leaf_god"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, LeafGodEntity::new)
                    .dimensions(EntityDimensions.fixed(2f, 6f))
                    .build());

    public static final EntityType<LeafProjectileEntity> LEAF_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(OctoComputing.MOD_ID, "leaf_projectile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, (EntityType<LeafProjectileEntity> entityType, World world) -> new LeafProjectileEntity(entityType, world))
                    .dimensions(EntityDimensions.fixed(0.3125f, 0.3125f))
                    .build());
    public static void registerModEntities() {
        OctoComputing.LOGGER.info("Registering Entities for " + OctoComputing.MOD_ID);

    }
}
