package net.pixeldreamstudios.passiveskilltreeadditions.client;

import daripher.skilltree.SkillTreeMod;
import daripher.skilltree.client.screen.SkillTreeScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component; // Correct import for Component
import net.minecraft.resources.ResourceLocation;
import net.pixeldreamstudios.passiveskilltreeadditions.PassiveSkillTreeAdditions;
import net.pixeldreamstudios.passiveskilltreeadditions.config.ModConfig;

import java.util.List;

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

        // Use configuration values for button position
        int buttonX = ModConfig.CLIENT.buttonX.get();
        int buttonY = ModConfig.CLIENT.buttonY.get();

        this.toggleBtn = new ImageButton(buttonX, buttonY, 10, 10, 0, 0, TEXTURE_HEIGHT / 2, BUTTON_TEXTURE, TEXTURE_WIDTH, TEXTURE_HEIGHT, btn -> {
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
        // Update button position based on the configuration
        this.toggleBtn.setX(ModConfig.CLIENT.buttonX.get());
        this.toggleBtn.setY(ModConfig.CLIENT.buttonY.get());

        // Render the button
        this.toggleBtn.render(gfx, mouseX, mouseY, partialTicks);

        // Check if the mouse is over the button
        if (isMouseOverButton(mouseX, mouseY)) {
            // Render the tooltip when the mouse is over the button
            renderTooltip(gfx, mouseX, mouseY);
        }
    }

    // Helper method to check if the mouse is over the button
    private boolean isMouseOverButton(int mouseX, int mouseY) {
        return mouseX >= this.toggleBtn.getX() && mouseX < this.toggleBtn.getX() + this.toggleBtn.getWidth()
                && mouseY >= this.toggleBtn.getY() && mouseY < this.toggleBtn.getY() + this.toggleBtn.getHeight();
    }

    // Render tooltip when hovering over the button
    private void renderTooltip(GuiGraphics gfx, int mouseX, int mouseY) {
        List<Component> tooltip = List.of(Component.literal("Passive Skill Tree")); // Tooltip text

        // Use the Minecraft font renderer to draw the tooltip
        gfx.renderComponentTooltip(Minecraft.getInstance().font, tooltip, mouseX, mouseY);
    }

    @Override
    public void setFocused(boolean b) {

    }

    @Override
    public boolean isFocused() {
        return false;
    }
}
