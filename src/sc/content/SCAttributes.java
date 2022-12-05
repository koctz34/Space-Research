package sc.content;

import mindustry.world.meta.Attribute;

public class SCAttributes {
    public static Attribute waterSteam, windPower;

    public static void load() {
        windPower = Attribute.add("windPower");
        waterSteam = Attribute.add("waterSteam");
    }
}
