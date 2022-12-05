package sc.audio;

import arc.*;
import arc.audio.*;
import arc.struct.*;
import sc.content.*;
import mindustry.Vars;
import mindustry.audio.SoundControl;
import mindustry.content.StatusEffects;
import mindustry.game.SpawnGroup;
import mindustry.type.*;

import static mindustry.game.EventType.*;
import static mindustry.Vars.state;

public class MusicHandler {
    public Seq<Music> comlirAmbient = new Seq<>();

    public Seq<Music> vAmbient, vDark;

    protected Planet curPlanet;

    protected SoundControl control = Vars.control.sound;

    public MusicHandler(){
        Events.on(ClientLoadEvent.class, e -> reload());
        //change the music to modded OST
        Events.on(WorldLoadEvent.class, e -> {
            Sector sector = state.rules.sector;
            if (sector != null) curPlanet = sector.planet;
                else return;

            if (curPlanet == SCPlanets.comlir) {
                control.ambientMusic = control.darkMusic = comlirAmbient;
            } else if (curPlanet == SCPlanets.comlir) {
                control.ambientMusic = control.darkMusic = comlirAmbient;
            }
        });
        Events.on(WaveEvent.class, e -> {
            SpawnGroup boss = state.rules.spawns.find(group -> group.getSpawned(state.wave - 2) > 0 && group.effect == StatusEffects.boss);
            if (boss == null) return;
        });
        //this should hopefully reset the music back to vanilla
        Events.on(StateChangeEvent.class, e -> {
            if (curPlanet == SCPlanets.comlir || curPlanet == SCPlanets.comlir) return;

            control.ambientMusic = vAmbient;
            control.darkMusic = vDark;
        });
    }

    public void reload(){
        comlirAmbient = Seq.with(SCMusic.dive, SCMusic.abandoned);
        comlirAmbient = Seq.with(SCMusic.abandoned);

        vAmbient = control.ambientMusic;
        vDark = control.darkMusic;
    }
}
