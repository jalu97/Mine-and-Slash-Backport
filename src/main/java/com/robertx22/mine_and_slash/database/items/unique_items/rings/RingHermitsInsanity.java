package com.robertx22.mine_and_slash.database.items.unique_items.rings;

import com.robertx22.mine_and_slash.database.items.unique_items.StatReq;
import com.robertx22.mine_and_slash.database.items.unique_items.bases.BaseUniqueRing;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalPeneFlat;
import com.robertx22.mine_and_slash.database.stats.mods.map_mods.minus.LessHealthMap;
import com.robertx22.mine_and_slash.database.stats.mods.percent.offense.CriticalDamagePercent;
import com.robertx22.mine_and_slash.saveclasses.player_stat_points.LvlPointStat;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.IRarity;
import com.robertx22.mine_and_slash.uncommon.localization.Styles;

import java.util.Arrays;
import java.util.List;

public class RingHermitsInsanity extends BaseUniqueRing {

    static StatReq req = new StatReq(LvlPointStat.STRENGTH, StatReq.Size.MEDIUM, LvlPointStat.INTELLIGENCE, StatReq.Size.MEDIUM);

    @Override
    public StatReq getRequirements() {
        return req;
    }

    @Override
    public int Tier() {
        return 4;
    }

    @Override
    public String GUID() {
        return "ring_hermit_insanity";
    }

    @Override
    public int getRarityRank() {
        return IRarity.Mythic;
    }

    @Override
    public List<StatMod> uniqueStats() {
        return Arrays.asList(new LessHealthMap(), new CriticalDamagePercent().multi(7));
    }

    @Override
    public List<StatMod> primaryStats() {
        return Arrays.asList(new ElementalPeneFlat(Elements.Elemental).multi(3));
    }

    @Override
    public String locNameForLangFile() {
        return Styles.YELLOW + "Hermit's Ring of Insanity";
    }

    @Override
    public String locDescForLangFile() {
        return "Stop! Don't approach me..";
    }

}
