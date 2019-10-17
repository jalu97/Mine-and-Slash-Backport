package com.robertx22.mine_and_slash.db_lists.registry;

import com.robertx22.mine_and_slash.config.compatible_items.ConfigItem;
import com.robertx22.mine_and_slash.config.dimension_configs.DimensionConfig;
import com.robertx22.mine_and_slash.config.whole_mod_entity_configs.ModEntityConfig;
import com.robertx22.mine_and_slash.database.affixes.Prefix;
import com.robertx22.mine_and_slash.database.affixes.Suffix;
import com.robertx22.mine_and_slash.database.gearitemslots.bases.GearItemSlot;
import com.robertx22.mine_and_slash.database.item_modifications.bases.BaseItemModification;
import com.robertx22.mine_and_slash.database.item_modifications.gear_items.AddChaosStatMod;
import com.robertx22.mine_and_slash.database.items.currency.CurrencyItem;
import com.robertx22.mine_and_slash.database.items.currency.ItemOrbOfTransmutation;
import com.robertx22.mine_and_slash.database.items.runes.base.BaseRuneItem;
import com.robertx22.mine_and_slash.database.items.runes.base.BaseUniqueRuneItem;
import com.robertx22.mine_and_slash.database.items.runes.unique_runes.PSIItem;
import com.robertx22.mine_and_slash.database.items.unique_items.IUnique;
import com.robertx22.mine_and_slash.database.map_affixes.BaseMapAffix;
import com.robertx22.mine_and_slash.database.runewords.RuneWord;
import com.robertx22.mine_and_slash.database.sets.Set;
import com.robertx22.mine_and_slash.database.spells.bases.BaseSpell;
import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.status_effects.bases.BaseStatusEffect;
import com.robertx22.mine_and_slash.database.talent_tree.Perk;
import com.robertx22.mine_and_slash.database.talent_tree.PerkEffect;
import com.robertx22.mine_and_slash.database.talent_tree.data.StartPerkEffects;
import com.robertx22.mine_and_slash.database.world_providers.BaseWorldProvider;
import com.robertx22.mine_and_slash.database.world_providers.BirchForestIWP;
import com.robertx22.mine_and_slash.db_lists.initializers.*;
import com.robertx22.mine_and_slash.db_lists.initializers.profession_recipes.AlchemyRecipes;
import com.robertx22.mine_and_slash.db_lists.registry.empty_entries.*;
import com.robertx22.mine_and_slash.dimensions.MapManager;
import com.robertx22.mine_and_slash.professions.recipe.BaseRecipe;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.IWorld;

import java.util.HashMap;

public class SlashRegistry {

    public static DimensionConfig getDimensionConfig(IWorld world) {
        String id = MapManager.getId(world);
        return DimensionConfigs().get(id);

    }

    public static ModEntityConfig getEntityConfig(LivingEntity entity,
                                                  EntityCap.UnitData data) {

        String monster_id = entity.getType().getRegistryName().toString();
        String mod_id = entity.getType().getRegistryName().getNamespace();

        ModEntityConfig config = null;

        if (EntityConfigs().isRegistered(monster_id)) {
            config = EntityConfigs().get(monster_id);
            if (config != null) {
                return config;
            }
        } else {
            if (EntityConfigs().isRegistered(mod_id)) {
                config = EntityConfigs().get(mod_id);

                if (config != null) {
                    return config;
                }

            } else {
                config = EntityConfigs().byEntityTypeDefault.get(data.getType());

                if (config != null) {
                    return config;
                }
            }
        }

        return EntityConfigs().getDefault();

    }

    public static SlashRegistryContainer<PerkEffect> PerkEffects() {
        return getRegistry(SlashRegistryType.PERK_EFFECT);
    }

    public static SlashRegistryContainer<Perk> Perks() {
        return getRegistry(SlashRegistryType.PERK);
    }

    public static SlashRegistryContainer<BaseRecipe> Recipes() {
        return getRegistry(SlashRegistryType.RECIPE);
    }

    public static SlashRegistryContainer<CurrencyItem> CurrencyItems() {
        return getRegistry(SlashRegistryType.CURRENCY_ITEMS);
    }

