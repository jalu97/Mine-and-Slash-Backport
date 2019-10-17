package com.robertx22.mine_and_slash.database.gearitemslots.bases;

import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.HealthFlat;

import java.util.Arrays;
import java.util.List;

public abstract class BaseArmor extends GearItemSlot {

    @Override
    public final int Weight() {
        return super.Weight() / 3;
    }

    @Override
    public List<StatMod> PrimaryStats() {
        return Arrays.asList(new HealthFlat());
    }

    @Override
    public GearSlotType slotType() {
        return GearSlotType.Armor;
    }
}
