package com.robertx22.mine_and_slash.commands.giveitems;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.robertx22.mine_and_slash.commands.bases.GearTypeSuggestions;
import com.robertx22.mine_and_slash.loot.blueprints.RunedGearBlueprint;
import com.robertx22.mine_and_slash.loot.gens.RunedGearLootGen;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.PlayerEntity;

import javax.annotation.Nullable;
import java.util.Objects;

public class GiveRunedGear {

    public static void register(CommandDispatcher<CommandSource> commandDispatcher) {
        commandDispatcher.register(Commands.literal("giverunedgear")
                .requires(e -> e.hasPermissionLevel(2))
                .then(Commands.argument("target", EntityArgument.player())
                        .then(Commands.argument("type", StringArgumentType.word())
                                .suggests(new GearTypeSuggestions())
                                .then(Commands.argument("level", IntegerArgumentType.integer())
                                        .then(Commands.argument("rarity", IntegerArgumentType
                                                .integer(0, 5))
                                                .then(Commands.argument("amount", IntegerArgumentType
                                                        .integer(1, 5000))
                                                        .executes(e -> execute(e.getSource(), EntityArgument
                                                                .getPlayer(e, "target"), StringArgumentType
                                                                .getString(e, "type"), IntegerArgumentType
                                                                .getInteger(e, "level"), IntegerArgumentType
                                                                .getInteger(e, "rarity"), IntegerArgumentType
                                                                .getInteger(e, "amount")

                                                        ))))))));
    }

    private static int execute(CommandSource commandSource, @Nullable PlayerEntity player,
                               String type, int lvl, int rarity, int amount) {

        if (Objects.isNull(player)) {
            try {
                player = commandSource.asPlayer();
            } catch (CommandSyntaxException e) {
                e.printStackTrace();
                return 1;
            }
        }
        RunedGearBlueprint blueprint = new RunedGearBlueprint(lvl);
        if (rarity > -1) {
            blueprint.setSpecificRarity(rarity);
        }
        if (!type.equals("random")) {
            blueprint.SetSpecificType(type);
        }
        blueprint.LevelRange = false;

        for (int i = 0; i < amount; i++) {
            player.addItemStackToInventory(RunedGearLootGen.CreateStack(blueprint));
        }

        return 0;
    }
}
