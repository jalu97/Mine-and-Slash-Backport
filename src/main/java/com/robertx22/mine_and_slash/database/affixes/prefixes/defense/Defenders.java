package com.robertx22.mine_and_slash.database.affixes.prefixes.defense;

import com.robertx22.mine_and_slash.database.affixes.Prefix;
import com.robertx22.mine_and_slash.database.requirements.Requirements;
import com.robertx22.mine_and_slash.database.requirements.SlotRequirement;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.percent.BlockStrengthPercent;

import java.util.Arrays;
import java.util.List;

public class Defenders extends Prefix {

    public Defenders() {
        super(new Requirements(SlotRequirement.shield()));
    }

    @Override
    public String GUID() {
        return "defenders";
    }

    @Override
    public List<StatMod> StatMods() {
        return Arrays.asList(new BlockStrengthPercent());
    }

    @Override
    public String locNameForLangFile() {
        return "Defender's";
    }
}

