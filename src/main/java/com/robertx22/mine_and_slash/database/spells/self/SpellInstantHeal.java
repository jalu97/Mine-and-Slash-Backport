package com.robertx22.mine_and_slash.database.spells.self;

import com.robertx22.mine_and_slash.database.items.spell_items.self.ItemInstantHeal;
import com.robertx22.mine_and_slash.database.spells.bases.EffectCalculation;
import com.robertx22.mine_and_slash.database.spells.bases.SpellBuffCheck;
import com.robertx22.mine_and_slash.database.stats.types.resources.Health;
import com.robertx22.mine_and_slash.saveclasses.ResourcesData;
import com.robertx22.mine_and_slash.saveclasses.item_classes.SpellItemData;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap.UnitData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import com.robertx22.mine_and_slash.uncommon.effectdatas.SpellBuffEffect;
import com.robertx22.mine_and_slash.uncommon.localization.CLOC;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.ParticleUtils;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.SoundUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class SpellInstantHeal extends BaseSpellHeal {

    @Override
    public SpellType Type() {
        return SpellType.Self_Heal;
    }

    @Override
    public String GUID() {
        return "instant_heal";
    }

    @Override
    public int ManaCost() {
        return 40;
    }

    @Override
    public int BaseValue() {
        return 25;
    }

    @Override
    public EffectCalculation ScalingValue() {
        return new EffectCalculation(Health.INSTANCE, 0.1F);
    }

    @Override
    public Item SpellItem() {
        return ItemInstantHeal.ITEM;
    }

    @Override
    public ITextComponent GetDescription(SpellItemData data) {
        return CLOC.tooltip("spell_instant_heal");
    }

    @Override
    public boolean cast(World world, PlayerEntity caster, Hand hand, int ticksInUse,
                        SpellItemData spellData) {

        try {

            if (!world.isRemote) {

                UnitData data = Load.Unit(caster);

                data.getResources()
                        .modify(new ResourcesData.Context(data, caster, ResourcesData.Type.HEALTH, spellData
                                .GetDamage(data.getUnit()), ResourcesData.Use.RESTORE, this));

                SoundUtils.playSoundAtPlayer(caster, SoundEvents.ENTITY_GENERIC_DRINK, 1, 1);
                // spell buffs
                SpellBuffCheck check = new SpellBuffCheck(this.Type());
                SpellBuffEffect spelleffect = new SpellBuffEffect(caster, check);
                spelleffect.Activate();
                checkSpellBuffs(caster, check);
                //
            } else {

                ParticleUtils.spawnHealParticles(caster, 10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

}
