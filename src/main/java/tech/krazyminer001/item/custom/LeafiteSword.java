package tech.krazyminer001.item.custom;

import tech.krazyminer001.entity.ModEntityTypeTags;
import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;

import java.util.List;

public class LeafiteSword extends SwordItem {
    public LeafiteSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.getType().isIn(ModEntityTypeTags.LEAFY)) {
            target.damage(attacker.getWorld().getDamageSources().create(
                    attacker instanceof PlayerEntity ? DamageTypes.PLAYER_ATTACK : DamageTypes.MOB_ATTACK,
                            attacker), 5);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(1, Text.translatable("item.octocomputing.leafite_sword.tooltip"));
    }
}
