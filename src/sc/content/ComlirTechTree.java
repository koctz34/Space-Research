package sc.content;

import arc.struct.Seq;
import mindustry.game.Objectives;

import static sc.content.SCBlocks.*;
import static sc.content.SCItems.*;
import static sc.content.SCFluids.*;
import static sc.content.SCSectors.*;
import static sc.content.SCUnits.*;
import static mindustry.content.Items.silicon;
import static mindustry.content.TechTree.*;

public class ComlirTechTree {
    public static void load() {
        SCPlanets.comlir.techTree = nodeRoot("@planet.sc-comlir.name", SCBlocks.corePsi, false, () -> {
            node(sectorOne, () -> {
                node(sectorTwo, Seq.with(new Objectives.SectorComplete(sectorOne)), () -> {
                    node(sectorThre, Seq.with(new Objectives.SectorComplete(sectorTwo)), () -> {
                        node(sectorBeggin, Seq.with(new Objectives.SectorComplete(sectorThre)), () -> {});
                        node(sectorBase, Seq.with(new Objectives.SectorComplete(sectorThre)), () -> {});
                    });
                });
            });
            node(itemLent, () -> {
                node(itemLentJunkt, () -> {});
                node(itemLentRouter, () -> {});
                node(waterPomp, () -> {
                    node(liquidLent, () -> {});
                });
            });
            node(militaryBase, () -> {
                node(acrolis, () -> {
                    node(militaryBaseUp, () -> {
                        node(acro, () -> {
                            node(ac, () -> {});
                        });
                    });
                });
                node(tankBase, () -> {
                    node(tanker, () -> {
                        node(tankBaseUp, () -> {
                            node(titanos, () -> {
                                node(titaner, () -> {});
                            });
                        });
                    });
                });
            });
            node(drille, () -> {
                node(cyanDrille, () -> {});
                node(latynSmelter, () -> {
                    node(froinGaser, () -> {});
                    node(flimatPress, () -> {});
                });
                node(drilleBore, () -> {});
            });
            node(clust, () -> {
                node(fleng, () -> {
                    node(healo, () -> {
                        node(destr, () -> {
                            node(rocke, () -> {});
                        });
                        node(minig, () -> {});
                        node(shardGun, () -> {});
                    });
                });
                node(tesotyWall, () -> {
                    node(tesotyLargeWall, () -> {});
                    node(critonWall, () -> {
                        node(critonLargeWall, () -> {});
                        node(matrixShiel, () -> {});
                    });
                });
            });
            nodeProduce(tesoty, () -> {
                nodeProduce(silicon, () -> {
                    nodeProduce(latyn, () -> {
                        nodeProduce(criton, () -> {
                            nodeProduce(flimat, () -> {});
                        });
                        nodeProduce(froin, () -> {});
                    });
                } );
            });
        });
    }
}
