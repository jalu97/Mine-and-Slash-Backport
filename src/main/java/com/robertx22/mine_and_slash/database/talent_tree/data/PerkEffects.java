package com.robertx22.mine_and_slash.database.talent_tree.data;

import com.robertx22.mine_and_slash.database.stats.types.core_stats.*;
import com.robertx22.mine_and_slash.database.stats.types.defense.Armor;
import com.robertx22.mine_and_slash.database.stats.types.defense.BlockStrength;
import com.robertx22.mine_and_slash.database.stats.types.defense.DodgeRating;
import com.robertx22.mine_and_slash.database.stats.types.generated.*;
import com.robertx22.mine_and_slash.database.stats.types.offense.CriticalDamage;
import com.robertx22.mine_and_slash.database.stats.types.offense.CriticalHit;
import com.robertx22.mine_and_slash.database.stats.types.offense.PhysicalDamage;
import com.robertx22.mine_and_slash.database.stats.types.offense.SpellDamage;
import com.robertx22.mine_and_slash.database.stats.types.resources.*;
import com.robertx22.mine_and_slash.database.talent_tree.PerkEffectBuilder;
import com.robertx22.mine_and_slash.database.talent_tree.PerkEffectsWrapper;
import com.robertx22.mine_and_slash.saveclasses.ExactStatData;
import com.robertx22.mine_and_slash.uncommon.effectdatas.interfaces.WeaponTypes;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.enumclasses.StatTypes;

import java.util.HashMap;

public class PerkEffects {

    public static PerkEffectsWrapper SPELL_DMG;
    public static PerkEffectsWrapper CRIT_HIT;
    public static PerkEffectsWrapper CRIT_DMG;

    public static PerkEffectsWrapper INTELLIGENCE;
    public static PerkEffectsWrapper WISDOM;
    public static PerkEffectsWrapper STAMINA;
    public static PerkEffectsWrapper DEXTERITY;
    public static PerkEffectsWrapper VITALITY;
    public static PerkEffectsWrapper STRENGTH;

    public static PerkEffectsWrapper MAGIC_SHIELD_PERCENT;
    public static PerkEffectsWrapper MANA_PERCENT;
    public static PerkEffectsWrapper BLOCK_PERCENT;
    public static PerkEffectsWrapper HEALTH_PERCENT;
    public static PerkEffectsWrapper ENERGY_PERCENT;
    public static PerkEffectsWrapper DODGE_PERCENT;
    public static PerkEffectsWrapper ARMOR_PERCENT;
    public static PerkEffectsWrapper MANA_REGEN_PERCENT;
    public static PerkEffectsWrapper HEALTH_REGEN_PERCENT;
    public static PerkEffectsWrapper ENERGY_REGEN_PERCENT;
    public static PerkEffectsWrapper MAGIC_SHIELD_REGEN_PERCENT;
    public static PerkEffectsWrapper PHYSICAL_DMG;

    // COMBINED EFFECTS
    public static PerkEffectsWrapper MANA_PERC_PLUS_MAGIC_SHIELD_PERCENT, CRIT_HIT_CRIT_DMG;
    public static PerkEffectsWrapper INT_WIS, STR_CRIT_DMG, ENE_ENE_REGEN, STA_DEX, DODGE_ENE_REGEN, DODGE_ENE;
    public static PerkEffectsWrapper HP_HP_REGEN, PHYS_DMG_CRIT_DMG, PHYS_DMG_CRIT_HIT, MANA_MANA_REGEN;

    public static HashMap<WeaponTypes, PerkEffectsWrapper> WEP_DMG_MAP = new HashMap<>();
    public static HashMap<WeaponTypes, PerkEffectsWrapper> WEP_ELE_DMG_MAP = new HashMap<>();

    public static HashMap<Elements, PerkEffectsWrapper> ELE_RES_PERCENT_MAP = new HashMap<>();
    public static HashMap<Elements, PerkEffectsWrapper> SPELL_DMG_PERCENT_MAP = new HashMap<>();
    public static HashMap<Elements, PerkEffectsWrapper> ATTACK_DAMAGE_PERCENT_MAP = new HashMap<>();
    public static HashMap<Elements, PerkEffectsWrapper> SPELL_TO_ATK_DAMAGE_MAP = new HashMap<>();
    public static HashMap<Elements, PerkEffectsWrapper> SPELL_TO_ATK_DAMAGE_PERCENT_MAP = new HashMap<>();
    public static HashMap<Elements, PerkEffectsWrapper> All_ELE_DMG_MAP = new HashMap<>();
    public static HashMap<Elements, PerkEffectsWrapper> ELE_PENE_PERCENT_MAP = new HashMap<>();

