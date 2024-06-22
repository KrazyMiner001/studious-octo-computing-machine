package tech.krazyminer001.recipe;

import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.blockentity.ImplementedInventory;
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
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import tech.krazyminer001.blockentity.custom.LeafShrineBlockEntity;

public class LeafShrineRecipe implements Recipe<LeafShrineRecipeInput> {
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

    public LeafShrineRecipe(Ingredient inputCenter, Ingredient inputNorth, Ingredient inputEast, Ingredient inputSouth, Ingredient inputWest, RegistryEntry<Item> output, int outputAmount, int craftingTime, CraftingRecipeCategory category) {
        this(inputCenter, inputNorth, inputEast, inputSouth, inputWest, new ItemStack(output, outputAmount), craftingTime, category);
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

    public Identifier getId() {
        return OctoComputing.SERVER.getRecipeManager().listAllOfType(Type.INSTANCE).stream().filter(r -> r.value().equals(this)).findFirst().orElseThrow(() -> new IllegalStateException("Recipe not found")).id();
    }

    @Override
    public boolean matches(LeafShrineRecipeInput inventory, World world) {
        if (inventory.getSize() < 5)
            return false;
        return inputCenter.test(inventory.getStackInSlot(0)) && inputNorth.test(inventory.getStackInSlot(1)) && inputEast.test(inventory.getStackInSlot(2)) && inputSouth.test(inventory.getStackInSlot(3)) && inputWest.test(inventory.getStackInSlot(4));
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> ingredients = DefaultedList.of();
        ingredients.add(inputCenter);
        ingredients.add(inputNorth);
        ingredients.add(inputEast);
        ingredients.add(inputSouth);
        ingredients.add(inputWest);
        return ingredients;
    }

    @Override
    public ItemStack craft(LeafShrineRecipeInput inventory, RegistryWrapper.WrapperLookup lookup) {
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

    public ItemStack getOutput() {
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
        ).apply(instance, LeafShrineRecipe::new));

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
