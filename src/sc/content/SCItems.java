package sc.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

import static mindustry.content.Items.*;

public class SCItems {
    public static Item tesoty, latyn, criton, flimat;

    public static Seq<Item> comlirItems = new Seq<>();

    public static void load(){
        tesoty = new Item("tesoty", Color.valueOf("fa6464")){{
            hardness = 2;
        }};
        criton = new Item("criton", Color.valueOf("32a879")){{
            hardness = 3;
            frames = 5;
            frameTime = 10;
        }};
        latyn = new Item("latyn", Color.valueOf("faca64")){{
            hardness = 2;
            cost = 1.5f;
            frames = 5;
            frameTime = 10;
        }};
        flimat = new Item("flimat", Color.valueOf("41a317")){{
            hardness = 3;
            frames = 5;
            frameTime = 10;
        }};
        comlirItems.addAll(tesoty, latyn, silicon, flimat, criton);
    }
}