    public static void create() {

        PHYSICAL_DMG = PerkEffectBuilder.build("phys_dmg", PhysicalDamage.INSTANCE, new ExactStatData(2, StatTypes.Percent, PhysicalDamage.GUID));
        SPELL_DMG = PerkEffectBuilder.build("spell_dmg", SpellDamage.INSTANCE, new ExactStatData(2, StatTypes.Flat, SpellDamage.GUID));
        CRIT_HIT = PerkEffectBuilder.build("crit_hit", CriticalHit.INSTANCE, new ExactStatData(2, StatTypes.Flat, CriticalHit.GUID));
        CRIT_DMG = PerkEffectBuilder.build("crit_dmg", CriticalDamage.INSTANCE, new ExactStatData(3, StatTypes.Flat, CriticalDamage.GUID));
        BLOCK_PERCENT = PerkEffectBuilder.build("block_percent", BlockStrength.INSTANCE, new ExactStatData(3, StatTypes.Percent, BlockStrength.GUID));

        int core_amount = 1;

        INTELLIGENCE = PerkEffectBuilder.build("int", Intelligence.INSTANCE, new ExactStatData(core_amount, StatTypes.Flat, Intelligence.GUID));
        WISDOM = PerkEffectBuilder.build("wis", Wisdom.INSTANCE, new ExactStatData(core_amount, StatTypes.Flat, Wisdom.GUID));

        STAMINA = PerkEffectBuilder.build("sta", Stamina.INSTANCE, new ExactStatData(core_amount, StatTypes.Flat, Stamina.GUID));
        DEXTERITY = PerkEffectBuilder.build("dex", Dexterity.INSTANCE, new ExactStatData(core_amount, StatTypes.Flat, Dexterity.GUID));

        VITALITY = PerkEffectBuilder.build("vit", Vitality.INSTANCE, new ExactStatData(core_amount, StatTypes.Flat, Vitality.GUID));
        STRENGTH = PerkEffectBuilder.build("str", Strength.INSTANCE, new ExactStatData(core_amount, StatTypes.Flat, Strength.GUID));

        MAGIC_SHIELD_PERCENT = PerkEffectBuilder.build("ms_percent", MagicShield.INSTANCE, new ExactStatData(4, StatTypes.Percent, MagicShield.GUID));
        MANA_PERCENT = PerkEffectBuilder.build("mana_percent", Mana.INSTANCE, new ExactStatData(4, StatTypes.Percent, Mana.GUID));
        HEALTH_PERCENT = PerkEffectBuilder.build("hp_percent", Health.INSTANCE, new ExactStatData(3, StatTypes.Percent, Health.GUID));
        ENERGY_PERCENT = PerkEffectBuilder.build("energy_percent", Energy.INSTANCE, new ExactStatData(4, StatTypes.Percent, Energy.GUID));
        DODGE_PERCENT = PerkEffectBuilder.build("dodge_percent", DodgeRating.INSTANCE, new ExactStatData(5, StatTypes.Percent, DodgeRating.GUID));
        ARMOR_PERCENT = PerkEffectBuilder.build("armor_percent", Armor.INSTANCE, new ExactStatData(5, StatTypes.Percent, Armor.GUID));

        MANA_REGEN_PERCENT = PerkEffectBuilder.build("mana_regen_percent", ManaRegen.INSTANCE, new ExactStatData(5, StatTypes.Percent, ManaRegen.GUID));
        HEALTH_REGEN_PERCENT = PerkEffectBuilder.build("hp_regen_percent", HealthRegen.INSTANCE, new ExactStatData(5, StatTypes.Percent, HealthRegen.GUID));
        ENERGY_REGEN_PERCENT = PerkEffectBuilder.build("energy_regen_percent", EnergyRegen.INSTANCE, new ExactStatData(5, StatTypes.Percent, EnergyRegen.GUID));
        MAGIC_SHIELD_REGEN_PERCENT = PerkEffectBuilder.build("ms_regen_percent", MagicShieldRegen.INSTANCE, new ExactStatData(5, StatTypes.Percent, MagicShieldRegen.GUID));

        float wepDmg = 2;

        for (WeaponTypes wep : WeaponTypes.getAll()) {
            WEP_DMG_MAP.put(wep, PerkEffectBuilder.build(wep.name()
                    .toLowerCase() + "_dmg_percent", new WeaponDamage(wep), new ExactStatData(wepDmg, StatTypes.Flat, new WeaponDamage(wep))));

            WEP_ELE_DMG_MAP.put(wep, PerkEffectBuilder.build(wep.name()
                    .toLowerCase() + "_ele_dmg_percent", EleWepDmg.MAP.get(wep), new ExactStatData(wepDmg, StatTypes.Flat, EleWepDmg.MAP
                    .get(wep))));

        }

        float elenum = 5;

        for (Elements ele : Elements.values()) {

            ELE_RES_PERCENT_MAP.put(ele, PerkEffectBuilder.build(ele.name()
                    .toLowerCase() + "_res", new ElementalResist(ele), new ExactStatData(elenum, StatTypes.Percent, new ElementalResist(ele))));

            SPELL_DMG_PERCENT_MAP.put(ele, PerkEffectBuilder.build(ele.name()
                    .toLowerCase() + "_spell_dmg", new ElementalSpellDamage(ele), new ExactStatData(elenum, StatTypes.Percent, new ElementalSpellDamage(ele))));

            ELE_PENE_PERCENT_MAP.put(ele, PerkEffectBuilder.build(ele.name()
                    .toLowerCase() + "_pene", new ElementalPene(ele), new ExactStatData(elenum, StatTypes.Percent, new ElementalPene(ele))));

            ATTACK_DAMAGE_PERCENT_MAP.put(ele, PerkEffectBuilder.build(ele.name()
                    .toLowerCase() + "_attack_dmg", new ElementalAttackDamage(ele), new ExactStatData(elenum, StatTypes.Percent, new ElementalAttackDamage(ele))));

            SPELL_TO_ATK_DAMAGE_MAP.put(ele, PerkEffectBuilder.build(ele.name()
                    .toLowerCase() + "_spell_to_attack_dmg", new ElementalSpellToAttackDMG(ele), new ExactStatData(elenum, StatTypes.Flat, new ElementalSpellToAttackDMG(ele))));

            SPELL_TO_ATK_DAMAGE_PERCENT_MAP.put(ele, PerkEffectBuilder.build(ele.name()
                    .toLowerCase() + "_spell_to_attack_dmg_percent", new ElementalSpellToAttackDMG(ele), new ExactStatData(10, StatTypes.Percent, new ElementalSpellToAttackDMG(ele))));

            All_ELE_DMG_MAP.put(ele, PerkEffectBuilder.build(ele.name()
                    .toLowerCase() + "_all_dmg", new AllElementalDamage(ele), new ExactStatData(elenum, StatTypes.Flat, new AllElementalDamage(ele))));

        }

    }

