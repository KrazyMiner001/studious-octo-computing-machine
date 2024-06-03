package tech.krazyminer001.block.custom;

import tech.krazyminer001.blockentity.custom.EndergleamBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class EndergleamBlock extends BlockWithEntity {
    public static final MapCodec<EndergleamBlock> CODEC = createCodec(EndergleamBlock::new);
    public EndergleamBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new EndergleamBlockEntity(pos, state);
    }
}
