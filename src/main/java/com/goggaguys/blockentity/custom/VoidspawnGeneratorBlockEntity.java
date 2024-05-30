package com.goggaguys.blockentity.custom;

import com.goggaguys.OctoComputing;
import com.goggaguys.blockentity.ImplementedInventory;
import com.goggaguys.blockentity.ModBlockEntities;
import com.goggaguys.blockentity.screen.screenhandlers.VoidspawnGeneratorScreenHandler;
import com.goggaguys.recipe.LeafShrineRecipe;
import com.goggaguys.recipe.VoidspawnGeneratorRecipe;
import com.klikli_dev.modonomicon.api.ModonomiconAPI;
import com.klikli_dev.modonomicon.api.multiblock.Multiblock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

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
    private RecipeEntry<VoidspawnGeneratorRecipe> currentRecipe;
    private int craftingTime = 0;


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
        nbt.putShort("CraftingTime", (short) this.craftingTime);
        assert world != null;
        if (currentRecipe != null) {
            nbt.putString("CurrentRecipe", currentRecipe.id().toString());
        }
        this.craftingTime = nbt.getShort("CraftingTime");

        if (nbt.contains("CurrentRecipe")) {
            String recipeString = nbt.getString("CurrentRecipe");
            if (!recipeString.isEmpty() && OctoComputing.SERVER != null) {
                Optional<RecipeEntry<?>> optionalRecipe = OctoComputing.SERVER.getRecipeManager().get(new Identifier(recipeString));
                if (optionalRecipe.isPresent()) {
                    if (optionalRecipe.get().value() instanceof VoidspawnGeneratorRecipe recipe) {
                        this.currentRecipe = new RecipeEntry<>(new Identifier(recipeString), recipe);
                    };
                }
            }
        }
    }

    public static void serverTick(@NotNull World world, BlockPos pos, BlockState blockState, VoidspawnGeneratorBlockEntity voidspawnGeneratorBlockEntity) {
        Multiblock multiblock = ModonomiconAPI.get().getMultiblock(new Identifier(OctoComputing.MOD_ID, "voidspawn_generator"));
        BlockRotation rotation = multiblock.validate(world, pos);
        if (rotation == null) {
            return;
        }
        if (voidspawnGeneratorBlockEntity.currentRecipe == null) {
            var optionalRecipeEntry = world.getRecipeManager().getFirstMatch(VoidspawnGeneratorRecipe.Type.INSTANCE, voidspawnGeneratorBlockEntity, world);
            if (optionalRecipeEntry.isPresent()
                            && optionalRecipeEntry.get().value().matches(voidspawnGeneratorBlockEntity, world)
                            && (voidspawnGeneratorBlockEntity.inventory.get(2).isEmpty()
                                || (voidspawnGeneratorBlockEntity.inventory.get(2).getItem() == optionalRecipeEntry.get().value().getOutput().getItem()
                                && voidspawnGeneratorBlockEntity.inventory.get(2).getCount() <= voidspawnGeneratorBlockEntity.inventory.get(2).getMaxCount() - optionalRecipeEntry.get().value().getOutput().getCount()))) {
                voidspawnGeneratorBlockEntity.currentRecipe = optionalRecipeEntry.get();
            } else {
                return;
            };
        }
        voidspawnGeneratorBlockEntity.craftingTime++;
        if (voidspawnGeneratorBlockEntity.craftingTime >= voidspawnGeneratorBlockEntity.currentRecipe.value().getCraftingTime()) {
            voidspawnGeneratorBlockEntity.craftingTime = 0;
            voidspawnGeneratorBlockEntity.setStack(2, voidspawnGeneratorBlockEntity.currentRecipe.value().getResult(world.getRegistryManager()).copyWithCount(voidspawnGeneratorBlockEntity.inventory.get(2).getCount() + voidspawnGeneratorBlockEntity.currentRecipe.value().getOutput().getCount()));
            voidspawnGeneratorBlockEntity.removeStack(1, 1);
            voidspawnGeneratorBlockEntity.currentRecipe = null;
        }
    }

    public static void clientTick(@NotNull World world, BlockPos pos, BlockState blockState, VoidspawnGeneratorBlockEntity voidspawnGeneratorBlockEntity) {

    }

    }
