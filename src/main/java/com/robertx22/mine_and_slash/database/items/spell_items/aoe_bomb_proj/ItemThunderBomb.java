package com.robertx22.mine_and_slash.database.items.spell_items.aoe_bomb_proj;

import com.robertx22.mine_and_slash.database.spells.aoe_bomb_proj.SpellThunderBomb;
import com.robertx22.mine_and_slash.database.spells.bases.BaseSpell;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class ItemThunderBomb extends BaseBombitem {

    public ItemThunderBomb() {
        super();
    }

    @ObjectHolder(Ref.MODID + ":spell_thunder_bomb")
    public static final Item ITEM = null;

    @Override
    public BaseSpell Spell() {
        return new SpellThunderBomb();
    }

    @Override
    public String GUID() {
        return Ref.MODID + ":spell_thunder_bomb";
    }

}
