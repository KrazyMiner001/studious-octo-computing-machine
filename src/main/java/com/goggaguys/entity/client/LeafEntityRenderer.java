package com.goggaguys.entity.client;

import com.goggaguys.OctoComputing;
import com.goggaguys.entity.custom.LeafEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class LeafEntityRenderer extends MobEntityRenderer<LeafEntity, LeafEntityModel<LeafEntity>> {
    private static final Identifier TEXTURE = new Identifier(OctoComputing.MOD_ID, "textures/entity/leaf_entity.png");

    public LeafEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new LeafEntityModel<>(context.getPart(ModModelLayers.LEAF)), 0.5f);
    }

    @Override
    public Identifier getTexture(LeafEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(LeafEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, 1);
    }
}
