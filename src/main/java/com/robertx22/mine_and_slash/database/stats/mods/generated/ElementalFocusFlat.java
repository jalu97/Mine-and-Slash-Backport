package com.robertx22.mine_and_slash.database.stats.mods.generated;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.ElementalStatMod;
import com.robertx22.mine_and_slash.database.stats.types.generated.ElementalFocus;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.enumclasses.StatTypes;

public class ElementalFocusFlat extends ElementalStatMod {

    public ElementalFocusFlat(Elements element) {
        super(element);
    }

    @Override
    public Stat GetBaseStat() {
        return new ElementalFocus(this.element);
    }

    @Override
    public float Min() {
        return 10;
    }

    @Override
    public float Max() {
        return 25;
    }

    @Override
    public StatTypes Type() {
        return StatTypes.Flat;
    }

    @Override
    public String GUID() {
        return element.name() + "focus_flat";
    }

    @Override
    public StatMod newGeneratedInstance(Elements element) {
        return new ElementalFocusFlat(element);
    }

}

