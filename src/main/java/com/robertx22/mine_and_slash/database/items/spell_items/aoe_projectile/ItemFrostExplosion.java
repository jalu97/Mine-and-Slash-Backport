package com.robertx22.mine_and_slash.database.items.spell_items.aoe_projectile;

import com.robertx22.mine_and_slash.database.spells.aoe_projectile.SpellFrostExplosion;
import com.robertx22.mine_and_slash.database.spells.bases.BaseSpell;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class ItemFrostExplosion extends BaseExplosionItem {

    public ItemFrostExplosion() {
        super();
    }

    @ObjectHolder(Ref.MODID + ":spell_frostexplosion")
    public static final Item ITEM = null;

    @Override
    public BaseSpell Spell() {
        return new SpellFrostExplosion();
    }

    @Override
    public String GUID() {
        return Ref.MODID + ":spell_frostexplosion";
    }

}
