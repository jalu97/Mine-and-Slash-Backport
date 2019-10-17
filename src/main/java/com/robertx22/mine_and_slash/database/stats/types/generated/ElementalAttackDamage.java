package com.robertx22.mine_and_slash.database.stats.types.generated;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.effects.offense.ElementalAttackDamageEffect;
import com.robertx22.mine_and_slash.database.stats.types.ElementalStat;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.interfaces.IStatEffect;
import com.robertx22.mine_and_slash.uncommon.interfaces.IStatEffects;

import java.util.ArrayList;
import java.util.List;

public class ElementalAttackDamage extends ElementalStat implements IStatEffects {

    @Override
    public Stat.StatGroup statGroup() {
        return Stat.StatGroup.EleAttackDamage;
    }

    public ElementalAttackDamage(Elements element) {
        super(element);

    }

    @Override
    public Stat newGeneratedInstance(Elements element) {
        return new ElementalSpellToAttackDMG(element);
    }

    @Override
    public String getIconPath() {
        return "ele_atk_dmg/" + element.guidName;
    }

    @Override
    public boolean ScalesToLevel() {
        return true;
    }

    @Override
    public boolean IsPercent() {
        return false;
    }

    @Override
    public IStatEffect getEffect() {
        return new ElementalAttackDamageEffect();
    }

    @Override
    public String locDescLangFileGUID() {
        return Ref.MODID + ".stat_desc." + "ele_atk_dmg";
    }

    @Override
    public String locNameForLangFile() {
        return "Attack " + this.Element().name() + " Damage";
    }

    @Override
    public String locDescForLangFile() {
        return "Adds x element damage on weapon hit";
    }

    @Override
    public String GUID() {
        return "Attack " + Element().name() + " Damage";
    }

    @Override
    public List<Stat> generateAllPossibleStatVariations() {
        List<Stat> list = new ArrayList<>();
        Elements.getAllSingleElements().forEach(x -> list.add(newGeneratedInstance(x)));
        return list;
    }

}
