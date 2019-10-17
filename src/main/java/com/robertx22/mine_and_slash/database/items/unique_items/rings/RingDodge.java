package com.robertx22.mine_and_slash.database.items.unique_items.rings;

import com.robertx22.mine_and_slash.database.items.unique_items.StatReq;
import com.robertx22.mine_and_slash.database.items.unique_items.bases.BaseUniqueRing;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.DodgeRatingFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.HealthFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalResistFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.WeaponDamageFlat;
import com.robertx22.mine_and_slash.database.stats.mods.percent.DodgePercent;
import com.robertx22.mine_and_slash.saveclasses.player_stat_points.LvlPointStat;
import com.robertx22.mine_and_slash.uncommon.effectdatas.interfaces.WeaponTypes;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.IRarity;
import com.robertx22.mine_and_slash.uncommon.localization.Styles;

import java.util.Arrays;
import java.util.List;

public class RingDodge extends BaseUniqueRing {

    public RingDodge() {

    }

    static StatReq req = new StatReq(LvlPointStat.DEXTERITY, StatReq.Size.NORMAL);

    @Override
    public StatReq getRequirements() {
        return req;
    }

    @Override
    public int Tier() {
        return 1;
    }

    @Override
    public String GUID() {
        return "ringdodge0";
    }

    @Override
    public List<StatMod> uniqueStats() {
        return Arrays.asList(new DodgeRatingFlat(), new DodgePercent(), new ElementalResistFlat(Elements.Nature), new WeaponDamageFlat(WeaponTypes.Bow));
    }

    @Override
    public List<StatMod> primaryStats() {
        return Arrays.asList(new HealthFlat());
    }

    @Override
    public int getRarityRank() {
        return IRarity.Legendary;
    }

    @Override
    public String locNameForLangFile() {
        return Styles.YELLOW + "Ring of Swiftness";
    }

    @Override
    public String locDescForLangFile() {
        return "Swift as the Wind.";
    }
}
