package com.robertx22.mine_and_slash.mmorpg.registers.common;

import com.robertx22.mine_and_slash.mmorpg.MMORPG;
import com.robertx22.mine_and_slash.network.*;
import com.robertx22.mine_and_slash.network.sync_cap.RequestSyncCapToClient;
import com.robertx22.mine_and_slash.network.sync_cap.SyncCapabilityToClient;

public class PacketRegister {
    public static void register() {
        int index = 0;

        MMORPG.Network.registerMessage(index++, EntityUnitPacket.class, EntityUnitPacket::encode, EntityUnitPacket::decode, EntityUnitPacket::handle);

        MMORPG.Network.registerMessage(index++, DmgNumPacket.class, DmgNumPacket::encode, DmgNumPacket::decode, DmgNumPacket::handle);

        MMORPG.Network.registerMessage(index++, NoEnergyPacket.class, NoEnergyPacket::encode, NoEnergyPacket::decode, NoEnergyPacket::handle);

        MMORPG.Network.registerMessage(index++, ParticleGenPacket.class, ParticleGenPacket::encode, ParticleGenPacket::decode, ParticleGenPacket::handle);

        MMORPG.Network.registerMessage(index++, RequestTilePacket.class, RequestTilePacket::encode, RequestTilePacket::decode, RequestTilePacket::handle);

        MMORPG.Network.registerMessage(index++, MasterBagPacket.class, MasterBagPacket::encode, MasterBagPacket::decode, MasterBagPacket::handle);

        MMORPG.Network.registerMessage(index++, RarityItemDropPacket.class, RarityItemDropPacket::encode, RarityItemDropPacket::decode, RarityItemDropPacket::handle);

        MMORPG.Network.registerMessage(index++, ProfessionRecipePacket.class, ProfessionRecipePacket::encode, ProfessionRecipePacket::decode, ProfessionRecipePacket::handle);

        MMORPG.Network.registerMessage(index++, SyncCapabilityToClient.class, SyncCapabilityToClient::encode, SyncCapabilityToClient::decode, SyncCapabilityToClient::handle);

        MMORPG.Network.registerMessage(index++, RequestSyncCapToClient.class, RequestSyncCapToClient::encode, RequestSyncCapToClient::decode, RequestSyncCapToClient::handle);

        MMORPG.Network.registerMessage(index++, SpendStatPointPacket.class, SpendStatPointPacket::encode, SpendStatPointPacket::decode, SpendStatPointPacket::handle);

        MMORPG.Network.registerMessage(index++, OpenPickStatsGuiPacket.class, OpenPickStatsGuiPacket::encode, OpenPickStatsGuiPacket::decode, OpenPickStatsGuiPacket::handle);

        MMORPG.Network.registerMessage(index++, AllocateTalentPacket.class, AllocateTalentPacket::encode, AllocateTalentPacket::decode, AllocateTalentPacket::handle);

        MMORPG.Network.registerMessage(index++, OpenTalentsGuiPacket.class, OpenTalentsGuiPacket::encode, OpenTalentsGuiPacket::decode, OpenTalentsGuiPacket::handle);

        MMORPG.Network.registerMessage(index++, TryRemoveTalentPacket.class, TryRemoveTalentPacket::encode, TryRemoveTalentPacket::decode, TryRemoveTalentPacket::handle);

    }

}


