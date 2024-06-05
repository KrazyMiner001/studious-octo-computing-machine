package tech.krazyminer001.enchantment;

import tech.krazyminer001.damagetype.ModDamageTypeTags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.tag.ItemTags;

public class LeafProtectionEnchantment extends Enchantment {
    protected LeafProtectionEnchantment() {
        super(Enchantment.properties(ItemTags.WEAPON_ENCHANTABLE, ItemTags.SWORD_ENCHANTABLE, 5, 4, Enchantment.leveledCost(5, 10), Enchantment.leveledCost(25, 8), 2, EquipmentSlot.HEAD, EquipmentSlot.FEET, EquipmentSlot.LEGS, EquipmentSlot.HEAD));
    }

    @Override
    public int getProtectionAmount(int level, DamageSource source) {
        if (source.isIn(ModDamageTypeTags.LEAFY))
            return level * 2;
          else return 0;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && !(other instanceof ProtectionEnchantment);
    }
}
