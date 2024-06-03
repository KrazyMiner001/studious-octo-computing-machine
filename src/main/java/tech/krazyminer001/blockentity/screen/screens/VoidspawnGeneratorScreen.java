package tech.krazyminer001.blockentity.screen.screens;

import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.blockentity.screen.screenhandlers.VoidspawnGeneratorScreenHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class VoidspawnGeneratorScreen extends HandledScreen<VoidspawnGeneratorScreenHandler> {
    //A path to the gui texture. In this example we use the texture from the dispenser
    private static final Identifier TEXTURE = new Identifier(OctoComputing.MOD_ID, "textures/gui/container/voidspawn_generator.png");
    protected int backgroundHeight = 188;

    public VoidspawnGeneratorScreen(VoidspawnGeneratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.titleY-=11;
        this.playerInventoryTitleY+=11;

    }


    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
        context.drawGuiTexture(new Identifier(OctoComputing.MOD_ID, "container/voidspawn_generator/progress"), 60, 31, 0, 0, x + 83, y + 10, (int) (getScreenHandler().getCraftingProgress()*60), 31);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);

        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void init() {
        super.init();
        // Center the title
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}


