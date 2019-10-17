package com.robertx22.mine_and_slash.database.stats.types.core_stats;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.saveclasses.StatData;
import com.robertx22.mine_and_slash.saveclasses.gearitem.StatModData;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.TooltipInfo;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.localization.Styles;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.StatUtils;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseCoreStat extends Stat implements ICoreStat {

    @Override
    public StatGroup statGroup() {
        return StatGroup.CoreStat;
    }

    @Override
    public boolean IsPercent() {
        return false;
    }

    @Override
    public boolean ScalesToLevel() {
        return true;
    }

    @Override
    public Elements Element() {
        return null;
    }

    @Override
    public float amountToReach100Percent() {
        return 10;
    }

    @Override
    public float calculateScalingStatGrowth(float stat, int lvl) {
        return StatUtils.calculateBaseStatScalingStatGrowth(stat, lvl);
    }

    public float getPercent(EntityCap.UnitData unitdata, StatData data) {
        return MathHelper.clamp(data.Value / calculateScalingStatGrowth(this.amountToReach100Percent(), unitdata
                .getLevel()) * 100, 0, 100000);
    }

    public List<ITextComponent> getCoreStatTooltip(EntityCap.UnitData unitdata,
                                                   StatData data) {

        TooltipInfo info = new TooltipInfo(unitdata, null, unitdata.getLevel());

        List<ITextComponent> list = new ArrayList<>();
        list.add(Styles.GREENCOMP().appendText("Stats that benefit: "));
        getMods(unitdata, data).forEach(x -> list.addAll(x.GetTooltipString(info)));
        return list;

    }

    public List<StatModData> getMods(EntityCap.UnitData unitdata, StatData data) {
        return this.statsThatBenefit()
                .stream()
                .map(x -> StatModData.Load(x, (int) getPercent(unitdata, data)).noMin())
                .collect(Collectors.toList());

    }

    @Override
    public void addToOtherStats(EntityCap.UnitData unitdata, StatData data) {
        getMods(unitdata, data).forEach(x -> x.useOnPlayer(unitdata));
    }

}


