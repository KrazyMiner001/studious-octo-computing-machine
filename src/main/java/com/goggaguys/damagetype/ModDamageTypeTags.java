package com.goggaguys.damagetype;

import com.goggaguys.OctoComputing;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModDamageTypeTags {
    public static final TagKey<DamageType> LEAFY = TagKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(OctoComputing.MOD_ID, "leafy"));
}
