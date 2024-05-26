package com.goggaguys.recipe;

import com.goggaguys.blockentity.ImplementedInventory;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;

public class LeafShrineRecipe implements Recipe<ImplementedInventory> {
    final Ingredient inputCenter;
    final Ingredient inputNorth;
    final Ingredient inputEast;
    final Ingredient inputSouth;
    final Ingredient inputWest;
    final ItemStack output;
    final Identifier id;
    final CraftingRecipeCategory category;

    public LeafShrineRecipe(Ingredient inputCenter, Ingredient inputNorth, Ingredient inputWestast, Ingredient inputSouth, Ingredient inputWest, ItemStack output, Identifier id, CraftingRecipeCategory category) {
        this.inputCenter = inputCenter;
        this.inputNorth = inputNorth;
        this.inputEast = inputWestast;
        this.inputSouth = inputSouth;
        this.inputWest = inputWest;
        this.output = output;
        this.id = id;
        this.category = category;
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

    public Identifier getId() {
        return id;
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
                Identifier.CODEC.fieldOf("id").forGetter(recipe -> recipe.id),
                ItemStack.ITEM_CODEC.fieldOf("output").forGetter(recipe -> recipe.output.getRegistryEntry()),
                Codec.INT.optionalFieldOf("outputAmount", 1).forGetter(recipe -> recipe.output.getCount()),
                CraftingRecipeCategory.CODEC.fieldOf("category").orElse(CraftingRecipeCategory.MISC).forGetter(LeafShrineRecipe::getCategory)
        ).apply(instance, (inputCenter, inputNorth, inputEast, inputSouth, inputWest, id, output, outputAmount, category) -> new LeafShrineRecipe(inputCenter, inputNorth, inputEast, inputSouth, inputWest, new ItemStack(output, outputAmount), id, category)));

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

            Identifier id = buf.readIdentifier();

            ItemStack output = ItemStack.PACKET_CODEC.decode(buf);
            int outputAmount = buf.readInt();

            CraftingRecipeCategory category = buf.readEnumConstant(CraftingRecipeCategory.class);

            return new LeafShrineRecipe(inputCenter, inputNorth, inputEast, inputSouth, inputWest, new ItemStack(output.getRegistryEntry(), outputAmount), id, category);
        }

        public void write(RegistryByteBuf buf, LeafShrineRecipe recipe) {
            Ingredient.PACKET_CODEC.encode(buf, recipe.inputCenter);
            Ingredient.PACKET_CODEC.encode(buf, recipe.inputNorth);
            Ingredient.PACKET_CODEC.encode(buf, recipe.inputEast);
            Ingredient.PACKET_CODEC.encode(buf, recipe.inputSouth);
            Ingredient.PACKET_CODEC.encode(buf, recipe.inputWest);

            buf.writeIdentifier(recipe.id);

            ItemStack.PACKET_CODEC.encode(buf, recipe.output);
            buf.writeInt(recipe.output.getCount());

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
