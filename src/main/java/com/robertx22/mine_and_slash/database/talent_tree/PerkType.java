package com.robertx22.mine_and_slash.database.talent_tree;

import com.robertx22.mine_and_slash.mmorpg.Ref;
import net.minecraft.util.ResourceLocation;

public enum PerkType {

    SMALL(24, 24, 0, 1),
    BIG(35, 39, 48, 2.5F),
    MAJOR(50, 50, 101, 5);

    PerkType(int x, int y, int offsetX, float statMulti) {
        this.sizeX = x;
        this.sizeY = y;
        this.offsetX = offsetX;
        this.statMulti = statMulti;

    }

    public int sizeX;
    public int sizeY;
    public int offsetX;
    public float statMulti;

    public int getOffsetY(PerkConnection.Allocation status) {
        if (status == PerkConnection.Allocation.CAN_ALLOCATE) {
            return 0;
        }
        if (status == PerkConnection.Allocation.ALLOCATED) {
            return 130;
        } else {
            return 66;
        }
    }

    public int getOffsetX() {
        return this.offsetX;
    }

    public ResourceLocation TEXTURE = new ResourceLocation(Ref.MODID, "textures/gui/talents/perks.png");

}