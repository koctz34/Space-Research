package sc.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class SCFluids {
    public static Liquid oxygen, tokicite, froin;

    public static void load() {
        froin = new Liquid("froin", Color.valueOf("a7f79e")){{
            gas = true;
            flammability = 0.3f;
        }};

    }
}
