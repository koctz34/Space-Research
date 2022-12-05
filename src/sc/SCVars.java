package sc;

import sc.audio.MusicHandler;

public class SCVars {
    public static MusicHandler handler;

    public static void load() {
        handler = new MusicHandler();
    }
}
