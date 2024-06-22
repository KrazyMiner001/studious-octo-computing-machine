package tech.krazyminer001.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LeafPicker extends Item {
    public LeafPicker() {
        super(new Settings().maxDamage(750));
    }

    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && !state.isIn(BlockTags.FIRE)) {
            stack.damage(1, miner, EquipmentSlot.MAINHAND);
        }

        return state.isIn(BlockTags.LEAVES) || super.postMine(stack, world, state, pos, miner);
    }

    public boolean isSuitableFor(BlockState state) {
        return state.isIn(BlockTags.LEAVES);
    }

    public float getMiningSpeed(ItemStack stack, BlockState state) {
        if (!state.isIn(BlockTags.LEAVES)) {
            return super.getMiningSpeed(stack, state);
        }
        return 15.0F;
    }
}
