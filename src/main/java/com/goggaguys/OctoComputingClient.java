package com.goggaguys;

import com.goggaguys.block.ModBlocks;
import com.goggaguys.entity.ModEntities;
import com.goggaguys.entity.client.LeafMonsterEntityModel;
import com.goggaguys.entity.client.LeafMonsterEntityRenderer;
import com.goggaguys.entity.client.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class OctoComputingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MYSTERY_SAPLING, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MYSTERY_LEAVES, RenderLayer.getCutout());

		EntityRendererRegistry.register(ModEntities.LEAF_MONSTER_ENTITY, LeafMonsterEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LEAF, LeafMonsterEntityModel::getTexturedModelData);

		OctoComputing.LOGGER.info("Initializing Client");
	}
}