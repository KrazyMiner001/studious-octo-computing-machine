package com.goggaguys.block.custom;

import com.goggaguys.blockentity.ImplementedInventory;
import com.goggaguys.blockentity.custom.LeafShrineBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.SculkChargeParticleEffect;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LeafShrineBlock extends BlockWithEntity {
    public static final MapCodec<LeafShrineBlock> CODEC = createCodec(LeafShrineBlock::new);
    public LeafShrineBlock(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LeafShrineBlockEntity(pos, state);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;
        LeafShrineBlockEntity blockEntity = (LeafShrineBlockEntity) world.getBlockEntity(pos);

        assert blockEntity != null;
        if (!player.isSneaking()) {
            if (!player.getMainHandStack().isEmpty()) {
                if (((Inventory) blockEntity).getStack(0).isEmpty()) {
                    ((Inventory) blockEntity).setStack(0, player.getMainHandStack().copy());
                    player.getMainHandStack().setCount(0);
                    blockEntity.markDirty();
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.PASS;
                }
            } else {
                if (!((Inventory) blockEntity).getStack(0).isEmpty()) {
                    player.giveItemStack(((Inventory) blockEntity).getStack(0));
                    ((Inventory) blockEntity).removeStack(0);
                    blockEntity.markDirty();
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.PASS;
                }
            }
        } else {
            if (!((Inventory) blockEntity).getStack(0).isEmpty()) {
                //Todo
                blockEntity.markDirty();
                return ActionResult.SUCCESS;
            } else {
                return ActionResult.PASS;
            }
        }
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        ItemScatterer.onStateReplaced(state, newState, world, pos);
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
