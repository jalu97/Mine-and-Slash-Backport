package com.robertx22.mine_and_slash.database.stats.mods.flat.resources;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.types.resources.Energy;
import com.robertx22.mine_and_slash.uncommon.enumclasses.StatTypes;

public class EnergyFlat extends StatMod {

    public EnergyFlat() {
    }

    @Override
    public String GUID() {
        return "EnergyFlat";
    }

    @Override
    public float Min() {
        return 5;
    }

    @Override
    public float Max() {
        return 25;
    }

    @Override
    public StatTypes Type() {
        return StatTypes.Flat;
    }

    @Override
    public Stat GetBaseStat() {
        return Energy.INSTANCE;
    }

}
