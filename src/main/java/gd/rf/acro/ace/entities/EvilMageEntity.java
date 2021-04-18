package gd.rf.acro.ace.entities;

import gd.rf.acro.ace.ACE;
import gd.rf.acro.ace.spells.ShotgunSpell;
import gd.rf.acro.ace.spells.Spell;
import gd.rf.acro.ace.spells.Spells;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

public class EvilMageEntity extends HostileEntity implements RangedAttackMob {
    private ListTag spells;

    public EvilMageEntity(World world) {
        super(ACE.EVIL_MAGE_ENTITY_TYPE, world);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(4, new CastSnapSpellGoal<>(this,1.0D, 20, 15.0F));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.targetSelector.add(2, new FollowTargetGoal(this, PlayerEntity.class, true));
    }
    public static DefaultAttributeContainer.Builder attributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2D);
    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {

        if(spells!=null && spells.size()>0)
        {
            Spell spell = Spells.getSpellByName(spells.get(RandomUtils.nextInt(0,spells.size())).asString());
            spell.snapCast(this);
        }
    }
    protected void initEquipment(LocalDifficulty difficulty) {
        super.initEquipment(difficulty);
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ACE.BASIC_WAND));

    }

    @Override
    public void writeCustomDataToTag(CompoundTag tag) {
        super.writeCustomDataToTag(tag);
        tag.put("spells",spells);
    }

    @Override
    public void readCustomDataFromTag(CompoundTag tag) {
        super.readCustomDataFromTag(tag);
        spells= (ListTag) tag.get("spells");
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, CompoundTag entityTag) {
        entityData = super.initialize(world, difficulty, spawnReason, entityData, entityTag);
        initEquipment(difficulty);
        List<Spell> all = Spells.getSpellsByStyle("snap");

        spells=new ListTag();
        spells.add(StringTag.of("EmberSpell"));
        for (int i = 0; i < 5; i++) {
            String aSpell = all.get(RandomUtils.nextInt(0,all.size())).name();
            spells.add(StringTag.of(aSpell));
        }
        System.out.println(spells.toString());
        return entityData;
    }
}
