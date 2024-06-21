package tech.krazyminer001.entity;

import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.entity.custom.LeafGodEntity;
import tech.krazyminer001.entity.custom.LeafMonsterEntity;
import tech.krazyminer001.entity.custom.LeafProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import static tech.krazyminer001.utility.Util.of;


public class ModEntities {
    public static final EntityType<LeafMonsterEntity> LEAF_MONSTER = Registry.register(Registries.ENTITY_TYPE,
            of("leaf_monster"),
            EntityType.Builder.create(LeafMonsterEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.7f, 2.1f)
                    .build());

    public static final EntityType<LeafGodEntity> LEAF_GOD = Registry.register(Registries.ENTITY_TYPE,
            of("leaf_god"),
            EntityType.Builder.create(LeafGodEntity::new, SpawnGroup.MISC)
                    .dimensions(2f, 6f)
                    .build());

    public static final EntityType<LeafProjectileEntity> LEAF_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            of("leaf_projectile"),
            EntityType.Builder.create((EntityType<LeafProjectileEntity> entityType, World world) -> new LeafProjectileEntity(entityType, world), SpawnGroup.MISC)
                    .dimensions(0.3125f, 0.3125f)
                    .build());

    public static void registerModEntities() {
        OctoComputing.LOGGER.info("Registering Entities for " + OctoComputing.MOD_ID);

    }
}
