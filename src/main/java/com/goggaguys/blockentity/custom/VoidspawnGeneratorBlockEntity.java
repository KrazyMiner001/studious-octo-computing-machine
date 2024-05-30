package com.goggaguys.blockentity.custom;

import com.goggaguys.blockentity.ImplementedInventory;
import com.goggaguys.blockentity.ModBlockEntities;
import com.goggaguys.blockentity.screen.screenhandlers.VoidspawnGeneratorScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class VoidspawnGeneratorBlockEntity extends BlockEntity implements ImplementedInventory, NamedScreenHandlerFactory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    private final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        @Override
        public int get(int index) {
            return 0;
        }

        @Override
        public void set(int index, int value) {
        }

        @Override
        public int size() {
            return 0;
        }
    };


    public VoidspawnGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.VOIDSPAWN_GENERATOR_BLOCK_ENTITY, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new VoidspawnGeneratorScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapperLookup) {
        super.readNbt(nbt, wrapperLookup);
        Inventories.readNbt(nbt, this.inventory, wrapperLookup);
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapperLookup) {
        super.writeNbt(nbt, wrapperLookup);
        Inventories.writeNbt(nbt, this.inventory, wrapperLookup);
    }
}
