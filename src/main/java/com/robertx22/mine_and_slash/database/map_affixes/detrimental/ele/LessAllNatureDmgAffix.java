package com.robertx22.mine_and_slash.database.map_affixes.detrimental.ele;

import com.robertx22.mine_and_slash.database.map_affixes.DetrimentalMapAffix;
import com.robertx22.mine_and_slash.database.stats.mods.map_mods.minus.all_ele_dmg.LessAllNatureDamageMap;
import com.robertx22.mine_and_slash.saveclasses.gearitem.StatModData;

import java.util.Arrays;
import java.util.List;

public class LessAllNatureDmgAffix extends DetrimentalMapAffix {

    @Override
    public String GUID() {
        return "LessAllNatureDmgAffix";
    }

    @Override
    public List<StatModData> Stats(int percent) {
        return Arrays.asList(StatModData.Load(new LessAllNatureDamageMap(), percent));
    }

}
