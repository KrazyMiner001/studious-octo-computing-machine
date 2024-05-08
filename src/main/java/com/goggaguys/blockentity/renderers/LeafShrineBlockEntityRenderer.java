package com.goggaguys.blockentity.renderers;

import com.goggaguys.blockentity.custom.LeafShrineBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

public class LeafShrineBlockEntityRenderer <T extends LeafShrineBlockEntity> implements BlockEntityRenderer<T> {
    public LeafShrineBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        // Move the item
        double offset = Math.sin((entity.getWorld().getTime() + tickDelta) / 8.0) / 8.0;
        matrices.translate(0.5, 1 + offset, 0.5);

        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((entity.getWorld().getTime() + tickDelta) * 4));

        MinecraftClient.getInstance().getItemRenderer().renderItem(entity.getItems().get(0), ModelTransformationMode.GROUND, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);

        // Mandatory call after GL calls
        matrices.pop();
    }
}
