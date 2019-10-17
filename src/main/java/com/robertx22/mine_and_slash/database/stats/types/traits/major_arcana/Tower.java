package com.robertx22.mine_and_slash.database.stats.types.traits.major_arcana;

import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.MajorArmorFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.corestats.VitalityFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalResistFlat;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;

import java.util.Arrays;
import java.util.List;

public class Tower extends BaseMajorArcana {

    public static final String GUID = "Tower";

    @Override
    public String GUID() {
        return GUID;
    }

    @Override
    public List<StatMod> getStats() {
        return Arrays.asList(new VitalityFlat(), new MajorArmorFlat(), new ElementalResistFlat(Elements.Fire));
    }

    @Override
    public String locNameForLangFile() {
        return "Tower";
    }
}
