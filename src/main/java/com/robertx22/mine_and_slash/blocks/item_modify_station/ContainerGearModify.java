package com.robertx22.mine_and_slash.blocks.item_modify_station;

import com.robertx22.mine_and_slash.blocks.bases.BaseTileContainer;
import com.robertx22.mine_and_slash.blocks.slots.AnyModifySlot;
import com.robertx22.mine_and_slash.blocks.slots.ModifySlot;
import com.robertx22.mine_and_slash.blocks.slots.OutputSlot;
import com.robertx22.mine_and_slash.mmorpg.registers.common.ContainerTypeRegisters;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;

public class ContainerGearModify extends BaseTileContainer {

    private final int HOTBAR_SLOT_COUNT = 9;
    private final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;

    public static final int MODIFY_SLOTS_COUNT = 3;

    public ContainerGearModify(int i, PlayerInventory playerInventory,
                               PacketBuffer packetBuffer) {
        this(i, playerInventory, new Inventory(TileGearModify.TOTAL_SLOTS_COUNT), packetBuffer
                .readBlockPos());

    }

    public ContainerGearModify(int i, PlayerInventory invPlayer, IInventory inventory,
                               BlockPos pos) {

        super(MODIFY_SLOTS_COUNT, ContainerTypeRegisters.GEAR_MODIFY, i);

        this.pos = pos;

        final int PLAYER_INVENTORY_XPOS = 47;

        final int SLOT_X_SPACING = 18;
        final int SLOT_Y_SPACING = 18;
        final int HOTBAR_YPOS = 183;
        // Add the players hotbar to the gui - the [xpos, ypos] location of each item
        for (int x = 0; x < HOTBAR_SLOT_COUNT; x++) {
            int slotNumber = x;
            addSlot(new Slot(invPlayer, slotNumber, PLAYER_INVENTORY_XPOS + SLOT_X_SPACING * x, HOTBAR_YPOS));
        }

        final int PLAYER_INVENTORY_YPOS = 125;
        // Add the rest of the players inventory to the gui
        for (int y = 0; y < PLAYER_INVENTORY_ROW_COUNT; y++) {
            for (int x = 0; x < PLAYER_INVENTORY_COLUMN_COUNT; x++) {
                int slotNumber = HOTBAR_SLOT_COUNT + y * PLAYER_INVENTORY_COLUMN_COUNT + x;
                int xpos = PLAYER_INVENTORY_XPOS + x * SLOT_X_SPACING;
                int ypos = PLAYER_INVENTORY_YPOS + y * SLOT_Y_SPACING;
                addSlot(new Slot(invPlayer, slotNumber, xpos, ypos));
            }
        }

        // VANILLA END

        final int INPUT_SLOTS_XPOS = 65;
        final int INPUT_SLOTS_YPOS = 24;
        // Add the tile input slots

        int count = 0;

        addSlot(new ModifySlot(inventory, count++, INPUT_SLOTS_XPOS, INPUT_SLOTS_YPOS + SLOT_Y_SPACING * 2));

        addSlot(new AnyModifySlot(inventory, count++, 111, INPUT_SLOTS_YPOS + SLOT_Y_SPACING * 1));

        final int OUTPUT_SLOTS_XPOS = 172;
        final int OUTPUT_SLOTS_YPOS = 24;

        addSlot(new OutputSlot(inventory, count++, OUTPUT_SLOTS_XPOS, OUTPUT_SLOTS_YPOS + SLOT_Y_SPACING * 2));

    }

    @Override
    public boolean canInteractWith(PlayerEntity player) {
        return true;
    }

}