package com.goggaguys.blockentity.renderers;

import com.goggaguys.blockentity.custom.VoidspawnGeneratorBlockEntity;
import com.goggaguys.item.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

import java.util.Objects;
import java.util.Random;

public class VoidspawnGeneratorBlockEntityRenderer<T extends VoidspawnGeneratorBlockEntity> implements BlockEntityRenderer<T> {

    public VoidspawnGeneratorBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(VoidspawnGeneratorBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();

        matrices.translate(0.5, 0.5, 0.5);
        Random random = new Random(entity.hashCode());
        double time = Objects.requireNonNull(entity.getWorld()).getTime() + tickDelta;
        double xRot = 4*time*random.nextDouble() % 360;
        double yRot = 4*time*random.nextDouble() % 360;
        double zRot = 4*time*random.nextDouble() % 360;
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float) yRot));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees((float) xRot));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float) zRot));

        MinecraftClient.getInstance().getItemRenderer().renderItem(ModItems.CORRUPTED_CORE.getDefaultStack(), ModelTransformationMode.GROUND, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);

        matrices.pop();
    }
}
