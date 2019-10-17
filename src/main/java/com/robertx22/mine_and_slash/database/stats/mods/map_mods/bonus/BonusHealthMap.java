package com.robertx22.mine_and_slash.database.stats.mods.map_mods.bonus;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.types.resources.Health;
import com.robertx22.mine_and_slash.uncommon.enumclasses.StatTypes;

public class BonusHealthMap extends StatMod {

    public BonusHealthMap() {
    }

    @Override
    public String GUID() {
        return "BonusHealthMap";
    }

    @Override
    public float Min() {
        return 0;
    }

    @Override
    public float Max() {
        return 50;
    }

    @Override
    public StatTypes Type() {
        return StatTypes.Flat;
    }

    @Override
    public Stat GetBaseStat() {
        return Health.INSTANCE;
    }

}