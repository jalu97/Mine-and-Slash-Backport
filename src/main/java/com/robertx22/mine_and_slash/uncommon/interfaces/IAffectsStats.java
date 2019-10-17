package com.robertx22.mine_and_slash.uncommon.interfaces;

import com.robertx22.mine_and_slash.database.IGUID;
import com.robertx22.mine_and_slash.saveclasses.StatData;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap;

public interface IAffectsStats extends IGUID {
    void affectStats(EntityCap.UnitData data, StatData statData);

}
