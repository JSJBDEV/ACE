package gd.rf.acro.ace.entities;

import gd.rf.acro.ace.ACE;
import gd.rf.acro.ace.Utils;
import gd.rf.acro.ace.spells.ChainLightningSpell;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BoltEntity extends SnowballEntity {
    private LivingEntity in;
    private float damage=1;
    private String extra="";


    public BoltEntity(EntityType<? extends SnowballEntity> entityType, World world,LivingEntity caster,Item toShow,float damageTo, String special) {
        super(entityType, world);
        in=caster;
        setItem(new ItemStack(toShow));
        damage=damageTo;
        extra=special;

    }
    public BoltEntity(World world)
    {
        super(ACE.BOLT_ENTITY_TYPE, world);
        System.out.println("world");
    }
    public BoltEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
        System.out.println("uses xyz");
    }



    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Utils.applyMagicModDamage(in,entityHitResult.getEntity(),damage);
        if(in!=null)
        {
            if(extra.contains("freeze") && entityHitResult.getEntity() instanceof LivingEntity)
            {
                ((LivingEntity) entityHitResult.getEntity()).addStatusEffect(new StatusEffectInstance(ACE.FREEZE_EFFECT,100,2));
            }
            if(extra.contains("force"))
            {
                Vec3d v = this.getVelocity();
                entityHitResult.getEntity().addVelocity(v.x,v.y,v.z);
            }
            if(extra.contains("burn"))
            {
                entityHitResult.getEntity().setOnFireFor(5);
            }
            if(extra.contains("chain") && entityHitResult.getEntity() instanceof LivingEntity)
            {
                ChainLightningSpell.chain((LivingEntity) entityHitResult.getEntity(),in);
            }

        }
    }





    @Override
    protected Item getDefaultItem() {
        return Items.ACACIA_BOAT;
    }

    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        Entity entity = in;
        return new EntitySpawnS2CPacket(this, entity == null ? 0 : entity.getId());
    }
}
