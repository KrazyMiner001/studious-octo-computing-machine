package com.goggaguys.utilities;

import com.goggaguys.item.custom.ChlorophyteArmor;
import com.goggaguys.item.custom.LeafiteArmor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class LeafResistancePotency {
    public static int getPotency(PlayerEntity player) {
        int potency = 0;
        for (ItemStack armorPiece : player.getInventory().armor) {
            if (armorPiece.getItem() instanceof ChlorophyteArmor) {
                potency += 2;
            } else if (armorPiece.getItem() instanceof LeafiteArmor) {
                potency++;
            }
        }
        return potency;
    }
}
