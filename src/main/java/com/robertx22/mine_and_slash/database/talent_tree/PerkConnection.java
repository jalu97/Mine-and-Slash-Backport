package com.robertx22.mine_and_slash.database.talent_tree;

import java.util.Objects;

public class PerkConnection {

    public PerkConnection(Allocation status, Perk one, Perk two) {
        this.allocationStatus = status;
        this.one = one;
        this.two = two;

    }

    public Perk one, two;
    public Allocation allocationStatus = Allocation.CANT_ALLOCATE;

    public enum Allocation {
        CAN_ALLOCATE(0),
        CANT_ALLOCATE(12),
        ALLOCATED(6);

        Allocation(int spriteOffsetX) {
            this.spriteOffsetX = spriteOffsetX;
        }

        public int spriteOffsetX;
    }

    private String getCombinedGuid() {
        return Objects.hash(one.GUID()) > Objects.hash(two.GUID()) ? one.GUID() + two.GUID() : two
                .GUID() + one.GUID();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PerkConnection)) {
            return false;
        }
        return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCombinedGuid());
    }

}
