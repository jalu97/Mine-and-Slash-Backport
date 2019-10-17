package com.robertx22.mine_and_slash.database.stats.types.spell_buff_traits;

import com.robertx22.mine_and_slash.database.stats.effects.spell_buffs.GhostProjectileBuff;
import com.robertx22.mine_and_slash.database.stats.types.spell_buff_traits.base.SpellBuffTrait;
import com.robertx22.mine_and_slash.uncommon.interfaces.IStatEffect;

public class GhostProjectileTrait extends SpellBuffTrait {

    public static String GUID = "Ghost Projectile";

    @Override
    public String GUID() {
        return GUID;
    }

    @Override
    public IStatEffect getEffect() {
        return new GhostProjectileBuff();
    }

    @Override
    public String locDescForLangFile() {
        return "Your Single Target Spell Projectiles now go through enemies.";
    }

    @Override
    public String locNameForLangFile() {
        return "Ghost Projectile";
    }
}
