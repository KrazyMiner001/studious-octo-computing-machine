package com.goggaguys.block.custom;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.entity.ModEntities;
import com.goggaguys.world.dimension.ModDimensions;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;

public class LeafPortalBlock extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = Properties.HORIZONTAL_AXIS;
    public static final MapCodec<LeafPortalBlock> CODEC = createCodec(LeafPortalBlock::new);
    public LeafPortalBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends Block> getCodec() {
        return CODEC;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextDouble() < 0.025 && world.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
            world.spawnEntity(ModEntities.LEAF_MONSTER.spawn(world, pos, SpawnReason.STRUCTURE));
        }
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return super.hasRandomTicks(state);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (world instanceof ServerWorld
                && !entity.hasVehicle()
                && !entity.hasPassengers()
                && entity.canUsePortals()
                && entity.isSneaking()) {

            RegistryKey<World> currentWorldKey = world.getRegistryKey();
            if (currentWorldKey == World.OVERWORLD) {
                if (!entity.hasPortalCooldown()) {
                    entity.setPortalCooldown(entity.getDefaultPortalCooldown() * 2);

                    // => teleport to Leaf Dimension
                    ServerWorld targetWorld = ((ServerWorld) world).getServer().getWorld(ModDimensions.LEAF_LEVEL_KEY);
                    if (targetWorld != null) {
                        BlockPos portalPos = new BlockPos(pos.getX(), findPortalY(pos.getX(), pos.getY() + 320, pos.getZ(), targetWorld) + 1, pos.getZ());
                        if (!targetWorld.getBlockState(portalPos).isOf(ModBlocks.LEAF_PORTAL)) {
                            targetWorld.setBlockState(portalPos, ModBlocks.LEAF_PORTAL.getDefaultState().with(AXIS, Direction.Axis.X));
                        }

                        if (entity instanceof PlayerEntity) {

                        }
                        FabricDimensions.teleport(entity, targetWorld, new TeleportTarget(Vec3d.ofCenter(portalPos), Vec3d.ZERO, entity.getYaw(), entity.getPitch()));
                        entity.setPortalCooldown(entity.getDefaultPortalCooldown() * 2);
                    }
                }
            } else {
                if (!entity.hasPortalCooldown()) {
                    entity.setPortalCooldown(entity.getDefaultPortalCooldown() * 2);

                    // => teleport to Overworld
                    ServerWorld targetWorld = ((ServerWorld) world).getServer().getWorld(World.OVERWORLD);
                    if (targetWorld != null) {
                        BlockPos portalPos = new BlockPos(pos.getX(), findPortalY(pos.getX(), pos.getY() - 320, pos.getZ(), targetWorld) + 1, pos.getZ());
                        if (!targetWorld.getBlockState(portalPos).isOf(ModBlocks.LEAF_PORTAL)) {
                            targetWorld.setBlockState(portalPos, ModBlocks.LEAF_PORTAL.getDefaultState().with(AXIS, Direction.Axis.X));
                        }

                        FabricDimensions.teleport(entity, targetWorld, new TeleportTarget(Vec3d.ofCenter(portalPos), Vec3d.ZERO, entity.getYaw(), entity.getPitch()));
                        entity.setPortalCooldown(entity.getDefaultPortalCooldown() * 2);
                    }
                }
            }
        }
    }

    private static int findPortalY (int x, int y, int z, ServerWorld world) {
        for (int testY = world.getBottomY(); testY <= world.getTopY(); testY++) {
            BlockPos testPos = new BlockPos(x, testY, z);
            if (world.getBlockState(testPos).getBlock() == ModBlocks.LEAF_PEDESTAL) {
                if (world.getBlockState(testPos) == ModBlocks.LEAF_PEDESTAL.getDefaultState().with(LeafPedestalBlock.ACTIVATED, false)) {
                    world.setBlockState(testPos, ModBlocks.LEAF_PEDESTAL.getDefaultState().with(LeafPedestalBlock.ACTIVATED, true));
                }
                return testY;
            }
        }
        int yPos = world.getTopPosition(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, new BlockPos(x, y, z)).getY();
        return yPos < world.getBottomY() + 2 ? y : yPos;
    }


    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        if (world.getBlockState(pos.down()) == ModBlocks.LEAF_PEDESTAL.getDefaultState().with(LeafPedestalBlock.ACTIVATED, true)) {
            world.setBlockState(pos.down(), ModBlocks.LEAF_PEDESTAL.getDefaultState(), 0);
            world.updateNeighbors(pos, ModBlocks.LEAF_PEDESTAL);
        }
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (world.getBlockState(pos.down()) == ModBlocks.LEAF_PEDESTAL.getDefaultState().with(LeafPedestalBlock.ACTIVATED, true)) {
            world.setBlockState(pos.down(), ModBlocks.LEAF_PEDESTAL.getDefaultState(), 0);
            world.updateNeighbors(pos, ModBlocks.LEAF_PEDESTAL);
        }
        return super.onBreak(world, pos, state, player);
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return ItemStack.EMPTY;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        switch(rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch(state.get(AXIS)) {
                    case Z:
                        return state.with(AXIS, Direction.Axis.X);
                    case X:
                        return state.with(AXIS, Direction.Axis.Z);
                    default:
                        return state;
                }
            default:
                return state;
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }
}
