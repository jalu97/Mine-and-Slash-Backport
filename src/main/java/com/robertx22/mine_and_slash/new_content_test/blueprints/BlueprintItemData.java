package com.robertx22.mine_and_slash.new_content_test.blueprints;

import com.robertx22.mine_and_slash.database.rarities.GearRarity;
import com.robertx22.mine_and_slash.db_lists.Rarities;
import com.robertx22.mine_and_slash.new_content_test.blueprints.requests.BlueprintDataItemRequest;
import com.robertx22.mine_and_slash.new_content_test.blueprints.requests.BlueprintSimpleItemRequest;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.TooltipContext;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.TooltipInfo;
import com.robertx22.mine_and_slash.uncommon.datasaving.Blueprint;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.DataItemType;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.ICommonDataItem;
import com.robertx22.mine_and_slash.uncommon.localization.Words;
import info.loenwind.autosave.annotations.Storable;
import info.loenwind.autosave.annotations.Store;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

import java.util.ArrayList;
import java.util.List;

@Storable
public class BlueprintItemData implements ICommonDataItem<GearRarity> {

    @Store
    public List<BlueprintDataItemRequest> dataRequests = new ArrayList<>();

    @Store
    public List<BlueprintSimpleItemRequest> simpleItemRequests = new ArrayList<>();

    @Store
    public BlueprintGearReward gearReward = new BlueprintGearReward();

    @Store
    public int level;

    @Store
    public int tier;

    @Store
    public int rarity;

    @Override
    public void saveToStack(ItemStack stack) {
        Blueprint.Save(stack, this);
    }

    public int getDifficulty() {

        int diff = 0;

        diff += dataRequests.stream()
                .mapToInt(BlueprintDataItemRequest::getDifficultyValue)
                .sum();

        diff += simpleItemRequests.stream()
                .mapToInt(BlueprintSimpleItemRequest::getDifficultyValue)
                .sum();

        return diff;

    }

    @Override
    public DataItemType getDataType() {
        return DataItemType.BLUEPRINT;
    }

    @Override
    public String getUniqueGUID() {
        return "";
    }

    @Override
    public void BuildTooltip(TooltipContext ctx) {
        List<ITextComponent> tooltip = ctx.event.getToolTip();

        TooltipInfo info = new TooltipInfo();

        tooltip.add(Words.Requirements.locName().appendText(": "));

        dataRequests.forEach(x -> tooltip.addAll(x.GetTooltipString(info)));
        simpleItemRequests.forEach(x -> tooltip.addAll(x.GetTooltipString(info)));

    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getRarityRank() {
        return rarity;
    }

    @Override
    public GearRarity getRarity() {
        return Rarities.Items.get(rarity);
    }

    @Override
    public ItemStack getSalvageResult(float salvageBonus) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean isSalvagable(SalvageContext context) {
        return false;
    }

    @Override
    public int Tier() {
        return tier;
    }

    @Override
    public String getSpecificType() {
        return "";
    }
}
