package com.robertx22.mine_and_slash.database.runewords.slots_4;

import com.robertx22.mine_and_slash.database.runewords.RuneWord;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.AllTraitMods;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.EnergyRegenFlat;
import com.robertx22.mine_and_slash.database.stats.mods.percent.DodgePercent;
import com.robertx22.mine_and_slash.database.stats.types.spell_buff_traits.BuffEnergyRegenTrait;
import com.robertx22.mine_and_slash.database.items.runes.BerItem;
import com.robertx22.mine_and_slash.database.items.runes.ItaItem;
import com.robertx22.mine_and_slash.database.items.runes.VohItem;
import com.robertx22.mine_and_slash.database.items.runes.XahItem;
import com.robertx22.mine_and_slash.database.items.runes.base.BaseRuneItem;

import java.util.Arrays;
import java.util.List;

public class RuneWordLimitless extends RuneWord {

    @Override
    public List<StatMod> mods() {
        return Arrays.asList(new AllTraitMods(new BuffEnergyRegenTrait()), new EnergyRegenFlat(), new DodgePercent());
    }

    @Override
    public String GUID() {
        return "Limitless";
    }

    @Override
    public List<BaseRuneItem> runes() {
        return Arrays.asList(new VohItem(0), new ItaItem(0), new BerItem(0), new XahItem(0));
    }

    @Override
    public String locNameForLangFile() {
        return "Limitless";
    }
}
