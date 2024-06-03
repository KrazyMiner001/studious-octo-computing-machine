package tech.krazyminer001.datagen;

import tech.krazyminer001.block.ModBlocks;
import tech.krazyminer001.block.ModProperties;
import tech.krazyminer001.item.ModItems;
import tech.krazyminer001.model.ModItemModelGenerator;
import tech.krazyminer001.utilities.CompressedChainMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;

import static net.minecraft.data.client.BlockStateModelGenerator.createSingletonBlockState;
import static net.minecraft.data.client.BlockStateModelGenerator.createSouthDefaultHorizontalRotationStates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerTintableCross(ModBlocks.MYSTERY_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.TRANSIENTWOOD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.ENDERGLEAM_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAF_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_LEAF_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAFSTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOIDSPAWN_GENERATOR);

        blockStateModelGenerator.registerLog(ModBlocks.MYSTERY_LOG).log(ModBlocks.MYSTERY_LOG).wood(ModBlocks.MYSTERY_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MYSTERY_LOG).log(ModBlocks.STRIPPED_MYSTERY_LOG).wood(ModBlocks.STRIPPED_MYSTERY_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MYSTERY_LEAVES);

        blockStateModelGenerator.registerLog(ModBlocks.TRANSIENTWOOD_LOG).log(ModBlocks.TRANSIENTWOOD_LOG).wood(ModBlocks.TRANSIENTWOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_TRANSIENTWOOD_LOG).log(ModBlocks.STRIPPED_TRANSIENTWOOD_LOG).wood(ModBlocks.STRIPPED_TRANSIENTWOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRANSIENTWOOD_LEAVES);

        blockStateModelGenerator.registerLog(ModBlocks.ENDERGLEAM_LOG).log(ModBlocks.ENDERGLEAM_LOG).wood(ModBlocks.ENDERGLEAM_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_ENDERGLEAM_LOG).log(ModBlocks.STRIPPED_ENDERGLEAM_LOG).wood(ModBlocks.STRIPPED_ENDERGLEAM_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDERGLEAM_LEAVES);

        blockStateModelGenerator.registerSingleton(ModBlocks.EXTRATERRESTRIAL_LEAF_DEBRIS, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHLOROPHYTE_BLOCK);

        blockStateModelGenerator.registerLog(ModBlocks.ETERNALWOOD).wood(ModBlocks.ETERNALWOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ETERNALLEAVES);

        blockStateModelGenerator.blockStateCollector.
                accept(VariantsBlockStateSupplier.create(ModBlocks.LEAF_PORTAL)
                        .coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_AXIS)
                                .register(Direction.Axis.X, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(ModBlocks.LEAF_PORTAL, "_x")))
                                .register(Direction.Axis.Z, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(ModBlocks.LEAF_PORTAL, "_z")))
                        )
                );

        blockStateModelGenerator.blockStateCollector
                .accept(VariantsBlockStateSupplier.create(ModBlocks.LEAF_PEDESTAL)
                                .coordinate(BlockStateVariantMap.create(ModProperties.ACTIVATED)
                                                .register(false, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(ModBlocks.LEAF_PEDESTAL)))
                                                .register(true, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(ModBlocks.LEAF_PEDESTAL, "_activated")))
                                )
                );

        blockStateModelGenerator.blockStateCollector
                .accept(createSingletonBlockState(ModBlocks.LEAF_SHRINE,
                        ModelIds.getBlockModelId(ModBlocks.LEAF_SHRINE)));

        blockStateModelGenerator.blockStateCollector
                .accept(createSingletonBlockState(ModBlocks.LEAF_PLINTH,
                        ModelIds.getBlockModelId(ModBlocks.LEAF_PLINTH)));

        BlockStateModelGenerator.BlockTexturePool mystery_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MYSTERY_PLANKS);
        BlockStateModelGenerator.BlockTexturePool transientwood_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TRANSIENTWOOD_PLANKS);
        BlockStateModelGenerator.BlockTexturePool endergleam_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ENDERGLEAM_PLANKS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        ModItemModelGenerator modItemModelGenerator = new ModItemModelGenerator(itemModelGenerator.writer);

        for (Item i : CompressedChainMap.compressedChainMap.regularToCompressed.keySet()) {
            Item compressed = CompressedChainMap.compressedChainMap.regularToCompressed.get(i);
            Item doubleCompressed = CompressedChainMap.compressedChainMap.compressedToDoubleCompressed.get(compressed);
            modItemModelGenerator.registerCompressedChain(i, compressed, doubleCompressed);
        }

        itemModelGenerator.register(ModItems.LEAFSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_DEBRIS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAFITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.LEAF_PICKER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.LEAF_MONSTER_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

        modItemModelGenerator.registerCompressedArmorChain(
                (ArmorItem) ModItems.LEAF_HELMET,
                (ArmorItem) ModItems.COMPRESSED_LEAF_HELMET,
                (ArmorItem) ModItems.DOUBLE_COMPRESSED_LEAF_HELMET);
        modItemModelGenerator.registerCompressedArmorChain(
                (ArmorItem) ModItems.LEAF_CHESTPLATE,
                (ArmorItem) ModItems.COMPRESSED_LEAF_CHESTPLATE,
                (ArmorItem) ModItems.DOUBLE_COMPRESSED_LEAF_CHESTPLATE);
        modItemModelGenerator.registerCompressedArmorChain(
                (ArmorItem) ModItems.LEAF_LEGGINGS,
                (ArmorItem) ModItems.COMPRESSED_LEAF_LEGGINGS,
                (ArmorItem) ModItems.DOUBLE_COMPRESSED_LEAF_LEGGINGS);
        modItemModelGenerator.registerCompressedArmorChain(
                (ArmorItem) ModItems.LEAF_BOOTS,
                (ArmorItem) ModItems.COMPRESSED_LEAF_BOOTS,
                (ArmorItem) ModItems.DOUBLE_COMPRESSED_LEAF_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAFITE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAFITE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAFITE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LEAFITE_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.CHLOROPHYTE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.CHLOROPHYTE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.CHLOROPHYTE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.CHLOROPHYTE_BOOTS);

        itemModelGenerator.register(ModItems.LEAFITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAFITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAFITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAFITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAFITE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.CHLOROPHYTE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_HOE, Models.HANDHELD);

        modItemModelGenerator.registerCompressedHandheldChain(ModItems.LEAF_SWORD, ModItems.COMPRESSED_LEAF_SWORD, ModItems.DOUBLE_COMPRESSED_LEAF_SWORD);
        modItemModelGenerator.registerCompressedHandheldChain(ModItems.LEAF_PICKAXE, ModItems.COMPRESSED_LEAF_PICKAXE, ModItems.DOUBLE_COMPRESSED_LEAF_PICKAXE);
        modItemModelGenerator.registerCompressedHandheldChain(ModItems.LEAF_AXE, ModItems.COMPRESSED_LEAF_AXE, ModItems.DOUBLE_COMPRESSED_LEAF_AXE);
        modItemModelGenerator.registerCompressedHandheldChain(ModItems.LEAF_SHOVEL, ModItems.COMPRESSED_LEAF_SHOVEL, ModItems.DOUBLE_COMPRESSED_LEAF_SHOVEL);
        modItemModelGenerator.registerCompressedHandheldChain(ModItems.LEAF_HOE, ModItems.COMPRESSED_LEAF_HOE, ModItems.DOUBLE_COMPRESSED_LEAF_HOE);

    }

    private void registerLeafPedestal(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier leafPedestalModelId = ModelIds.getBlockModelId(ModBlocks.LEAF_PEDESTAL);
        Identifier leafPedestalFilledModelId = ModelIds.getBlockSubModelId(ModBlocks.LEAF_PEDESTAL, "_activated");
        blockStateModelGenerator.blockStateCollector
                .accept(
                        VariantsBlockStateSupplier.create(ModBlocks.LEAF_PEDESTAL)
                                .coordinate(
                                        BlockStateVariantMap.create(BooleanProperty.of("activated"))
                                                .register(false, BlockStateVariant.create().put(VariantSettings.MODEL, leafPedestalModelId))
                                                .register(true, BlockStateVariant.create().put(VariantSettings.MODEL, leafPedestalFilledModelId))
                                )
                                .coordinate(createSouthDefaultHorizontalRotationStates())
                );
    }
}
