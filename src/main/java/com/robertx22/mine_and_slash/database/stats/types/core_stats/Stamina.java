package com.robertx22.mine_and_slash.database.stats.types.core_stats;

import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.ArmorFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.EnergyFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.EnergyRegenFlat;
import com.robertx22.mine_and_slash.database.stats.mods.percent.ArmorPercent;

import java.util.Arrays;
import java.util.List;

public class Stamina extends BaseCoreStat {

    public static final String GUID = "Stamina";
    public static Stamina INSTANCE = new Stamina();

    private Stamina() {

    }

    @Override
    public String getIconPath() {
        return "core/sta";
    }

    @Override
    public String locDescForLangFile() {
        return "Increases Energy, Energy Regen, Armor and Armor Percent";
    }

    @Override
    public String GUID() {
        return GUID;
    }

    @Override
    public List<StatMod> statsThatBenefit() {
        return Arrays.asList(new EnergyRegenFlat().multi(0.4F), new EnergyFlat().multi(1.25F), new ArmorFlat()
                .multi(0.75F), new ArmorPercent());
    }

    @Override
    public String locNameForLangFile() {
        return "Stamina";
    }
}
