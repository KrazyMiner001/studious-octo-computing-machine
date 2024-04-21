package com.goggaguys.block.custom;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.block.ModProperties;
import com.goggaguys.item.ModItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.SimpleVoxelShape;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;

public class LeafPedestalBlock extends Block {
    public static final MapCodec<LeafPedestalBlock> CODEC = createCodec(LeafPedestalBlock::new);
    public static final BooleanProperty ACTIVATED = ModProperties.ACTIVATED;
    protected static final VoxelShape PEDESTAL_SHAPE = VoxelShapes.union(
            VoxelShapes.cuboid(0.125f, 0f, 0.125f, 0.875, 0.125, 0.875),
            VoxelShapes.cuboid(0.25f, 0.125f, 0.25f, 0.75f, 0.625f, 0.75),
            VoxelShapes.cuboid(0.1875f, 0.625f, 0.1875f, 0.8125f, 0.6875f, 0.8125f));
    public LeafPedestalBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(ACTIVATED, false));
    }

    @Override
    protected MapCodec<? extends Block> getCodec() {
        return CODEC;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return PEDESTAL_SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return PEDESTAL_SHAPE;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getMainHandStack().getItem() == ModItems.LEAF_CORE /*Todo:make not placeholder*/ && spaceForPortal(world, pos) && !world.getBlockState(pos).get(ACTIVATED)) {
            if (!player.isCreative()) {
                player.getMainHandStack().setCount(player.getMainHandStack().getCount() - 1);
            }
            world.setBlockState(pos, state.with(ACTIVATED, true));
            Direction[] playerLookDirectionOrder = Direction.getEntityFacingOrder(player);
            ArrayList<Direction.Axis> playerLookAxisOrder = new ArrayList<>();
            for (Direction direction : Direction.getEntityFacingOrder(player)) {
                playerLookAxisOrder.add(direction.getAxis());
            }
            Direction.Axis playerLookAxis = Direction.Axis.X;
            for (Direction.Axis testAxis : playerLookAxisOrder) {
                if (LeafPortalBlock.AXIS.getValues().contains(testAxis)) {
                    playerLookAxis = testAxis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
                    break;
                }
            }
            world.setBlockState(pos.up(), ModBlocks.LEAF_PORTAL.getDefaultState().with(LeafPortalBlock.AXIS, playerLookAxis));
            return ActionResult.success(true);
        }
        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED);
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    private static boolean spaceForPortal(World world, BlockPos pos) {
        return world.getBlockState(pos.up()).getBlock() == Blocks.AIR;
    }
}
