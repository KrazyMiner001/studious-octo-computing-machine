package com.goggaguys.item.custom;

import com.goggaguys.effects.ModStatusEffects;
import com.goggaguys.item.ModArmorMaterials;
import com.goggaguys.utilities.LeafResistancePotency;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ChlorophiteArmor extends ArmorItem {
    private boolean hasFlightBuff = false;
    public ChlorophiteArmor(Type type) {
        super(ModArmorMaterials.CHLOROPHYTE, type, new FabricItemSettings());
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity playerEntity) {
            int effectPotency = LeafResistancePotency.getPotency(playerEntity) - 1;
            if (effectPotency >= 0) {
                playerEntity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.LEAFED_RESISTANCE_EFFECT, 1, effectPotency, true, false, false));
            }

            this.hasFlightBuff = hasFullArmorSet(playerEntity);

            if (this.hasFlightBuff) {
                playerEntity.getAbilities().allowFlying = true;
            } else if (!playerEntity.getAbilities().creativeMode){
                playerEntity.getAbilities().allowFlying = false;
                playerEntity.getAbilities().flying = false;
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public TypedActionResult<ItemStack> equipAndSwap(Item item, World world, PlayerEntity user, Hand hand) {
        return super.equipAndSwap(item, world, user, hand);
    }

    private boolean hasFullArmorSet(PlayerEntity player) {
        int armorPieces = 0;
        for (ItemStack armorPiece : player.getInventory().armor) {
            if (armorPiece.getItem() instanceof ChlorophiteArmor) {
                armorPieces++;
            }
        }
        return armorPieces == 4;
    }
}
