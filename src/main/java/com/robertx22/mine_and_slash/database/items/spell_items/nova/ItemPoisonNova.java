package com.robertx22.mine_and_slash.database.items.spell_items.nova;

import com.robertx22.mine_and_slash.database.spells.bases.BaseSpell;
import com.robertx22.mine_and_slash.database.spells.nova.SpellPoisonNova;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class ItemPoisonNova extends BaseItemNova {

    public ItemPoisonNova() {
        super();

    }

    @ObjectHolder(Ref.MODID + ":spell_poison_nova")
    public static final Item ITEM = null;

    @Override
    public BaseSpell Spell() {
        return new SpellPoisonNova();
    }

    @Override
    public String GUID() {
        return Ref.MODID + ":spell_poison_nova";
    }

}
