package com.robertx22.mine_and_slash.saveclasses;

import com.robertx22.mine_and_slash.uncommon.enumclasses.StatTypes;
import info.loenwind.autosave.annotations.Storable;
import info.loenwind.autosave.annotations.Store;

import java.util.HashMap;

@Storable
public class CustomExactStatsData {

    public CustomExactStatsData() {

    }

    @Store
    public HashMap<String, ExactStatData> stats = new HashMap<>();

    public void add(String hashmapGUID, String statGUID, float value, StatTypes type) {
        try {
            stats.put(hashmapGUID, new ExactStatData(value, type, statGUID));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void remove(String hashmapGUID) {
        stats.remove(hashmapGUID);
    }

}
