package com.goggaguys.recipe;

import com.goggaguys.blockentity.ImplementedInventory;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

import java.util.Optional;
import java.util.stream.Stream;

public class LeafShrineRecipe implements Recipe<ImplementedInventory> {
    final Ingredient inputCenter;
    final Ingredient inputNorth;
    final Ingredient inputEast;
    final Ingredient inputSouth;
    final Ingredient inputWest;
    final ItemStack output;
    final int craftingTime;
    final CraftingRecipeCategory category;

    public LeafShrineRecipe(Ingredient inputCenter, Ingredient inputNorth, Ingredient inputEast, Ingredient inputSouth, Ingredient inputWest, ItemStack output, int craftingTime, CraftingRecipeCategory category) {
        this.inputCenter = inputCenter;
        this.inputNorth = inputNorth;
        this.inputEast = inputEast;
        this.inputSouth = inputSouth;
        this.inputWest = inputWest;
        this.output = output;
        this.craftingTime = craftingTime;
        this.category = category;
    }

    public LeafShrineRecipe(CraftingRecipeCategory category, DefaultedList<Ingredient> inputs, Item output, int outputCount, int craftingTime) {
        this.category = category;
        this.inputCenter = inputs.get(0);
        this.inputNorth = inputs.get(1);
        this.inputEast = inputs.get(2);
        this.inputSouth = inputs.get(3);
        this.inputWest = inputs.get(4);
        this.output = new ItemStack(output, outputCount);
        this.craftingTime = craftingTime;
    }

    public Ingredient getInputCenter() {
        return inputCenter;
    }

    public Ingredient getInputNorth() {
        return inputNorth;
    }

    public Ingredient getInputEast() {
        return inputEast;
    }

    public Ingredient getInputSouth() {
        return inputSouth;
    }

    public Ingredient getInputWest() {
        return inputWest;
    }

    public int getCraftingTime() {
        return craftingTime;
    }

    @Override
    public boolean matches(ImplementedInventory inventory, World world) {
        if (inventory.size() < 5)
            return false;
        return inputCenter.test(inventory.getStack(0)) && inputNorth.test(inventory.getStack(1)) && inputEast.test(inventory.getStack(2)) && inputSouth.test(inventory.getStack(3)) && inputWest.test(inventory.getStack(4));
    }

    @Override
    public ItemStack craft(ImplementedInventory inventory, RegistryWrapper.WrapperLookup lookup) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    public static class Serializer implements RecipeSerializer<LeafShrineRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "leaf_shrine_recipe";

        public Serializer() {}

        MapCodec<LeafShrineRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("inputCenter").forGetter(LeafShrineRecipe::getInputCenter),
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("inputNorth").forGetter(LeafShrineRecipe::getInputNorth),
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("inputEast").forGetter(LeafShrineRecipe::getInputEast),
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("inputSouth").forGetter(LeafShrineRecipe::getInputSouth),
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("inputWest").forGetter(LeafShrineRecipe::getInputWest),
                ItemStack.ITEM_CODEC.fieldOf("output").forGetter(recipe -> recipe.output.getRegistryEntry()),
                Codec.INT.optionalFieldOf("outputAmount", 1).forGetter(recipe -> recipe.output.getCount()),
                Codec.INT.optionalFieldOf("craftingTime", 20).forGetter(LeafShrineRecipe::getCraftingTime),
                CraftingRecipeCategory.CODEC.fieldOf("category").orElse(CraftingRecipeCategory.MISC).forGetter(LeafShrineRecipe::getCategory)
        ).apply(instance, (inputCenter, inputNorth, inputEast, inputSouth, inputWest, output, outputAmount, craftingTime, category) -> new LeafShrineRecipe(inputCenter, inputNorth, inputEast, inputSouth, inputWest, new ItemStack(output, outputAmount), craftingTime, category)));

        @Override
        public MapCodec<LeafShrineRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, LeafShrineRecipe> packetCodec() {
            return PacketCodec.ofStatic(this::write, this::read);
        }

        public LeafShrineRecipe read(RegistryByteBuf buf) {
            Ingredient inputCenter = Ingredient.PACKET_CODEC.decode(buf);
            Ingredient inputNorth = Ingredient.PACKET_CODEC.decode(buf);
            Ingredient inputEast = Ingredient.PACKET_CODEC.decode(buf);
            Ingredient inputSouth = Ingredient.PACKET_CODEC.decode(buf);
            Ingredient inputWest = Ingredient.PACKET_CODEC.decode(buf);

            ItemStack output = ItemStack.PACKET_CODEC.decode(buf);
            int outputAmount = buf.readInt();
            int craftingTime = buf.readInt();

            CraftingRecipeCategory category = buf.readEnumConstant(CraftingRecipeCategory.class);

            return new LeafShrineRecipe(inputCenter, inputNorth, inputEast, inputSouth, inputWest, new ItemStack(output.getRegistryEntry(), outputAmount), craftingTime, category);
        }

        public void write(RegistryByteBuf buf, LeafShrineRecipe recipe) {
            Ingredient.PACKET_CODEC.encode(buf, recipe.inputCenter);
            Ingredient.PACKET_CODEC.encode(buf, recipe.inputNorth);
            Ingredient.PACKET_CODEC.encode(buf, recipe.inputEast);
            Ingredient.PACKET_CODEC.encode(buf, recipe.inputSouth);
            Ingredient.PACKET_CODEC.encode(buf, recipe.inputWest);

            ItemStack.PACKET_CODEC.encode(buf, recipe.output);
            buf.writeInt(recipe.output.getCount());
            buf.writeInt(recipe.craftingTime);

            buf.writeEnumConstant(recipe.getCategory());
        }
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    public static class Type implements RecipeType<LeafShrineRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();

        public static final String ID = "leaf_shrine_recipe";
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public CraftingRecipeCategory getCategory() {
        return category;
    }
}
