package com.goggaguys.entity.client;

import com.goggaguys.entity.custom.LeafMonsterEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class LeafMonsterEntityModel<T extends LeafMonsterEntity> extends SinglePartEntityModel<T> {
    private final ModelPart leafEntity;

    public LeafMonsterEntityModel(ModelPart root) {
        this.leafEntity = root.getChild("leafEntity");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData leafEntity = modelPartData.addChild("leafEntity", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = leafEntity.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf = body.addChild("leaf", ModelPartBuilder.create().uv(0, 4).cuboid(0.0F, -7.0F, -5.0F, 0.0F, 2.0F, 10.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf_6_r1 = leaf.addChild("leaf_6_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0271F, -8.4502F, -5.0F, 0.0F, 4.0F, 10.0F, new Dilation(0.1F))
                .uv(0, 20).cuboid(-1.0271F, -4.4502F, -9.0F, 0.0F, 6.0F, 18.0F, new Dilation(0.1F))
                .uv(0, 0).cuboid(-0.9729F, 0.9502F, -11.0F, 0.0F, 11.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(3.8507F, -25.4139F, 0.0F, 0.0F, 0.0F, 0.1745F));

        ModelPartData leaf_3_r1 = leaf.addChild("leaf_3_r1", ModelPartBuilder.create().uv(0, 11).cuboid(0.75F, -2.5F, -11.0F, 0.0F, 5.0F, 22.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -11.5F, 0.0F, 0.0F, 0.0F, 0.0436F));

        ModelPartData leaf_2_r1 = leaf.addChild("leaf_2_r1", ModelPartBuilder.create().uv(0, 0).cuboid(0.25F, -1.0F, -9.0F, 0.0F, 2.0F, 18.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        ModelPartData stem = body.addChild("stem", ModelPartBuilder.create().uv(0, 44).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData inner_stem_3_r1 = stem.addChild("inner_stem_3_r1", ModelPartBuilder.create().uv(20, 0).cuboid(0.25F, -13.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F))
                .uv(28, 0).cuboid(0.25F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -18.5F, -0.5F, 0.0F, 0.0F, 0.2182F));

        ModelPartData inner_stem_1_r1 = stem.addChild("inner_stem_1_r1", ModelPartBuilder.create().uv(36, 0).cuboid(-1.5F, -4.5F, -0.5F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.8922F, -9.4829F, -0.5F, 0.0F, 0.0F, 0.0873F));

        ModelPartData veins = body.addChild("veins", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

        ModelPartData right_1 = veins.addChild("right_1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -0.25F));

        ModelPartData part_2_r1 = right_1.addChild("part_2_r1", ModelPartBuilder.create().uv(39, 6).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -8.5822F, 8.3815F, 0.5236F, 0.0F, 0.0F));

        ModelPartData part_1_r1 = right_1.addChild("part_1_r1", ModelPartBuilder.create().uv(43, 13).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -7.5F, 3.5F, 0.2182F, 0.0F, 0.0F));

        ModelPartData right_2 = veins.addChild("right_2", ModelPartBuilder.create(), ModelTransform.of(1.5F, -17.7901F, 5.2123F, 0.0F, 0.0F, 0.1745F));

        ModelPartData part_3_r1 = right_2.addChild("part_3_r1", ModelPartBuilder.create().uv(36, 12).cuboid(-1.0F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.1721F, 2.4023F, 1.2678F, -0.0393F, -0.1249F));

        ModelPartData part_2_r2 = right_2.addChild("part_2_r2", ModelPartBuilder.create().uv(7, 1).cuboid(-0.5F, -3.0F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 2.5442F, 1.0472F, 0.0F, 0.0F));

        ModelPartData part_1_r2 = right_2.addChild("part_1_r2", ModelPartBuilder.create().uv(36, 38).cuboid(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, -1.9623F, 0.6109F, 0.0F, 0.0F));

        ModelPartData left_1 = veins.addChild("left_1", ModelPartBuilder.create(), ModelTransform.of(0.25F, -10.3659F, -4.4968F, 0.0F, 3.1416F, 0.0F));

        ModelPartData part_2_r3 = left_1.addChild("part_2_r3", ModelPartBuilder.create().uv(22, 12).cuboid(-0.5F, -1.25F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2163F, 2.6282F, 0.5236F, 0.0F, 0.0F));

        ModelPartData part_1_r3 = left_1.addChild("part_1_r3", ModelPartBuilder.create().uv(29, 11).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.8659F, -2.2532F, 0.2182F, 0.0F, 0.0F));

        ModelPartData left_2 = veins.addChild("left_2", ModelPartBuilder.create(), ModelTransform.of(1.5F, -20.7901F, -4.7877F, 0.0F, 3.1416F, 0.1745F));

        ModelPartData part_3_r2 = left_2.addChild("part_3_r2", ModelPartBuilder.create().uv(43, 33).cuboid(-0.5F, -10.5372F, -5.5071F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0217F, 12.8791F, 1.2654F, 0.0F, 0.0F));

        ModelPartData part_2_r4 = left_2.addChild("part_2_r4", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -11.6603F, -7.5F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5584F, 12.5442F, 1.0472F, 0.0F, 0.0F));

        ModelPartData part_1_r4 = left_2.addChild("part_1_r4", ModelPartBuilder.create().uv(15, 11).cuboid(-0.5F, -6.2358F, -11.6915F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2901F, 8.0377F, 0.6109F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        leafEntity.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }


    @Override
    public ModelPart getPart() {
        return leafEntity;
    }
}
