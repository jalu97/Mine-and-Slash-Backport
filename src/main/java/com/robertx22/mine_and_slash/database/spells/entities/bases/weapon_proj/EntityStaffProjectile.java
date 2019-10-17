package com.robertx22.mine_and_slash.database.spells.entities.bases.weapon_proj;

import com.robertx22.mine_and_slash.database.spells.bases.BaseSpellEffect;
import com.robertx22.mine_and_slash.database.spells.bases.DamageData;
import com.robertx22.mine_and_slash.database.spells.entities.bases.EntityBaseProjectile;
import com.robertx22.mine_and_slash.items.gearitems.weapon_mechanics.StaffWeaponMechanic;
import com.robertx22.mine_and_slash.mmorpg.registers.common.EntityRegister;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap.UnitData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.WorldUtils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class EntityStaffProjectile extends EntityBaseProjectile {

    ItemStack staff;

    public EntityStaffProjectile(EntityType<? extends EntityStaffProjectile> type,
                                 World world) {
        super(type, world);
    }

    public EntityStaffProjectile(World worldIn) {
        super(EntityRegister.STAFFPROJECTILE, worldIn);

    }

    public EntityStaffProjectile(FMLPlayMessages.SpawnEntity spawnEntity, World world) {
        super(EntityRegister.STAFFPROJECTILE, world);
    }

    public void SetReady(ItemStack staff) {
        this.staff = staff;
    }

    @Override
    public double radius() {
        return 0.5D;
    }

    @Override
    protected void onImpact(RayTraceResult result) {

        LivingEntity entity = getEntityHit(result, 0.5D);

        if (entity != null && staff != null) {

            if (!world.isRemote) {
                try {

                    UnitData sourcedata = Load.Unit(this.thrower);
                    UnitData targetdata = Load.Unit(entity);

                    StaffWeaponMechanic.INSTANCE.powerAttack(null, this.getThrower(), entity, sourcedata, targetdata, this.charge);

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }

        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte) 3);
            this.remove();
        }

    }

    @Override
    public void tick() {

        super.tick();

        if (world.isRemote) {
            for (int i = 0; i < 5; i++) {

                this.world.addParticle(ParticleTypes.CRIT, true, this.posX + rand.nextFloat() * 0.2 - 0.1, this.posY + this
                        .getHeight() / 2 + rand.nextFloat() * 0.2 - 0.1, this.posZ + rand.nextFloat() * 0.2 - 0.1, 0, 0, 0);

            }
        }

        if (this.ticksExisted > 20) {
            this.remove();
        }
    }

    public void SpawnAndShoot(BaseSpellEffect effect, DamageData data,
                              LivingEntity caster) {
        SpawnAndShoot(effect, data, caster, 1.5F);
    }

    public void SpawnAndShoot(BaseSpellEffect effect, DamageData data,
                              LivingEntity caster, float vel) {

        this.ignoreEntity = caster;
        this.thrower = caster;

        SetReady(caster.getHeldItemMainhand());
        this.setPos(caster);
        shoot(caster, caster.rotationPitch, caster.rotationYaw, 0.0F, vel, 1.0F);

        WorldUtils.spawnEntity(world, this);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack getItem() {
        return new ItemStack(Items.ENDER_PEARL);
    }
}