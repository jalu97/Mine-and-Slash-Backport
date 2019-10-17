package com.robertx22.mine_and_slash.database.items.currency.loc_reqs;

import com.robertx22.mine_and_slash.config.ModConfig;
import com.robertx22.mine_and_slash.database.items.currency.ItemLevelUpGear;
import com.robertx22.mine_and_slash.saveclasses.item_classes.GearItemData;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.IRarity;
import com.robertx22.mine_and_slash.uncommon.localization.Words;
import net.minecraft.util.text.ITextComponent;

import java.util.function.Predicate;

public class SimpleGearLocReq extends BaseLocRequirement {

    public static final SimpleGearLocReq NO_SET = new SimpleGearLocReq(x -> x.set == null, Words.Doesnthaveset
            .locName());
    public static final SimpleGearLocReq NO_PREFIX = new SimpleGearLocReq(x -> x.prefix == null, Words.NoPrefix
            .locName());
    public static final SimpleGearLocReq NO_SUFFIX = new SimpleGearLocReq(x -> x.suffix == null, Words.NoSuffix
            .locName());
    public static final SimpleGearLocReq SEC_STAT_NOT_ALREADY_ADDED = new SimpleGearLocReq(x -> x.secondaryStats != null && x.secondaryStats.AddedStat == false, Words.CanOnlyUseOnce
            .locName());
    public static final SimpleGearLocReq HAS_INSFUSION = new SimpleGearLocReq(x -> x.infusion != null, Words.HasInfusion
            .locName());
    public static final SimpleGearLocReq LVLED_LESS_THAN_10_TIMES = new SimpleGearLocReq(x -> x.timesLeveledUp < ItemLevelUpGear.MAXIMUM_LEVEL_UPS, Words.CanOnlyUse10times
            .locName());
    public static final SimpleGearLocReq NO_CHAOS_STATS = new SimpleGearLocReq(x -> x.chaosStats == null, Words.NoChaosStats
            .locName());
    public static final SimpleGearLocReq LEVEL_ISNT_HIGHER_THAN_MAX = new SimpleGearLocReq(x -> x.level < ModConfig.INSTANCE.Server.MAXIMUM_PLAYER_LEVEL
            .get(), Words.LvlLessThanMax.locName());
    public static final SimpleGearLocReq IS_COMMON = new SimpleGearLocReq(x -> x.Rarity == IRarity.Common, Words.IsCommon
            .locName());
    public static final SimpleGearLocReq IS_LOWER_THAN_MYTHIC = new SimpleGearLocReq(x -> x.Rarity < IRarity.Mythic, Words.isLowerThanMythic
            .locName());
    public static final SimpleGearLocReq IS_NOT_UNIQUE = new SimpleGearLocReq(x -> x.Rarity != IRarity.Unique, Words.isNotUnique
            .locName());
    public static final SimpleGearLocReq IS_UNIQUE = new SimpleGearLocReq(x -> x.Rarity == IRarity.Unique, Words.isUnique
            .locName());

    public static final BaseLocRequirement HAS_PREFIX = new SimpleGearLocReq(x -> x.prefix != null, Words.hasPrefix
            .locName());
    public static final BaseLocRequirement HAS_SUFFIX = new SimpleGearLocReq(x -> x.suffix != null, Words.hasSuffix
            .locName());
    public static final BaseLocRequirement HAS_SET = new SimpleGearLocReq(x -> x.set != null, Words.hasSet
            .locName());
    public static final BaseLocRequirement HAS_PRIMARY_STATS = new SimpleGearLocReq(x -> x.primaryStats != null, Words.hasSet
            .locName());
    public static final BaseLocRequirement HAS_UNIQUE_STATS = new SimpleGearLocReq(x -> x.uniqueStats != null, Words.hasUniqueStats
            .locName());
    public static final BaseLocRequirement CAN_UPGRADE_INFUSION = new SimpleGearLocReq(x -> x.infusion != null && x.infusion
            .canUpgrade(), Words.canUpgradeInfusion.locName());

    private SimpleGearLocReq(Predicate<GearItemData> pred, ITextComponent text) {
        this.text = text;
        this.gearsThatCanDoThis = pred;
    }

    Predicate<GearItemData> gearsThatCanDoThis;
    ITextComponent text;

    @Override
    public ITextComponent getText() {

        return text;
    }

    @Override
    public boolean isAllowed(LocReqContext context) {

        if (context.data instanceof GearItemData) {
            GearItemData gear = (GearItemData) context.data;
            return gearsThatCanDoThis.test(gear);

        }

        return false;
    }

}
