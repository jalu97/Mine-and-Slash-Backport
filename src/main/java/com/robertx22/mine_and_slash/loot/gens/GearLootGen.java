package com.robertx22.mine_and_slash.loot.gens;

import com.robertx22.mine_and_slash.config.ModConfig;
import com.robertx22.mine_and_slash.database.items.unique_items.IUnique;
import com.robertx22.mine_and_slash.database.rarities.GearRarity;
import com.robertx22.mine_and_slash.db_lists.Rarities;
import com.robertx22.mine_and_slash.loot.LootInfo;
import com.robertx22.mine_and_slash.loot.LootUtils;
import com.robertx22.mine_and_slash.loot.blueprints.GearBlueprint;
import com.robertx22.mine_and_slash.loot.blueprints.UniqueGearBlueprint;
import com.robertx22.mine_and_slash.saveclasses.gearitem.*;
import com.robertx22.mine_and_slash.saveclasses.item_classes.GearItemData;
import com.robertx22.mine_and_slash.saveclasses.rune.RunesData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Gear;
import com.robertx22.mine_and_slash.uncommon.enumclasses.LootType;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.RandomUtils;
import net.minecraft.item.ItemStack;

public class GearLootGen extends BaseLootGen {

    public GearLootGen(LootInfo info) {
        super(info);
    }

    @Override
    public float BaseChance() {
        return ModConfig.INSTANCE.DropRates.GEAR_DROPRATE.get().floatValue();
    }

    @Override
    public LootType lootType() {
        return LootType.NormalItem;
    }

    @Override
    public ItemStack generateOne() {

        GearBlueprint gearPrint = new GearBlueprint(info.level);

        ItemStack stack = CreateStack(gearPrint);

        GearItemData gear = Gear.Load(stack);

        return LootUtils.RandomDamagedGear(stack, gear.getRarity(), gear.level);

    }

    public static GearItemData CreateData(GearBlueprint blueprint) {
        return GearLootGen.CreateData(blueprint, GearItemEnum.NORMAL);
    }

    public static GearItemData CreateData(GearBlueprint blueprint, GearItemEnum type) {

        GearRarity rarity = Rarities.Items.get(blueprint.getRarityRank());
        GearItemData data = new GearItemData();

        data.level = blueprint.getLevel();
        data.gearTypeName = blueprint.GetGearType().GUID();
        data.Rarity = rarity.Rank();

        if (type == GearItemEnum.UNIQUE && blueprint instanceof UniqueGearBlueprint) {

            UniqueGearBlueprint uniqprint = (UniqueGearBlueprint) blueprint;

            IUnique unique = uniqprint.getUnique();

            if (unique != null) {
                data.gearTypeName = unique.getGearSlot().GUID();

                data.isUnique = true;

                data.uniqueGUID = unique.GUID();
                data.uniqueStats = new UniqueStatsData(unique.GUID());
                data.uniqueStats.RerollFully(data);

                if (unique.canGetSet()) {
                    data.set = new SetData();
                    data.set = data.set.generate(data);

                }

            } else {
                return null;
            }
        }

        data.requirements = new StatRequirementsData();
        data.requirements.create(data);

        if (type.canGetPrimaryStats()) {
            data.primaryStats = new PrimaryStatsData();
            data.primaryStats.RerollFully(data);
        }
        if (type.canGetSecondaryStats()) {
            data.secondaryStats = new SecondaryStatsData();
            data.secondaryStats.RerollFully(data);
        }
        if (type.canGetChaosStats()) {
            if (blueprint.getsChaosStats()) {
                data.chaosStats = new ChaosStatsData();
                data.chaosStats.RerollFully(data);
            }
        }

        if (type.canGetAffixes()) {
            if (RandomUtils.roll(rarity.AffixChance())) {

                data.suffix = new SuffixData();
                data.suffix.RerollFully(data);

            }
            if (RandomUtils.roll(rarity.AffixChance())) {

                data.prefix = new PrefixData();
                data.prefix.RerollFully(data);

            }
        }
        if (type.canGetSet()) {
            if (blueprint.canGetSet(data)) {
                data.set = new SetData();
                data.set = data.set.generate(data);
            }
        }

        if (type == GearItemEnum.RUNED) {
            data.runes = new RunesData();
            data.runes.capacity = rarity.runeSlots();
        }

        return data;
    }

    public static ItemStack CreateStack(GearBlueprint schema) {

        GearItemData data = CreateData(schema);
        ItemStack stack = new ItemStack(data.getItem());
        Gear.Save(stack, data);
        return stack;

    }

    public static ItemStack CreateStack(GearItemData data) {

        ItemStack stack = new ItemStack(data.getItem());
        Gear.Save(stack, data);
        return stack;

    }

}
