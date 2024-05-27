package com.goggaguys.blockentity.custom;

import com.goggaguys.blockentity.ImplementedInventory;
import com.goggaguys.blockentity.ModBlockEntities;
import com.goggaguys.recipe.LeafShrineRecipe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Function;

public class LeafShrineBlockEntity extends BlockEntity implements ImplementedInventory {
    private int craftingTime = 0;
    private LeafShrineRecipe currentRecipe;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public LeafShrineBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LEAF_SHRINE_BLOCK_ENTITY, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public ItemStack getStack(int slot) {
        if (slot != 0) {
            return ItemStack.EMPTY;
        }
        return inventory.get(slot);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        NbtList nbtList = nbt.getList("Items", 10);
        NbtCompound nbtCompound = nbtList.getCompound(0);
        inventory.set(0, ItemStack.fromNbtOrEmpty(registryLookup, nbtCompound));
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.writeNbt(nbt, inventory, registryLookup);
        super.writeNbt(nbt, registryLookup);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    @Override
    public void markDirty() {
        assert world != null;
        world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_LISTENERS);
        super.markDirty();
    }

    public boolean craftItem() {
        if (craftingTime != 0) {
            return false;
        }
        LeafShrineBlockEntity blockEntity = this;
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
            currentRecipe = match.get();
            craftingTime = match.get().getCraftingTime();
            return true;
        }
        return false;
    }

    public static void serverTick(@NotNull World world, BlockPos pos, BlockState blockState, LeafShrineBlockEntity leafShrineBlockEntity) {
        if (leafShrineBlockEntity.craftingTime > 0) {
            leafShrineBlockEntity.craftingTime--;

            BlockEntity northPlinth = world.getBlockEntity(pos.north(2));
            if (!(northPlinth instanceof LeafPlinthBlockEntity northPlinthBlockEntity)) {
                leafShrineBlockEntity.craftingTime = 0;
                return;
            }
            BlockEntity eastPlinth = world.getBlockEntity(pos.east(2));
            if (!(eastPlinth instanceof LeafPlinthBlockEntity eastPlinthBlockEntity)) {
                leafShrineBlockEntity.craftingTime = 0;
                return;
            }
            BlockEntity southPlinth = world.getBlockEntity(pos.south(2));
            if (!(southPlinth instanceof LeafPlinthBlockEntity southPlinthBlockEntity)) {
                leafShrineBlockEntity.craftingTime = 0;
                return;
            }
            BlockEntity westPlinth = world.getBlockEntity(pos.west(2));
            if (!(westPlinth instanceof LeafPlinthBlockEntity westPlinthBlockEntity)) {
                leafShrineBlockEntity.craftingTime = 0;
                return;
            }

            if (leafShrineBlockEntity.craftingTime == 0) {
                ItemStack result = leafShrineBlockEntity.currentRecipe.getResult(null).copy();
                world.spawnEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5, result));
                for (int i = 0; i < 5; i++) {
                    switch (i) {
                        case 0 -> leafShrineBlockEntity.removeStack(0, 1);
                        case 1 -> northPlinthBlockEntity.removeStack(0, 1);
                        case 2 -> eastPlinthBlockEntity.removeStack(0, 1);
                        case 3 -> southPlinthBlockEntity.removeStack(0, 1);
                        case 4 -> westPlinthBlockEntity.removeStack(0, 1);
                    }
                }

                leafShrineBlockEntity.markDirty();
            }
        }
    }

    public static void clientTick(@NotNull World world, BlockPos blockPos, BlockState blockState, LeafShrineBlockEntity leafShrineBlockEntity) {

    }


}