    public static void createCombined() {

        MANA_PERC_PLUS_MAGIC_SHIELD_PERCENT = PerkEffectBuilder.build("mana_ms_percent", MAGIC_SHIELD_PERCENT
                .small(), MANA_PERCENT.small());

        INT_WIS = PerkEffectBuilder.build("int_wis", INTELLIGENCE.small(), WISDOM.small());
        STA_DEX = PerkEffectBuilder.build("sta_dex", STAMINA.small(), DEXTERITY.small());
        HP_HP_REGEN = PerkEffectBuilder.build("hp_hp_regen", HEALTH_PERCENT.small(), HEALTH_REGEN_PERCENT
                .small());
        ENE_ENE_REGEN = PerkEffectBuilder.build("ene_ene_regen", ENERGY_REGEN_PERCENT.small(), ENERGY_PERCENT
                .small());
        MANA_MANA_REGEN = PerkEffectBuilder.build("mana_mana_regen", MANA_REGEN_PERCENT.small(), MANA_PERCENT
                .small());

        PHYS_DMG_CRIT_DMG = PerkEffectBuilder.build("phys_dmg_crit_dmg", PHYSICAL_DMG.small(), CRIT_DMG
                .small());

        PHYS_DMG_CRIT_HIT = PerkEffectBuilder.build("phys_dmg_crit_hit", PHYSICAL_DMG.small(), CRIT_HIT
                .small());
        CRIT_HIT_CRIT_DMG = PerkEffectBuilder.build("crit_hit_crit_dmg", CRIT_DMG.small(), CRIT_HIT
                .small());

        STR_CRIT_DMG = PerkEffectBuilder.build("str_crit_dmg", STRENGTH.small(), CRIT_DMG.small());
        DODGE_ENE_REGEN = PerkEffectBuilder.build("dodge_ene_regen", DODGE_PERCENT.small(), ENERGY_REGEN_PERCENT
                .small());
        DODGE_ENE = PerkEffectBuilder.build("dodge_ene", DODGE_PERCENT.small(), ENERGY_PERCENT
                .small());

    }

}

