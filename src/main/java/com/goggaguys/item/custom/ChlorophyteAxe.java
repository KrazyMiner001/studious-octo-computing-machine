package com.goggaguys.item.custom;

import com.goggaguys.OctoComputing;
import com.goggaguys.item.ModToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChlorophyteAxe extends AxeItem implements ActivatableItem {
    public ChlorophyteAxe() {
        super(ModToolMaterial.CHLOROPHYTE, 7, -2.0f, new FabricItemSettings());
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (miner instanceof PlayerEntity playerEntity && ActivatableItem.isActivated(stack)) {
            Set<BlockPos> treeBlocks = getTreeBlocks(world, state.getBlock(), pos, new HashSet<>());

            for (BlockPos treeBlock : treeBlocks) {
                if (!playerEntity.isCreative()) {
                    world.breakBlock(treeBlock, true, playerEntity);
                }
            }
        }

        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (hand == Hand.MAIN_HAND && user.isSneaking()) {
            boolean isActivated = ActivatableItem.isActivated(stack);
            ActivatableItem.setActivated(stack, !isActivated);

            return TypedActionResult.success(stack);
        }
        return TypedActionResult.pass(stack);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(1, Text.translatable("item.octocomputing.chlorophyte.toggleable_ability"));
        if (ActivatableItem.isActivated(stack)) {
            tooltip.add(2, Text.translatable("item.octocomputing.chlorophyte.chlorophyte_axe.treecapitator_ability.enabled").formatted(Formatting.GRAY));
        } else {
            tooltip.add(2, Text.translatable("item.octocomputing.chlorophyte.chlorophyte_axe.treecapitator_ability.disabled").formatted(Formatting.GRAY));
        }
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
