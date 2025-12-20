package net.jcquestmark.justamod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.jcquestmark.justamod.JustAMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CompressorMachineScreen extends AbstractContainerScreen<CompressorMachineMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(JustAMod.MOD_ID, "textures/gui/material_compressor_gui.png");

    public CompressorMachineScreen(CompressorMachineMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderProgressArrow (GuiGraphics guiGraphics, int x, int y) {
        if (menu.isCompressing()) {
            guiGraphics.blit(TEXTURE, x + 82, y + 36, 176, 0, menu.getScaledProgress(), 16);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(guiGraphics, pMouseX, pMouseY);
    }
}
