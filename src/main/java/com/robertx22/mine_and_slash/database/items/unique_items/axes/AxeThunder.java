package com.robertx22.mine_and_slash.database.items.unique_items.axes;

import com.robertx22.mine_and_slash.database.items.unique_items.StatReq;
import com.robertx22.mine_and_slash.database.items.unique_items.bases.BaseUniqueAxe;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalAttackDamageFlat;
import com.robertx22.mine_and_slash.database.stats.mods.percent.much_less.CrippleLifeOnHitPercent;
import com.robertx22.mine_and_slash.database.stats.mods.percent.offense.CriticalDamagePercent;
import com.robertx22.mine_and_slash.database.stats.mods.percent.offense.CriticalHitPercent;
import com.robertx22.mine_and_slash.saveclasses.player_stat_points.LvlPointStat;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.localization.Styles;

import java.util.Arrays;
import java.util.List;

public class AxeThunder extends BaseUniqueAxe {
    public AxeThunder() {

    }

    static StatReq req = new StatReq(LvlPointStat.STRENGTH, StatReq.Size.MEDIUM);

    @Override
    public StatReq getRequirements() {
        return req;
    }

    @Override
    public int Tier() {
        return 11;
    }

    @Override
    public String GUID() {
        return "axethunder0";
    }

    @Override
    public List<StatMod> uniqueStats() {
        return Arrays.asList(new CriticalHitPercent().multi(2.5F), new CriticalDamagePercent()
                .multi(2.5F), new CrippleLifeOnHitPercent());
    }

    @Override
    public List<StatMod> primaryStats() {
        return Arrays.asList(new ElementalAttackDamageFlat(Elements.Thunder));
    }

    @Override
    public String locNameForLangFile() {
        return Styles.YELLOW + "Thunderstorm Axe";
    }

    @Override
    public String locDescForLangFile() {
        return "Sparks fly, heads roll.";
    }
}
