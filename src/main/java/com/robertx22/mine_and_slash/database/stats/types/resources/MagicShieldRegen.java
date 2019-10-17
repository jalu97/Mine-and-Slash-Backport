package com.robertx22.mine_and_slash.database.stats.types.resources;

import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import net.minecraft.util.text.TextFormatting;

public class MagicShieldRegen extends BaseRegenClass {

    public static MagicShieldRegen INSTANCE = new MagicShieldRegen();
    public static String GUID = "magic_shield_regen";

    private MagicShieldRegen() {

    }

    @Override
    public String getIconPath() {
        return "regen/magic_shield_regen";
    }

    @Override
    public TextFormatting getIconFormat() {
        return TextFormatting.BLUE;
    }

    @Override
    public String getIcon() {
        return "\u0E51";
    }

    @Override
    public StatGroup statGroup() {
        return StatGroup.Main;
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
    public Elements Element() {
        return null;
    }

    @Override
    public boolean IsPercent() {
        return false;
    }

    @Override
    public String locNameForLangFile() {
        return "Magic Shield Regen";
    }
}
