package net.pixeldreamstudios.passiveskilltreeadditions.client;

import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PassiveSkillTreeAdditionsClient {
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void addAttribComponent(ScreenEvent.Init.Post e) {
        if (e.getScreen() instanceof InventoryScreen scn) {
            var atrComp = new PassiveSkillTreeAdditionsGui(scn);
            e.addListener(atrComp);
            e.addListener(atrComp.toggleBtn);
        }
    }
}
