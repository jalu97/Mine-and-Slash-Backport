package com.robertx22.mine_and_slash.database.items.unique_items.boots;

import com.robertx22.mine_and_slash.database.items.unique_items.StatReq;
import com.robertx22.mine_and_slash.database.items.unique_items.bases.BaseUniqueBoots;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.HealthFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalResistFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalSpellToAttackDMGFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.WeaponDamageFlat;
import com.robertx22.mine_and_slash.database.stats.mods.percent.offense.CriticalDamagePercent;
import com.robertx22.mine_and_slash.saveclasses.player_stat_points.LvlPointStat;
import com.robertx22.mine_and_slash.uncommon.effectdatas.interfaces.WeaponTypes;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.localization.Styles;

import java.util.Arrays;
import java.util.List;

public class BootsThunder extends BaseUniqueBoots {

    public BootsThunder() {

    }

    static StatReq req = new StatReq(LvlPointStat.VITALITY, StatReq.Size.MEDIUM);

    @Override
    public StatReq getRequirements() {
        return req;
    }

    @Override
    public int Tier() {
        return 19;
    }

    @Override
    public String GUID() {
        return "bootsthunder0";
    }

    @Override
    public List<StatMod> uniqueStats() {
        return Arrays.asList(new WeaponDamageFlat(WeaponTypes.Hammer), new ElementalSpellToAttackDMGFlat(Elements.Thunder), new CriticalDamagePercent(), new ElementalResistFlat(Elements.Thunder));
    }

    @Override
    public List<StatMod> primaryStats() {
        return Arrays.asList(new HealthFlat());
    }

    @Override
    public String locNameForLangFile() {
        return Styles.YELLOW + "Lightning Tendril Boots";
    }

    @Override
    public String locDescForLangFile() {
        return "Sparks fly wherever I stand.";
    }
}
