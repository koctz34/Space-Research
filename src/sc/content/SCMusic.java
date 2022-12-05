package sc.content;

import arc.audio.Music;
import mindustry.Vars;

public class SCMusic {
    public static Music
        dive,
        abandoned,
        livingSteam;

    public static void load() {
        dive = Vars.tree.loadMusic("dive");

        abandoned = Vars.tree.loadMusic("abandoned");

        livingSteam = Vars.tree.loadMusic("living-steam");
    }
}
