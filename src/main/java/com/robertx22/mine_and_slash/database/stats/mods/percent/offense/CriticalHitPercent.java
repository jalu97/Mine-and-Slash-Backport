package com.robertx22.mine_and_slash.database.stats.mods.percent.offense;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.types.offense.CriticalHit;
import com.robertx22.mine_and_slash.uncommon.enumclasses.StatTypes;

public class CriticalHitPercent extends StatMod {

    public CriticalHitPercent() {
    }

    @Override
    public String GUID() {
        return "CriticalHitPercent";

    }

    @Override
    public float Min() {
        return 3;

    }

    @Override
    public float Max() {
        return 15;
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
