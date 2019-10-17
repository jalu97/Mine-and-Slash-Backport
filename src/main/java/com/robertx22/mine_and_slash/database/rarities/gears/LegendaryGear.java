package com.robertx22.mine_and_slash.database.rarities.gears;

import com.robertx22.mine_and_slash.config.ModConfig;
import com.robertx22.mine_and_slash.database.MinMax;
import com.robertx22.mine_and_slash.database.rarities.GearRarity;
import com.robertx22.mine_and_slash.database.rarities.base.BaseLegendary;

public class LegendaryGear extends BaseLegendary implements GearRarity {
    @Override
    public float requirementMulti() {
        return 0.8F;
    }

    @Override
    public int AffixChance() {
        return 80;
    }

    @Override
    public MinMax StatPercents() {
        return new MinMax(25, 90);
    }

    @Override
    public int SetChance() {
        return 50;
    }

    @Override
    public float specialItemChance() {
        return 6.5F;
    }

    @Override
    public int Weight() {
        return ModConfig.INSTANCE.RarityWeightConfig.ITEMS.LEGENDARY_WEIGHT.get();
    }

    @Override
    public int runeSlots() {
        return 4;
    }

    @Override
    public float itemTierPower() {
        return 2.5F;
    }

    @Override
    public float powerMultiplier() {
        return 2.5F;
    }
}
