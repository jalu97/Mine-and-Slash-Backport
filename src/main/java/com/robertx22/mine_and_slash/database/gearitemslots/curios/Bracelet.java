package com.robertx22.mine_and_slash.database.gearitemslots.curios;

import com.robertx22.mine_and_slash.database.gearitemslots.bases.GearItemSlot;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.offense.SpellDamageFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalResistFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalSpellDamageFlat;
import com.robertx22.mine_and_slash.items.gearitems.baubles.ItemBracelet;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.ListUtils;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.List;

public class Bracelet extends GearItemSlot {
    public static GearItemSlot INSTANCE = new Bracelet();

    private Bracelet() {

    }

    @Override
    public String resourceID() {
        return "bracelet";
    }

    @Override
    public String GUID() {
        return "Bracelet";
    }

    @Override
    public List<StatMod> PrimaryStats() {
        return ListUtils.newList(new ElementalSpellDamageFlat(Elements.Physical).allSingleElementVariations(), new SpellDamageFlat());

    }

    @Override
    public boolean isGearOfThisType(Item item) {
        return false;
    }

    @Override
    public List<StatMod> PossibleSecondaryStats() {
        return new ElementalResistFlat(Elements.Physical).allSingleElementVariations();
    }

    @Override
    public Item DefaultItem() {
        return ItemBracelet.Items.get(0);
    }

    @Override
    public HashMap<Integer, Item> ItemsForRarities() {
        return ItemBracelet.Items;
    }

    @Override
    public GearSlotType slotType() {
        return GearSlotType.Jewerly;
    }

    @Override
    public String locNameForLangFile() {
        return "Bracelet";
    }
}