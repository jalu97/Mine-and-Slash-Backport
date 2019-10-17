package com.robertx22.mine_and_slash.database.stats.types.traits.major_arcana;

import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.corestats.StaminaFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.EnergyRegenFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalSpellDamagePercent;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;

import java.util.Arrays;
import java.util.List;

public class StrengthArcana extends BaseMajorArcana {

    public static final String GUID = "StrengthArcana";

    @Override
    public String GUID() {
        return GUID;
    }

    @Override
    public List<StatMod> getStats() {
        return Arrays.asList(new StaminaFlat().multi(2), new EnergyRegenFlat(), new ElementalSpellDamagePercent(Elements.Fire));
    }

    @Override
    public String locNameForLangFile() {
        return "Strength";
    }

}
