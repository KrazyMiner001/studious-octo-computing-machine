package com.goggaguys.blockentity.renderers;

import com.goggaguys.OctoComputing;
import com.goggaguys.blockentity.custom.LeafShrineBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

public class LeafShrineBlockEntityRenderer implements BlockEntityRenderer<LeafShrineBlockEntity> {
    private static ItemStack stack = new ItemStack(Items.AIR, 1);

    public LeafShrineBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(LeafShrineBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        // Calculate the current offset in the y value
        double offset = Math.sin((entity.getWorld().getTime() + tickDelta) / 8.0) / 4.0;
        // Move the item
        matrices.translate(0.5, 1.25 + offset, 0.5);

        // Rotate the item
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((entity.getWorld().getTime() + tickDelta) * 4));

        int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
        if (!((Inventory) entity).getStack(0).isEmpty()) {
            MinecraftClient.getInstance().getItemRenderer().renderItem(((Inventory) entity).getStack(0), ModelTransformationMode.GROUND, lightAbove, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
        }

        // Mandatory call after GL calls
        matrices.pop();
    }
}
