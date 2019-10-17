package com.robertx22.mine_and_slash.database.items.unique_items.bows;

import com.robertx22.mine_and_slash.database.items.unique_items.IElementalUnique;
import com.robertx22.mine_and_slash.database.items.unique_items.IUnique;
import com.robertx22.mine_and_slash.database.items.unique_items.StatReq;
import com.robertx22.mine_and_slash.database.items.unique_items.bases.BaseUniqueBow;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.corestats.DexterityFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalAttackDamageFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalSpellToAttackDMGFlat;
import com.robertx22.mine_and_slash.database.stats.mods.percent.offense.CriticalHitPercent;
import com.robertx22.mine_and_slash.saveclasses.player_stat_points.LvlPointStat;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.localization.Styles;

import java.util.Arrays;
import java.util.List;

public class BowElemental extends BaseUniqueBow implements IElementalUnique {

    public BowElemental(Elements element) {
        this.element = element;
    }

    Elements element;

    @Override
    public List<StatMod> uniqueStats() {
        return Arrays.asList(new DexterityFlat().multi(1.5F), new ElementalSpellToAttackDMGFlat(element), new CriticalHitPercent()
                .multi(2));
    }

    static StatReq req = new StatReq(LvlPointStat.DEXTERITY, StatReq.Size.NORMAL);

    @Override
    public StatReq getRequirements() {
        return req;
    }

    @Override
    public List<StatMod> primaryStats() {
        return Arrays.asList(new ElementalAttackDamageFlat(element));
    }

    @Override
    public String GUID() {
        return "bow_" + element.guidName + "0";
    }

    @Override
    public int Tier() {
        return 10;
    }

    @Override
    public String locNameForLangFile() {
        return Styles.YELLOW + "Bow of " + element.name() + " Affinity";
    }

    @Override
    public String locDescForLangFile() {
        return "Aim steady, imbue with " + element.dmgName + "!";
    }

    @Override
    public IUnique newInstance(Elements element) {
        return new BowElemental(element);
    }

}
