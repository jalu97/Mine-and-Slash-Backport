package com.robertx22.mine_and_slash.database.stats.effects.defense;

import com.robertx22.mine_and_slash.database.stats.IUsableStat;
import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.saveclasses.StatData;
import com.robertx22.mine_and_slash.saveclasses.Unit;
import com.robertx22.mine_and_slash.uncommon.effectdatas.DamageEffect;
import com.robertx22.mine_and_slash.uncommon.effectdatas.EffectData;
import com.robertx22.mine_and_slash.uncommon.effectdatas.EffectData.EffectTypes;
import com.robertx22.mine_and_slash.uncommon.interfaces.IStatEffect;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.RandomUtils;

public class DodgeEffect implements IStatEffect {

    @Override
    public int GetPriority() {
        return Priority.AlmostLast.priority;
    }

    @Override
    public EffectSides Side() {
        return EffectSides.Target;
    }

    @Override
    public EffectData TryModifyEffect(EffectData Effect, Unit source, StatData data,
                                      Stat stat) {

        try {
            if (Effect instanceof DamageEffect && !Effect.getEffectType()
                    .equals(EffectTypes.SPELL)) {

                IUsableStat usable = (IUsableStat) stat;

                float chance = usable.GetUsableValue(Effect.targetData.getLevel(), (int) data.Value) * 100;

                if (RandomUtils.roll(chance)) {
                    DamageEffect dmgeffect = (DamageEffect) Effect;

                    Effect.number = 0;
                    dmgeffect.isDodged = true;
                    Effect.canceled = true;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Effect;
    }

}
