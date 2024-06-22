package tech.krazyminer001.recipe;

import tech.krazyminer001.blockentity.custom.VoidspawnGeneratorBlockEntity;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class VoidspawnGeneratorRecipe implements Recipe<VoidspawnGeneratorRecipeInput> {
    final Ingredient catalyst;
    final Ingredient fuel;
    final ItemStack output;
    final int craftingTime;
    final CraftingRecipeCategory category;

    public VoidspawnGeneratorRecipe(Ingredient catalyst, Ingredient fuel, ItemStack output, int craftingTime, CraftingRecipeCategory category) {
        this.catalyst = catalyst;
        this.fuel = fuel;
        this.output = output;
        this.craftingTime = craftingTime;
        this.category = category;
    }

    public VoidspawnGeneratorRecipe(Ingredient catalyst, Ingredient fuel, RegistryEntry<Item> output, int outputAmount, int craftingTime, CraftingRecipeCategory category) {
        this(catalyst, fuel, new ItemStack(output, outputAmount), craftingTime, category);
    }

    public VoidspawnGeneratorRecipe(CraftingRecipeCategory category, DefaultedList<Ingredient> inputs, Item output, int outputCount, int craftingTime) {
        this.category = category;
        this.catalyst = inputs.get(0);
        this.fuel = inputs.get(1);
        this.output = new ItemStack(output, outputCount);
        this.craftingTime = craftingTime;
    }

    public Ingredient getCatalyst() {
        return catalyst;
    }

    public Ingredient getFuel() {
        return fuel;
    }

    public ItemStack getOutput() {
        return output;
    }

    public int getCraftingTime() {
        return craftingTime;
    }

    public CraftingRecipeCategory getCategory() {
        return category;
    }

    @Override
    public boolean matches(VoidspawnGeneratorRecipeInput inventory, World world) {
        if (inventory.getSize() < 3) return false;
        return catalyst.test(inventory.getStackInSlot(0)) && fuel.test(inventory.getStackInSlot(1));
    }

    @Override
    public ItemStack craft(VoidspawnGeneratorRecipeInput inventory, RegistryWrapper.WrapperLookup lookup) {
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

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<VoidspawnGeneratorRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();

        public static final String ID = "voidspawn_generator_recipe";
    }

    public static class Serializer implements RecipeSerializer<VoidspawnGeneratorRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "voidspawn_generator_recipe";

        MapCodec<VoidspawnGeneratorRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("catalyst").forGetter(VoidspawnGeneratorRecipe::getCatalyst),
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("fuel").forGetter(VoidspawnGeneratorRecipe::getFuel),
                ItemStack.ITEM_CODEC.fieldOf("output").forGetter(recipe -> recipe.output.getRegistryEntry()),
                Codec.INT.optionalFieldOf("outputAmount", 1).forGetter(recipe -> recipe.output.getCount()),
                Codec.INT.optionalFieldOf("craftingTime", 20).forGetter(VoidspawnGeneratorRecipe::getCraftingTime),
                CraftingRecipeCategory.CODEC.fieldOf("category").orElse(CraftingRecipeCategory.MISC).forGetter(VoidspawnGeneratorRecipe::getCategory)
        ).apply(instance, VoidspawnGeneratorRecipe::new));

        public Serializer() {}

        @Override
        public MapCodec<VoidspawnGeneratorRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, VoidspawnGeneratorRecipe> packetCodec() {
            return PacketCodec.ofStatic(this::write, this::read);
        }

        public VoidspawnGeneratorRecipe read(RegistryByteBuf buf) {
            Ingredient catalyst = Ingredient.PACKET_CODEC.decode(buf);
            Ingredient fuel = Ingredient.PACKET_CODEC.decode(buf);
            ItemStack output = ItemStack.PACKET_CODEC.decode(buf);
            int outputAmount = buf.readInt();
            int craftingTime = buf.readInt();
            CraftingRecipeCategory category = buf.readEnumConstant(CraftingRecipeCategory.class);
            return new VoidspawnGeneratorRecipe(catalyst, fuel, new ItemStack(output.getRegistryEntry(), outputAmount), craftingTime, category);
        }

        public void write(RegistryByteBuf buf, VoidspawnGeneratorRecipe recipe) {
            Ingredient.PACKET_CODEC.encode(buf, recipe.catalyst);
            Ingredient.PACKET_CODEC.encode(buf, recipe.fuel);
            ItemStack.PACKET_CODEC.encode(buf, recipe.output);
            buf.writeInt(recipe.output.getCount());
            buf.writeInt(recipe.craftingTime);
            buf.writeEnumConstant(recipe.category);
        }
    }
}
