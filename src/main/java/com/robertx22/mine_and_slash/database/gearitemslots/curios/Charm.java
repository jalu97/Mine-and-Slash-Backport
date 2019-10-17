package com.robertx22.mine_and_slash.database.gearitemslots.curios;

import com.robertx22.mine_and_slash.database.gearitemslots.bases.GearItemSlot;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.corestats.*;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalPeneFlat;
import com.robertx22.mine_and_slash.items.gearitems.baubles.ItemCharm;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import net.minecraft.item.Item;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Charm extends GearItemSlot {
    public static GearItemSlot INSTANCE = new Charm();

    private Charm() {

    }

    @Override
    public String resourceID() {
        return "charm";
    }

    @Override
    public String GUID() {
        return "Charm";
    }

    static float multi = 2;

    @Override
    public List<StatMod> PrimaryStats() {
        return Arrays.asList(new ElementalPeneFlat(Elements.Fire).multi(multi), new ElementalPeneFlat(Elements.Water)
                .multi(multi), new ElementalPeneFlat(Elements.Thunder).multi(multi), new ElementalPeneFlat(Elements.Nature)
                .multi(multi), new ElementalPeneFlat(Elements.Physical).multi(multi));

    }

    @Override
    public boolean isGearOfThisType(Item item) {
        return false;
    }

    @Override
    public List<StatMod> PossibleSecondaryStats() {
        return Arrays.asList(new StrengthFlat(), new VitalityFlat(), new IntelligenceFlat(), new WisdomFlat(), new StaminaFlat(), new DexterityFlat());
    }

    @Override
    public Item DefaultItem() {
        return ItemCharm.Items.get(0);
    }

    @Override
    public HashMap<Integer, Item> ItemsForRarities() {
        return ItemCharm.Items;
    }

    @Override
    public int Weight() {
        return 1200;
    }

    @Override
    public GearSlotType slotType() {
        return GearSlotType.Jewerly;
    }

    @Override
    public String locNameForLangFile() {
        return "Charm";
    }
}
