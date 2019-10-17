package com.robertx22.mine_and_slash.database.sets.from_lvl_50;

import com.robertx22.mine_and_slash.database.requirements.LevelRequirement;
import com.robertx22.mine_and_slash.database.requirements.Requirements;
import com.robertx22.mine_and_slash.database.requirements.SlotRequirement;
import com.robertx22.mine_and_slash.database.sets.Set;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.ArmorFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.corestats.VitalityFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.HealthFlat;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.IRarity;

import java.util.HashMap;

public class TheAscended extends Set {

    @Override
    public String locNameForLangFile() {
        return "The Ascended";
    }

    @Override
    public HashMap<Integer, StatMod> AllMods() {

        return new HashMap<Integer, StatMod>() {
            {
                {
                    put(2, new ArmorFlat());
                    put(3, new VitalityFlat().multi(2));
                    put(4, new HealthFlat());
                }
            }
        };
    }

    @Override
    public int getRarityRank() {
        return IRarity.Epic;
    }

    @Override
    public Requirements requirements() {
        return new Requirements(SlotRequirement.armorsOnlyNoOffHand(), LevelRequirement.fromLVL50());
    }

    @Override
    public String GUID() {
        return "the_ascended";
    }
}
