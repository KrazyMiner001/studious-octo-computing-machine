package tech.krazyminer001.effects;

import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.effects.custom.LeafedResistanceEffect;
import tech.krazyminer001.effects.custom.LeafedStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    public static final RegistryEntry<StatusEffect> LEAFED_EFFECT = registerEffect("leafed",
            new LeafedStatusEffect());

    public static final RegistryEntry<StatusEffect> LEAFED_RESISTANCE_EFFECT = registerEffect("leafed_resistance",
            new LeafedResistanceEffect());

    private static RegistryEntry<StatusEffect> registerEffect(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, new Identifier(OctoComputing.MOD_ID, name), effect);
    }

    public static void registerModStatusEffects() {
        OctoComputing.LOGGER.info("Registering Status Effects for " + OctoComputing.MOD_ID);
    }
}
