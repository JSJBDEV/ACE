package gd.rf.acro.ace;

import gd.rf.acro.ace.items.DustyTomeItem;
import gd.rf.acro.ace.spells.Spell;
import gd.rf.acro.ace.spells.Spells;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.SpawnerBlock;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {


    //random but it can process minus numbers, useful for coordinates
    public static int random(int min, int max)
    {
        if(min<0)
        {
            return (RandomUtils.nextInt(0,max+Math.abs(min))-Math.abs(min));
        }
        return RandomUtils.nextInt(min,max);
    }
    public static int randomNoZero(int min, int max)
    {
        if(min<1)
        {
            int g = (RandomUtils.nextInt(1,max+Math.abs(min))-Math.abs(min));
            if(g!=0){return g;}
            return randomNoZero(min,max);
        }

        return RandomUtils.nextInt(min,max);
    }

    //this should probably be deprecated, see below
    public static LivingEntity castBeam(LivingEntity user, World world, float[] rgb)
    {
        return castBeam(user, world, rgb,5);
    }

    //makes a particle beam using a raycast
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
    //makes a particle beam to a blockpos
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
    //makes a particle beam between 2 entities
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
            case "air":
                return new float[]{1,1,1};

        }
        return new float[]{0,0,0};
    }

    //Turns the spell class name into normal english
    @Environment(EnvType.CLIENT)
    public static MutableText getFormattedSpellName(Spell spell)
    {
        String[] r = spell.name().split("(?=\\p{Upper})");
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

    //helper method to render on dusty tomes and in hud
    @Environment(EnvType.CLIENT)
    public static MutableText getSpellDisplay(Spell spell)
    {
        LiteralText text = new LiteralText(" ");
        text.setStyle(Style.EMPTY.withItalic(false));
        return text.append(Utils.getSpellIcon(spell)).append(Utils.getFormattedSpellName(spell));
    }

    //A spell description
    public static String getSpellTranslatable(Spell spell)
    {
        return "ace."+ spell.name()+".desc";
    }


    //gets a procedurally generated icon for a spell including ones I don't add
    @Environment(EnvType.CLIENT)
    public static MutableText getSpellIcon(Spell spell)
    {
        int spellNumber = (int) getSpellNumber(spell);
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
        style = style.withColor(TextColor.fromRgb(spellNumber));
        if(spellNumber%5==0)
        {
            style = style.withBold(true);
        }
        if(spellNumber%7==0)
        {
            style = style.withUnderline(true);
        }
        if(spellNumber%11==0)
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
                spells.add(Spells.getSpellByName(stack.getTag().getString("spell")));
            }
        });
        return spells;
    }

    public static void modifyDevotionValue(LivingEntity entity,String devotion, int amount)
    {
        Scoreboard scoreboard = entity.world.getScoreboard();
        if(!scoreboard.getObjectiveNames().contains("ace_"+devotion))
        {
            scoreboard.addObjective("ace_"+devotion, ScoreboardCriterion.DUMMY,new LiteralText("Devotion to "+devotion), ScoreboardCriterion.RenderType.INTEGER);
        }
        scoreboard.getPlayerScore(entity.getUuidAsString(),scoreboard.getObjective("ace_"+devotion)).incrementScore(amount);
    }
    public static int getDevotionTo(LivingEntity entity, String devotion)
    {
        Scoreboard scoreboard = entity.world.getScoreboard();
        if(!scoreboard.getObjectiveNames().contains("ace_"+devotion))
        {
            scoreboard.addObjective("ace_"+devotion, ScoreboardCriterion.DUMMY,new LiteralText("Devotion to "+devotion), ScoreboardCriterion.RenderType.INTEGER);
        }
        return scoreboard.getPlayerScore(entity.getUuidAsString(),scoreboard.getObjective("ace_"+devotion)).getScore();
    }

    //creates an AreaEffectCloud entity (like in dragons breath potions)
    public static void createAOE(World world, BlockPos pos,float[] rgb, StatusEffectInstance effect)
    {
        AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(world,pos.getX(),pos.getY(),pos.getZ());
        areaEffectCloudEntity.setParticleType(new DustParticleEffect(rgb[0],rgb[1],rgb[2],1));
        areaEffectCloudEntity.setRadius(3.0F);
        areaEffectCloudEntity.setDuration(200);
        areaEffectCloudEntity.setRadiusGrowth((7.0F - areaEffectCloudEntity.getRadius()) / (float)areaEffectCloudEntity.getDuration());
        areaEffectCloudEntity.addEffect(effect);
        world.spawnEntity(areaEffectCloudEntity);
    }

    //Congruential number generation because hashcodes change but pseudorandom doesn't
    public static long getSpellNumber(Spell spell)
    {

        int numbers = spell.name().chars().sum();
        return ((numbers+5441441)*3411241)%92341123;
    }

    public static ItemStack createRocketStack()
    {
        ItemStack stack = new ItemStack(Items.FIREWORK_ROCKET);
        CompoundTag tag = new CompoundTag();
        ListTag explosions = new ListTag();
        for (int i = 0; i < RandomUtils.nextInt(1,7); i++) {
            CompoundTag explosion = new CompoundTag();
            explosion.putBoolean("Flicker",RandomUtils.nextBoolean());
            explosion.putBoolean("Trail",RandomUtils.nextBoolean());
            explosion.putInt("Type",RandomUtils.nextInt(0,5));
            explosion.putIntArray("Colors",genColourList(RandomUtils.nextInt(1,5)));
            explosion.putIntArray("FadeColors",genColourList(RandomUtils.nextInt(1,5)));
            explosions.add(explosion);
        }
        tag.put("Explosions",explosions);
        tag.putInt("Flight",Utils.random(-5,5));
        CompoundTag fireworks = new CompoundTag();
        fireworks.put("Fireworks",tag);
        stack.setTag(fireworks);
        return stack;
    }
    public static List<Integer> genColourList(int length)
    {
        List<Integer> colours = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            colours.add(Formatting.byColorIndex(RandomUtils.nextInt(0,16)).getColorValue());
        }

        return colours;
    }

}
