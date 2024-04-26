package com.goggaguys.item.custom;

import com.goggaguys.item.ModToolMaterial;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ChlorophyteHoe extends HoeItem implements ActivatableItem {
    public ChlorophyteHoe() {
        super(ModToolMaterial.CHLOROPHYTE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterial.CHLOROPHYTE, 1, 0.5f)));
    }

    private static Set<BlockPos> getNearbyBlocks(World world, BlockPos pos) {
        Set<BlockPos> nearbyBlocks = new HashSet<>();
        if (!TILLING_ACTIONS.containsKey(world.getBlockState(pos).getBlock())) {
            return nearbyBlocks;
        }

        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        for (int x = posX - 1; x <= posX + 1; x++) {
            for (int z = posZ - 1; z <= posZ + 1; z++) {
                BlockPos testPos = new BlockPos(x, posY, z);
                if (TILLING_ACTIONS.containsKey(world.getBlockState(testPos).getBlock())) {
                    nearbyBlocks.add(testPos);
                }
            }
        }

        nearbyBlocks.remove(pos);
        return nearbyBlocks;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        BlockPos blockPos = context.getBlockPos();
        if (ActivatableItem.isActivated(context.getStack())) {
            Set<BlockPos> hoePos = getNearbyBlocks(context.getWorld(), blockPos);
            for (BlockPos pos : hoePos) {
                tillBlock(new ItemUsageContext(context.getWorld() ,context.getPlayer(), context.getHand(), context.getStack(), new BlockHitResult(context.getHitPos(), context.getSide(), pos, context.hitsInsideBlock())));
            }
        }

        return super.useOnBlock(context);
    }

    private void tillBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>> pair = TILLING_ACTIONS.get(world.getBlockState(blockPos).getBlock());
        if (pair != null)  {
            Predicate<ItemUsageContext> predicate = pair.getFirst();
            Consumer<ItemUsageContext> consumer = pair.getSecond();
            if (predicate.test(context)) {
                if (!world.isClient) {
                    consumer.accept(context);
                }
            }
        }
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
            tooltip.add(2, Text.translatable("item.octocomputing.chlorophyte.chlorophyte_hoe.3x3_ability.enabled").formatted(Formatting.GRAY));
        } else {
            tooltip.add(2, Text.translatable("item.octocomputing.chlorophyte.chlorophyte_hoe.3x3_ability.disabled").formatted(Formatting.GRAY));
        }
    }

}
