package tech.krazyminer001.entity.client;

import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.entity.custom.LeafProjectileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

import java.awt.*;

import static tech.krazyminer001.utility.Util.of;

public class LeafProjectileEntityRenderer extends EntityRenderer<LeafProjectileEntity> {
    private static final Identifier TEXTURE = of("textures/entity/leaf_projectile.png");
    private final LeafProjectileEntityModel model;

    public LeafProjectileEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new LeafProjectileEntityModel(context.getPart(ModModelLayers.LEAF_PROJECTILE));
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 35).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 64, 64);
    }

    protected int getBlockLight(LeafProjectileEntity leafProjectileEntity, BlockPos blockPos) {
        return 15;
    }

    public void render(LeafProjectileEntity leafProjectileEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.scale(1f, 1f, 1f);
        float h = MathHelper.lerpAngleDegrees(g, leafProjectileEntity.prevYaw, leafProjectileEntity.getYaw());
        float j = MathHelper.lerp(g, leafProjectileEntity.prevPitch, leafProjectileEntity.getPitch());
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(this.getTexture(leafProjectileEntity)));
        this.model.setHeadRotation(0.0F, h, j);
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 0xFFFFFF);
        matrixStack.pop();
        super.render(leafProjectileEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    public Identifier getTexture(LeafProjectileEntity leafProjectileEntity) {
        return TEXTURE;
    }
}