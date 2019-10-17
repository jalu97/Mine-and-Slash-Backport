package com.robertx22.mine_and_slash.database.runewords.slots_3;

import com.robertx22.mine_and_slash.database.runewords.RuneWord;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.ManaOnHitFlat;
import com.robertx22.mine_and_slash.database.stats.mods.percent.ManaRegenPercent;
import com.robertx22.mine_and_slash.database.items.runes.ItaItem;
import com.robertx22.mine_and_slash.database.items.runes.MosItem;
import com.robertx22.mine_and_slash.database.items.runes.RahItem;
import com.robertx22.mine_and_slash.database.items.runes.base.BaseRuneItem;

import java.util.Arrays;
import java.util.List;

public class RuneWordRadiance extends RuneWord {

    @Override
    public List<StatMod> mods() {
        return Arrays.asList(new ManaOnHitFlat(), new ManaRegenPercent());
    }

    @Override
    public String GUID() {
        return "Radiance";
    }

    @Override
    public List<BaseRuneItem> runes() {

        return Arrays.asList(new ItaItem(0), new MosItem(0), new RahItem(0));

    }

    @Override
    public String locNameForLangFile() {
        return "Radiance";
    }
}