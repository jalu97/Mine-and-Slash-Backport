package com.robertx22.mine_and_slash.onevent.entity;

import com.robertx22.mine_and_slash.config.whole_mod_entity_configs.ModEntityConfig;
import com.robertx22.mine_and_slash.db_lists.Rarities;
import com.robertx22.mine_and_slash.db_lists.registry.SlashRegistry;
import com.robertx22.mine_and_slash.loot.LootUtils;
import com.robertx22.mine_and_slash.loot.MasterLootGen;
import com.robertx22.mine_and_slash.mmorpg.MMORPG;
import com.robertx22.mine_and_slash.mmorpg.registers.common.CriteriaRegisters;
import com.robertx22.mine_and_slash.network.DmgNumPacket;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap.UnitData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.NumberUtils;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.WorldUtils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OnMobDeathDrops {

    @SubscribeEvent
    public static void mobOnDeathDrop(LivingDeathEvent event) {

        try {

            LivingEntity entity = event.getEntityLiving();

            if (entity.world.isRemote) {
                return;
            }

            if (!(entity instanceof PlayerEntity)) {
                if (event.getSource().getTrueSource() instanceof ServerPlayerEntity) {
                    if (Load.hasUnit(entity)) {

                        ServerPlayerEntity player = (ServerPlayerEntity) event.getSource()
                                .getTrueSource();

                        UnitData victim = Load.Unit(entity);
                        UnitData killer = Load.Unit(player);

                        if (victim.shouldDropLoot() == false) {
                            return;
                        }

                        CriteriaRegisters.DROP_LVL_PENALTY_TRIGGER.trigger(player, killer, victim);

                        ModEntityConfig config = SlashRegistry.getEntityConfig(entity, victim);

                        float loot_multi = (float) config.LOOT_MULTI;
                        float exp_multi = (float) config.EXP_MULTI;

                        if (loot_multi > 0) {
                            MasterLootGen.genAndDrop(victim, killer, entity, player);
                        }

                        if (exp_multi > 0) {
                            int exp = GiveExp(entity, player, killer, victim, exp_multi);

                            if (exp > 0) {
                                DmgNumPacket packet = new DmgNumPacket(entity, Elements.Nature, "+" + NumberUtils
                                        .formatNumber(exp) + " Exp!");
                                packet.isExp = true;
                                MMORPG.sendToClient(packet, player);
                            }
                        }
                    }
                }
            }

        } catch (

                Exception e) {
            e.printStackTrace();
        }

    }

    private static int GiveExp(LivingEntity victim, PlayerEntity entity, UnitData player,
                               UnitData mob, float multi) {

        int exp = (int) (mob.getLevel() * Rarities.Mobs.get(mob.getRarity())
                .ExpOnKill() * multi);

        exp = (int) LootUtils.ApplyLevelDistancePunishment(mob, player, exp);

        if (victim instanceof SlimeEntity) {
            exp /= 10;
        }

        if (WorldUtils.isMapWorldClass(victim.world)) {
            exp *= Load.playerMapData(entity).getExpMultiplier();
        }

        exp = player.PostGiveExpEvent(victim, entity, exp);

        return exp;

    }

}
