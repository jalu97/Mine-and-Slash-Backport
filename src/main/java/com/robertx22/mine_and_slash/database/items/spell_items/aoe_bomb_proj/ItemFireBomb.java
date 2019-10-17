package com.robertx22.mine_and_slash.database.items.spell_items.aoe_bomb_proj;

import com.robertx22.mine_and_slash.database.spells.aoe_bomb_proj.SpellFireBomb;
import com.robertx22.mine_and_slash.database.spells.bases.BaseSpell;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class ItemFireBomb extends BaseBombitem {

    public ItemFireBomb() {
        super();
    }

    @ObjectHolder(Ref.MODID + ":spell_fire_bomb")
    public static final Item ITEM = null;

    @Override
    public BaseSpell Spell() {
        return new SpellFireBomb();
    }

    @Override
    public String GUID() {
        return Ref.MODID + ":spell_fire_bomb";
    }

}
