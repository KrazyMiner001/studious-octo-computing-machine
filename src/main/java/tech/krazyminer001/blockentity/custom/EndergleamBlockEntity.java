package tech.krazyminer001.blockentity.custom;

import tech.krazyminer001.blockentity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class EndergleamBlockEntity extends BlockEntity {
    public EndergleamBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ENDERGLEAM_BLOCK_ENTITY, pos, state);
    }


    public boolean shouldDrawSide(Direction side) {
        return true;
    }
}
