package com.robertx22.mine_and_slash.database.stats.mods.percent.much_less;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.types.offense.CriticalHit;
import com.robertx22.mine_and_slash.uncommon.enumclasses.StatTypes;

public class CrippleCriticalHitPercent extends StatMod {

    public CrippleCriticalHitPercent() {
    }

    @Override
    public String GUID() {
        return "CrippleCriticalHitPercent";

    }

    @Override
    public float Min() {
        return -25;
    }

    @Override
    public float Max() {
        return -50;
    }

    @Override
    public StatTypes Type() {
        return StatTypes.Percent;
    }

    @Override
    public Stat GetBaseStat() {
        return CriticalHit.INSTANCE;
    }

}