package net.pixeldreamstudios.passiveskilltreeadditions;

import com.mojang.logging.LogUtils;
import daripher.skilltree.attribute.event.AttributeEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.pixeldreamstudios.passiveskilltreeadditions.client.PassiveSkillTreeAdditionsClient;
import org.slf4j.Logger;

@Mod(PassiveSkillTreeAdditions.MODID)
public class PassiveSkillTreeAdditions
{
    public static final String MODID = "passiveskilltreeadditions";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PassiveSkillTreeAdditions() {
        LOGGER.info("Hello from Passive Skill Tree Additions!");
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        MinecraftForge.EVENT_BUS.register(new AttributeEvents());
        if (FMLEnvironment.dist.isClient()) {
            MinecraftForge.EVENT_BUS.register(new PassiveSkillTreeAdditionsClient());
            FMLJavaModLoadingContext.get().getModEventBus().register(PassiveSkillTreeAdditionsClient.class);
        }

    }
}
