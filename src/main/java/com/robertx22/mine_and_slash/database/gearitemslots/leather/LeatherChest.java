package com.robertx22.mine_and_slash.database.gearitemslots.leather;

import com.robertx22.mine_and_slash.database.gearitemslots.bases.GearItemSlot;
import com.robertx22.mine_and_slash.database.gearitemslots.bases.armor.BaseChest;
import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.items.gearitems.armor.leather.LeatherChestItem;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.List;

public class LeatherChest extends BaseChest {
    public static GearItemSlot INSTANCE = new LeatherChest();

    private LeatherChest() {

    }

    @Override
    public List<Stat> statRequirements() {
        return leatherRequirements();
    }

    @Override
    public List<StatMod> PossibleSecondaryStats() {
        return leatherArmorStats();
    }

    @Override
    public HashMap<Integer, Item> ItemsForRarities() {
        return LeatherChestItem.Items;
    }

    @Override
    public String locNameForLangFile() {
        return "Leather Chest";
    }

    @Override
    public String GUID() {
        return "Leather_Chest";
    }
}
