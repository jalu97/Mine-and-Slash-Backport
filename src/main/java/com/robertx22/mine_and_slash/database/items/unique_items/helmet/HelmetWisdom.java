package com.robertx22.mine_and_slash.database.items.unique_items.helmet;

import com.robertx22.mine_and_slash.database.gearitemslots.bases.GearItemSlot;
import com.robertx22.mine_and_slash.database.gearitemslots.cloth.ClothHelmet;
import com.robertx22.mine_and_slash.database.items.unique_items.StatReq;
import com.robertx22.mine_and_slash.database.items.unique_items.bases.BaseUniqueHelmet;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.ArmorFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.corestats.WisdomFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.MagicShieldFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.ManaOnHitFlat;
import com.robertx22.mine_and_slash.saveclasses.player_stat_points.LvlPointStat;
import com.robertx22.mine_and_slash.uncommon.localization.Styles;

import java.util.Arrays;
import java.util.List;

public class HelmetWisdom extends BaseUniqueHelmet {

    public static HelmetWisdom INSTANCE = new HelmetWisdom();

    private HelmetWisdom() {

    }

    static StatReq req = new StatReq(LvlPointStat.WISDOM, StatReq.Size.NORMAL);

    @Override
    public StatReq getRequirements() {
        return req;
    }

    @Override
    public boolean canGetSet() {
        return true;
    }

    @Override
    public int Tier() {
        return 12;
    }

    @Override
    public String GUID() {
        return "helmetwisdom0";
    }

    @Override
    public List<StatMod> uniqueStats() {
        return Arrays.asList(new WisdomFlat(), new ArmorFlat(), new ManaOnHitFlat().multi(2));
    }

    @Override
    public List<StatMod> primaryStats() {
        return Arrays.asList(new MagicShieldFlat());
    }

    @Override
    public GearItemSlot getGearSlot() {
        return ClothHelmet.INSTANCE;
    }

    @Override
    public String locNameForLangFile() {
        return Styles.YELLOW + "Helmet of Wisdom";
    }

    @Override
    public String locDescForLangFile() {
        return "True wisdom is knowing you know nothing.";
    }

}
