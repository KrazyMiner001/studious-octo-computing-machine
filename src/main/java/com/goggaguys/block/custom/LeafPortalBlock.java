package com.goggaguys.block.custom;

import com.goggaguys.entity.ModEntities;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class LeafPortalBlock extends Block {
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
        super.onEntityCollision(state, world, pos, entity); //todo
    }
}
