package tech.krazyminer001.entity.client;

import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.entity.custom.LeafMonsterEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import static tech.krazyminer001.utility.Util.of;

public class LeafMonsterEntityRenderer extends MobEntityRenderer<LeafMonsterEntity, LeafMonsterEntityModel<LeafMonsterEntity>> {
    private static final Identifier TEXTURE = of("textures/entity/leaf_monster.png");

    public LeafMonsterEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new LeafMonsterEntityModel<>(context.getPart(ModModelLayers.LEAF_MONSTER)), 0.6f);
    }

    @Override
    public Identifier getTexture(LeafMonsterEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(LeafMonsterEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
