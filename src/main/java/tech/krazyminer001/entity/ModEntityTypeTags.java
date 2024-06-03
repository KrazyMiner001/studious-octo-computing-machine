package tech.krazyminer001.entity;

import tech.krazyminer001.OctoComputing;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModEntityTypeTags {
    public static final TagKey<EntityType<?>> LEAFY = TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier(OctoComputing.MOD_ID, "leafy"));
}
