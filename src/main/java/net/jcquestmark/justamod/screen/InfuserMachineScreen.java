
package net.jcquestmark.justamod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.jcquestmark.justamod.JustAMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class InfuserMachineScreen extends AbstractContainerScreen<InfuserMachineMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(JustAMod.MOD_ID, "textures/gui/material_infuser_gui.png");

    public InfuserMachineScreen(InfuserMachineMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
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
        renderFuelBar(guiGraphics, x, y);
    }

    private void renderProgressArrow (GuiGraphics guiGraphics, int x, int y) {
        if (menu.isInfusing()) {
            guiGraphics.blit(TEXTURE, x + 65, y + 31, 176, 0, 46, menu.getScaledProgress());
        }
    }

    private void renderFuelBar (GuiGraphics guiGraphics, int x, int y) {
        int scaledFuelAmount = menu.getScaledFuelAmount();
        guiGraphics.blit(TEXTURE, x + 10, y + (57 - scaledFuelAmount), 176, (56 - scaledFuelAmount), 12, scaledFuelAmount);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(guiGraphics, pMouseX, pMouseY);
        renderFuelText(guiGraphics, pMouseX, pMouseY);
    }

    private void renderFuelText(GuiGraphics guiGraphics, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        int xa = 10; int xb = 21;
        int ya = 17; int yb = 56;
        // Screen things ^^
        // x range of tooltip from xa to xb
        // y range of tooltip from ya to yb

        if(pMouseX >= x + xa && pMouseX <= x + xb && pMouseY >= y + ya && pMouseY <= y + yb) {
            var tooltip = Component.literal(menu.getFuelText());

            guiGraphics.renderTooltip(this.font, tooltip, pMouseX, pMouseY);
        }
    }


    @Override
    protected void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
        super.renderLabels(pGuiGraphics, pMouseX, pMouseY);

        pGuiGraphics.drawString(this.font, Component.literal("T"), 99, 99, 0x404040, false);
    }
}
