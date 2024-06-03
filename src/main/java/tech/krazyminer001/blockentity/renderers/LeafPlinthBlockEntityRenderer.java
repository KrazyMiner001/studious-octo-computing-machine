package tech.krazyminer001.blockentity.renderers;

import tech.krazyminer001.blockentity.custom.LeafPlinthBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

import java.util.Objects;

public class LeafPlinthBlockEntityRenderer<T extends LeafPlinthBlockEntity> implements BlockEntityRenderer<T> {
    public LeafPlinthBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(T blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();

        // Calculate the current offset in the y value
        double offset = Math.sin((Objects.requireNonNull(blockEntity.getWorld()).getTime() + tickDelta) / 8.0) / 8.0;
        // Move the item
        matrices.translate(0.5, 1 + offset, 0.5);
        // Rotate the item
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((blockEntity.getWorld().getTime() + tickDelta) * 4));

        MinecraftClient.getInstance().getItemRenderer().renderItem(blockEntity.getItems().get(0), ModelTransformationMode.GROUND, light, overlay, matrices, vertexConsumers, blockEntity.getWorld(), 0);

        matrices.pop();
    }
}
