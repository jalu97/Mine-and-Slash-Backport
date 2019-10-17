package com.robertx22.mine_and_slash.database.items.unique_items.bases;

import com.robertx22.mine_and_slash.database.gearitemslots.bases.GearItemSlot;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.PlateBoots;
import com.robertx22.mine_and_slash.database.items.unique_items.IUnique;
import com.robertx22.mine_and_slash.database.rarities.gears.UniqueGear;
import com.robertx22.mine_and_slash.items.gearitems.armor.plate.PlateBootsItem;
import com.robertx22.mine_and_slash.uncommon.interfaces.IBaseAutoLoc;

public abstract class BaseUniqueBoots extends PlateBootsItem implements IUnique {

    public BaseUniqueBoots() {
        super(new UniqueGear().Rank());

    }

    @Override

    public String locDescLangFileGUID() {
        return this.getRegistryName().toString() + ".desc";
    }

    @Override
    public String locNameLangFileGUID() {
        return this.getRegistryName().toString();
    }

    @Override
    public IBaseAutoLoc.AutoLocGroup locNameGroup() {
        return IBaseAutoLoc.AutoLocGroup.Unique_Items;
    }

    @Override
    public GearItemSlot getGearSlot() {
        return PlateBoots.INSTANCE;
    }
}
