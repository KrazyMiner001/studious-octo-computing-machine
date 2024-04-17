package com.goggaguys.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class LeafPicker extends Item {
    public LeafPicker() {
        super(new FabricItemSettings().maxDamage(750));
    }

    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && !state.isIn(BlockTags.FIRE)) {
            stack.damage(1, miner, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }

        return state.isIn(BlockTags.LEAVES) || super.postMine(stack, world, state, pos, miner);
    }

    public boolean isSuitableFor(BlockState state) {
        return state.isIn(BlockTags.LEAVES);
    }

    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (!state.isIn(BlockTags.LEAVES)) {
            return super.getMiningSpeedMultiplier(stack, state);
        }
        return 15.0F;
    }
}
