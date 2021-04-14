package gd.rf.acro.ace;

import net.minecraft.world.World;

public class Calendar {

    public static String getDate(long lunar)
    {
        return getDayPeriod(lunar)+" of the "+getMoonCycle(lunar)+getCorrect(getMoonCycle(lunar))+" "+getMoonPhaseName(lunar);

    }

    public static int getMoonCycle(long lunarTime) {
        return (int)(lunarTime / 24000L / 8L) + 1;
    }

    public static int getMoonPhase(long lunarTime) {
        return (int)(lunarTime / 24000L % 8L + 8L) % 8;
    }
    public static String getMoonPhaseName(long lunarTime)
    {
        
        switch (getMoonPhase(lunarTime))
        {
            default:
                return "Full moon";
            case 1:
                return "Waning gibbous";
            case 2:
                return "Third quarter";
            case 3:
                return "Waning crescent";
            case 4:
                return "New moon";
            case 5:
                return "Waxing crescent";
            case 6:
                return "First quarter";
            case 7:
                return "Waxing gibbous";
                
        }
        
    }
    public static String getCorrect(int no)
    {
        if(no==1)
        {
            return "st";
        }
        if(no==2)
        {
            return "nd";
        }
        if(no==3)
        {
            return "rd";
        }
        return "th";
    }
    
    public static String getDayPeriod(long lunarTime)
    {
        long tod = lunarTime % 24000L;
        if(tod>=6000 && tod<12000)
        {
            return "Afternoon";
        }
        if(tod>=12000 && tod < 13000)
        {
            return "Sunset";
        }
        if(tod>=13000 && tod < 18000)
        {
            return "Dusk";
        }
        if(tod>=18000 && tod < 23000)
        {
            return "Twilight";
        }
        if(tod>=23000 && tod < 24000)
        {
            return "Dawn";
        }
        return "Morning";
    }
}