    public static SlashRegistryContainer<BaseUniqueRuneItem> UniqueRunes() {
        return getRegistry(SlashRegistryType.UNIQUE_RUNES);
    }

    private static SlashRegistryContainer<DimensionConfig> DimensionConfigs() {
        return getRegistry(SlashRegistryType.DIMENSION_CONFIGS);
    }

    public static SlashRegistryContainer<BaseItemModification> ItemModifications() {
        return getRegistry(SlashRegistryType.ITEM_MODIFICATION);
    }

    public static SlashRegistryContainer<ConfigItem> CompatibleItems() {
        return getRegistry(SlashRegistryType.COMPATIBLE_ITEM);
    }

    public static SlashRegistryContainer<BaseStatusEffect> StatusEffects() {
        return getRegistry(SlashRegistryType.STATUS_EFFECT);
    }

    public static SlashRegistryContainer<BaseMapAffix> MapAffixes() {
        return getRegistry(SlashRegistryType.MAP_AFFIX);
    }

    public static SlashRegistryContainer<IUnique> UniqueGears() {
        return getRegistry(SlashRegistryType.UNIQUE_GEAR);
    }

    public static SlashRegistryContainer<Set> Sets() {
        return getRegistry(SlashRegistryType.SET);
    }

    public static SlashRegistryContainer<Prefix> Prefixes() {
        return getRegistry(SlashRegistryType.PREFIX);
    }

    public static SlashRegistryContainer<Suffix> Suffixes() {
        return getRegistry(SlashRegistryType.SUFFIX);
    }

    public static SlashRegistryContainer<GearItemSlot> GearTypes() {
        return getRegistry(SlashRegistryType.GEAR_TYPE);
    }

    public static SlashRegistryContainer<BaseSpell> Spells() {
        return getRegistry(SlashRegistryType.SPELL);
    }

    public static SlashRegistryContainer<BaseRuneItem> Runes() {
        return getRegistry(SlashRegistryType.RUNE);
    }

    public static SlashRegistryContainer<RuneWord> RuneWords() {
        return getRegistry(SlashRegistryType.RUNEWORD);
    }

    public static SlashRegistryContainer<BaseWorldProvider> WorldProviders() {
        return getRegistry(SlashRegistryType.WORLD_PROVIDER);
    }

    public static ModEntityContainer EntityConfigs() {
        return (ModEntityContainer) getRegistry(SlashRegistryType.MOD_ENTITY_CONFIGS);
    }

    public static SlashRegistryContainer<Stat> Stats() {
        return getRegistry(SlashRegistryType.STAT);
    }

    public static SlashRegistryContainer<StatMod> StatMods() {
        return getRegistry(SlashRegistryType.STATMOD);
    }

    private static HashMap<SlashRegistryType, SlashRegistryContainer> map = new HashMap<>();

    public static SlashRegistryContainer getRegistry(SlashRegistryType type) {
        return map.get(type);
    }

    public static ISlashRegistryEntry get(SlashRegistryType type, String guid) {
        return getRegistry(type).get(guid);

    }

    public static void init() {
        try {
            map = new HashMap<>(); // same reason this is here
            createRegistries();
            registerFromAllInits();
        } catch (ExceptionInInitializerError e) {
            // leave this, once this error happened and we don't know why. this is to know the cause if it happens again
            e.printStackTrace();
            e.getCause().printStackTrace();
        }
    }

    private static void registerFromAllInits() {

        new Spells().registerAll(); // some stats are based on spells, so spells go first
        new Stats().registerAll();// STATS MUST BE INIT before STATMODS  cus statmods ARE DERIVED FROM STATS, or should be at least
        new StatMods().registerAll();
        new Runes().registerAll();
        new RuneWords().registerAll();
        new GearTypes().registerAll();
        new MapAffixes().registerAll();
        new Prefixes().registerAll();
        new Suffixes().registerAll();
        new StatusEffects().registerAll();
        new UniqueGears().registerAll();
        new WorldProviders().registerAll();
        new Sets().registerAll();
        new ItemModifications().registerAll();
        new CurrencyItems().registerAll();
        new UniqueRunes().registerAll();

        // professions
        new AlchemyRecipes().registerAll();

        new PerkEffectsInit().registerAll();
        new Perks().registerAll();

    }

