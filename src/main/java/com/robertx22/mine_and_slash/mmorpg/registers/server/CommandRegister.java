package com.robertx22.mine_and_slash.mmorpg.registers.server;

import com.mojang.brigadier.CommandDispatcher;
import com.robertx22.mine_and_slash.commands.*;
import com.robertx22.mine_and_slash.commands.entity.*;
import com.robertx22.mine_and_slash.commands.giveitems.*;
import net.minecraft.command.CommandSource;
import net.minecraft.server.MinecraftServer;

public class CommandRegister {

    public static void Register(MinecraftServer server) {
        System.out.println("Registering Mine and Slash Commands.");

        CommandDispatcher<CommandSource> dispatcher = server.getCommandManager()
                .getDispatcher();

        SetLevel.register(dispatcher);
        RestoreLevel.register(dispatcher);
        GiveExp.register(dispatcher);
        GiveAwakenRuneword.register(dispatcher);
        GiveExactUnique.register(dispatcher);
        GiveGear.register(dispatcher);
        GiveMap.register(dispatcher);
        GiveRune.register(dispatcher);
        GiveRunedGear.register(dispatcher);
        GiveSpell.register(dispatcher);
        GiveUniqueGear.register(dispatcher);
        SetEntityLevel.register(dispatcher);
        SetEntityRarity.register(dispatcher);

        GiveStatMod.register(dispatcher);
        RemoveStatMod.register(dispatcher);
        ClearStatMods.register(dispatcher);

        GiveStat.register(dispatcher);
        RemoveStat.register(dispatcher);
        ClearStats.register(dispatcher);

        ReloadConfigs.register(dispatcher);
        ModifyItem.register(dispatcher);
        GiveBlueprint.register(dispatcher);
        GiveUniqueRune.register(dispatcher);
        SayMapInfo.register(dispatcher);
        OpenPickStatsGui.register(dispatcher);
        ResetTalents.register(dispatcher);
        OpenTalentsGui.register(dispatcher);

    }
}