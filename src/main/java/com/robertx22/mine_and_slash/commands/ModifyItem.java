package com.robertx22.mine_and_slash.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.robertx22.mine_and_slash.commands.bases.ItemModSuggestions;
import com.robertx22.mine_and_slash.database.item_modifications.bases.BaseItemModification;
import com.robertx22.mine_and_slash.db_lists.registry.SlashRegistry;
import com.robertx22.mine_and_slash.saveclasses.item_classes.GearItemData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Gear;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.ICommonDataItem;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;

import javax.annotation.Nullable;
import java.util.Objects;

public class ModifyItem {

    public static void register(CommandDispatcher<CommandSource> commandDispatcher) {
        commandDispatcher.register(Commands.literal("modifyItem")
                .requires(e -> e.hasPermissionLevel(2))
                .then(Commands.argument("target", EntityArgument.player())
                        .then(Commands.argument("type", StringArgumentType.word())
                                .suggests(new ItemModSuggestions())
                                .executes(e -> run(e.getSource(), EntityArgument.getPlayer(e, "target"), StringArgumentType
                                        .getString(e, "type"))))));
    }

    private static int run(CommandSource commandSource, @Nullable PlayerEntity player,
                           String word) {

        if (Objects.isNull(player)) {
            try {
                player = commandSource.asPlayer();
            } catch (CommandSyntaxException e) {
                e.printStackTrace();
                return 1;
            }

        }

        try {
            ICommonDataItem data = ICommonDataItem.load(player.getHeldItemMainhand());
            BaseItemModification mod = SlashRegistry.ItemModifications().get(word);

            if (mod.canModify(data)) {
                mod.modify(data);
                Gear.Save(player.getHeldItemMainhand(), (GearItemData) data);

                player.sendMessage(new StringTextComponent("Success! Added modification: ")
                        .appendSibling(mod.locName()));
            } else {
                player.sendMessage(new StringTextComponent("Modification Failed, can't be done on this item."));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
