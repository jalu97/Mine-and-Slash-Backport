package com.robertx22.mine_and_slash.database.spells.aoe_bomb_proj.bases;

import com.robertx22.mine_and_slash.database.spells.bases.EffectCalculation;
import com.robertx22.mine_and_slash.database.spells.projectile.BaseSpellProjectile;
import com.robertx22.mine_and_slash.database.stats.types.generated.ElementalSpellDamage;
import com.robertx22.mine_and_slash.saveclasses.item_classes.SpellItemData;
import com.robertx22.mine_and_slash.uncommon.localization.CLOC;
import net.minecraft.util.text.ITextComponent;

public abstract class BaseBombSpell extends BaseSpellProjectile {

    @Override
    public int BaseValue() {
        return 15;
    }

    @Override
    public int useTimeTicks() {
        return 20;
    }

    @Override
    public ITextComponent GetDescription(SpellItemData data) {
        return CLOC.tooltip("aoe_bomb_spell");

    }

    @Override
    public EffectCalculation ScalingValue() {
        return new EffectCalculation(new ElementalSpellDamage(this.Element()), this.damageScaling);
    }

    @Override
    public SpellType Type() {
        return SpellType.Aoe_Bomb_Projectile;
    }

    @Override
    public int ManaCost() {
        return 40;
    }

    public float damageScaling = 0.75F;

}
