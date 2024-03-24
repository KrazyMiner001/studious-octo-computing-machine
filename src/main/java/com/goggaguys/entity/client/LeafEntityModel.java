package com.goggaguys.entity.client;

import com.goggaguys.entity.custom.LeafEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.Entity;

public class LeafEntityModel<T extends LeafEntity> extends SinglePartEntityModel<T> {
    final ModelPart leafEntity;

    public LeafEntityModel(ModelPart root) {
        this.leafEntity = root.getChild("leaf");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData leafEntity = modelPartData.addChild("leaf", ModelPartBuilder.create(), ModelTransform.pivot(0.0f, 24.0f, 0.0f));

        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public ModelPart getPart() {
        return leafEntity;
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}
