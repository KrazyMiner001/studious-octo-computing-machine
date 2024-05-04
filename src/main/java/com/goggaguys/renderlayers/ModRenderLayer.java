package com.goggaguys.renderlayers;

import com.goggaguys.blockentity.renderers.EndergleamBlockEntityRenderer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.block.entity.EndPortalBlockEntityRenderer;

public class ModRenderLayer extends RenderLayer {
    public static RenderLayer ENDERGLEAM = RenderLayer.of("endergleam", VertexFormats.POSITION, VertexFormat.DrawMode.QUADS, 1536, false, false, MultiPhaseParameters.builder().program(END_PORTAL_PROGRAM).texture(Textures.create().add(EndergleamBlockEntityRenderer.PORTAL_TEXTURE, false, false).add(EndergleamBlockEntityRenderer.PORTAL_TEXTURE, false, false).build()).build(false));

    public ModRenderLayer(String name, VertexFormat vertexFormat, VertexFormat.DrawMode drawMode, int expectedBufferSize, boolean hasCrumbling, boolean translucent, Runnable startAction, Runnable endAction) {
        super(name, vertexFormat, drawMode, expectedBufferSize, hasCrumbling, translucent, startAction, endAction);
    }

    public static RenderLayer getEndergleam() {
        return ENDERGLEAM;
    }
}
