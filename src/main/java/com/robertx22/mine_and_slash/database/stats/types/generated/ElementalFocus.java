package com.robertx22.mine_and_slash.database.stats.types.generated;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.effects.offense.ElementalFocusEffect;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.interfaces.IElementalGenerated;
import com.robertx22.mine_and_slash.uncommon.interfaces.IStatEffect;
import com.robertx22.mine_and_slash.uncommon.interfaces.IStatEffects;

import java.util.ArrayList;
import java.util.List;

public class ElementalFocus extends Stat implements IElementalGenerated<Stat>, IStatEffects {
    public Elements element;

    public ElementalFocus(Elements element) {
        this.element = element;

    }

    @Override
    public String locNameForLangFile() {
        return element.name() + " Focus";
    }

    @Override
    public String GUID() {
        return element.name() + "_focus";
    }

    @Override
    public Stat newGeneratedInstance(Elements element) {
        return new ElementalFocus(element);
    }

    @Override
    public boolean IsPercent() {
        return true;
    }

    @Override
    public boolean ScalesToLevel() {
        return false;
    }

    @Override
    public Elements Element() {
        return element;
    }

    @Override
    public String locDescForLangFile() {
        return "Increases Dmg for that element by a % but decreases dmg from all other elements.";
    }

    @Override
    public String locDescLangFileGUID() {
        return Ref.MODID + ".stat_desc." + "elemental_focus";
    }

    @Override
    public IStatEffect getEffect() {
        return new ElementalFocusEffect();
    }

    @Override
    public List<Stat> generateAllPossibleStatVariations() {
        List<Stat> list = new ArrayList<>();
        Elements.getAllSingleElements().forEach(x -> list.add(newGeneratedInstance(x)));
        return list;
    }

}
