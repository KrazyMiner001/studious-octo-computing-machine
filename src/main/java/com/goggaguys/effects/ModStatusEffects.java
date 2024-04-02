package com.goggaguys.effects;

import com.goggaguys.OctoComputing;
import com.goggaguys.effects.custom.LeafedResistanceEffect;
import com.goggaguys.effects.custom.LeafedStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    public static final StatusEffect LEAFED_EFFECT = registerEffect("leafed",
            new LeafedStatusEffect());

    public static final StatusEffect LEAFED_RESISTANCE_EFFECT = registerEffect("leafed_resistance",
            new LeafedResistanceEffect());

    private static StatusEffect registerEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(OctoComputing.MOD_ID, name), effect);
    }

    public static void registerModStatusEffects() {
        OctoComputing.LOGGER.info("Registering Status Effects for " + OctoComputing.MOD_ID);
    }
}
