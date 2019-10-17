package com.robertx22.mine_and_slash.database.items.currency;

import com.robertx22.mine_and_slash.database.items.currency.loc_reqs.BaseLocRequirement;
import com.robertx22.mine_and_slash.database.items.currency.loc_reqs.SimpleGearLocReq;
import com.robertx22.mine_and_slash.items.ores.ItemOre;
import com.robertx22.mine_and_slash.items.profession.alchemy.bases.IHasRecipe;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.professions.blocks.bases.Professions;
import com.robertx22.mine_and_slash.professions.recipe.BaseRecipe;
import com.robertx22.mine_and_slash.professions.recipe.SimpleRecipe;
import com.robertx22.mine_and_slash.saveclasses.item_classes.GearItemData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Gear;
import com.robertx22.mine_and_slash.uncommon.interfaces.IRenamed;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.IRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Arrays;
import java.util.List;

public class RerollUniqueNumbers extends CurrencyItem implements ICurrencyItemEffect, IRenamed, IHasRecipe {
    @Override
    public String GUID() {
        return "currency/reroll_unique_numbers";
    }

    private static final String name = Ref.MODID + ":currency/reroll_unique_numbers";

    @Override
    public List<String> oldNames() {
        return Arrays.asList(Ref.MODID + ":reroll_unique_numbers");
    }

    public RerollUniqueNumbers() {

        super(name);

    }

    @Override
    public ItemStack ModifyItem(ItemStack stack, ItemStack Currency) {

        GearItemData gear = Gear.Load(stack);

        gear.uniqueStats.RerollNumbers(gear);

        Gear.Save(stack, gear);

        return stack;
    }

    @Override
    public List<BaseLocRequirement> requirements() {
        return Arrays.asList(SimpleGearLocReq.HAS_UNIQUE_STATS);
    }

    @Override
    public int Tier() {
        return 14;
    }

    @Override
    public int getRarityRank() {
        return IRarity.Epic;
    }

    @Override
    public List<String> loreLines() {
        return Arrays.asList("Anything can change.");
    }

    @Override
    public String locNameForLangFile() {
        return nameColor + "Orb Of Unique Blessing";
    }

    @Override
    public String locDescForLangFile() {
        return "Re-rolls unique stat numbers";
    }

    @Override
    public int instabilityAddAmount() {
        return 10;
    }

    @Override
    public BaseRecipe getRecipe() {
        return SimpleRecipe.Builder.create(GUID(), Professions.TINKERERING)
                .addMaterial(ItemOre.ItemOres.get(getRarityRank()), 10)
                .addMaterial(new ItemNumberReroll().getFromForgeRegistry(), 5)
                .addMaterial(new ItemOrbOfTransmutation().getFromForgeRegistry(), 2)
                .addMaterial(Items.DIAMOND, 1)
                .buildMaterials()
                .setOutput(this)
                .levelReq(50)
                .expGained(50)
                .build();

    }
}