package com.goggaguys.damagetype;

import com.goggaguys.OctoComputing;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ModDamageTypes {
    private static final Map<RegistryKey<DamageType>, DamageType> TYPES = new HashMap<>();

    public static final RegistryKey<DamageType> LEAF = registerKey(new DamageType("leaf", 0f));

    private static RegistryKey<DamageType> registerKey(DamageType source) {
        RegistryKey<DamageType> type = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(OctoComputing.MOD_ID, source.msgId()));
        TYPES.put(type, source);
        return type;
    }

    public static void bootstrap(Registerable<DamageType> context) {
        context.register(LEAF, TYPES.get(LEAF));
    }

    public static Collection<DamageType> sources() {
        return TYPES.values();
    }
}
