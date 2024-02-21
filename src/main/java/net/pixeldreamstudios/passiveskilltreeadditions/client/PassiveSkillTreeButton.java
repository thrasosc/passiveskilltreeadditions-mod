package net.pixeldreamstudios.passiveskilltreeadditions.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.resources.ResourceLocation;
import net.pixeldreamstudios.passiveskilltreeadditions.PassiveSkillTreeAdditions;

public class PassiveSkillTreeButton extends ImageButton {
    private static ResourceLocation HOVER_TEXTURE = new ResourceLocation(PassiveSkillTreeAdditions.MODID, "textures/gui/inventory/button/passive_skill_tree_hover.png");
    public PassiveSkillTreeButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, ResourceLocation pResourceLocation, int pTextureWidth, int pTextureHeight, OnPress pOnPress) {
        super(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pResourceLocation, pOnPress);
    }

    @Override
    public void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderTexture(pGuiGraphics, this.resourceLocation, this.getX(), this.getY(), this.xTexStart, this.yTexStart, this.yDiffTex, this.width, this.height, this.textureWidth, this.textureHeight);
    }
}
