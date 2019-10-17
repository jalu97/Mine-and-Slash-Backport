package com.robertx22.mine_and_slash.database.stats.mods.percent.much_less;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.types.defense.DodgeRating;
import com.robertx22.mine_and_slash.uncommon.enumclasses.StatTypes;

public class CrippleDodgePercent extends StatMod {

    public CrippleDodgePercent() {
    }

    @Override
    public String GUID() {
        return "CrippleDodgePercent";

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
        return DodgeRating.INSTANCE;
    }

}