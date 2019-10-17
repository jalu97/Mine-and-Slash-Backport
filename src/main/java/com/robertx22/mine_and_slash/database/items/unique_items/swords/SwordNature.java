package com.robertx22.mine_and_slash.database.items.unique_items.swords;

import com.robertx22.mine_and_slash.database.items.unique_items.StatReq;
import com.robertx22.mine_and_slash.database.items.unique_items.bases.BaseUniqueSword;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.LifestealFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalAttackDamageFlat;
import com.robertx22.mine_and_slash.database.stats.mods.percent.LifestealPercent;
import com.robertx22.mine_and_slash.saveclasses.player_stat_points.LvlPointStat;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.localization.Styles;

import java.util.Arrays;
import java.util.List;

public class SwordNature extends BaseUniqueSword {
    public SwordNature() {

    }

    static StatReq req = new StatReq(LvlPointStat.VITALITY, StatReq.Size.NORMAL);

    @Override
    public StatReq getRequirements() {
        return req;
    }

    @Override
    public int Tier() {
        return 2;
    }

    @Override
    public String GUID() {
        return "swordnature0";
    }

    @Override
    public List<StatMod> uniqueStats() {
        return Arrays.asList(new LifestealFlat(), new LifestealPercent());
    }

    @Override
    public List<StatMod> primaryStats() {
        return Arrays.asList(new ElementalAttackDamageFlat(Elements.Nature));
    }

    @Override
    public String locNameForLangFile() {
        return Styles.YELLOW + "Sword of the Nature Spirit";
    }

    @Override
    public String locDescForLangFile() {
        return "Forever lasting.";
    }
}
