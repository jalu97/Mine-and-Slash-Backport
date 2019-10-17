package com.robertx22.mine_and_slash.database.stats.types.traits.major_arcana;

import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.corestats.WisdomFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.offense.CriticalHitFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalSpellDamageFlat;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;

import java.util.Arrays;
import java.util.List;

public class Hermit extends BaseMajorArcana {

    public static final String GUID = "Hermit";

    @Override
    public String GUID() {
        return GUID;
    }

    @Override
    public List<StatMod> getStats() {
        return Arrays.asList(new WisdomFlat(), new CriticalHitFlat().multi(2), new ElementalSpellDamageFlat(Elements.Nature));
    }

    @Override
    public String locNameForLangFile() {
        return "The Hermit";
    }
}
