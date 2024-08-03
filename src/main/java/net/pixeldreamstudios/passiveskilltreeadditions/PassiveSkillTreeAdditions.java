package net.pixeldreamstudios.passiveskilltreeadditions;

import com.mojang.logging.LogUtils;
import daripher.skilltree.attribute.event.AttributeEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.pixeldreamstudios.passiveskilltreeadditions.client.PassiveSkillTreeAdditionsClient;
import org.slf4j.Logger;

@Mod(PassiveSkillTreeAdditions.MODID)
public class PassiveSkillTreeAdditions {
    public static final String MODID = "passiveskilltreeadditions";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PassiveSkillTreeAdditions() {
        LOGGER.info("Hello from Passive Skill Tree Additions!");

        // Register the configuration
        ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.CLIENT, net.pixeldreamstudios.passiveskilltreeadditions.config.ModConfig.CLIENT_SPEC);

        // Register event bus
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        MinecraftForge.EVENT_BUS.register(new AttributeEvents());

        if (FMLEnvironment.dist.isClient()) {
            MinecraftForge.EVENT_BUS.register(new PassiveSkillTreeAdditionsClient());
            FMLJavaModLoadingContext.get().getModEventBus().register(PassiveSkillTreeAdditionsClient.class);
        }
    }

    // Setup method called during setup phase
    @SubscribeEvent
    public void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Setting up Passive Skill Tree Additions!");
        // Setup logic here
    }
}
