package net.pixeldreamstudios.passiveskilltreeadditions.client;

import daripher.skilltree.SkillTreeMod;
import daripher.skilltree.client.screen.SkillTreeScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.resources.ResourceLocation;
import net.pixeldreamstudios.passiveskilltreeadditions.PassiveSkillTreeAdditions;

public class PassiveSkillTreeAdditionsGui implements Renderable, GuiEventListener {
    protected static final ResourceLocation BUTTON_TEXTURE = new ResourceLocation(PassiveSkillTreeAdditions.MODID, "textures/gui/inventory/button/passive_skill_tree.png");
    protected static final int TEXTURE_WIDTH = 10;
    protected static final int TEXTURE_HEIGHT = 20;
    protected final InventoryScreen parent;
    protected final ImageButton toggleBtn;
    protected int leftPos, topPos;
    protected boolean open = false;

    public PassiveSkillTreeAdditionsGui(InventoryScreen parent) {
        this.parent = parent;
        this.leftPos = parent.getGuiLeft();
        this.topPos = parent.getGuiTop();
        this.toggleBtn = new ImageButton(parent.getGuiLeft(), parent.getGuiTop(), 10, 10, 0, 0, TEXTURE_HEIGHT / 2, BUTTON_TEXTURE, TEXTURE_WIDTH, TEXTURE_HEIGHT, btn -> {
            this.toggleVisibility();
        });
    }

    public void toggleVisibility() {
        this.open = !this.open;
        if (this.open) {
            Minecraft.getInstance().setScreen(
                    new SkillTreeScreen(new ResourceLocation(SkillTreeMod.MOD_ID, "main_tree")));
        }
    }

    @Override
    public void render(GuiGraphics gfx, int mouseX, int mouseY, float partialTicks) {
        this.toggleBtn.setX(this.parent.getGuiLeft() + 63);
        this.toggleBtn.setY(this.parent.getGuiTop() + 66);
    }

    @Override
    public void setFocused(boolean b) {

    }

    @Override
    public boolean isFocused() {
        return false;
    }
}
