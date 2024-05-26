package com.goggaguys.blockentity.renderers;

import com.goggaguys.blockentity.custom.LeafShrineBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

import java.util.Random;

public class LeafShrineBlockEntityRenderer <T extends LeafShrineBlockEntity> implements BlockEntityRenderer<T> {
    public LeafShrineBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();

        Random random = new Random((long) entity.getPos().getX() * entity.getPos().getY() * entity.getPos().getZ() * entity.getItems().get(0).getItem().hashCode());
        // Move the item
        matrices.translate(0.4 + random.nextDouble() * 0.2, 0.75, 0.4 + random.nextDouble() * 0.2);

        matrices.multiply(RotationAxis.POSITIVE_Y.rotation((float) (random.nextDouble() * 2 * Math.PI)));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));

        MinecraftClient.getInstance().getItemRenderer().renderItem(entity.getItems().get(0), ModelTransformationMode.GROUND, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);

        // Mandatory call after GL calls
        matrices.pop();
    }
}
