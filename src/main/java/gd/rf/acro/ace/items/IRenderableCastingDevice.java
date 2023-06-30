package gd.rf.acro.ace.items;

import gd.rf.acro.ace.spells.SpellACE;
import net.minecraft.item.ItemStack;

public interface IRenderableCastingDevice {
    SpellACE getEquipped(ItemStack stack);
    void scrollMinus(ItemStack stack);
    void scrollPlus(ItemStack stack);
    void addSpell(ItemStack stack, SpellACE... spell);
    void removeSpell(ItemStack stack, SpellACE spell);
}
