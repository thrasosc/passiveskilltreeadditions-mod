package net.pixeldreamstudios.passiveskilltreeadditions.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfig {
    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;

    static {
        final Pair<Client, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static class Client {
        public final ForgeConfigSpec.IntValue buttonX;
        public final ForgeConfigSpec.IntValue buttonY;

        public Client(ForgeConfigSpec.Builder builder) {
            builder.push("Button Settings");

            buttonX = builder
                    .comment("X position of the Passive Skill Tree button in the inventory screen")
                    .defineInRange("buttonX", 189, 0, Integer.MAX_VALUE);

            buttonY = builder
                    .comment("Y position of the Passive Skill Tree button in the inventory screen")
                    .defineInRange("buttonY", 105, 0, Integer.MAX_VALUE);

            builder.pop();
        }
    }
}
