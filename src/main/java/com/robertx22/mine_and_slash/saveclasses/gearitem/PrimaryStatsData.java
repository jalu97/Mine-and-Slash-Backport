package com.robertx22.mine_and_slash.saveclasses.gearitem;

import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.IRerollable;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.ITooltipList;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.TooltipInfo;
import com.robertx22.mine_and_slash.saveclasses.item_classes.GearItemData;
import com.robertx22.mine_and_slash.uncommon.localization.Styles;
import com.robertx22.mine_and_slash.uncommon.localization.Words;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.RandomUtils;
import info.loenwind.autosave.annotations.Storable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import java.util.ArrayList;
import java.util.List;

@Storable
public class PrimaryStatsData extends StatGroupData implements ITooltipList, IRerollable {

    public PrimaryStatsData() {

    }

    @Override
    public void RerollFully(GearItemData gear) {

        this.Mods = new ArrayList<StatModData>();

        if (gear.isUnique()) {
            for (StatMod mod : gear.uniqueStats.getUniqueItem().primaryStats()) {
                StatModData moddata = StatModData.NewRandom(gear.getRarity(), mod);
                this.Mods.add(moddata);
            }

        } else {
            StatMod mod = RandomUtils.weightedRandom(gear.GetBaseGearType()
                    .PrimaryStats());
            StatModData moddata = StatModData.NewRandom(gear.getRarity(), mod);
            this.Mods.add(moddata);
        }
    }

    @Override
    public void RerollNumbers(GearItemData gear) {

        for (StatModData data : this.Mods) {
            data.setPercent(gear.getRarity().StatPercents().genPercent());
        }

    }

    @Override
    public List<ITextComponent> GetTooltipString(TooltipInfo info) {

        List<ITextComponent> list = new ArrayList<ITextComponent>();

        if (info.verbose) {
            list.add(Styles.GRAYCOMP()
                    .appendSibling(Words.Primary_Stats.locName().appendText(":")));

        }

        list.add(new StringTextComponent(" "));

        info.usePrettyStatSymbols = true;

        for (LevelAndStats part : this.GetAllStats(info.level)) {
            for (StatModData data : part.mods) {
                list.addAll(data.GetTooltipString(info));
            }
        }
        info.usePrettyStatSymbols = false;

        return list;

    }

}
