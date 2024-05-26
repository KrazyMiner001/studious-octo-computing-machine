package com.goggaguys.block.custom;

import com.goggaguys.blockentity.ImplementedInventory;
import com.goggaguys.blockentity.custom.LeafPlinthBlockEntity;
import com.goggaguys.blockentity.custom.LeafShrineBlockEntity;
import com.goggaguys.recipe.LeafShrineRecipe;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

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

    private static boolean craftItem(LeafShrineBlockEntity blockEntity) {
        BlockPos pos = blockEntity.getPos();
        World world = blockEntity.getWorld();

        DefaultedList<ItemStack> items = DefaultedList.ofSize(5, blockEntity.getStack(0));
        assert world != null;
        BlockEntity northPlinth = world.getBlockEntity(pos.north(2));
        if (northPlinth instanceof LeafPlinthBlockEntity northPlinthBlockEntity) {
            if (northPlinthBlockEntity.getStack(0).isEmpty()) {
                items.set(1, Items.AIR.getDefaultStack());
            }
            items.set(1, northPlinthBlockEntity.getStack(0));
        } else {
            return false;
        }
        BlockEntity eastPlinth = world.getBlockEntity(pos.east(2));
        if (eastPlinth instanceof LeafPlinthBlockEntity eastPlinthBlockEntity) {
            if (eastPlinthBlockEntity.getStack(0).isEmpty()) {
                items.set(2, Items.AIR.getDefaultStack());
            }
            items.set(2, eastPlinthBlockEntity.getStack(0));
        } else {
            return false;
        }
        BlockEntity southPlinth = world.getBlockEntity(pos.south(2));
        if (southPlinth instanceof LeafPlinthBlockEntity southPlinthBlockEntity) {
            if (southPlinthBlockEntity.getStack(0).isEmpty()) {
                items.set(3, Items.AIR.getDefaultStack());
            }
            items.set(3, southPlinthBlockEntity.getStack(0));
        } else {
            return false;
        }
        BlockEntity westPlinth = world.getBlockEntity(pos.west(2));
        if (westPlinth instanceof LeafPlinthBlockEntity westPlinthBlockEntity) {
            if (westPlinthBlockEntity.getStack(0).isEmpty()) {
                items.set(4, Items.AIR.getDefaultStack());
            }
            items.set(4, westPlinthBlockEntity.getStack(0));
        } else {
            return false;
        }
        ImplementedInventory inventory = ImplementedInventory.of(items);
        Optional<LeafShrineRecipe> match = world.getRecipeManager().getFirstMatch(LeafShrineRecipe.Type.INSTANCE, inventory, world).map(RecipeEntry::value);

        if (match.isPresent()) {
            ItemStack result = match.get().getResult(null).copy();
            world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5, 0, 0, 0);

            world.spawnEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5, result));
            for (int i = 0; i < 5; i++) {
                switch (i) {
                    case 0 -> blockEntity.removeStack(0, 1);
                    case 1 -> northPlinthBlockEntity.removeStack(0, 1);
                    case 2 -> eastPlinthBlockEntity.removeStack(0, 1);
                    case 3 -> southPlinthBlockEntity.removeStack(0, 1);
                    case 4 -> westPlinthBlockEntity.removeStack(0, 1);
                }
            }

            blockEntity.markDirty();
            return true;
        }
        return false;
    }

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
                boolean atLeastOneCraft = false;
                boolean successfulCraft;
                do {
                    successfulCraft = craftItem(blockEntity);
                    atLeastOneCraft = atLeastOneCraft || successfulCraft;
                } while (successfulCraft);
                if (atLeastOneCraft) {
                    return ActionResult.SUCCESS;
                }
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
}
