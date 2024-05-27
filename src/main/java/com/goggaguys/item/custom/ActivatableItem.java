package com.goggaguys.item.custom;

import com.goggaguys.item.ModDataComponentTypes;
import net.minecraft.item.ItemStack;

public interface ActivatableItem {
    String NBT_STRING = "activated";

    static void setActivated(ItemStack stack, boolean activated) {
        stack.set(ModDataComponentTypes.ACTIVATED, activated);
    }

    static boolean isActivated(ItemStack stack) {
        return stack.getOrDefault(ModDataComponentTypes.ACTIVATED, false);
    }
}
