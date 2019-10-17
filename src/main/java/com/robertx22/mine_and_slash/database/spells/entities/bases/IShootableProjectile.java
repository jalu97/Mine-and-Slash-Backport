package com.robertx22.mine_and_slash.database.spells.entities.bases;

import com.robertx22.mine_and_slash.database.spells.bases.BaseSpellEffect;
import com.robertx22.mine_and_slash.database.spells.bases.DamageData;
import net.minecraft.entity.LivingEntity;

public interface IShootableProjectile {

    public void SpawnAndShoot(BaseSpellEffect effect, DamageData data,
                              LivingEntity caster);

}
