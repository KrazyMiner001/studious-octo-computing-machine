package com.goggaguys;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.blockentity.ModBlockEntities;
import com.goggaguys.blockentity.renderers.EndergleamBlockEntityRenderer;
import com.goggaguys.blockentity.renderers.LeafPlinthBlockEntityRenderer;
import com.goggaguys.blockentity.renderers.LeafShrineBlockEntityRenderer;
import com.goggaguys.entity.ModEntities;
import com.goggaguys.entity.client.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class OctoComputingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockRenderLayerMap.INSTANCE.putBlocks(
				RenderLayer.getCutout(),
				
				ModBlocks.MYSTERY_SAPLING,
				ModBlocks.MYSTERY_LEAVES,
				ModBlocks.TRANSIENTWOOD_SAPLING,
				ModBlocks.TRANSIENTWOOD_LEAVES,
				ModBlocks.ENDERGLEAM_SAPLING,
				ModBlocks.ENDERGLEAM_LEAVES,
				ModBlocks.ENDERGLEAM_LOG,
				ModBlocks.ENDERGLEAM_WOOD,
				ModBlocks.ENDERGLEAM_PLANKS,
				ModBlocks.STRIPPED_ENDERGLEAM_LOG,
				ModBlocks.STRIPPED_ENDERGLEAM_WOOD,
				ModBlocks.ETERNALLEAVES,
				ModBlocks.LEAF_PEDESTAL,
				ModBlocks.LEAF_PORTAL,
				ModBlocks.LEAF_SHRINE,
				ModBlocks.LEAF_PLINTH
		);

		BlockEntityRendererFactories.register(ModBlockEntities.ENDERGLEAM_BLOCK_ENTITY, EndergleamBlockEntityRenderer::new);
		BlockEntityRendererFactories.register(ModBlockEntities.LEAF_SHRINE_BLOCK_ENTITY, LeafShrineBlockEntityRenderer::new);
		BlockEntityRendererFactories.register(ModBlockEntities.LEAF_PLINTH_BLOCK_ENTITY, LeafPlinthBlockEntityRenderer::new);

		EntityRendererRegistry.register(ModEntities.LEAF_MONSTER, LeafMonsterEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LEAF_MONSTER, LeafMonsterEntityModel::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.LEAF_GOD, LeafGodEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LEAF_GOD, LeafGodEntityModel::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.LEAF_PROJECTILE, LeafProjectileEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LEAF_PROJECTILE, LeafProjectileEntityModel::getTexturedModelData);

		OctoComputing.LOGGER.info("Initializing Client");
	}
}