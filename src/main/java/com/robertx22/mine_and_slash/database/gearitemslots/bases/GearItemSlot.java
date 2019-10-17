package com.robertx22.mine_and_slash.database.gearitemslots.bases;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.AllTraitMods;
import com.robertx22.mine_and_slash.database.stats.mods.flat.ArmorFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.DodgeRatingFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.corestats.*;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.ManaFlat;
import com.robertx22.mine_and_slash.database.stats.types.core_stats.*;
import com.robertx22.mine_and_slash.db_lists.Rarities;
import com.robertx22.mine_and_slash.db_lists.registry.ISlashRegistryEntry;
import com.robertx22.mine_and_slash.db_lists.registry.SlashRegistry;
import com.robertx22.mine_and_slash.db_lists.registry.SlashRegistryType;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.Rarity;
import com.robertx22.mine_and_slash.uncommon.interfaces.IAutoLocName;
import com.robertx22.mine_and_slash.uncommon.interfaces.IWeighted;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public abstract class GearItemSlot implements IWeighted, IAutoLocName, ISlashRegistryEntry<GearItemSlot> {

    public enum GearSlotType {
        Weapon,
        Armor,
        Jewerly,
        OffHand
    }

    public int cooldownTicks() {
        return 20;
    }

    public boolean isGearOfThisType(Item item) {
        return false;
    }

    public abstract String resourceID();

    public static List<StatMod> leatherArmorStats() {
        return Arrays.asList(new DodgeRatingFlat(), new DodgeRatingFlat(), new StaminaFlat(), new DexterityFlat());
    }

    public static List<StatMod> plateArmorStats() {
        return Arrays.asList(new ArmorFlat().multi(1.25F), new VitalityFlat(), new StrengthFlat());
    }

    public static List<StatMod> clothArmorStats() {
        return Arrays.asList(new ArmorFlat().multi(0.75F), new ManaFlat().multi(1.75F), new IntelligenceFlat(), new WisdomFlat());
    }

    public List<Stat> statRequirements() {
        return Arrays.asList();
    }

    public static List<Stat> plateRequirements() {
        return Arrays.asList(Strength.INSTANCE, Vitality.INSTANCE);
    }

    public static List<Stat> clothRequirements() {
        return Arrays.asList(Intelligence.INSTANCE, Wisdom.INSTANCE);
    }

    public static List<Stat> leatherRequirements() {
        return Arrays.asList(Dexterity.INSTANCE, Stamina.INSTANCE);
    }

    @Override
    public int getRarityRank() {
        return 0;
    }

    @Override
    public Rarity getRarity() {
        return Rarities.Items.get(getRarityRank());
    }

    @Override
    public int Tier() {
        return 0;
    }

    @Override
    public SlashRegistryType getSlashRegistryType() {
        return SlashRegistryType.GEAR_TYPE;
    }

    @Override
    public AutoLocGroup locNameGroup() {
        return AutoLocGroup.Gear_Slots;
    }

    public abstract GearSlotType slotType();

    public List<StatMod> coreStatMods() {
        return Arrays.asList(new StrengthFlat(), new VitalityFlat(), new IntelligenceFlat(), new WisdomFlat(), new StaminaFlat(), new DexterityFlat());
    }

    @Override
    public String locNameLangFileGUID() {
        return Ref.MODID + ".gear_type." + formattedGUID();
    }

    public abstract List<StatMod> PrimaryStats();

    public abstract List<StatMod> PossibleSecondaryStats();

    public Item DefaultItem() {
        return Items.AIR;
    }

    public abstract HashMap<Integer, Item> ItemsForRarities();

    public int Weight() {
        return 1000;
    }

    public ItemStack GetStackForRarity(int rarityNum) {

        if (ItemsForRarities().containsKey(rarityNum)) {
            return new ItemStack(ItemsForRarities().get(rarityNum));
        }

        return new ItemStack(DefaultItem());

    }

    public Item GetItemForRarity(int rarityNum) {

        if (ItemsForRarities().containsKey(rarityNum)) {
            return ItemsForRarities().get(rarityNum);
        }

        return DefaultItem();

    }

    public List<StatMod> ChaosStats() {

        List<StatMod> list = new ArrayList<StatMod>();

        for (StatMod mod : SlashRegistry.StatMods().getAll().values()) {
            if (mod instanceof AllTraitMods) {
                list.add(mod);
            }
        }

        return list;
    }

}
