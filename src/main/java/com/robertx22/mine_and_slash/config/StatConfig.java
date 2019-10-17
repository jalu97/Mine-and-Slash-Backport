package com.robertx22.mine_and_slash.config;

import scala.Double;

public class StatConfig {

    public static final String NAME = "BASE_STATS";

    public Double physical_damage;
    public Double physical_damage_per_level;
    public Double mana;
    public Double mana_per_level;
    public Double energy;
    public Double energy_per_level;
    public Double mana_regen;
    public Double mana_regen_per_level;
    public Double health_regen;
    public Double health_regen_per_level;
    public Double armor;
    public Double armor_per_level;
    public Double health;
    public Double health_per_level;

    public Double magic_shield;
    public Double magic_shield_per_level;
    public Double magic_shield_regen;
    public Double magic_shield_regen_per_level;

    public Double critical_hit;
    public Double critical_hit_per_level;
    public Double energy_regen;
    public Double energy_regen_per_level;
    public Double critical_damage;
    public Double critical_damage_per_level;
    public Double spell_damage;
    public Double spell_damage_per_level;

    StatConfig(ForgeConfigSpec.Builder builder) {
        builder.push("PLAYER_BASE_STATS");

        energy = builder.translation("mmorpg.stat.energy")
                .defineInRange("energy", 0F, 0, Integer.MAX_VALUE);
        energy_per_level = builder.translation("mmorpg.stat.energy_per_level")
                .defineInRange("energy_per_level", 125F, 0, Integer.MAX_VALUE);
        energy_regen = builder.translation("mmorpg.stat.energy_regen")
                .defineInRange("energy_regen", 0F, 0, Integer.MAX_VALUE);
        energy_regen_per_level = builder.translation("mmorpg.stat.energy_regen_per_level")
                .defineInRange("energy_regen_per_level", 7F, 0, Integer.MAX_VALUE);

        mana = builder.translation("mmorpg.stat.mana")
                .defineInRange("mana", 0F, 0, Integer.MAX_VALUE);
        mana_per_level = builder.translation("mmorpg.stat.mana_per_level")
                .defineInRange("mana_per_level", 50F, 0, Integer.MAX_VALUE);
        mana_regen = builder.translation("mmorpg.stat.mana_regen")
                .defineInRange("mana_regen", 0F, 0, Integer.MAX_VALUE);
        mana_regen_per_level = builder.translation("mmorpg.stat.mana_regen_per_level")
                .defineInRange("mana_regen_per_level", 3F, 0, Integer.MAX_VALUE);

        health = builder.translation("mmorpg.stat.health")
                .defineInRange("health", 100F, 0, Integer.MAX_VALUE);
        health_per_level = builder.translation("mmorpg.stat.health_per_level")
                .defineInRange("health_per_level", 5F, 0, Integer.MAX_VALUE);
        health_regen = builder.translation("mmorpg.stat.health_regen")
                .defineInRange("health_regen", 4F, 0, Integer.MAX_VALUE);
        health_regen_per_level = builder.translation("mmorpg.stat.health_regen_per_level")
                .defineInRange("health_regen_per_level", 1F, 0, Integer.MAX_VALUE);

        magic_shield = builder.translation("mmorpg.stat.magic_shield")
                .defineInRange("magic_shield", 0D, 0, Integer.MAX_VALUE);
        magic_shield_per_level = builder.translation("mmorpg.stat.magic_shield_per_level")
                .defineInRange("magic_shield_per_level", 0D, 0, Integer.MAX_VALUE);
        magic_shield_regen = builder.translation("mmorpg.stat.magic_shield_regen")
                .defineInRange("magic_shield_regen", 3D, 0, Integer.MAX_VALUE);
        magic_shield_regen_per_level = builder.translation("mmorpg.stat.magic_shield_regen_per_level")
                .defineInRange("magic_shield_regen_per_level", 1D, 0, Integer.MAX_VALUE);

        physical_damage = builder.translation("mmorpg.stat.physical_damage")
                .defineInRange("physical_damage", 3F, 0, Integer.MAX_VALUE);
        physical_damage_per_level = builder.translation("mmorpg.stat.physical_damage_per_level")
                .defineInRange("physical_damage_per_level", 0.3F, 0, Integer.MAX_VALUE);
        armor = builder.translation("mmorpg.stat.armor")
                .defineInRange("armor", 10F, 0, Integer.MAX_VALUE);
        armor_per_level = builder.translation("mmorpg.stat.armor_per_level")
                .defineInRange("armor_per_level", 5F, 0, Integer.MAX_VALUE);

        critical_hit = builder.translation("mmorpg.stat.critical_hit")
                .defineInRange("critical_hit", 1F, 0, Integer.MAX_VALUE);
        critical_hit_per_level = builder.translation("mmorpg.stat.critical_hit_per_level")
                .defineInRange("critical_hit_per_level", 0F, 0, Integer.MAX_VALUE);
        critical_damage = builder.translation("mmorpg.stat.critical_damage")
                .defineInRange("critical_damage", 0F, 0, Integer.MAX_VALUE);
        critical_damage_per_level = builder.translation("mmorpg.stat.critical_damage_per_level")
                .defineInRange("critical_damage_per_level", 0F, 0, Integer.MAX_VALUE);

        spell_damage = builder.translation("mmorpg.stat.spell_damage")
                .defineInRange("spell_damage", 3F, 0, Integer.MAX_VALUE);
        spell_damage_per_level = builder.translation("mmorpg.stat.spell_damage_per_level")
                .defineInRange("spell_damage_per_level", 0.25F, 0, Integer.MAX_VALUE);

        builder.pop();

    }
}