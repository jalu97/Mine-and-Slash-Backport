package com.robertx22.mine_and_slash.database.stats.types.traits.major_arcana;

import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.LifestealFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalPeneFlat;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;

import java.util.Arrays;
import java.util.List;

public class Judgement extends BaseMajorArcana {

    public static final String GUID = "Judgement";

    @Override
    public String GUID() {
        return GUID;
    }

    @Override
    public List<StatMod> getStats() {
        return Arrays.asList(new ElementalPeneFlat(Elements.Water), new ElementalPeneFlat(Elements.Fire), new LifestealFlat());
    }

    @Override
    public String locNameForLangFile() {
        return "Judgement";
    }
}
