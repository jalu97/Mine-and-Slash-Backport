package com.robertx22.mine_and_slash.database.stats.types.resources;

import net.minecraft.util.text.TextFormatting;

public class ManaRegen extends BaseRegenClass {
    public static String GUID = "Mana Regen";

    public static final ManaRegen INSTANCE = new ManaRegen();

    @Override
    public TextFormatting getIconFormat() {
        return TextFormatting.AQUA;
    }

    @Override
    public String getIcon() {
        return "\u0E51";
    }

    @Override
    public String getIconPath() {
        return "regen/mana_regen";
    }

    @Override
    public StatGroup statGroup() {
        return StatGroup.Main;
    }

    private ManaRegen() {
        this.minimumValue = 0;
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
        return "Mana Regen";
    }
}
