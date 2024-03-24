package com.goggaguys.enchantments;

import com.goggaguys.OctoComputing;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static Enchantment LEAF_PROTECTION = registerEnchantment("leaf_protection", new LeafProtectionEnchantment());
    public static Enchantment GARDEN_SHEARS = registerEnchantment("garden_shears", new GardenShearsEnchantment());

    private static Enchantment registerEnchantment(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(OctoComputing.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        OctoComputing.LOGGER.info("Registering enchantments for " + OctoComputing.MOD_ID);
    }
}
