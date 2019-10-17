package com.robertx22.mine_and_slash.blocks.slots;

import com.robertx22.mine_and_slash.items.bags.BaseSlot;
import com.robertx22.mine_and_slash.uncommon.item_filters.bases.ItemFilterGroup;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;

public class MapSlot extends BaseSlot {

    public MapSlot(Inventory itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);

    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return ItemFilterGroup.ANY_MAP.anyMatchesFilter(stack);
    }

}