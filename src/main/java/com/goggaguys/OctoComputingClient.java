package com.goggaguys;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.entity.ModEntities;
import com.goggaguys.entity.client.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class OctoComputingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MYSTERY_SAPLING, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MYSTERY_LEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ETERNALLEAVES, RenderLayer.getCutout());

		EntityRendererRegistry.register(ModEntities.LEAF_MONSTER, LeafMonsterEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LEAF_MONSTER, LeafMonsterEntityModel::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.LEAF_GOD, LeafGodEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LEAF_GOD, LeafGodEntityModel::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.LEAF_PROJECTILE, LeafProjectileEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LEAF_PROJECTILE, LeafProjectileEntityModel::getTexturedModelData);

		OctoComputing.LOGGER.info("Initializing Client");
	}
}