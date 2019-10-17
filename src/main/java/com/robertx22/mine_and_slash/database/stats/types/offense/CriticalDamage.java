package com.robertx22.mine_and_slash.database.stats.types.offense;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.effects.offense.CriticalDamageEffect;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.interfaces.IStatEffect;
import com.robertx22.mine_and_slash.uncommon.interfaces.IStatEffects;

public class CriticalDamage extends Stat implements IStatEffects {

    public static Stat INSTANCE = new CriticalDamage();
    public static String GUID = "Critical Damage";

    @Override
    public StatGroup statGroup() {
        return StatGroup.Damage;
    }

    @Override
    public String locDescForLangFile() {
        return "If Critical, multiply by x";
    }

    @Override
    public String getIconPath() {
        return "crit_dmg";
    }

    @Override
    public IStatEffect getEffect() {
        return new CriticalDamageEffect();
    }

    private CriticalDamage() {
        this.BaseFlat = 20;
        this.minimumValue = 0;
    }

    @Override
    public String GUID() {
        return GUID;
    }

    @Override
    public boolean ScalesToLevel() {
        return false;
    }

    @Override
    public Elements Element() {
        return null;
    }

    @Override
    public boolean IsPercent() {
        return true;
    }

    @Override
    public String locNameForLangFile() {
        return "Critical Damage";
    }
}
