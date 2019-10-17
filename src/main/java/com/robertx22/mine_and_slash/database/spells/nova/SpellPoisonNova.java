package com.robertx22.mine_and_slash.database.spells.nova;

import com.robertx22.mine_and_slash.database.items.spell_items.nova.ItemPoisonNova;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import net.minecraft.item.Item;

public class SpellPoisonNova extends BaseNovaSpell {

    @Override
    public String GUID() {
        return "spell_poison_nova";
    }

    @Override
    public Elements Element() {
        return Elements.Nature;
    }

    @Override
    public Item SpellItem() {
        return ItemPoisonNova.ITEM;
    }

}
