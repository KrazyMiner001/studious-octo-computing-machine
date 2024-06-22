package tech.krazyminer001.item.custom;

import net.minecraft.item.tooltip.TooltipType;
import tech.krazyminer001.item.ModToolMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ChlorophyteAxe extends AxeItem implements ActivatableItem {
    public ChlorophyteAxe() {
        super(ModToolMaterial.CHLOROPHYTE, new Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterial.CHLOROPHYTE, 7, -2.0f)));
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (miner instanceof PlayerEntity playerEntity && ActivatableItem.isActivated(stack)) {
            List<BlockPos> treeBlocks = getTreeBlocks(world, state.getBlock(), pos, new ArrayList<>());

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
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(1, Text.translatable("item.octocomputing.chlorophyte.toggleable_ability"));
        if (ActivatableItem.isActivated(stack)) {
            tooltip.add(2, Text.translatable("item.octocomputing.chlorophyte.chlorophyte_axe.treecapitator_ability.enabled").formatted(Formatting.GRAY));
        } else {
            tooltip.add(2, Text.translatable("item.octocomputing.chlorophyte.chlorophyte_axe.treecapitator_ability.disabled").formatted(Formatting.GRAY));
        }
    }

    private List<BlockPos> getTreeBlocks (World world, Block blockType , BlockPos pos, List<BlockPos> ignoredBlocks) {
        if (!blockType.getDefaultState().isIn(BlockTags.LOGS)) {
            return new ArrayList<>();
        }
        List<BlockPos> treeBlocks = new ArrayList<>();
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        for (int x = posX - 1; x <= posX + 1; x++) {
            for (int y = posY - 1; y <= posY + 1; y++) {
                for (int z = posZ - 1; z <= posZ + 1; z++) {

                    BlockPos testPos = new BlockPos(x, y, z);
                    if (!ignoredBlocks.contains(testPos)) {
                        List<BlockPos> checkedBlocks = new ArrayList<>(treeBlocks);
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
