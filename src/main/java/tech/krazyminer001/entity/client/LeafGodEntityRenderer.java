package tech.krazyminer001.entity.client;

import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.entity.custom.LeafGodEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import static tech.krazyminer001.utility.Util.of;

public class LeafGodEntityRenderer extends MobEntityRenderer<LeafGodEntity, LeafGodEntityModel<LeafGodEntity>> {
    private static final Identifier TEXTURE = of("textures/entity/leaf_god.png");

    public LeafGodEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new LeafGodEntityModel<>(context.getPart(ModModelLayers.LEAF_GOD)), 0.6f);
    }

    @Override
    public Identifier getTexture(LeafGodEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(LeafGodEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
