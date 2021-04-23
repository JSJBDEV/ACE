package gd.rf.acro.ace.items;

import gd.rf.acro.ace.spells.Spell;
import gd.rf.acro.ace.spells.Spells;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;

public interface IRenderableCastingDevice {
    Spell getEquipped(ItemStack stack);
    void scrollMinus(ItemStack stack);
    void scrollPlus(ItemStack stack);
    void addSpell(ItemStack stack, Spell... spell);
    void removeSpell(ItemStack stack, Spell spell);
}
