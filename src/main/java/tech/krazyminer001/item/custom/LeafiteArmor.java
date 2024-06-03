package tech.krazyminer001.item.custom;

import tech.krazyminer001.effects.ModStatusEffects;
import tech.krazyminer001.item.ModArmorMaterials;
import tech.krazyminer001.utilities.LeafResistancePotency;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LeafiteArmor extends ArmorItem {
    public LeafiteArmor(Type type) {
        super(ModArmorMaterials.LEAFITE, type, new Item.Settings().maxDamage(type.getMaxDamage(50)));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity playerEntity) {
            int effectPotency = LeafResistancePotency.getPotency(playerEntity) - 1;
            if (effectPotency >= 0) {
                playerEntity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.LEAFED_RESISTANCE_EFFECT, 1, effectPotency, true, false, false));
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
