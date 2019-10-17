package com.robertx22.mine_and_slash.database.requirements;

import com.robertx22.mine_and_slash.database.gearitemslots.bases.GearItemSlot;
import com.robertx22.mine_and_slash.database.gearitemslots.bases.armor.BaseBoots;
import com.robertx22.mine_and_slash.database.gearitemslots.bases.armor.BaseChest;
import com.robertx22.mine_and_slash.database.gearitemslots.bases.armor.BaseHelmet;
import com.robertx22.mine_and_slash.database.gearitemslots.bases.armor.BasePants;
import com.robertx22.mine_and_slash.database.gearitemslots.cloth.ClothBoots;
import com.robertx22.mine_and_slash.database.gearitemslots.cloth.ClothChest;
import com.robertx22.mine_and_slash.database.gearitemslots.cloth.ClothHelmet;
import com.robertx22.mine_and_slash.database.gearitemslots.cloth.ClothPants;
import com.robertx22.mine_and_slash.database.gearitemslots.curios.Bracelet;
import com.robertx22.mine_and_slash.database.gearitemslots.curios.Charm;
import com.robertx22.mine_and_slash.database.gearitemslots.curios.Necklace;
import com.robertx22.mine_and_slash.database.gearitemslots.curios.Ring;
import com.robertx22.mine_and_slash.database.gearitemslots.offhand.Shield;
import com.robertx22.mine_and_slash.database.gearitemslots.weapons.Staff;
import com.robertx22.mine_and_slash.db_lists.registry.SlashRegistry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SlotRequirement extends BaseRequirement {

    public List<GearItemSlot> slots = new ArrayList<>();

    private SlotRequirement(GearItemSlot slot) {
        this.slots.add(slot);
    }

    private SlotRequirement(List<GearItemSlot> slots) {
        this.slots.addAll(slots);
    }

    @Override
    public boolean meetsRequierment(GearRequestedFor requested) {

        for (GearItemSlot slot : slots) {
            if (requested.forSlot.getClass().isAssignableFrom(slot.getClass())) {
                return true;
            }
        }
        return false;

    }

    public static SlotRequirement ChestAndShield() {
        SlotRequirement req = new SlotRequirement(SlotRequirement.chest().slots);
        req.slots.add(Shield.INSTANCE);
        return req;

    }

    public static SlotRequirement helmetCharmAndNecklace() {
        SlotRequirement req = new SlotRequirement(SlotRequirement.helmet().slots);
        req.slots.add(Necklace.INSTANCE);
        req.slots.add(Charm.INSTANCE);

        return req;

    }

    public static SlotRequirement ring() {
        return new SlotRequirement(Ring.INSTANCE);
    }

    public static SlotRequirement slots(GearItemSlot... slots) {
        return new SlotRequirement(Arrays.asList(slots));
    }

    public static SlotRequirement necklace() {
        return new SlotRequirement(Necklace.INSTANCE);
    }

    public static SlotRequirement charm() {
        return new SlotRequirement(Charm.INSTANCE);
    }

    public static SlotRequirement shield() {
        return new SlotRequirement(Shield.INSTANCE);
    }

    public static SlotRequirement staff() {
        return new SlotRequirement(Staff.INSTANCE);
    }

    public static SlotRequirement bracelet() {
        return new SlotRequirement(Bracelet.INSTANCE);
    }

    public static SlotRequirement chest() {
        return new SlotRequirement(SlashRegistry.GearTypes()
                .getAll()
                .values()
                .stream()
                .filter(x -> x instanceof BaseChest)
                .collect(Collectors.toList()));
    }

    public static SlotRequirement pants() {
        return new SlotRequirement(SlashRegistry.GearTypes()
                .getAll()
                .values()
                .stream()
                .filter(x -> x instanceof BasePants)
                .collect(Collectors.toList()));
    }

    public static SlotRequirement boots() {
        return new SlotRequirement(SlashRegistry.GearTypes()
                .getAll()
                .values()
                .stream()
                .filter(x -> x instanceof BaseBoots)
                .collect(Collectors.toList()));
    }

    public static SlotRequirement helmet() {
        return new SlotRequirement(SlashRegistry.GearTypes()
                .getAll()
                .values()
                .stream()
                .filter(x -> x instanceof BaseHelmet)
                .collect(Collectors.toList()));
    }

    public static SlotRequirement weaponsOnly() {
        return new SlotRequirement(weaponSlots());
    }

    public static SlotRequirement armorsOnly() {
        return new SlotRequirement(armorSlots());
    }

    public static SlotRequirement armorsOnlyNoOffHand() {
        return new SlotRequirement(armorSlotsNoOffHand());
    }

    public static SlotRequirement jewerlyOnly() {
        return new SlotRequirement(jewerlySlots());
    }

    public static SlotRequirement clothArmorOnly() {
        return new SlotRequirement(clothArmors());
    }

    static List<GearItemSlot> clothArmors() {
        List<GearItemSlot> list = new ArrayList<>();
        list.add(ClothBoots.INSTANCE);
        list.add(ClothHelmet.INSTANCE);
        list.add(ClothChest.INSTANCE);
        list.add(ClothPants.INSTANCE);
        return list;

    }

    static List<GearItemSlot> weaponSlots() {

        return SlashRegistry.GearTypes()
                .getAll()
                .values()
                .stream()
                .filter(x -> x.slotType().equals(GearItemSlot.GearSlotType.Weapon))
                .collect(Collectors.toList());

    }

    static List<GearItemSlot> armorSlots() {

        return SlashRegistry.GearTypes()
                .getAll()
                .values()
                .stream()
                .filter(x -> x.slotType()
                        .equals(GearItemSlot.GearSlotType.Armor) || x.slotType()
                        .equals(GearItemSlot.GearSlotType.OffHand)) // tenp i dont have enough affixes for off hands
                .collect(Collectors.toList());

    }

    static List<GearItemSlot> armorSlotsNoOffHand() {

        return SlashRegistry.GearTypes()
                .getAll()
                .values()
                .stream()
                .filter(x -> x.slotType().equals(GearItemSlot.GearSlotType.Armor))
                .collect(Collectors.toList());

    }

    static List<GearItemSlot> jewerlySlots() {

        return SlashRegistry.GearTypes()
                .getAll()
                .values()
                .stream()
                .filter(x -> x.slotType().equals(GearItemSlot.GearSlotType.Jewerly))
                .collect(Collectors.toList());

    }

}
