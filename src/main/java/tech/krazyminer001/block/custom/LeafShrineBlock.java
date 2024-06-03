package tech.krazyminer001.block.custom;

import tech.krazyminer001.blockentity.ModBlockEntities;
import tech.krazyminer001.blockentity.custom.LeafShrineBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
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

public class LeafShrineBlock extends BlockWithEntity {
    public static final MapCodec<LeafShrineBlock> CODEC = createCodec(LeafShrineBlock::new);
    public LeafShrineBlock(Settings settings) {
        super(settings);
    }
    private static final VoxelShape SHRINE_SHAPE = VoxelShapes.union(
            VoxelShapes.cuboid(1d / 16, 0, 1d / 16, 15d / 16, 3d / 16, 15d / 16),
            VoxelShapes.cuboid(4d / 16, 3d / 16, 4d / 16, 12d / 16, 9d / 16, 12d / 16),
            VoxelShapes.cuboid(2d / 16, 9d / 16, 2d / 16, 14d / 16, 12d / 16, 14d / 16)
    );

    @Override
    public MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LeafShrineBlockEntity(pos, state);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;
        LeafShrineBlockEntity blockEntity = (LeafShrineBlockEntity) world.getBlockEntity(pos);

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
        } else {
            if (!((Inventory) blockEntity).getStack(0).isEmpty()) {
                return blockEntity.craftItem() ? ActionResult.SUCCESS : ActionResult.PASS;
            }
        }
        return ActionResult.PASS;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        ItemScatterer.onStateReplaced(state, newState, world, pos);
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHRINE_SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHRINE_SHAPE;
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> validateTicker(World world, BlockEntityType<T> givenType, BlockEntityType<? extends AbstractFurnaceBlockEntity> expectedType) {
        return world.isClient ? null : validateTicker(givenType, expectedType, AbstractFurnaceBlockEntity::tick);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (world.isClient) {
            return validateTicker(type, ModBlockEntities.LEAF_SHRINE_BLOCK_ENTITY, LeafShrineBlockEntity::clientTick);
        } else {
            return validateTicker(type, ModBlockEntities.LEAF_SHRINE_BLOCK_ENTITY, LeafShrineBlockEntity::serverTick);
        }
    }
}
