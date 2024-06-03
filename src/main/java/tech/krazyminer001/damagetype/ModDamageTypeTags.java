package tech.krazyminer001.damagetype;

import tech.krazyminer001.OctoComputing;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModDamageTypeTags {
    public static final TagKey<DamageType> LEAFY = TagKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(OctoComputing.MOD_ID, "leafy"));
    public static final TagKey<DamageType> LEAF_GOD_IMMUNE = TagKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(OctoComputing.MOD_ID, "leaf_god_immune"));
}
