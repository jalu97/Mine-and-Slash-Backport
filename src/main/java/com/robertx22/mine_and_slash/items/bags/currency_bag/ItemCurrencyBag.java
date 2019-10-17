package com.robertx22.mine_and_slash.items.bags.currency_bag;

import com.robertx22.mine_and_slash.items.bags.BaseBagItem;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.uncommon.item_filters.bases.ItemFilterGroup;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.ObjectHolder;

public class ItemCurrencyBag extends BaseBagItem {

    public static final String ID = Ref.MODID + ":currency_bag";

    @ObjectHolder(ID)
    public static final Item ITEM = null;

    public ItemCurrencyBag() {
        super(ID);
    }

    @Override
    public ItemFilterGroup filterGroup() {
        return ItemFilterGroup.CURRENCY_BAG;
    }

    @Override
    public INamedContainerProvider getNamedContainer(ItemStack stack) {
        return new NamedContainerCurrencyBag(stack);
    }

}
