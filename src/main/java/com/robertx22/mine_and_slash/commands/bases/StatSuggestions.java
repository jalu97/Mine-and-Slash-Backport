package com.robertx22.mine_and_slash.commands.bases;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.db_lists.registry.SlashRegistry;

import java.util.ArrayList;
import java.util.List;

public class StatSuggestions extends CommandSuggestions {

    @Override
    public List<String> suggestions() {

        List<String> list = new ArrayList();
        for (Stat item : SlashRegistry.Stats().getAll().values()) {
            list.add(item.GUID());
        }

        return list;

    }

}

