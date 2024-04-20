package com.goggaguys.block.custom;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.item.ModItems;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PortalPedestalBlock extends Block {
    public static final MapCodec<PortalPedestalBlock> CODEC = createCodec(PortalPedestalBlock::new);
    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");
    public PortalPedestalBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(ACTIVATED, false));
    }

    @Override
    protected MapCodec<? extends Block> getCodec() {
        return CODEC;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getMainHandStack().getItem() == ModItems.LEAF_CORE /*Todo:make not placeholder*/ && spaceForPortal(world, pos) && !world.getBlockState(pos).get(ACTIVATED)) {
            if (!player.isCreative()) {
                player.getMainHandStack().setCount(player.getMainHandStack().getCount() - 1);
            }
            world.setBlockState(pos, state.with(ACTIVATED, true));
            world.setBlockState(pos.up(), ModBlocks.LEAF_PORTAL.getDefaultState());
            return ActionResult.success(true);
        }
        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED);
    }

    private static boolean spaceForPortal(World world, BlockPos pos) {
        return world.getBlockState(pos.up()).getBlock() == Blocks.AIR;
    }
}
