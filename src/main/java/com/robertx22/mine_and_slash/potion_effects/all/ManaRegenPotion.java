package com.robertx22.mine_and_slash.potion_effects.all;

import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.potion_effects.SpellPotionBase;
import com.robertx22.mine_and_slash.saveclasses.ResourcesData;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap.UnitData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.ParticleUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectType;
import net.minecraft.util.ResourceLocation;

public class ManaRegenPotion extends SpellPotionBase {

    public static final ManaRegenPotion INSTANCE = new ManaRegenPotion();

    private ManaRegenPotion() {
        // boolean isBadEffectIn, int liquidColorIn
        super(EffectType.BENEFICIAL, 4393423);
        this.setRegistryName(new ResourceLocation(Ref.MODID, GUID()));

    }

    @Override
    public String locNameForLangFile() {
        return "Regen Mana";
    }

    @Override
    public String GUID() {
        return "mana_regen";
    }

    @Override
    public void doEffect(Entity applier, Entity caster, LivingEntity target,
                         int amplifier) {

    }

    @Override
    public void performEffectEverySetTime(LivingEntity entity, int amplifier) {

        try {

            if (entity.world.isRemote) {
                ParticleUtils.spawnManaRestoreParticles(entity, 5);
            } else {
                UnitData data = Load.Unit(entity);

                ResourcesData.Context cost = new ResourcesData.Context(data, entity, ResourcesData.Type.MANA, amplifier, ResourcesData.Use.RESTORE);

                data.getResources().modify(cost);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int performEachXTicks() {
        return 40;
    }
}
