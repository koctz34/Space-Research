package sc.content;

import mindustry.Vars;
import mindustry.game.Schematic;
import mindustry.game.Schematics;

import java.io.IOException;

public class SCSchematics {
    public static Schematic comlirLoadout;

    public static void load() {
        comlirLoadout = loadSchem("sc-comlir");
    }

    static Schematic loadSchem(String name) {
        Schematic s;
        try {
            s = Schematics.read(Vars.tree.get("schematics/" + name + ".msch"));
        } catch (IOException e) {
            s = null;
            e.printStackTrace();
        }
        return s;
    }

    static Schematic loadBase64(String b64) {
        return Schematics.readBase64(b64);
    }
}
