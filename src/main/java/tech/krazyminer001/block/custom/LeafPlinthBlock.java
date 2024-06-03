package tech.krazyminer001.block.custom;

import tech.krazyminer001.blockentity.custom.LeafPlinthBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LeafPlinthBlock extends BlockWithEntity {
    private static final MapCodec<LeafPlinthBlock> CODEC = createCodec(LeafPlinthBlock::new);
    private static final VoxelShape PLINTH_SHAPE;

    public LeafPlinthBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LeafPlinthBlockEntity(pos, state);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;
        LeafPlinthBlockEntity blockEntity = (LeafPlinthBlockEntity) world.getBlockEntity(pos);

        assert blockEntity != null;
        if (!player.isSneaking()) {
            if (!player.getMainHandStack().isEmpty()) {
                if (((Inventory) blockEntity).getStack(0).isEmpty()) {
                    ((Inventory) blockEntity).setStack(0, player.getMainHandStack().copy());
                    player.getMainHandStack().setCount(0);
                    blockEntity.markDirty();
                    return ActionResult.SUCCESS;
                }
            } else {
                if (!((Inventory) blockEntity).getStack(0).isEmpty()) {
                    player.giveItemStack(((Inventory) blockEntity).getStack(0));
                    ((Inventory) blockEntity).removeStack(0);
                    blockEntity.markDirty();
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.PASS;

    }
    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        ItemScatterer.onStateReplaced(state, newState, world, pos);
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return PLINTH_SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return PLINTH_SHAPE;
    }

    static {
        PLINTH_SHAPE = VoxelShapes.union(
                VoxelShapes.cuboid(6d / 16, 0, 6d / 16, 10d / 16, 1d / 16, 10d / 16),
                VoxelShapes.cuboid(7.5 / 16, 1d / 16, 7.5 / 16, 8.5 / 16, 12d / 16, 8.5 / 16),
                VoxelShapes.cuboid(6.5 / 16, 12d / 16, 6.5 / 16, 9.5 / 16, 13d / 16, 9.5 / 16)
        );
    }
}
