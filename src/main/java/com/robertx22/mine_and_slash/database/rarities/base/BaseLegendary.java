package com.robertx22.mine_and_slash.database.rarities.base;

import com.robertx22.mine_and_slash.database.MinMax;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.Rarity;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements.RGB;
import net.minecraft.util.text.TextFormatting;

public abstract class BaseLegendary implements Rarity {
    @Override
    public int colorInt() {
        return 16755200;
    }

    @Override
    public String GUID() {

        return "Legendary";
    }

    @Override
    public int Rank() {

        return 4;
    }

    @Override
    public DropSoundData getDropSound() {
        return new DropSoundData();
    }

    @Override
    public TextFormatting textFormatColor() {
        return TextFormatting.GOLD;
    }

    @Override
    public MinMax SpawnDurabilityHit() {
        return new MinMax(80, 95);
    }

    @Override
    public String Color() {
        return TextFormatting.GOLD.toString();
    }

    @Override
    public RGB getRGBColor() {
        return new RGB(255, 153, 51);
    }

    @Override
    public String locNameForLangFile() {
        return "Legendary";
    }
}
