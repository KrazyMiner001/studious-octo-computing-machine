package com.goggaguys.blockentity;

import com.goggaguys.OctoComputing;
import com.goggaguys.block.ModBlocks;
import com.goggaguys.blockentity.custom.EndergleamBlockEntity;
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

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntityType(String name, BlockEntityType<T> block) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(OctoComputing.MOD_ID, name), block);
    }

    public static void registerModBlocksEntities() {
        OctoComputing.LOGGER.info("Registering Block Entities for " + OctoComputing.MOD_ID);
    }
}
