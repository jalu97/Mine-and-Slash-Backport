package com.robertx22.mine_and_slash.config;

import com.robertx22.mine_and_slash.a_libraries.neat_mob_overlay.NeatConfig;
import com.robertx22.mine_and_slash.uncommon.enumclasses.PlayerGUIs;

import net.minecraftforge.client.gui.ForgeGuiFactory.ForgeConfigGui;
import net.minecraftforge.common.config.Config;
import scala.Int;

import org.apache.commons.lang3.tuple.Pair;

public class ClientContainer {
	
	public static final String NAME = "CLIENT";
    
	public NeatConfig neatConfig;
    public DmgParticleConfig dmgParticleConfig;
    
    
	@Config.Name("Render Item On Ground Rarity Particles")
	@Config.LangKey("mmorpg.config.item_on_ground_particles")
	@Config.Comment("Might help with finding gear, but could also be laggy")
	public boolean RENDER_ITEM_ENTITY_RARITY_PARTICLES = false;

	@Config.Name("Render Chat Combat Log")
	@Config.LangKey("mmorpg.config.chat_combat_log")
	@Config.Comment("Show/Disable Chat Damage Numbers")
	public boolean RENDER_CHAT_COMBAT_LOG = false;

	@Config.Name("Show Affixes In Item Names")
	@Config.LangKey("")
	@Config.Comment("")
	public boolean SHOW_AFFIXED_NAME = true;

	@Config.Name("Render Floating Damage Numbers")
	@Config.LangKey("mmorpg.config.floating_damage_numbers")
	@Config.Comment("Show/Disable Floating Damage Numbers when you attack mobs")
	public boolean RENDER_FLOATING_DAMAGE = true;

	@Config.Name("Render Mob Health Bar")
	@Config.LangKey("mmorpg.config.mob_health_bag")
	@Config.Comment("Show/Disable mob health bars")
	public boolean RENDER_MOB_HEALTH_GUI = true;

	@Config.Name("Show Low Ene/Mana Warnings")
	@Config.LangKey("mmorpg.config.low_resource_warnings")
	@Config.Comment("Posts them in chat if you can't cast spell or attakc")
	public boolean SHOW_LOW_ENERGY_MANA_WARNING = false;

	@Config.Name("Show Floating Exp")
	@Config.LangKey("mmorpg.config.floating_exp")
	@Config.Comment("Shows how much exp you got from a mob kill. Can get annoying when you can't see your damage i assume.")
	public boolean SHOW_FLOATING_EXP = false;
	
	@Config.Name("Mob GUI Overlay Toggle")
	@Config.LangKey("mmorpg.config.mob_gui_overlay")
	@Config.Comment("Choose whether or not to show the overhead GUI on mobs showing Level, Rarity, and Health.")
	public boolean SHOW_MOB_GUI = true;
}