package tech.krazyminer001.item.custom;

import net.minecraft.item.tooltip.TooltipType;
import tech.krazyminer001.entity.ModEntityTypeTags;
import tech.krazyminer001.item.ModToolMaterial;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.text.Text;

import java.util.List;

public class ChlorophyteSword extends SwordItem {
    public ChlorophyteSword() {
        super(ModToolMaterial.CHLOROPHYTE, new Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.CHLOROPHYTE, 7, -1)));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.getType().isIn(ModEntityTypeTags.LEAFY)) {
            target.damage(attacker.getWorld().getDamageSources().create(
                    attacker instanceof PlayerEntity ? DamageTypes.PLAYER_ATTACK : DamageTypes.MOB_ATTACK,
                    attacker), 8);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(1, Text.translatable("item.octocomputing.chlorophyte.chlorophyte_sword.tooltip"));
    }
}
