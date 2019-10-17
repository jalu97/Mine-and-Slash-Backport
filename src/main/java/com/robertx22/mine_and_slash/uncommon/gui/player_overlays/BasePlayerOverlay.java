package com.robertx22.mine_and_slash.uncommon.gui.player_overlays;

import com.mojang.blaze3d.platform.GlStateManager;
import com.robertx22.mine_and_slash.saveclasses.Unit;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap.UnitData;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.NumberUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import java.awt.*;

public abstract class BasePlayerOverlay {

    public int TEXTURE_WIDTH = 106;
    public int TEXTURE_HEIGHT = 11;

    public enum Type {
        HP,
        MANA,
        ENE,
        EXP
    }

    public final ResourceLocation manatexturepath = new ResourceLocation("mmorpg", "textures/gui/overlay/mana_bar.png");
    public final ResourceLocation energytexturepath = new ResourceLocation("mmorpg", "textures/gui/overlay/energy_bar.png");
    public final ResourceLocation healthtexturepath = new ResourceLocation("mmorpg", "textures/gui/overlay/health_bar.png");
    public final ResourceLocation experiencetexturepath = new ResourceLocation("mmorpg", "textures/gui/overlay/experience_bar.png");
    public final ResourceLocation magicshieldpath = new ResourceLocation("mmorpg", "textures/gui/overlay/magic_shield_bar.png");
    public final ResourceLocation bloodpath = new ResourceLocation("mmorpg", "textures/gui/overlay/blood_bar.png");

    public abstract void Draw(AbstractGui gui, Minecraft mc, LivingEntity entity,
                              RenderGameOverlayEvent event, Unit unit, UnitData level);

    public void DrawBar(Minecraft mc, AbstractGui gui, ResourceLocation res,
                        float current, float max, Type type, UnitData data, int x,
                        int y) {

        GlStateManager.color4f(1F, 1F, 1F, 1F);
        mc.getTextureManager().bindTexture(res);

        if (type == Type.MANA && data.getUnit().isBloodMage()) {
            mc.getTextureManager().bindTexture(bloodpath);
            current = data.getResources().getBlood();
            max = data.getUnit().getMaximumBlood();
        }

        gui.blit(x, y, 0, 0, TEXTURE_WIDTH, this.TEXTURE_HEIGHT); // the bar

        int barwidth = MathHelper.clamp((int) (((float) current / max * 100)), 0, 100);

        gui.blit(x + 3, y + 3, 0, TEXTURE_HEIGHT, barwidth, 5); // inner fill texture

        //RENDER ENERGY SHIELD LIKE
        if (type == Type.HP) {

            float curMS = data.getResources().getMagicShield();
            if (curMS > 0) {

                float hp = data.getUnit().healthData().Value;

                float maxperc = MathHelper.clamp(curMS / hp, 0, 1);

                int enebar = (int) ((int) ((curMS / data.getUnit()
                        .magicShieldData().Value * 100)) * maxperc);
                mc.getTextureManager().bindTexture(magicshieldpath);
                gui.blit(x + 3, y + 3, 0, TEXTURE_HEIGHT, enebar, 5);
            }

        }
        //RENDER ENERGY SHIELD LIKE

        String now = NumberUtils.formatNumber((int) current);
        String maximum = NumberUtils.formatNumber((int) max);
        String str = "";

        if (type == Type.HP) { // show effective health only on numbers, but let bars each separate from hp and ms
            now = NumberUtils.formatNumber((int) data.getUnit()
                    .getCurrentEffectiveHealth(mc.player, data));
            maximum = NumberUtils.formatNumber((int) data.getUnit()
                    .getMaxEffectiveHealth());
        }

        if (type != Type.EXP) {
            str = now + "/" + maximum;
        } else {
            str = "Lvl:" + data.getLevel() + " " + now + "/" + maximum;
        }

        float text_x = x + TEXTURE_WIDTH / 2 - mc.fontRenderer.getStringWidth(str) / 2;
        float text_y = y + (float) TEXTURE_HEIGHT / 2 - (float) mc.fontRenderer.FONT_HEIGHT / 2 + 0.5F;

        mc.fontRenderer.drawStringWithShadow(str, text_x, text_y, Color.LIGHT_GRAY.getRGB());

    }

}
