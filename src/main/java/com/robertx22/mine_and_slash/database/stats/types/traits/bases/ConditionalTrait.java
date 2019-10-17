package com.robertx22.mine_and_slash.database.stats.types.traits.bases;

import com.robertx22.mine_and_slash.database.stats.IUsableStat;
import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.Trait;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap;

public abstract class ConditionalTrait extends Trait {

    enum MoreOrLess {
        More,
        Less
    }

    public abstract Stat stat();

    public abstract int amount();

    public abstract boolean isPercent();

    public abstract MoreOrLess moreOrLess();

    @Override
    public boolean condition(EntityCap.UnitData unit) {

        float val = unit.getUnit().getStat(stat()).Flat;

        if (stat() instanceof IUsableStat) {
            IUsableStat usable = (IUsableStat) stat();
            val = usable.GetUsableValue(unit.getLevel(), (int) val);
        }

        if (moreOrLess().equals(MoreOrLess.More)) {
            return val > amount();
        } else {
            return val < amount();
        }
    }

    @Override
    public String locDescForLangFile() {

        String desc = "If " + stat().locNameForLangFile() + " is " + moreOrLess().name() + " than " + amount();

        if (isPercent()) {
            desc += " Percent";
        }

        return desc;

    }

}
