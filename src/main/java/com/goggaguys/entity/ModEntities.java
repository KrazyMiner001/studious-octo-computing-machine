package com.goggaguys.entity;

import com.goggaguys.OctoComputing;
import com.goggaguys.entity.custom.LeafMonsterEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<LeafMonsterEntity> LEAF_MONSTER_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(OctoComputing.MOD_ID, "leaf_monster"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LeafMonsterEntity::new)
                    .dimensions(EntityDimensions.fixed(0.7f, 2.1f)).build());
    public static void registerModEntities() {
        OctoComputing.LOGGER.info("Registering Entities for " + OctoComputing.MOD_ID);

    }
}
