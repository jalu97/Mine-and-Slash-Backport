package com.robertx22.mine_and_slash.database.items.runes;

import com.robertx22.mine_and_slash.database.items.runes.base.BaseRuneItem;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.HealthRegenFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.LifestealFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.MagicShieldRegenFlat;
import net.minecraft.item.Item;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class XahItem extends BaseRuneItem {
    public static HashMap<Integer, Item> Items = new HashMap<Integer, Item>();

    public XahItem(int rarity) {
        super(rarity);

    }

    @Override
    public String name() {
        return "XAH";
    }

    @Override
    public List<StatMod> weaponStat() {
        return Arrays.asList(new LifestealFlat());
    }

    @Override
    public List<StatMod> armorStat() {
        return this.spellDamagePercents();
    }

    @Override
    public List<StatMod> jewerlyStat() {
        return Arrays.asList(new HealthRegenFlat(), new MagicShieldRegenFlat());
    }

    @Override
    public BaseRuneItem byRarity(int rar) {
        return (BaseRuneItem) Items.get(rar);
    }

}