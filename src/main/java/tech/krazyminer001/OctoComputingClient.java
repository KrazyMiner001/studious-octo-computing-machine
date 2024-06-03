package tech.krazyminer001;

import tech.krazyminer001.block.ModBlocks;
import tech.krazyminer001.blockentity.ModBlockEntities;
import tech.krazyminer001.blockentity.renderers.EndergleamBlockEntityRenderer;
import tech.krazyminer001.blockentity.renderers.LeafPlinthBlockEntityRenderer;
import tech.krazyminer001.blockentity.renderers.LeafShrineBlockEntityRenderer;
import tech.krazyminer001.blockentity.renderers.VoidspawnGeneratorBlockEntityRenderer;
import tech.krazyminer001.blockentity.screen.ModHandledScreens;
import tech.krazyminer001.entity.ModEntities;
import tech.krazyminer001.entity.client.*;
import tech.krazyminer001.networking.ModS2CPacketReciever;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

@Environment(EnvType.CLIENT)
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
		BlockRenderLayerMap.INSTANCE.putBlocks(
				RenderLayer.getTranslucent(),

				ModBlocks.VOIDSPAWN_GENERATOR
		);

		ModS2CPacketReciever.registerS2CReceivers();
		ModHandledScreens.registerScreenHandlers();

		BlockEntityRendererFactories.register(ModBlockEntities.ENDERGLEAM_BLOCK_ENTITY, EndergleamBlockEntityRenderer::new);
		BlockEntityRendererFactories.register(ModBlockEntities.LEAF_SHRINE_BLOCK_ENTITY, LeafShrineBlockEntityRenderer::new);
		BlockEntityRendererFactories.register(ModBlockEntities.LEAF_PLINTH_BLOCK_ENTITY, LeafPlinthBlockEntityRenderer::new);
		BlockEntityRendererFactories.register(ModBlockEntities.VOIDSPAWN_GENERATOR_BLOCK_ENTITY, VoidspawnGeneratorBlockEntityRenderer::new);

		EntityRendererRegistry.register(ModEntities.LEAF_MONSTER, LeafMonsterEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LEAF_MONSTER, LeafMonsterEntityModel::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.LEAF_GOD, LeafGodEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LEAF_GOD, LeafGodEntityModel::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.LEAF_PROJECTILE, LeafProjectileEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LEAF_PROJECTILE, LeafProjectileEntityModel::getTexturedModelData);

		OctoComputing.LOGGER.info("Initializing Client");
	}
}