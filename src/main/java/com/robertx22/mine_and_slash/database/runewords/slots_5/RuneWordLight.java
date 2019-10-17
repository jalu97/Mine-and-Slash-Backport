package com.robertx22.mine_and_slash.database.runewords.slots_5;

import com.robertx22.mine_and_slash.database.items.runes.*;
import com.robertx22.mine_and_slash.database.items.runes.base.BaseRuneItem;
import com.robertx22.mine_and_slash.database.runewords.RuneWord;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.AllTraitMods;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.HealthFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.HealthRegenFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalResistFlat;
import com.robertx22.mine_and_slash.database.stats.types.spell_buff_traits.LightTrait;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;

import java.util.Arrays;
import java.util.List;

public class RuneWordLight extends RuneWord {

    @Override
    public List<StatMod> mods() {
        return Arrays.asList(new AllTraitMods(new LightTrait()), new HealthRegenFlat(), new HealthFlat()
                .multi(0.7f), new ElementalResistFlat(Elements.Fire));
    }

    @Override
    public String GUID() {
        return "Light";
    }

    @Override
    public List<BaseRuneItem> runes() {
        return Arrays.asList(new ItaItem(0), new AnoItem(0), new DosItem(0), new XahItem(0), new GohItem(0));
    }

    @Override
    public String locNameForLangFile() {
        return "Light";
    }
}
