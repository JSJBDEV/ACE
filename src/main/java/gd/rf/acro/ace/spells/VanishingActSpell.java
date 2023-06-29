package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class VanishingActSpell extends SpellACE {
    @Override
    public String getCastingType() {
        return "snap";
    }

    @Override
    public Element getElement() {
        return "air";
    }

    @Override
    public int getTier() {
        return 0;
    }

    @Override
    public int getManaCost() {
        return 10;
    }

    @Override
    public void snapCast(LivingEntity caster) {
        super.snapCast(caster);
        if(caster instanceof PlayerEntity)
        {
            PlayerEntity playerEntity = (PlayerEntity) caster;
            if(playerEntity.getOffHandStack().getItem()!= ACE.DUSTY_TOME_ITEM)
            {
                playerEntity.getEnderChestInventory().addStack(playerEntity.getOffHandStack());
                playerEntity.getOffHandStack().setCount(0);
            }
        }
    }
}
