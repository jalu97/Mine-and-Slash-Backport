package com.robertx22.mine_and_slash.uncommon.gui.player_overlays;

import com.mojang.blaze3d.platform.GlStateManager;
import com.robertx22.mine_and_slash.saveclasses.Unit;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap.UnitData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class TopLeftOverlay extends BasePlayerOverlay {
    int xPos = 2;
    int yPos = 2;

    @Override
    public void Draw(AbstractGui gui, Minecraft mc, LivingEntity entity,
                     RenderGameOverlayEvent event, Unit unit, UnitData data) {
        yPos = 2;

        float scale = 1F;

        GlStateManager.scalef(scale, scale, scale);

        DrawBar(mc, gui, healthtexturepath, unit.health()
                .CurrentValue(mc.player, unit), unit.healthData().Value, Type.HP, data, xPos, yPos);
        yPos += 12;

        DrawBar(mc, gui, manatexturepath, data.getCurrentMana(), unit.manaData().Value, Type.MANA, data, xPos, yPos);
        yPos += 12;
        DrawBar(mc, gui, energytexturepath, data.getCurrentEnergy(), unit.energyData().Value, Type.ENE, data, xPos, yPos);
        yPos += 12;
        DrawBar(mc, gui, experiencetexturepath, data.getExp(), data.GetExpRequiredForLevelUp(), Type.EXP, data, xPos, yPos);

        scale = 1 / scale;
        GlStateManager.scalef(scale, scale, scale);

    }

}
