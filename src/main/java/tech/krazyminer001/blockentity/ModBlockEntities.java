package tech.krazyminer001.blockentity;

import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.block.ModBlocks;
import tech.krazyminer001.blockentity.custom.EndergleamBlockEntity;
import tech.krazyminer001.blockentity.custom.LeafPlinthBlockEntity;
import tech.krazyminer001.blockentity.custom.LeafShrineBlockEntity;
import tech.krazyminer001.blockentity.custom.VoidspawnGeneratorBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<EndergleamBlockEntity> ENDERGLEAM_BLOCK_ENTITY = registerBlockEntityType("endergleam",
            BlockEntityType.Builder.create(EndergleamBlockEntity::new,
                    ModBlocks.ENDERGLEAM_LEAVES,
                    ModBlocks.ENDERGLEAM_LOG,
                    ModBlocks.ENDERGLEAM_PLANKS,
                    ModBlocks.ENDERGLEAM_WOOD,
                    ModBlocks.STRIPPED_ENDERGLEAM_LOG,
                    ModBlocks.STRIPPED_ENDERGLEAM_WOOD).build());

    public static BlockEntityType<LeafShrineBlockEntity> LEAF_SHRINE_BLOCK_ENTITY = registerBlockEntityType("leaf_shrine",
            BlockEntityType.Builder.create(LeafShrineBlockEntity::new,
                    ModBlocks.LEAF_SHRINE).build());

    public static BlockEntityType<LeafPlinthBlockEntity> LEAF_PLINTH_BLOCK_ENTITY = registerBlockEntityType("leaf_plinth",
            BlockEntityType.Builder.create(LeafPlinthBlockEntity::new,
                    ModBlocks.LEAF_PLINTH).build());

    public static BlockEntityType<VoidspawnGeneratorBlockEntity> VOIDSPAWN_GENERATOR_BLOCK_ENTITY = registerBlockEntityType("voidspawn_generator",
            BlockEntityType.Builder.create(VoidspawnGeneratorBlockEntity::new,
                    ModBlocks.VOIDSPAWN_GENERATOR).build());

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntityType(String name, BlockEntityType<T> block) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(OctoComputing.MOD_ID, name), block);
    }

    public static void registerModBlocksEntities() {
        OctoComputing.LOGGER.info("Registering Block Entities for " + OctoComputing.MOD_ID);
    }
}
