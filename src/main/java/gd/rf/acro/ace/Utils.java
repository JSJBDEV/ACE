package gd.rf.acro.ace;

import com.mojang.datafixers.kinds.IdF;
import gd.rf.acro.ace.items.DustyTomeItem;
import gd.rf.acro.ace.spells.Spell;
import gd.rf.acro.ace.spells.Spells;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {


    public static int random(int min, int max)
    {
        if(min<0)
        {
            return (RandomUtils.nextInt(0,max+Math.abs(min))-Math.abs(min));
        }
        return RandomUtils.nextInt(min,max);
    }

    public static LivingEntity castBeam(LivingEntity user, World world, float[] rgb)
    {
        return castBeam(user, world, rgb,5);
    }
    public static LivingEntity castBeam(LivingEntity user, World world, float[] rgb,float size)
    {
        LivingEntity livingEntity = getRaycastHit(user,world);
        Random random = new Random();
        if (livingEntity!=null) {
            double d = 1D;
            double e = livingEntity.getX() - user.getBlockPos().getX();
            double f = livingEntity.getBodyY(0.5D) - user.getEyeY();
            double g = livingEntity.getZ() - user.getZ();
            double h = Math.sqrt(e * e + f * f + g * g);
            e /= h;
            f /= h;
            g /= h;
            double j = random.nextDouble();

            while(j < h) {
                j += 1.8D - d + random.nextDouble() * (1.7D - d);
                world.addParticle(new DustParticleEffect(rgb[0],rgb[1],rgb[2],size), user.getBlockPos().getX() + e * j, user.getEyeY() + f * j, user.getBlockPos().getZ() + g * j, 0.0D, 0.0D, 0.0D);

            }
        }
        return livingEntity;
    }
    public static void castBeamToPos(LivingEntity user, BlockPos pos, World world, float[] rgb, float size)
    {
        Random random = new Random();
        double d = 1D;
        double e = pos.getX() - user.getBlockPos().getX();
        double f = pos.getY() - user.getEyeY();
        double g = pos.getZ() - user.getZ();
        double h = Math.sqrt(e * e + f * f + g * g);
        e /= h;
        f /= h;
        g /= h;
        double j = random.nextDouble();

        while(j < h) {
            j += 1.8D - d + random.nextDouble() * (1.7D - d);
            world.addParticle(new DustParticleEffect(rgb[0],rgb[1],rgb[2],size), user.getBlockPos().getX() + e * j, user.getEyeY() + f * j, user.getBlockPos().getZ() + g * j, 0.0D, 0.0D, 0.0D);

        }
    }
    public static LivingEntity castConnection(LivingEntity user,LivingEntity livingEntity, World world, float[] rgb,int size)
    {
        Random random = new Random();
        if (livingEntity!=null) {
            double d = 1D;
            double e = livingEntity.getX() - user.getBlockPos().getX();
            double f = livingEntity.getBodyY(0.5D) - user.getEyeY();
            double g = livingEntity.getZ() - user.getZ();
            double h = Math.sqrt(e * e + f * f + g * g);
            e /= h;
            f /= h;
            g /= h;
            double j = random.nextDouble();

            while(j < h) {
                j += 1.8D - d + random.nextDouble() * (1.7D - d);
                world.addParticle(new DustParticleEffect(rgb[0],rgb[1],rgb[2],size), user.getBlockPos().getX() + e * j, user.getEyeY() + f * j, user.getBlockPos().getZ() + g * j, 0.0D, 0.0D, 0.0D);

            }
        }
        return livingEntity;
    }
    private static LivingEntity getRaycastHit(LivingEntity user, World world)
    {
        HitResult result = user.raycast(100,1,true);
        return world.getClosestEntity(LivingEntity.class, TargetPredicate.DEFAULT,user,result.getPos().getX(),result.getPos().getY(),result.getPos().getZ(),new Box(result.getPos().getX()-2,result.getPos().getY()-2,result.getPos().getZ()-2,result.getPos().getX()+2,result.getPos().getY()+2,result.getPos().getZ()+2));

    }

    public static float[] getColourForElement(String element)
    {
        switch (element)
        {
            case "fire":
                return new float[] {1,0,0};
            case "water":
                return new float[]{0,0,1};
            case "earth":
                return new float[]{0,1,0};

        }
        return new float[]{0,0,0};
    }

    public static MutableText getSpellName(Spell spell)
    {
        String[] r = spell.getClass().getSimpleName().split("(?=\\p{Upper})");
        LiteralText text = new LiteralText( String.join(" ",r));

        return text.setStyle(Style.EMPTY.withBold(false).withItalic(false).withUnderline(false).withColor(TextColor.fromRgb(getSpellColour(spell))));
    }
    public static int getSpellColour(Spell spell)
    {
        switch (spell.element())
        {
            case "fire":
                return Formatting.RED.getColorValue();
            case "water":
                return Formatting.BLUE.getColorValue();
            case "air":
                return Formatting.WHITE.getColorValue();
            case "earth":
                return Formatting.GREEN.getColorValue();

        }
        return Formatting.WHITE.getColorValue();
    }

    public static MutableText getSpellDisplay(Spell spell)
    {
        LiteralText text = new LiteralText(" ");
        text.setStyle(Style.EMPTY.withItalic(false));
        return text.append(Utils.getSpellIcon(spell)).append(Utils.getSpellName(spell));
    }

    public static String getSpellTranslatable(Spell spell)
    {
        return "ace."+spell.getClass().getSimpleName()+".desc";
    }

    //TODO: find something like hashcode but that doesn't change each boot
    public static MutableText getSpellIcon(Spell spell)
    {
        String variationSelector = "";
        //seems cursed, but the alchemical symbols are far outside minecrafts range
        //(the alchemical symbols are at 1F700 but minecrafts range stops at FF00)
        //so instead we use variation selectors 1-4, which are used for maths and stuff
        //but I feel like they probably wont pose much a problem here
        //The alternative is to use minecrafts fonts system but its considerably more complex
        //when I can literally modify minecrafts unicode_page_fe and putting in the symbols we want
        //https://unicode-table.com/en/blocks/alchemical-symbols/
        //https://unicode-table.com/en/blocks/variation-selectors/
        switch (spell.element())
        {
            case "fire":
                variationSelector="︀";
                break;
            case "air":
                variationSelector="︁";
                break;
            case "earth":
                variationSelector="︂";
                break;
            case "water":
                variationSelector="︃";
                break;
        }
        LiteralText text = new LiteralText(variationSelector);
        Style style = Style.EMPTY;
        style = style.withColor(TextColor.fromRgb(spell.getClass().hashCode()));
        if(spell.getClass().hashCode()%5==0)
        {
            style = style.withBold(true);
        }
        if(spell.getClass().hashCode()%7==0)
        {
            style = style.withUnderline(true);
        }
        if(spell.getClass().hashCode()%11==0)
        {
            style = style.withItalic(true);
        }
        text.setStyle(style);
        return text;
    }

    public static List<Spell> getSpellsInInventory(PlayerEntity playerEntity)
    {
        ArrayList<Spell> spells = new ArrayList<>();
        playerEntity.inventory.main.forEach(stack->
        {
            if(stack.getItem() instanceof DustyTomeItem)
            {
                spells.add(Spells.getSpellBySimpleClassName(stack.getTag().getString("spell")));
            }
        });
        return spells;
    }

}
