package com.goggaguys.blockentity.custom;

import com.goggaguys.OctoComputing;
import com.goggaguys.blockentity.ImplementedInventory;
import com.goggaguys.blockentity.ModBlockEntities;
import com.goggaguys.networking.ModS2CPacketSender;
import com.goggaguys.networking.ModS2CPackets;
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
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class LeafShrineBlockEntity extends BlockEntity implements ImplementedInventory {
    private int craftingTime = 0;
    private RecipeEntry<LeafShrineRecipe> currentRecipe;
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

        this.craftingTime = nbt.getShort("CraftingTime");

        if (nbt.contains("CurrentRecipe")) {
            String recipeString = nbt.getString("CurrentRecipe");
            if (!recipeString.isEmpty() && OctoComputing.SERVER != null) {
                Optional<RecipeEntry<?>> optionalRecipe = OctoComputing.SERVER.getRecipeManager().get(new Identifier(recipeString));
                if (optionalRecipe.isPresent()) {
                    if (optionalRecipe.get().value() instanceof LeafShrineRecipe recipe) {
                        this.currentRecipe = new RecipeEntry<>(new Identifier(recipeString), recipe);
                    };
                }
            }
        }
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putShort("CraftingTime", (short) this.craftingTime);
        assert world != null;
        if (currentRecipe != null) {
            nbt.putString("CurrentRecipe", currentRecipe.id().toString());
        }
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
        world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
        super.markDirty();
    }

    public boolean craftItem() {
        if (currentRecipe != null) {
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
        Optional<RecipeEntry<LeafShrineRecipe>> match = world.getRecipeManager().getFirstMatch(LeafShrineRecipe.Type.INSTANCE, inventory, world);

        if (match.isPresent()) {
            currentRecipe = match.get();
            craftingTime = 0;
            markDirty();
            return true;
        }
        return false;
    }

    public static void serverTick(@NotNull World world, BlockPos pos, BlockState blockState, LeafShrineBlockEntity leafShrineBlockEntity) {
        if (leafShrineBlockEntity.currentRecipe == null) {
            return;
        }
        if (leafShrineBlockEntity.craftingTime < leafShrineBlockEntity.currentRecipe.value().getCraftingTime()) {
            leafShrineBlockEntity.craftingTime++;
            ModS2CPacketSender.sendLeafShrineCraftingInProgressParticlePacket(world, pos);

            BlockEntity northPlinth = world.getBlockEntity(pos.north(2));
            if (!(northPlinth instanceof LeafPlinthBlockEntity northPlinthBlockEntity)) {
                leafShrineBlockEntity.craftingTime = 0;
                leafShrineBlockEntity.currentRecipe = null;
                return;
            }
            BlockEntity eastPlinth = world.getBlockEntity(pos.east(2));
            if (!(eastPlinth instanceof LeafPlinthBlockEntity eastPlinthBlockEntity)) {
                leafShrineBlockEntity.craftingTime = 0;
                leafShrineBlockEntity.currentRecipe = null;
                return;
            }
            BlockEntity southPlinth = world.getBlockEntity(pos.south(2));
            if (!(southPlinth instanceof LeafPlinthBlockEntity southPlinthBlockEntity)) {
                leafShrineBlockEntity.craftingTime = 0;
                leafShrineBlockEntity.currentRecipe = null;
                return;
            }
            BlockEntity westPlinth = world.getBlockEntity(pos.west(2));
            if (!(westPlinth instanceof LeafPlinthBlockEntity westPlinthBlockEntity)) {
                leafShrineBlockEntity.craftingTime = 0;
                leafShrineBlockEntity.currentRecipe = null;
                return;
            }

            if (leafShrineBlockEntity.craftingTime == leafShrineBlockEntity.currentRecipe.value().getCraftingTime() && leafShrineBlockEntity.currentRecipe != null) {
                ItemStack result = leafShrineBlockEntity.currentRecipe.value().getResult(null).copy();
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

                leafShrineBlockEntity.currentRecipe = null;
                ModS2CPacketSender.sendLeafShrineCraftingFinishedParticlePacket(world, pos);

            }
            leafShrineBlockEntity.markDirty();
        }
    }

    public static void clientTick(@NotNull World world, BlockPos blockPos, BlockState blockState, LeafShrineBlockEntity leafShrineBlockEntity) {
        LeafShrineBlockEntity blockEntity = (LeafShrineBlockEntity) world.getBlockEntity(blockPos);
        if (blockEntity != null) {
            int craftingTime = blockEntity.craftingTime;
            if (blockEntity.currentRecipe != null) {
                if (craftingTime < blockEntity.currentRecipe.value().getCraftingTime()){
                    blockEntity.spawnCraftingProgressParticles();

                    if (craftingTime == blockEntity.currentRecipe.value().getCraftingTime()) {
                        blockEntity.spawnFinishedCraftingParticles();
                    }
                }
            }
        }
    }

    public void spawnCraftingProgressParticles() {
        BlockPos blockPos = this.getPos();

        if (currentRecipe != null && world != null) {
            int initialCraftingTime = this.currentRecipe.value().getCraftingTime();
            double craftingProgress = (double) this.craftingTime / initialCraftingTime;

            world.addParticle(ParticleTypes.HAPPY_VILLAGER, blockPos.getX() + 0.5 + Direction.NORTH.getOffsetX()*2*(1-craftingProgress), blockPos.getY() + 1, blockPos.getZ() + 0.5 + Direction.NORTH.getOffsetZ()*2*(1-craftingProgress), 0, 0, 0);
            world.addParticle(ParticleTypes.HAPPY_VILLAGER, blockPos.getX() + 0.5 + Direction.EAST.getOffsetX()*2*(1-craftingProgress), blockPos.getY() + 1, blockPos.getZ() + 0.5 + Direction.EAST.getOffsetZ()*2*(1-craftingProgress), -0, 0, 0);
            world.addParticle(ParticleTypes.HAPPY_VILLAGER, blockPos.getX() + 0.5 + Direction.SOUTH.getOffsetX()*2*(1-craftingProgress), blockPos.getY() + 1, blockPos.getZ() + 0.5 + Direction.SOUTH.getOffsetZ()*2*(1-craftingProgress), 0, 0, 0);
            world.addParticle(ParticleTypes.HAPPY_VILLAGER, blockPos.getX() + 0.5 + Direction.WEST.getOffsetX()*2*(1-craftingProgress), blockPos.getY() + 1, blockPos.getZ() + 0.5 + Direction.WEST.getOffsetZ()*2*(1-craftingProgress), -0, 0, 0);
        }
    }

    public void spawnFinishedCraftingParticles() {
        BlockPos blockPos = this.getPos();
        if (world != null) {
            world.addParticle(ParticleTypes.EXPLOSION, blockPos.getX() + 0.5, blockPos.getY() + 1.5, blockPos.getZ() + 0.5, 0, 0, 0);
        }
    }
}
