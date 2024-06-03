package tech.krazyminer001.utilities;

import tech.krazyminer001.item.custom.ChlorophyteArmor;
import tech.krazyminer001.item.custom.LeafiteArmor;
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
