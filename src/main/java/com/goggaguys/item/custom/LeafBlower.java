package com.goggaguys.item.custom;

import com.goggaguys.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class LeafBlower extends Item {
    public LeafBlower() {
        super(new Item.Settings().maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        BlockPos pos = user.getBlockPos();
        BlockPos.iterateRecursively(pos, 6, 200, (blockPos, queuer) -> {
            Direction[] directions = Direction.values();

            for (Direction direction : directions) {
                queuer.accept(blockPos.offset(direction));
            }
        }, ((blockPos) -> {
            if (world.getBlockState(blockPos).isIn(BlockTags.LEAVES)) {
                world.breakBlock(blockPos, true);
            }
            return true;
        }));
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
