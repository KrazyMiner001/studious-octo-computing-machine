package tech.krazyminer001.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class LeafProjectileEntityModel extends EntityModel<Entity> {
	private final ModelPart leaf_projectile;
	public LeafProjectileEntityModel(ModelPart root) {
		this.leaf_projectile = root.getChild("leaf_projectile");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData leaf_projectile = modelPartData.addChild("leaf_projectile", ModelPartBuilder.create().uv(0, 9).cuboid(-1.0F, -5.0F, -5.0F, 2.0F, 2.0F, 10.0F, new Dilation(-0.5F))
				.uv(0, 0).cuboid(-3.0F, -4.0F, -6.0F, 6.0F, 0.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	public void setHeadRotation(float animationProgress, float yaw, float pitch) {
		this.leaf_projectile.yaw = yaw * 0.017453292F;
		this.leaf_projectile.pitch = pitch * 0.017453292F;
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		leaf_projectile.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}