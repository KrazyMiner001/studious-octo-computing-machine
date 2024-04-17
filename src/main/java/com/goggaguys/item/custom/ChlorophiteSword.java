package com.goggaguys.item.custom;

import com.goggaguys.entity.ModEntityGroups;
import com.goggaguys.item.ModToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class ChlorophiteSword extends SwordItem {
    public ChlorophiteSword() {
        super(ModToolMaterial.CHLOROPHYTE, 7, -1, new FabricItemSettings());
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.getGroup().equals(ModEntityGroups.LEAFY)) {
            target.damage(attacker.getWorld().getDamageSources().create(
                    attacker instanceof PlayerEntity ? DamageTypes.PLAYER_ATTACK : DamageTypes.MOB_ATTACK,
                    attacker), 8);
        }
        return super.postHit(stack, target, attacker);
    }
}
