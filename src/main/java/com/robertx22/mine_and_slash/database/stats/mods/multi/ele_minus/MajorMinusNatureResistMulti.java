package com.robertx22.mine_and_slash.database.stats.mods.multi.ele_minus;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.types.generated.ElementalResist;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;

public class MajorMinusNatureResistMulti extends BaseMajorEleResistMinus {

    public MajorMinusNatureResistMulti() {
    }

    @Override
    public String GUID() {
        return "MajorMinusNatureResistMulti";
    }

    @Override
    public Stat GetBaseStat() {
        return new ElementalResist(Elements.Nature);
    }

}