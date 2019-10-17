package com.robertx22.mine_and_slash.database.stats.types.resources;

import com.robertx22.mine_and_slash.database.stats.Stat;
import net.minecraft.util.text.TextFormatting;

public class EnergyRegen extends BaseRegenClass {
    public static Stat INSTANCE = new EnergyRegen();
    public static String GUID = "Energy Regen";

    @Override
    public TextFormatting getIconFormat() {
        return TextFormatting.GREEN;
    }

    @Override
    public String getIcon() {
        return "\u0E51";
    }

    @Override
    public String getIconPath() {
        return "regen/energy_regen";
    }

    @Override
    public StatGroup statGroup() {
        return StatGroup.Main;
    }

    private EnergyRegen() {

    }
    
    @Override
    public String GUID() {
        return GUID;
    }

    @Override
    public boolean ScalesToLevel() {
        return true;
    }

    @Override
    public String locNameForLangFile() {
        return "Energy Regen";
    }
}
