package com.robertx22.mine_and_slash.uncommon.utilityclasses;

import com.robertx22.mine_and_slash.dimensions.MapManager;
import com.robertx22.mine_and_slash.mmorpg.MMORPG;
import com.robertx22.mine_and_slash.potion_effects.all.TeleportProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.network.play.server.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldInfo;

import java.util.Comparator;
import java.util.Optional;

public class PlayerUtils {

    public static void sendPlayersMSGofStructureSpawnTEST(BlockPos pos, String name) {

        if (MMORPG.RUN_DEV_TOOLS) {
            for (ServerPlayerEntity player : MapManager.getServer()
                    .getPlayerList()
                    .getPlayers()) {

                player.sendMessage(new StringTextComponent(name + " Structure spawned at : " + pos
                        .toString()));

            }
        }
    }

    public static Entity changeDimension(ServerPlayerEntity player,
                                         DimensionType destination, BlockPos pos) {
        if (!net.minecraftforge.common.ForgeHooks.onTravelToDimension(player, destination))
            return null;
        player.invulnerableDimensionChange = true;
        DimensionType dimensiontype = player.dimension;
        if (dimensiontype == DimensionType.THE_END && destination == DimensionType.OVERWORLD) {
            player.detach();
            player.getServerWorld().removePlayer(player);
            if (!player.queuedEndExit) {
                player.queuedEndExit = true;

            }

            return player;
        } else {
            ServerWorld serverworld = player.server.getWorld(dimensiontype);
            player.dimension = destination;
            ServerWorld serverworld1 = player.server.getWorld(destination);
            WorldInfo worldinfo = player.world.getWorldInfo();
            player.connection.sendPacket(new SRespawnPacket(destination, worldinfo.getGenerator(), player.interactionManager
                    .getGameType()));
            player.connection.sendPacket(new SServerDifficultyPacket(worldinfo.getDifficulty(), worldinfo
                    .isDifficultyLocked()));
            PlayerList playerlist = player.server.getPlayerList();
            playerlist.updatePermissionLevel(player);
            serverworld.removeEntity(player, true); //Forge: the player entity is moved to the new world, NOT cloned. So keep the data alive with no matching invalidate call.
            player.revive();
            float f1 = player.rotationYaw;
            serverworld.getProfiler().startSection("moving");

            // MY STUFF
            player.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), f1, 0.0F);
            player.addPotionEffect(new EffectInstance(TeleportProtection.INSTANCE, 10 * 20));
            // MY STUFF

            serverworld.getProfiler().endSection();
            player.setWorld(serverworld1);
            serverworld1.func_217447_b(player);
            player.func_213846_b(serverworld);
            player.connection.setPlayerLocation(pos.getX(), pos.getY(), pos.getZ(), f1, 0.0F);
            player.interactionManager.setWorld(serverworld1);
            player.connection.sendPacket(new SPlayerAbilitiesPacket(player.abilities));
            playerlist.sendWorldInfo(player, serverworld1);
            playerlist.sendInventory(player);

            for (EffectInstance effectinstance : player.getActivePotionEffects()) {
                player.connection.sendPacket(new SPlayEntityEffectPacket(player.getEntityId(), effectinstance));
            }

            player.connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
            net.minecraftforge.fml.hooks.BasicEventHooks.firePlayerChangedDimensionEvent(player, dimensiontype, destination);
            return player;
        }
    }

    public static PlayerEntity nearestPlayer(ServerWorld world, LivingEntity entity) {

        Optional<ServerPlayerEntity> player = world.getPlayers()
                .stream()
                .min(Comparator.comparingDouble(entity::getDistanceSq));

        if (player.isPresent()) {
            return player.get();
        }

        return null;

    }

    public static CompoundNBT getPersistentNBT(PlayerEntity player) {

        CompoundNBT nbt = null;

        try {

            INBT basenbt = player.getPersistentData();

            if (basenbt != null) {
                nbt = (CompoundNBT) basenbt;
            }
            if (nbt == null) {
                nbt = new CompoundNBT();
            }

        } catch (Exception e) {
            nbt = new CompoundNBT();
            e.printStackTrace();
        }

        return nbt;

    }

    public static void setPestistentNBT(PlayerEntity player, CompoundNBT nbt) {

        player.getPersistentData().put(PlayerEntity.PERSISTED_NBT_TAG, nbt);
    }

}
