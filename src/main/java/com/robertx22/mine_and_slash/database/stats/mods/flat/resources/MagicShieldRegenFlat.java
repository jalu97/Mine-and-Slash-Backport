package com.robertx22.mine_and_slash.database.stats.mods.flat.resources;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.types.resources.MagicShieldRegen;
import com.robertx22.mine_and_slash.uncommon.enumclasses.StatTypes;

public class MagicShieldRegenFlat extends StatMod {

    public MagicShieldRegenFlat() {
    }

    @Override
    public String GUID() {
        return "magic_shield_regen_flat";
    }

    @Override
    public float Min() {
        return 1;
    }

    @Override
    public float Max() {
        return 2.5F;
    }

    @Override
    public StatTypes Type() {
        return StatTypes.Flat;
    }

    @Override
    public Stat GetBaseStat() {
        return MagicShieldRegen.INSTANCE;
    }

}
