package com.robertx22.mine_and_slash.database.rarities.gears;

import com.robertx22.mine_and_slash.config.ModConfig;
import com.robertx22.mine_and_slash.database.MinMax;
import com.robertx22.mine_and_slash.database.rarities.GearRarity;
import com.robertx22.mine_and_slash.database.rarities.base.BaseMythical;

public class MythicalGear extends BaseMythical implements GearRarity {
    @Override
    public float requirementMulti() {
        return 1F;
    }

    @Override
    public int AffixChance() {
        return 100;
    }

    @Override
    public MinMax StatPercents() {
        return new MinMax(35, 100);
    }

    @Override
    public int SetChance() {
        return 60;
    }

    @Override
    public float specialItemChance() {
        return 15.5F;
    }

    @Override
    public int Weight() {
        return ModConfig.INSTANCE.RarityWeightConfig.ITEMS.MYTHICAL_WEIGHT.get();
    }

    @Override
    public int runeSlots() {
        return 5;
    }

    @Override
    public float itemTierPower() {
        return 3;
    }

    @Override
    public float powerMultiplier() {
        return 7F;
    }
}
