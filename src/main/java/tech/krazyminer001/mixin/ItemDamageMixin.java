package tech.krazyminer001.mixin;

import tech.krazyminer001.item.ModItems;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemEntity.class)

public abstract class ItemDamageMixin {
    @Shadow public abstract ItemStack getStack();

    @ModifyExpressionValue(at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"), method = "damage")
    private boolean dontDamageExplodeBrokenLeafCore(boolean original) {
        return original || this.getStack().isOf(ModItems.BROKEN_LEAF_CORE);
    }
}
