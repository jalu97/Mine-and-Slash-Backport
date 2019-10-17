package com.robertx22.mine_and_slash.items.bags.master_bag;

import com.robertx22.mine_and_slash.items.bags.BaseBagItem;
import com.robertx22.mine_and_slash.items.bags.BaseInventory;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.uncommon.interfaces.IAutoLocName;
import com.robertx22.mine_and_slash.uncommon.item_filters.bases.ItemFilterGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ItemMasterBag extends BaseBagItem implements IAutoLocName {

    public static final String ID = Ref.MODID + ":master_bag";

    @ObjectHolder(ID)
    public static final Item ITEM = null;

    public ItemMasterBag() {
        super(ID);
        this.size *= ContainerMasterBag.ItemType.values().length;
        this.showCraftWarning = false;

    }

    @Override
    public BaseInventory getInventory(ItemStack bag, ItemStack stack) {

        if (stack.getCount() > 0 && filterGroup().anyMatchesFilter(stack)) {

            ContainerMasterBag.ItemType type = getItemType(stack);

            return new InventoryMasterBag(bag, type);

        }
        return null;

    }

    public static ContainerMasterBag.ItemType getItemType(ItemStack stack) {

        for (ContainerMasterBag.ItemType type : ContainerMasterBag.ItemType.values()) {
            if (type.filter.anyMatchesFilter(stack)) {
                return type;
            }
        }
        return ContainerMasterBag.ItemType.GEAR;

    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player,
                                                    @Nonnull Hand hand) {

        if (!world.isRemote) {

            ItemStack bag = player.getHeldItemMainhand();

            if (bag.getItem() instanceof ItemMasterBag) {
                NetworkHooks.openGui((ServerPlayerEntity) player, getNamedContainer(bag), extraData -> {
                    extraData.writeString(ContainerMasterBag.ItemType.GEAR.toString());
                });
            }
        }

        return ActionResult.newResult(ActionResultType.SUCCESS, player.getHeldItemMainhand());
    }

    @Override
    public ItemFilterGroup filterGroup() {
        return ItemFilterGroup.ANY_MASTER_BAG;
    }

    @Override
    public INamedContainerProvider getNamedContainer(ItemStack stack) {
        return new NamedMasterBag(stack, ContainerMasterBag.ItemType.GEAR);
    }

    @Override
    public AutoLocGroup locNameGroup() {
        return AutoLocGroup.Misc;
    }

    @Override
    public String locNameLangFileGUID() {
        return this.getRegistryName().toString();
    }

    @Override
    public String locNameForLangFile() {
        return TextFormatting.YELLOW + "Master Bag";
    }

    @Override
    public String GUID() {
        return "master_bag";
    }

    public static String NBT_ID = "mmorpg:master_loot_bag_data";

    @Override
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(
            ItemStack stack, @Nullable CompoundNBT nbt) {
        // TO TRANSFER TO NEW NBT SYSTEM WITHOUT LOSING ITEMS
        if (nbt != null && nbt.contains(NBT_ID)) {
            stack.setTag(nbt);
        }

        return null;
    }

}
