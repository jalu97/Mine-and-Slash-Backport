package com.robertx22.mine_and_slash.world_gen.structures;

import com.robertx22.mine_and_slash.mmorpg.registers.common.StructurePieceRegisters;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.PlayerUtils;
import com.robertx22.mine_and_slash.world_gen.structures.bases.StructurePieceData;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.function.Function;

public class Random1ChunkDunStructure extends ScatteredStructure<NoFeatureConfig> {

    public Random1ChunkDunStructure(
            Function<Dynamic<?>, ? extends NoFeatureConfig> dynamic) {
        super(dynamic);
    }

    @Override
    public String getStructureName() {
        return Ref.MODID + ":dungeon0";
    }

    @Override
    public int getSize() {
        return 3;
    }

    @Override
    public Structure.IStartFactory getStartFactory() {
        return Start::new;
    }

    @Override
    protected int getSeedModifier() {
        return 3;
    }

    public static class Start extends StructureStart {
        public Start(Structure<?> structure, int chunkX, int chunkZ, Biome biome,
                     MutableBoundingBox boundingbox, int referenceIn, long longNum) {
            super(structure, chunkX, chunkZ, biome, boundingbox, referenceIn, longNum);

        }

        @Override
        public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn,
                         int chunkX, int chunkZ, Biome biomeIn) {

            if (rand.nextInt(100) > 30) {
                int x = chunkX * 16;
                int z = chunkZ * 16;

                BlockPos blockpos = new BlockPos(x, 90, z);

                PlayerUtils.sendPlayersMSGofStructureSpawnTEST(blockpos, "dungeon0");

                Rotation rotation = Rotation.NONE;

                StructurePieceData data = new StructurePieceData(StructurePieceRegisters.FLOATING_ISLAND, templateManagerIn, blockpos, rotation, biomeIn);

                Random1ChunkDunPieces.init(data, this.components, this.rand);
                this.recalculateStructureSize();
            }
        }
    }

}