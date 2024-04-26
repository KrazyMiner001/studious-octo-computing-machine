package com.goggaguys.item.custom;

import com.goggaguys.item.ModToolMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChlorophyteShovel extends ShovelItem implements ActivatableItem{
    public ChlorophyteShovel() {
        super(ModToolMaterial.CHLOROPHYTE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterial.CHLOROPHYTE, 1, -2.0f)));
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (miner instanceof PlayerEntity playerEntity && ActivatableItem.isActivated(stack)) {
            if (!playerEntity.isCreative()) {
                Set<BlockPos> breakBlockSet = getNearbyBlocks(world, state.getBlock(), pos, playerEntity);

                for (BlockPos block : breakBlockSet) {
                    world.breakBlock(block, true, playerEntity);
                }
            }
        }

        return super.postMine(stack, world, state, pos, miner);
    }

    private static Set<BlockPos> getNearbyBlocks(World world, Block blockType , BlockPos pos, PlayerEntity playerEntity) {
        Set<BlockPos> nearbyBlocks = new HashSet<>();

        if (!blockType.getDefaultState().isIn(BlockTags.SHOVEL_MINEABLE)) {
            return nearbyBlocks;
        }
        Direction playerDirection = Arrays.stream(Direction.getEntityFacingOrder(playerEntity)).findFirst().orElseThrow();

        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        for (int x = posX - 1; x <= posX + 1; x++) {
            for (int y = posY - 1; y <= posY + 1; y++) {
                for (int z = posZ - 1; z <= posZ + 1; z++) {
                    int testPosX = playerDirection.getAxis() == Direction.Axis.X ? posX : x;
                    int testPosY = playerDirection.getAxis() == Direction.Axis.Y ? posY : y;
                    int testPosZ = playerDirection.getAxis() == Direction.Axis.Z ? posZ : z;
                    BlockPos testPos = new BlockPos(testPosX, testPosY, testPosZ);
                    if (world.getBlockState(testPos).getBlock() == blockType || (blockType.getDefaultState().isIn(BlockTags.STONE_ORE_REPLACEABLES)) && world.getBlockState(testPos).isIn(BlockTags.STONE_ORE_REPLACEABLES) || (blockType.getDefaultState().isIn(BlockTags.DEEPSLATE_ORE_REPLACEABLES) && world.getBlockState(testPos).isIn(BlockTags.DEEPSLATE_ORE_REPLACEABLES))) {
                        nearbyBlocks.add(testPos);
                    }
                }
            }
        }

        return nearbyBlocks;
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
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(1, Text.translatable("item.octocomputing.chlorophyte.toggleable_ability"));
        if (ActivatableItem.isActivated(stack)) {
            tooltip.add(2, Text.translatable("item.octocomputing.chlorophyte.chlorophyte_shovel.3x3_ability.enabled").formatted(Formatting.GRAY));
        } else {
            tooltip.add(2, Text.translatable("item.octocomputing.chlorophyte.chlorophyte_shovel.3x3_ability.disabled").formatted(Formatting.GRAY));
        }
    }
}
