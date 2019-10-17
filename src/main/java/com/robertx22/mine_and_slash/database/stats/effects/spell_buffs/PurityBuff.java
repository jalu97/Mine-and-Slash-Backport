package com.robertx22.mine_and_slash.database.stats.effects.spell_buffs;

import com.robertx22.mine_and_slash.database.stats.effects.spell_buffs.base.BaseSpellBuff;
import com.robertx22.mine_and_slash.database.spells.bases.BaseSpell.SpellType;
import com.robertx22.mine_and_slash.uncommon.effectdatas.interfaces.IBuffableSpell.SpellBuffType;

public class PurityBuff extends BaseSpellBuff {

    @Override
    public int GetPriority() {
        return 10;
    }

    @Override
    public SpellType typeOfSpellAffected() {
        return SpellType.Self_Heal;
    }

    @Override
    public SpellBuffType buffType() {
        return SpellBuffType.Purity_Remove_Negative_Effects;
    }

}
