package com.robertx22.mine_and_slash.a_libraries.neat_mob_overlay;

import com.robertx22.mine_and_slash.config.ClientContainer;
import com.robertx22.mine_and_slash.saveclasses.Unit;
import com.robertx22.mine_and_slash.saveclasses.effects.StatusEffectData;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap.UnitData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.LookUtils;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.NumberUtils;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import static net.minecraftforge.fml.relauncher.Side.CLIENT;

import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.Stack;

@Mod.EventBusSubscriber(value = CLIENT)
public class HealthBarRenderer {

    @SubscribeEvent
    public static void onRenderWorldLast(RenderWorldLastEvent event) {
        try {
            Minecraft mc = Minecraft.getInstance();

            if ((!ClientContainer.INSTANCE.neatConfig.renderInF1.get() && !Minecraft.isGuiEnabled()) || !NeatConfig.draw)
                return;

            Entity cameraEntity = mc.getRenderViewEntity();
            Frustum frustum = new Frustum();

            BlockPos renderingVector = cameraEntity.getPosition();

            float partialTicks = event.getPartialTicks();
            double viewX = cameraEntity.lastTickPosX + (cameraEntity.posX - cameraEntity.lastTickPosX) * partialTicks;
            double viewY = cameraEntity.lastTickPosY + (cameraEntity.posY - cameraEntity.lastTickPosY) * partialTicks;
            double viewZ = cameraEntity.lastTickPosZ + (cameraEntity.posZ - cameraEntity.lastTickPosZ) * partialTicks;
            frustum.setPosition(viewX, viewY, viewZ);

            if (ClientContainer.neatConfig.showOnlyFocused.get()) {
                Entity focused = LookUtils.getEntityLookedAt(mc.player);

                if (focused != null && focused instanceof EntityLivingBase && focused.isEntityAlive())
                    renderHealthBar((EntityLivingBase) focused, partialTicks, cameraEntity);
            } else {
                WorldClient client = mc.world;
                Int2ObjectMap<Entity> entitiesById = ObfuscationReflectionHelper.getPrivateValue(WorldClient.class, client, "entitiesById");
                for (Entity entity : entitiesById.values()) {
                    if (entity != null && entity instanceof EntityLivingBase && entity != mc.player && entity
                            .isInRangeToRender3d(renderingVector.getX(), renderingVector.getY(), renderingVector
                                    .getZ()) && (entity.ignoreFrustumCheck || frustum.isBoundingBoxInFrustum(entity
                            .getEntityBoundingBox())) && entity.isEntityAlive() && entity.getRecursivePassengers()
                            .isEmpty())
                        renderHealthBar((EntityLivingBase) entity, partialTicks, cameraEntity);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void renderHealthBar(EntityLivingBase passedEntity, float partialTicks,
                                       Entity viewPoint) {
        Stack<EntityLivingBase> ridingStack = new Stack<>();

        EntityLivingBase entity = passedEntity;
        ridingStack.push(entity);

        // MY CODE
        UnitData data = Load.Unit(entity);
        if (data == null) {
            return;
        }

        Unit unit = data.getUnit();
        if (unit == null) {
            return;
        }

        // MY CODE

        while (entity.getRidingEntity() != null && entity.getRidingEntity() instanceof LivingEntity) {
            entity = (EntityLivingBase) entity.getRidingEntity();
            ridingStack.push(entity);
        }

        Minecraft mc = Minecraft.getInstance();

        float pastTranslate = 0F;
        while (!ridingStack.isEmpty()) {
            entity = ridingStack.pop();
            boolean boss = !entity.isNonBoss();

            String entityID = entity.getEntityString();
            if (ClientContainer.INSTANCE.neatConfig.blacklist.get().contains(entityID))
                continue;

            processing:
            {
                float distance = passedEntity.getDistance(viewPoint);
                if (distance > ClientContainer.INSTANCE.neatConfig.maxDistance.get() || !passedEntity
                        .canEntityBeSeen(viewPoint) || entity.isInvisible())
                    break processing;
                if (!ClientContainer.INSTANCE.neatConfig.showOnBosses.get() && !boss)
                    break processing;
                if (!ClientContainer.INSTANCE.neatConfig.showOnPlayers.get() && entity instanceof PlayerEntity)
                    break processing;

                double x = passedEntity.lastTickPosX + (passedEntity.posX - passedEntity.lastTickPosX) * partialTicks;
                double y = passedEntity.lastTickPosY + (passedEntity.posY - passedEntity.lastTickPosY) * partialTicks;
                double z = passedEntity.lastTickPosZ + (passedEntity.posZ - passedEntity.lastTickPosZ) * partialTicks;

                float scale = 0.026666672F;
                // MY CODE
                float maxHealth = unit.healthData().Value;
                float health = unit.health().CurrentValue(entity, unit);
                //MY CODE

                if (maxHealth <= 0)
                    break processing;

                float percent = (int) ((health / maxHealth) * 100F);
                EntityRenderer renderManager = Minecraft.getInstance()
                        .getRenderManager();

                GlStateManager.pushMatrix();
                GlStateManager.translate((float) (x - renderManager.renderPosX), (float) (y - renderManager.renderPosY + passedEntity
                        .getHeight() + ClientContainer.INSTANCE.neatConfig.heightAbove.get()), (float) (z - renderManager.renderPosZ));
                GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                GlStateManager.rotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
                GlStateManager.rotatef(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
                GlStateManager.scale(-scale, -scale, scale);
                boolean lighting = GL11.glGetBoolean(GL11.GL_LIGHTING);
                GlStateManager.disableLighting();
                GlStateManager.depthMask(false);
                GlStateManager.disableDepth();
                GlStateManager.disableTexture2D();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder buffer = tessellator.getBuffer();

                float padding = ClientContainer.INSTANCE.neatConfig.backgroundPadding.get();
                int bgHeight = ClientContainer.INSTANCE.neatConfig.backgroundHeight.get();
                int barHeight = ClientContainer.INSTANCE.neatConfig.barHeight.get();
                float size = boss ? ClientContainer.INSTANCE.neatConfig.plateSizeBoss.get() : ClientContainer.INSTANCE.neatConfig.plateSize
                        .get();

                int r = 0;
                int g = 255;
                int b = 0;

                boolean useHue = !ClientContainer.INSTANCE.neatConfig.colorByType.get();
                if (useHue) {
                    float hue = Math.max(0F, (health / maxHealth) / 3F - 0.07F);
                    Color color = Color.getHSBColor(hue, 1F, 1F);
                    r = color.getRed();
                    g = color.getGreen();
                    b = color.getBlue();
                }

                GlStateManager.translate(0F, pastTranslate, 0F);

                float s = 0.5F;
                ITextComponent name = data.getName(entity);

                if (Screen.hasShiftDown()) {
                    name.appendSibling(new StringTextComponent(" {" + data.getType()
                            .name() + "} "));
                }

                String namestring = name.getFormattedText();

                float namel = mc.fontRenderer.getStringWidth(namestring) * s;
                if (namel + 20 > size * 2)
                    size = namel / 2F + 10F;
                float healthSize = size * (health / maxHealth);

                // Background
                if (ClientContainer.INSTANCE.neatConfig.drawBackground.get()) {
                    buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
                    buffer.pos(-size - padding, -bgHeight, 0.0D)
                            .color(0, 0, 0, 64)
                            .endVertex();
                    buffer.pos(-size - padding, barHeight + padding, 0.0D)
                            .color(0, 0, 0, 64)
                            .endVertex();
                    buffer.pos(size + padding, barHeight + padding, 0.0D)
                            .color(0, 0, 0, 64)
                            .endVertex();
                    buffer.pos(size + padding, -bgHeight, 0.0D)
                            .color(0, 0, 0, 64)
                            .endVertex();
                    tessellator.draw();
                }

                // Gray Space
                buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
                buffer.pos(-size, 0, 0.0D).color(127, 127, 127, 127).endVertex();
                buffer.pos(-size, barHeight, 0.0D).color(127, 127, 127, 127).endVertex();
                buffer.pos(size, barHeight, 0.0D).color(127, 127, 127, 127).endVertex();
                buffer.pos(size, 0, 0.0D).color(127, 127, 127, 127).endVertex();
                tessellator.draw();

                // Health Bar
                buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
                buffer.pos(-size, 0, 0.0D).color(r, g, b, 127).endVertex();
                buffer.pos(-size, barHeight, 0.0D).color(r, g, b, 127).endVertex();
                buffer.pos(healthSize * 2 - size, barHeight, 0.0D)
                        .color(r, g, b, 127)
                        .endVertex();
                buffer.pos(healthSize * 2 - size, 0, 0.0D)
                        .color(r, g, b, 127)
                        .endVertex();
                tessellator.draw();

                GlStateManager.enableTexture();

                GlStateManager.pushMatrix();
                GlStateManager.translate(-size, -4.5F, 0F);
                GlStateManager.scale(s, s, s);
                mc.fontRenderer.drawString(namestring, 0, 0, 0xFFFFFF);

                GlStateManager.pushMatrix();
                float s1 = 0.75F;
                GlStateManager.scale(s1, s1, s1);

                int h = ClientContainer.INSTANCE.neatConfig.hpTextHeight.get();
                String maxHpStr = TextFormatting.BOLD + NumberUtils.formatNumber((int) maxHealth);
                String hpStr = NumberUtils.formatNumber((int) health);
                String percStr = (int) percent + "%";

                if (maxHpStr.endsWith(".0"))
                    maxHpStr = maxHpStr.substring(0, maxHpStr.length() - 2);
                if (hpStr.endsWith(".0"))
                    hpStr = hpStr.substring(0, hpStr.length() - 2);

                if (ClientContainer.INSTANCE.neatConfig.showCurrentHP.get())
                    mc.fontRenderer.drawString(hpStr, 2, h, 0xFFFFFF);
                if (ClientContainer.INSTANCE.neatConfig.showMaxHP.get())
                    mc.fontRenderer.drawString(maxHpStr, (int) (size / (s * s1) * 2) - 2 - mc.fontRenderer
                            .getStringWidth(maxHpStr), h, 0xFFFFFF);
                if (ClientContainer.INSTANCE.neatConfig.showPercentage.get())
                    mc.fontRenderer.drawString(percStr, (int) (size / (s * s1)) - mc.fontRenderer
                            .getStringWidth(percStr) / 2, h, 0xFFFFFFFF);
                if (ClientContainer.INSTANCE.neatConfig.enableDebugInfo.get() && mc.gameSettings.showDebugInfo)
                    mc.fontRenderer.drawString("GEAR_FACTORY_ID: \"" + entityID + "\"", 0, h + 16, 0xFFFFFFFF);
                GlStateManager.popMatrix();

                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

                s1 = 0.5F;
                GlStateManager.scale(s1, s1, s1);
                GlStateManager.translate(size / (s * s1) * 2 - 16, 0F, 0F);
                mc.textureManager.bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);

                // SHOW ICONS HERE

                // MY CODE
                int off = 0;

                for (StatusEffectData statusdata : unit.statusEffects.values()) {
                    renderIcon(off, 0, new ItemStack(statusdata.GetEffect()
                            .ItemModel()), 16, 16);
                    off -= 16;

                }
                // show that loots are prevented
                if (!data.shouldDropLoot()) {
                    renderIcon(off, 0, new ItemStack(Items.BARRIER), 16, 16);
                    off -= 16;
                }
                //MY CODE

                GlStateManager.popMatrix();

                GlStateManager.disableBlend();
                GlStateManager.enableDepth();
                GlStateManager.depthMask(true);
                if (lighting)
                    GlStateManager.enableLighting();
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                GlStateManager.popMatrix();

                pastTranslate -= bgHeight + barHeight + padding;
            }
        }
    }

    public static void renderIcon(int vertexX, int vertexY, ItemStack stack, int intU,
                                  int intV) {
        try {
            Minecraft mc = Minecraft.getInstance();
            IBakedModel iBakedModel = mc.getItemRenderer()
                    .getItemModelMesher()
                    .getItemModel(stack);
            TextureAtlasSprite textureAtlasSprite = mc.getTextureMap()
                    .getAtlasSprite(iBakedModel.getParticleTexture()
                            .getName()
                            .toString());
            mc.getTextureManager().bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder buffer = tessellator.getBuffer();
            buffer.begin(7, DefaultVertexFormats.POSITION_TEX);
            buffer.pos((double) (vertexX), (double) (vertexY + intV), 0.0D)
                    .tex((double) textureAtlasSprite.getMinU(), (double) textureAtlasSprite
                            .getMaxV())
                    .endVertex();
            buffer.pos((double) (vertexX + intU), (double) (vertexY + intV), 0.0D)
                    .tex((double) textureAtlasSprite.getMaxU(), (double) textureAtlasSprite
                            .getMaxV())
                    .endVertex();
            buffer.pos((double) (vertexX + intU), (double) (vertexY), 0.0D)
                    .tex((double) textureAtlasSprite.getMaxU(), (double) textureAtlasSprite
                            .getMinV())
                    .endVertex();
            buffer.pos((double) (vertexX), (double) (vertexY), 0.0D)
                    .tex((double) textureAtlasSprite.getMinU(), (double) textureAtlasSprite
                            .getMinV())
                    .endVertex();
            tessellator.draw();
        } catch (Exception e) {
        }
    }

}