    private static void createRegistries() {
        map.put(SlashRegistryType.GEAR_TYPE, new SlashRegistryContainer<GearItemSlot>(SlashRegistryType.GEAR_TYPE, new EmptyGearType()));
        map.put(SlashRegistryType.STAT, new SlashRegistryContainer<Stat>(SlashRegistryType.STAT, new EmptyStat()));
        map.put(SlashRegistryType.STATMOD, new SlashRegistryContainer<StatMod>(SlashRegistryType.STATMOD, new EmptyStatMod()));
        map.put(SlashRegistryType.SET, new SlashRegistryContainer<Set>(SlashRegistryType.SET, new EmptySet()));
        map.put(SlashRegistryType.SPELL, new SlashRegistryContainer<BaseSpell>(SlashRegistryType.SPELL, new EmptySpell()));
        map.put(SlashRegistryType.UNIQUE_GEAR, new SlashRegistryContainer<IUnique>(SlashRegistryType.UNIQUE_GEAR, new EmptyUnique()));
        map.put(SlashRegistryType.UNIQUE_RUNES, new SlashRegistryContainer<BaseUniqueRuneItem>(SlashRegistryType.UNIQUE_RUNES, new PSIItem()));
        map.put(SlashRegistryType.SUFFIX, new SlashRegistryContainer<Suffix>(SlashRegistryType.SUFFIX, new EmptySuffix()));
        map.put(SlashRegistryType.PREFIX, new SlashRegistryContainer<Prefix>(SlashRegistryType.PREFIX, new EmptyPrefix()));
        map.put(SlashRegistryType.RUNE, new SlashRegistryContainer<BaseRuneItem>(SlashRegistryType.RUNE, new EmptyRune(0)));
        map.put(SlashRegistryType.RUNEWORD, new SlashRegistryContainer<RuneWord>(SlashRegistryType.RUNEWORD, new EmptyRuneWord()));
        map.put(SlashRegistryType.MAP_AFFIX, new SlashRegistryContainer<BaseMapAffix>(SlashRegistryType.MAP_AFFIX, new EmptyMapAffix()));
        map.put(SlashRegistryType.STATUS_EFFECT, new SlashRegistryContainer<BaseStatusEffect>(SlashRegistryType.STATUS_EFFECT, new EmptyStatusEffect()));
        map.put(SlashRegistryType.WORLD_PROVIDER, new SlashRegistryContainer<BaseWorldProvider>(SlashRegistryType.WORLD_PROVIDER, new BirchForestIWP(null, null)));
        map.put(SlashRegistryType.ITEM_MODIFICATION, new SlashRegistryContainer<BaseItemModification>(SlashRegistryType.ITEM_MODIFICATION, new AddChaosStatMod()));
        map.put(SlashRegistryType.CURRENCY_ITEMS, new SlashRegistryContainer<CurrencyItem>(SlashRegistryType.CURRENCY_ITEMS, new ItemOrbOfTransmutation()));
        map.put(SlashRegistryType.RECIPE, new SlashRegistryContainer<BaseRecipe>(SlashRegistryType.RECIPE, null));
        map.put(SlashRegistryType.COMPATIBLE_ITEM, new SlashRegistryContainer<ConfigItem>(SlashRegistryType.COMPATIBLE_ITEM, new ConfigItem())
                .dontErrorIfEmpty()
                .logAdditions());
        map.put(SlashRegistryType.DIMENSION_CONFIGS, new SlashRegistryContainer<DimensionConfig>(SlashRegistryType.DIMENSION_CONFIGS, DimensionConfig
                .DefaultExtra()).logAdditions().dontErrorMissingEntriesOnAccess());
        map.put(SlashRegistryType.MOD_ENTITY_CONFIGS, new ModEntityContainer(SlashRegistryType.MOD_ENTITY_CONFIGS)
                .logAdditions());
        map.put(SlashRegistryType.PERK, new SlashRegistryContainer<Perk>(SlashRegistryType.PERK, null));
        map.put(SlashRegistryType.PERK_EFFECT, new SlashRegistryContainer<PerkEffect>(SlashRegistryType.PERK_EFFECT, StartPerkEffects.GUARDIAN));

    }

}
