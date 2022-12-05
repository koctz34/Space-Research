package sc.content;

import arc.graphics.*;
import sc.gen.*;
import mindustry.Vars;
import mindustry.game.Team;
import mindustry.graphics.g3d.*;
import mindustry.type.*;
import mindustry.world.meta.*;

import static sc.content.SCBlocks.*;
import static sc.content.SCItems.*;
import static mindustry.content.Planets.*;

public class SCPlanets {
    public static Planet
        /* planets */ comlir, torison, tonn;

    public static void load() {
        comlir = new Planet("comlir", sun, 1f, 2){{
            defaultCore = corePsi;
            hasAtmosphere = true;
            bloom = false;
            atmosphereColor = Color.valueOf("288a5d27");
            iconColor = Color.sky;
            meshLoader = () -> new HexMesh(this, 3);
            startSector = 2;
            alwaysUnlocked = true;
            generator = new ComlirPlanetGenerator(){{
                defaultLoadout = SCSchematics.comlirLoadout;
            }};
            defaultEnv = Env.terrestrial | Env.oxygen;
            minZoom = 0.1f;
            camRadius += 0.4f;
            tidalLock = true;
            orbitSpacing = 2f;
            totalRadius += 2.6f;
            lightSrcTo = 0.5f;
            lightDstFrom = 0.2f;
            allowLaunchLoadout = true;
            cloudMeshLoader = () -> new HexSkyMesh(this, 7, 1.5f, 0.10f, 4, Color.valueOf("b0dcb76d"), 2, 0.5f, 1.8f, 0.38f);
            ruleSetter = r -> {
                r.loadout = ItemStack.list();
                r.fog = false;
                r.showSpawns = true;
                r.defaultTeam = SCTeam.tritons;
                r.waveTeam = r.attackMode ? SCTeam.bessin : SCTeam.bessin;
                r.waves = true;
                r.coreDestroyClear = true;
                r.onlyDepositCore = true;
                r.enemyCoreBuildRadius = 300;
                r.coreCapture = false;
            };
        }};
        torison = new Planet("torison", sun, 1.2f, 3){{
            hasAtmosphere = true;
            bloom = false;
            orbitRadius = 40f;
            alwaysUnlocked = true;
            atmosphereColor = Color.valueOf("d17145");
            iconColor = Color.red;
            meshLoader = () -> new SunMesh(
                    this, 6,
                    5, 0.3, 1, 1.2, 1,
                    1f,
                    Color.valueOf("eb5234"),
                    Color.valueOf("c94126"),
                    Color.valueOf("a63a24"),
                    Color.valueOf("a84c39"),
                    Color.valueOf("a6422e"),
                    Color.valueOf("7a382b"),
                    Color.valueOf("cc6c18"),
                    Color.valueOf("b37447")
            );
            startSector = 2;
            minZoom = 0.4f;
            camRadius += 0.4f;
            tidalLock = true;
            orbitSpacing = 0.2f;
            allowLaunchLoadout = true;
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 6, 0.1f, 0.23f, 5, Color.valueOf("ab4935").a(0.75f), 2, 0.45f, 1.3f, 0.45f),
                    new HexSkyMesh(this, 3, 0.5f, 0.33f, 5, Color.valueOf("992d17").a(0.65f), 3, 0.45f, 1.45f, 0.45f),
                    new HexSkyMesh(this, 7, 0.2f, 0.26f, 5, Color.valueOf("992d17").a(0.65f), 4, 0.45f, 1.13f, 0.45f),
                    new HexSkyMesh(this, 5, 0.3f, 0.26f, 5, Color.valueOf("ab4935").a(0.75f), 2, 0.45f, 1.00f, 0.45f),
                    new HexSkyMesh(this, 3, 0.2f, 0.19f, 5, Color.valueOf("992d17").a(0.65f), 3, 0.25f, 1.22f, 0.45f)
            );
            ruleSetter = r -> {
                r.loadout = ItemStack.list();
                r.fog = false;
                r.showSpawns = true;
                r.defaultTeam = SCTeam.tritons;
                r.waveTeam = r.attackMode ? Team.sharded : SCTeam.bessin;
                r.waves = true;
                r.coreDestroyClear = true;
                r.onlyDepositCore = true;
                r.enemyCoreBuildRadius = 300;
                r.coreCapture = false;
            };
        }};
        tonn = new Planet("tonn", torison, 0.8f, 1){{
            hasAtmosphere = false;
            bloom = false;
            orbitRadius = 10f;
            alwaysUnlocked = true;
            iconColor = Color.lightGray;
            meshLoader = () -> new SunMesh(
                    this, 6,
                    5, 0.3, 1, 1.2, 1,
                    1f,
                    Color.valueOf("757575"),
                    Color.valueOf("7d7d7d"),
                    Color.valueOf("5e5e5e"),
                    Color.valueOf("4a4a4a"),
                    Color.valueOf("808080"),
                    Color.valueOf("999999"),
                    Color.valueOf("666666")
            );
            startSector = 4;
            minZoom = 0.4f;
            camRadius += 0.4f;
            tidalLock = true;
            orbitSpacing = 0.2f;
            allowLaunchLoadout = true;
            ruleSetter = r -> {
                r.loadout = ItemStack.list();
                r.fog = false;
                r.showSpawns = true;
                r.defaultTeam = SCTeam.tritons;
                r.waveTeam = r.attackMode ? Team.sharded : SCTeam.bessin;
                r.waves = true;
                r.coreDestroyClear = true;
                r.onlyDepositCore = true;
                r.enemyCoreBuildRadius = 300;
                r.coreCapture = false;
            };
        }};
        serpulo.hiddenItems.addAll(comlirItems);
        erekir.hiddenItems.addAll(comlirItems);
        comlir.hiddenItems.addAll(Vars.content.items()).removeAll(comlirItems);
    }
}
