package gd.rf.acro.ace.spells;

import gd.rf.acro.ace.ACE;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class VanishingActSpell extends Spell {
    @Override
    public String spellType() {
        return "snap";
    }

    @Override
    public String element() {
        return "air";
    }

    @Override
    public int tier() {
        return 0;
    }

    @Override
    public int cost() {
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
