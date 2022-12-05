package sc;

import arc.*;
import sc.content.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;

import static mindustry.Vars.*;
import static mindustry.game.EventType.*;

public class SCMod extends Mod {

    public SCMod() {
        Events.run(Trigger.update, () -> {
        });
    }

    @Override
    public void init() {
        if (headless) return;

        LoadedMod mod = mods.locateMod("sc");
    }

    @Override
    public void loadContent() {
        SCTeam.load();
        SCMusic.load();
        SCAttributes.load();
        SCWeathers.load();
        SCItems.load();
        SCFluids.load();
        SCUnits.load();
        SCBlocks.load();
        SCSchematics.load();
        SCPlanets.load();
        SCSectors.load();
        ComlirTechTree.load();
    }
}
