package tech.krazyminer001.blockentity.renderers;

import tech.krazyminer001.blockentity.custom.EndergleamBlockEntity;
import tech.krazyminer001.renderlayer.ModRenderLayer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.joml.Matrix4f;

public class EndergleamBlockEntityRenderer <T extends EndergleamBlockEntity> implements BlockEntityRenderer<T> {
    public static final Identifier PORTAL_TEXTURE = new Identifier("textures/entity/end_portal.png");

    public EndergleamBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(T endPortalBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
        Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
        this.renderSides(endPortalBlockEntity, matrix4f, vertexConsumerProvider.getBuffer(this.getLayer()));
    }

    private void renderSides(T entity, Matrix4f matrix, VertexConsumer vertexConsumer) {
        float f = this.getBottomYOffset();
        float g = this.getTopYOffset();
        this.renderSide(entity, matrix, vertexConsumer, 0.001F, 0.999F, 0.001F, 0.999F, 0.999F, 0.999F, 0.999F, 0.999F, Direction.SOUTH);
        this.renderSide(entity, matrix, vertexConsumer, 0.001F, 0.999F, 0.999F, 0.001F, 0.001F, 0.001F, 0.001F, 0.001F, Direction.NORTH);
        this.renderSide(entity, matrix, vertexConsumer, 0.999F, 0.999F, 0.999F, 0.001F, 0.001F, 0.999F, 0.999F, 0.001F, Direction.EAST);
        this.renderSide(entity, matrix, vertexConsumer, 0.001F, 0.001F, 0.001F, 0.999F, 0.001F, 0.999F, 0.999F, 0.001F, Direction.WEST);
        this.renderSide(entity, matrix, vertexConsumer, 0.001F, 0.999F, f, f, 0.001F, 0.001F, 0.999F, 0.999F, Direction.DOWN);
        this.renderSide(entity, matrix, vertexConsumer, 0.001F, 0.999F, g, g, 0.999F, 0.999F, 0.001F, 0.001F, Direction.UP);
    }

    private void renderSide(T entity, Matrix4f model, VertexConsumer vertices, float x1, float x2, float y1, float y2, float z1, float z2, float z3, float z4, Direction side) {
        if (entity.shouldDrawSide(side)) {
            vertices.vertex(model, x1, y1, z1).next();
            vertices.vertex(model, x2, y1, z2).next();
            vertices.vertex(model, x2, y2, z3).next();
            vertices.vertex(model, x1, y2, z4).next();
        }

    }
    
    protected float getTopYOffset() {
        return 0.999F;
    }
    
    protected float getBottomYOffset() {
        return 0.001F;
    }

    protected RenderLayer getLayer() {
        return ModRenderLayer.getEndergleam();
    }

    @Override
    public int getRenderDistance() {
        return 256;
    }
}
