package com.robertx22.mine_and_slash.database.status_effects;

import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalSpellToAttackDMGFlat;
import com.robertx22.mine_and_slash.database.status_effects.bases.BaseMobEleDMG;
import com.robertx22.mine_and_slash.saveclasses.gearitem.StatModData;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import net.minecraft.item.Items;
import net.minecraft.item.Item;

import java.util.Arrays;
import java.util.List;

public class MobThunderDMGSE extends BaseMobEleDMG {

    @Override
    public Item ItemModel() {
        return Items.GLOWSTONE_DUST;
    }

    @Override
    public String GUID() {
        return "MobThunderDMGSE";
    }

    @Override
    public List<StatModData> Stats() {
        return Arrays.asList(StatModData.Load(new ElementalSpellToAttackDMGFlat(Elements.Thunder), percent));
    }

}
