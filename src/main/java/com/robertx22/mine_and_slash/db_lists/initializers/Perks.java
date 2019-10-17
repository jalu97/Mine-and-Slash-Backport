package com.robertx22.mine_and_slash.db_lists.initializers;

import com.robertx22.mine_and_slash.database.talent_tree.Perk;
import com.robertx22.mine_and_slash.database.talent_tree.csv_parser.TalentParser;
import com.robertx22.mine_and_slash.database.talent_tree.data.StartPerkEffects;
import com.robertx22.mine_and_slash.db_lists.registry.ISlashRegistryInit;
import com.robertx22.mine_and_slash.db_lists.registry.SlashRegistry;

import java.util.ArrayList;
import java.util.List;

public class Perks implements ISlashRegistryInit {

    public static List<Perk> all = new ArrayList<>();

    @Override
    public void registerAll() {

        TalentParser.parse();

        // all perks are made through parsing csv, this also makes it configurable for users!

        SlashRegistry.Perks()
                .getList()
                .stream()
                .filter(x -> x.effect == StartPerkEffects.GUARDIAN || x.effect == StartPerkEffects.MAGE || x.effect == StartPerkEffects.THIEF || x.effect == StartPerkEffects.WARRIOR)
                .forEach(x -> x.setAsStart());

    }

}
