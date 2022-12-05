package sc.content;

import mindustry.type.*;

public class SCSectors {
    public static SectorPreset
    /* Comlir */ sectorOne, sectorTwo, sectorThre, sectorBeggin, sectorBase;

    public static void load() {
        sectorOne = new SectorPreset("sectorOne", SCPlanets.comlir, 2){{
            captureWave = 10;
            addStartingItems = true;
            difficulty = 1;
            alwaysUnlocked = true;
        }};
        sectorBeggin = new SectorPreset("sectorBeggin", SCPlanets.comlir, 53){{
            captureWave = 20;
            addStartingItems = true;
            difficulty = 2;
        }};
        sectorBase = new SectorPreset("sectorBase", SCPlanets.comlir, 75){{
            captureWave = 30;
            difficulty = 3;
        }};
        sectorTwo = new SectorPreset("sectorTwo", SCPlanets.comlir, 17){{
            captureWave = 30;
            addStartingItems = true;
            difficulty = 2;
            attackAfterWaves = true;
        }};
        sectorThre = new SectorPreset("sectorThre", SCPlanets.comlir, 58){{
            captureWave = 15;
            difficulty = 2;
        }};
    }
}
