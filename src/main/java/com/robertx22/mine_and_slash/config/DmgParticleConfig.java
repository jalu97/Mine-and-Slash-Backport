package com.robertx22.mine_and_slash.config;

import net.minecraftforge.client.gui.ForgeGuiFactory.ForgeConfigGui;
import net.minecraftforge.common.config.Config;

public class DmgParticleConfig {

    public Boolean ENABLE_FLOATING_EXP;
    public Boolean ENABLE_FLOATING_DMG;

    public Double GRAVITY;
    public Double START_SIZE;
    public Double MAX_SIZE;
    public Double LIFESPAN;
    public Double SPEED;

    public Boolean GROWS;

    public DmgParticleConfig() {
    	
    	@Config.Name("Render Item On Ground Rarity Particles")
    	@Config.LangKey("mmorpg.config.floating_exp")
    	@Config.Comment(".")
    	public boolean ENABLE_FLOATING_EXP = true;

        GRAVITY = builder.define("GRAVITY", 0.15D);
        START_SIZE = builder.define("START_SIZE", 1D);
        MAX_SIZE = builder.define("MAX_SIZE", 2D);
        LIFESPAN = builder.define("LIFESPAN", 12D);
        SPEED = builder.define("SPEED", 0.5D);

        GROWS = builder.define("GROWS", true);

        ENABLE_FLOATING_EXP = builder.comment(".")
                .translation("mmorpg.config.floating_exp")
                .define("ENABLE_FLOATING_EXP", true);

        ENABLE_FLOATING_DMG = builder.comment(".")
                .translation("mmorpg.config.floating_damage_numbers")
                .define("ENABLE_FLOATING_DMG", true);

        builder.pop();
    }

}
