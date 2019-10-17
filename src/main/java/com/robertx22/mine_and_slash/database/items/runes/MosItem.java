package com.robertx22.mine_and_slash.database.items.runes;

import com.robertx22.mine_and_slash.database.items.runes.base.BaseRuneItem;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.ArmorFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.offense.CriticalDamageFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.MagicShieldRegenFlat;
import net.minecraft.item.Item;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MosItem extends BaseRuneItem {
    public static HashMap<Integer, Item> Items = new HashMap<Integer, Item>();

    public MosItem(int rarity) {
        super(rarity);

    }

    @Override
    public String name() {
        return "MOS";
    }

    @Override
    public List<StatMod> weaponStat() {
        return Arrays.asList(new CriticalDamageFlat());
    }

    @Override
    public List<StatMod> armorStat() {
        return Arrays.asList(new ArmorFlat(), new MagicShieldRegenFlat());
    }

    @Override
    public List<StatMod> jewerlyStat() {
        return this.resistFlats();
    }

    @Override
    public BaseRuneItem byRarity(int rar) {
        return (BaseRuneItem) Items.get(rar);
    }

}
