package com.goggaguys.item.custom;

import com.goggaguys.item.ModToolMaterial;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.SharedConstants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.time.Duration;
import java.util.*;

import static java.util.Collections.emptySet;

public class ChlorophyteAxe extends AxeItem {
    public ChlorophyteAxe() {
        super(ModToolMaterial.CHLOROPHYTE, 7, -2.0f, new FabricItemSettings());
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (miner instanceof PlayerEntity playerEntity) {

            Set<BlockPos> treeBlocks = getTreeBlocks(world, state.getBlock(), pos, new HashSet<>());

            for (BlockPos treeBlock : treeBlocks) {
                if (!playerEntity.isCreative()) {
                    world.breakBlock(treeBlock, true);
                }
            }
        }

        return super.postMine(stack, world, state, pos, miner);
    }

    private Set<BlockPos> getTreeBlocks (World world, Block blockType , BlockPos pos, Set<BlockPos> ignoredBlocks) {
        if (!blockType.getDefaultState().isIn(BlockTags.LOGS)) {
            return new HashSet<>();
        }
        Set<BlockPos> treeBlocks = new HashSet<>();
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        for (int x = posX - 1; x <= posX + 1; x++) {
            for (int y = posY - 1; y <= posY + 1; y++) {
                for (int z = posZ - 1; z <= posZ + 1; z++) {

                    BlockPos testPos = new BlockPos(x, y, z);
                    if (!ignoredBlocks.contains(testPos)) {
                        Set<BlockPos> checkedBlocks = new HashSet<>(treeBlocks);
                        checkedBlocks.addAll(ignoredBlocks);
                        checkedBlocks.add(testPos);
                        if (world.getBlockState(testPos).getBlock() == blockType) {
                            treeBlocks.add(testPos);
                            treeBlocks.addAll(getTreeBlocks(world, blockType, testPos, checkedBlocks));
                        }
                    }
                }
            }
        }
        return treeBlocks;
    }
}
