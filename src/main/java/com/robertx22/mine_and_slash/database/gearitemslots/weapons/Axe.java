package com.robertx22.mine_and_slash.database.gearitemslots.weapons;

import com.robertx22.mine_and_slash.database.gearitemslots.bases.BaseWeapon;
import com.robertx22.mine_and_slash.database.gearitemslots.bases.GearItemSlot;
import com.robertx22.mine_and_slash.database.items.unique_items.ISpecificStatReq;
import com.robertx22.mine_and_slash.database.items.unique_items.StatReq;
import com.robertx22.mine_and_slash.items.gearitems.bases.WeaponMechanic;
import com.robertx22.mine_and_slash.items.gearitems.weapon_mechanics.AxeWeaponMechanic;
import com.robertx22.mine_and_slash.items.gearitems.weapons.ItemAxe;
import com.robertx22.mine_and_slash.saveclasses.player_stat_points.LvlPointStat;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;

import java.util.HashMap;

public class Axe extends BaseWeapon implements ISpecificStatReq {
    public static GearItemSlot INSTANCE = new Axe();

    private Axe() {

    }

    static StatReq req = new StatReq(LvlPointStat.STRENGTH, StatReq.Size.SMALL);

    @Override
    public String resourceID() {
        return "axe";
    }

    @Override
    public StatReq getRequirements() {
        return req;
    }

    @Override
    public String GUID() {
        return "Axe";
    }

    @Override
    public boolean isGearOfThisType(Item item) {
        return item instanceof AxeItem;
    }

    @Override
    public Item DefaultItem() {
        return ItemAxe.Items.get(0);
    }

    @Override
    public HashMap<Integer, Item> ItemsForRarities() {
        return ItemAxe.Items;
    }

    @Override
    public int Weight() {
        return 1000;
    }

    @Override
    public WeaponMechanic mechanic() {
        return new AxeWeaponMechanic();
    }

    @Override
    public String locNameForLangFile() {
        return "Axe";
    }
}