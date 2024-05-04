package com.goggaguys;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.blockentity.ModBlockEntities;
import com.goggaguys.blockentity.renderers.EndergleamBlockEntityRenderer;
import com.goggaguys.entity.ModEntities;
import com.goggaguys.entity.client.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.client.rendering.BlockEntityRendererRegistryImpl;
import net.fabricmc.fabric.mixin.client.rendering.BlockEntityRendererFactoriesMixin;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.registry.Registry;

public class OctoComputingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MYSTERY_SAPLING, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MYSTERY_LEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRANSIENTWOOD_SAPLING, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRANSIENTWOOD_LEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ENDERGLEAM_SAPLING, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ENDERGLEAM_LEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ENDERGLEAM_LOG, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ENDERGLEAM_WOOD, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRIPPED_ENDERGLEAM_LOG, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRIPPED_ENDERGLEAM_WOOD, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ETERNALLEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEAF_PEDESTAL, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEAF_PORTAL, RenderLayer.getCutout());

		BlockEntityRendererFactories.register(ModBlockEntities.ENDERGLEAM_BLOCK_ENTITY, EndergleamBlockEntityRenderer::new);

		EntityRendererRegistry.register(ModEntities.LEAF_MONSTER, LeafMonsterEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LEAF_MONSTER, LeafMonsterEntityModel::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.LEAF_GOD, LeafGodEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LEAF_GOD, LeafGodEntityModel::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.LEAF_PROJECTILE, LeafProjectileEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LEAF_PROJECTILE, LeafProjectileEntityModel::getTexturedModelData);

		OctoComputing.LOGGER.info("Initializing Client");
	}
}