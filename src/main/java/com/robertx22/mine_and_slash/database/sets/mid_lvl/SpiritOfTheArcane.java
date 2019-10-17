package com.robertx22.mine_and_slash.database.sets.mid_lvl;

import com.robertx22.mine_and_slash.database.requirements.LevelRequirement;
import com.robertx22.mine_and_slash.database.requirements.Requirements;
import com.robertx22.mine_and_slash.database.requirements.SlotRequirement;
import com.robertx22.mine_and_slash.database.sets.Set;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.offense.SpellDamageFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.MagicShieldFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.ManaFlat;

import java.util.HashMap;

public class SpiritOfTheArcane extends Set {

    @Override
    public String locNameForLangFile() {
        return "Spirit of the Arcane";
    }

    @Override
    public HashMap<Integer, StatMod> AllMods() {

        return new HashMap<Integer, StatMod>() {
            {
                {
                    put(2, new ManaFlat());
                    put(3, new MagicShieldFlat().multi(0.5F));
                    put(4, new SpellDamageFlat());

                }
            }
        };
    }

    @Override
    public Requirements requirements() {
        return new Requirements(SlotRequirement.jewerlyOnly(), LevelRequirement.midLVLOnly());
    }

    @Override
    public String GUID() {
        return "spirit_of_the_arcane";
    }
}
