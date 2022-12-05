package sc.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.content.*;
import mindustry.entities.Effect;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.CacheLayer;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static sc.content.SCUnits.acrolis;
import static sc.content.SCItems.*;
import static sc.content.SCFluids.*;
import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static mindustry.type.ItemStack.*;

public class SCBlocks {
    public static Block
    //crafting
    latynSmelter, froinGaser, flimatPress,
    //production
    drille, drilleBore, cyanDrille,
    //distribution
    itemLent, itemLentRouter, itemLentJunkt,
    //liquids
    liquidLent, waterPomp,
    //defense
    destr, minig, clust, fleng, tesotyWall, tesotyLargeWall, healo, critonWall, critonLargeWall, matrixShiel, rocke, shardGun,
    //environment & ores
    cyan, cyanWall, silic, gre, greWall,
    blu, bluWall, pur, purWall,
    oreTesoty, wallOreCriton,
    bluVent,
    //units
    militaryBase, tankBase, tankBaseUp, militaryBaseUp,
    //storage
    corePsi;

    public static void load() {
        corePsi = new CoreBlock("core-psi"){{
            health = 2000;
            size = 4;
            unitCapModifier = 16;
            itemCapacity = 8000;
            alwaysUnlocked = true;
            unitType = SCUnits.tres;
            requirements(Category.effect, with(tesoty, 2000, latyn, 1000));
        }};
        oreTesoty = new OreBlock("ore-tesoty"){{
            itemDrop = tesoty;
        }};
        destr = new ItemTurret("Destroyer"){{
            requirements(Category.turret, with(tesoty, 200, latyn, 300, criton, 100));
            ammo(
                    latyn, new BasicBulletType(4f, 50){{
                        hitSize = 6.8f;
                        width = 15f;
                        height = 21f;
                        shootEffect = Fx.casing1;
                        ammoMultiplier = 3;
                        reloadMultiplier = 1.8f;
                        knockback = 0.4f;
                    }}
            );
            reload = 7f;
            recoilTime = 7f;
            coolantMultiplier = 0.3f;
            ammoUseEffect = Fx.casing1;
            range = 210f;
            inaccuracy = 2f;
            recoil = 3f;
            shoot = new ShootAlternate(8f);
            shake = 2f;
            size = 4;
            shootCone = 24f;
            shootSound = Sounds.shootBig;

            scaledHealth = size * 2;
            coolant = consumeCoolant(1f);

            limitRange();
        }};
        silic = new Floor("silic"){{
            itemDrop = silicon;
            playerUnmineable = true;
            attributes.set(Attribute.oil, 0.7f);
        }};
        cyan = new Floor("cyan"){{
            variants = 3;
        }};
        cyanWall = new StaticWall("cyan-wall"){{
            variants = 3;
        }};
        gre = new Floor("gre"){{
            variants = 3;
        }};
        greWall = new StaticWall("gre-wall"){};
        blu = new Floor("blu"){{
            variants = 3;
        }};
        bluWall = new StaticWall("blu-wall"){};
        pur = new Floor("pur"){{
            variants = 3;
        }};
        purWall = new StaticWall("pur-wall"){};
        latynSmelter = new GenericCrafter("latyn-smelter"){{
            requirements(Category.crafting, with(tesoty, 35));
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(latyn, 2);
            craftTime = 40f;
            size = 2;
            hasPower = false;
            hasLiquids = false;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("5064d4")));
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            researchCost = with(tesoty, 28);
            consumeItems(with(tesoty, 1, silicon, 1));
        }};
        flimatPress = new GenericCrafter("flimat-press"){{
            requirements(Category.crafting, with(tesoty, 60, criton, 50));
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(flimat, 2);
            craftTime = 60f;
            size = 3;
            hasPower = false;
            hasLiquids = false;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("8ec278")));
            researchCost = with(tesoty, 90, latyn, 20, criton, 70);
            consumeItems(with(tesoty, 3, silicon, 3));
        }};
        militaryBase = new UnitFactory("military-base"){{
            requirements(Category.units, with(tesoty, 20, latyn, 30));
            plans = Seq.with(
                    new UnitPlan(acrolis, 60f * 15, with(Items.silicon, 10, tesoty, 20))
            );
            size = 3;
            researchCost = with(tesoty, 150, latyn, 90);
        }};
        militaryBaseUp = new UnitFactory("military-base-up"){{
            requirements(Category.units, with(tesoty, 40, latyn, 50, criton, 20));
            plans = Seq.with(
                    new UnitPlan(SCUnits.acro, 70f * 15, with(Items.silicon, 20, tesoty, 35)),
                    new UnitPlan(SCUnits.ac, 80f * 15, with(Items.silicon, 40, tesoty, 50, flimat, 20))
            );
            size = 3;
            researchCost = with(tesoty, 150, latyn, 90);
        }};
        tankBase = new UnitFactory("tank-base"){{
            requirements(Category.units, with(tesoty, 30, latyn, 40));
            plans = Seq.with(
                    new UnitPlan(SCUnits.tanker, 60f * 15, with(latyn, 30, tesoty, 30))
            );
            size = 3;
            researchCost = with(tesoty, 170, latyn, 110);
        }};
        tankBaseUp = new UnitFactory("tank-base-up"){{
            requirements(Category.units, with(tesoty, 30, latyn, 40));
            plans = Seq.with(
                    new UnitPlan(SCUnits.titanos, 70f * 15, with(Items.silicon, 40, tesoty, 50, criton, 50)),
                    new UnitPlan(SCUnits.titaner, 80f * 15, with(Items.silicon, 60, tesoty, 70, flimat, 40))
            );
            size = 3;
            researchCost = with(tesoty, 170, latyn, 110);
        }};
        wallOreCriton = new OreBlock("ore-wall-criton", criton){{
            wallOre = true;
        }};
        clust = new ItemTurret("clust"){{
            requirements(Category.turret, with(SCItems.tesoty, 50, SCItems.latyn, 20));
            researchCost = with(tesoty, 30, latyn, 10);
            Effect sfe = new MultiEffect(Fx.shootBigColor, Fx.colorSparkBig);

            ammo(
                    SCItems.tesoty, new BasicBulletType(5f, 20){{
                        width = 6f;
                        hitSize = 2f;
                        height = 8f;
                        shootEffect = sfe;
                        smokeEffect = Fx.shootBigSmoke;
                        ammoMultiplier = 3;
                        pierceCap = 2;
                        pierce = true;
                        pierceBuilding = true;
                        hitColor = backColor = trailColor = Pal.redDust;
                        frontColor = Color.scarlet;
                        trailWidth = 2.1f;
                        trailLength = 5;
                        trailEffect = Fx.overdriven;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        buildingDamageMultiplier = 0.3f;
                    }},
                    SCItems.latyn, new BasicBulletType(8f, 30){{
                        width = 7f;
                        height = 3f;
                        hitSize = 9f;
                        shootEffect = sfe;
                        smokeEffect = Fx.shootBigSmoke;
                        ammoMultiplier = 1;
                        reloadMultiplier = 1f;
                        pierceCap = 3;
                        pierce = true;
                        pierceBuilding = true;
                        hitColor = backColor = trailColor = Pal.tungstenShot;
                        frontColor = Color.white;
                        trailWidth = 2.2f;
                        trailLength = 11;
                        trailEffect = Fx.overdriven;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        rangeChange = 40f;
                        buildingDamageMultiplier = 0.3f;
                    }}
            );

            coolantMultiplier = 6f;
            shootSound = Sounds.shootAlt;

            shake = 1f;
            ammoPerShot = 1;
            shootY = -2;
            outlineColor = Pal.redSpark;
            size = 2;
            envEnabled |= Env.space;
            reload = 40f;
            recoil = 2f;
            range = 190;
            shootCone = 3f;
            scaledHealth = size * 2;
            rotateSpeed = 1.5f;
            researchCostMultiplier = 0.02f;

            coolant = consume(new ConsumeLiquid(Liquids.water, 15f / 60f));
            limitRange();
        }};
        itemLentRouter = new Router("item-lent-router"){{
            requirements(Category.distribution, with(tesoty, 4));
        }};
        itemLentJunkt = new Junction("item-lent-junkt"){{
            requirements(Category.distribution, with(tesoty, 3));
            speed = 26;
            health = 30;
        }};
        rocke = new ItemTurret("rocke"){{
            requirements(Category.turret, with(tesoty, 120, latyn, 90, flimat, 80));

            ammo(
                    criton, new ArtilleryBulletType(2.8f, 70, "shell"){{
                        hitEffect = new MultiEffect(Fx.titanExplosion, Fx.titanSmoke);
                        despawnEffect = Fx.none;
                        knockback = 2f;
                        lifetime = 100f;
                        height = 15f;
                        width = 13f;
                        splashDamageRadius = 50f;
                        splashDamage = 70f;
                        scaledSplashDamage = true;
                        backColor = hitColor = trailColor = Color.valueOf("ea8878").lerp(Pal.redLight, 0.5f);
                        frontColor = Color.white;
                        ammoMultiplier = 1f;
                        hitSound = Sounds.titanExplosion;
                        trailLength = 32;
                        trailWidth = 3.35f;
                        trailSinScl = 2.5f;
                        trailSinMag = 0.5f;
                        trailEffect = Fx.overdriven;
                        despawnShake = 7f;

                        shootEffect = Fx.shootTitan;
                        smokeEffect = Fx.shootSmokeTitan;

                        shrinkX = 0.2f;
                        shrinkY = 0.1f;
                        buildingDamageMultiplier = 0.3f;
                    }}
            );

            shootSound = Sounds.mediumCannon;
            ammoPerShot = 4;
            maxAmmo = ammoPerShot * 3;
            targetAir = false;
            shake = 4f;
            recoil = 1f;
            reload = 60f * 2.3f;
            shootY = 7f;
            rotateSpeed = 1.4f;
            minWarmup = 0.85f;
            shootWarmupSpeed = 0.07f;

            coolant = consume(new ConsumeLiquid(Liquids.water, 30f / 60f));
            coolantMultiplier = 1.5f;

            shootWarmupSpeed = 0.08f;

            outlineColor = Pal.darkOutline;

            consumeLiquid(froin, 5f / 60f);

            scaledHealth = 250;
            range = 390f;
            size = 4;
        }};
        healo = new ItemTurret("healo"){{
            requirements(Category.turret, with(tesoty, 80, latyn, 60, criton, 20));
            researchCost = with(tesoty, 130, latyn, 90);
            Effect sfe = new MultiEffect(Fx.shootBigColor, Fx.colorSparkBig);

            ammo(
                    SCItems.latyn, new EmpBulletType(){{
                        width = 7f;
                        height = 3f;
                        hitSize = 9f;
                        shootEffect = sfe;
                        smokeEffect = Fx.shootBigSmoke;
                        ammoMultiplier = 1;
                        reloadMultiplier = 1f;
                        lifetime = 50;
                        damage = 16;
                        healPercent = 10;
                        pierceCap = 3;
                        pierce = true;
                        pierceBuilding = true;
                        hitColor = backColor = Color.green;
                        frontColor = Color.white;
                        trailColor = Color.lime;
                        trailWidth = 2.2f;
                        trailLength = 11;
                        trailEffect = Fx.overdriven;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        rangeChange = 40f;
                    }}
            );

            coolantMultiplier = 6f;
            shootSound = Sounds.shootAlt;

            shake = 1f;
            ammoPerShot = 1;
            shootY = -2;
            outlineColor = Color.green;
            size = 2;
            envEnabled |= Env.space;
            reload = 30f;
            recoil = 1f;
            range = 190;
            shootCone = 3f;
            scaledHealth = size * 2;
            rotateSpeed = 1.5f;
            researchCostMultiplier = 0.02f;

            coolant = consume(new ConsumeLiquid(Liquids.water, 15f / 60f));
            limitRange();
        }};
        drille = new Drill("drille"){{
            requirements(Category.production, with(SCItems.tesoty, 14));
            tier = 2;
            drillTime = 400;
            size = 2;
            researchCost = with(tesoty, 20);
            consumeLiquid(Liquids.water, 0.06f).boost();
        }};
        cyanDrille = new Drill("cyan-drille"){{
            requirements(Category.production, with(SCItems.tesoty, 30, latyn, 40));
            tier = 3;
            drillTime = 300;
            size = 3;
            researchCost = with(tesoty, 50, latyn, 60);
            consumeLiquid(Liquids.water, 0.06f).boost();
        }};
        froinGaser = new GenericCrafter("froin-gaser"){{
            requirements(Category.crafting, with(tesoty, 70, latyn, 80));
            craftEffect = Fx.none;
            outputLiquids = LiquidStack.with(froin, 4f / 60);
            craftTime = 50f;
            size = 3;
            hasLiquids = true;
            envEnabled |= Env.space | Env.underwater;
            envDisabled = Env.none;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawArcSmelt(), new DrawDefault());
            researchCost = with(tesoty, 100, latyn, 90);
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.12f;

            consumeItems(with(latyn, 1, silicon, 2));
        }};
        drilleBore = new BeamDrill("drille-bore"){{
            requirements(Category.production, with(tesoty, 60, latyn, 50));

            drillTime = 160f;
            tier = 3;
            size = 3;
            range = 2;
            fogRadius = 3;
            researchCost = with(tesoty, 80, latyn, 70);

            consumeLiquid(froin, 0.25f / 60f).boost();
        }};

        itemLent = new StackConveyor("item-lent"){{
            requirements(Category.distribution, with(tesoty, 2));
            health = 20;
            speed = 4f / 60f;
            itemCapacity = 2;
            researchCost = with(tesoty, 10);
        }};
        fleng = new ItemTurret("fleng"){{
            requirements(Category.turret, with(SCItems.tesoty, 70, SCItems.latyn, 50));

            Effect sfe = new MultiEffect(Fx.shootBigColor, Fx.colorSparkBig);

            ammo(
                    SCItems.tesoty, new BasicBulletType(7f, 40){{
                        width = 8f;
                        hitSize = 4f;
                        height = 10f;
                        shootEffect = sfe;
                        smokeEffect = Fx.shootBigSmoke;
                        ammoMultiplier = 2;
                        pierceCap = 2;
                        pierce = true;
                        pierceBuilding = true;
                        hitColor = backColor = trailColor = Pal.lightOrange;
                        frontColor = Color.orange;
                        trailWidth = 2.3f;
                        trailLength = 9;
                        trailEffect = Fx.overclocked;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        buildingDamageMultiplier = 0.5f;
                    }}
            );

            coolantMultiplier = 4f;
            shootSound = Sounds.shootAlt;

            shake = 1f;
            ammoPerShot = 1;
            shootY = -2;
            outlineColor = Pal.lightPyraFlame;
            size = 3;
            envEnabled |= Env.space;
            reload = 60f;
            recoil = 3f;
            range = 190;
            shootCone = 3f;
            scaledHealth = size * 2;
            rotateSpeed = 1.1f;
            researchCostMultiplier = 0.02f;

            coolant = consume(new ConsumeLiquid(Liquids.water, 15f / 60f));
            limitRange();
        }};
        tesotyWall = new Wall("tesoty-wall"){{
            requirements(Category.defense, with(SCItems.tesoty, 4));
            health = 80;
            armor = 2f;
            buildCostMultiplier = 8f;
            size =  1;
        }};
        matrixShiel = new ForceProjector("matrix-shiel"){{
            health = 70;
            size = 3;
            shieldHealth = 120f;
            cooldownNormal = 2.7f;
            cooldownLiquid = 1.9f;
            cooldownBrokenBase = 0.7f;
            requirements(Category.effect, with(tesoty, 80, criton, 80));
        }};
        critonWall = new Wall("criton-wall"){{
            requirements(Category.defense, with(criton, 4));
            health = 100;
            armor = 2f;
            buildCostMultiplier = 8f;
            size =  1;
        }};
        minig = new ItemTurret("minig"){{
            requirements(Category.turret, with(tesoty, 90, latyn, 60, flimat, 40));
            ammo(
                    silicon,  new BasicBulletType(2.5f, 4){{
                        width = 5f;
                        height = 7f;
                        lifetime = 80f;
                        ammoMultiplier = 5;
                    }}
            );
            shoot = new ShootAlternate(3.5f);
            reload = 2f;
            shootCone = 6f;
            ammoUseEffect = Fx.casing1;
            health = 50 * size;
            inaccuracy = 2f;
            size = 3;
            rotateSpeed = 8f;
            coolant = consume(new ConsumeLiquid(Liquids.water, 15f / 60f));
            limitRange();
        }};
        shardGun = new ItemTurret("shard-gun"){{
            requirements(Category.turret, with(tesoty, 100, criton, 60));
            ammo(
                    silicon,  new BasicBulletType(0.3f, 20){{
                        width = 10f;
                        height = 7f;
                        lifetime = 500f;
                        ammoMultiplier = 5;
                        sprite = "fos-planet";
                        backSprite = "fos-planet";
                    }}
            );
            shoot = new ShootAlternate(3.5f);
            reload = 5f;
            shootCone = 600f;
            ammoUseEffect = Fx.casing1;
            health = 50 * size;
            inaccuracy = 600f;
            size = 2;
            rotateSpeed = 50f;
        }};
        critonLargeWall = new Wall("criton-large-wall"){{
            requirements(Category.defense, with(criton, 4 * 4));
            health = 100 * 4;
            armor = 2f;
            buildCostMultiplier = 8f;
            size =  2;
        }};
        liquidLent = new Conduit("liquid-lent"){{
            requirements(Category.liquid, with(tesoty, 5));
            health = 20;
            researchCost = with(tesoty, 30);
        }};
        bluVent = new SteamVent("bluVent"){{
            parent = blendGroup = blu;
            attributes.set(SCAttributes.waterSteam, 1f);
        }};
        waterPomp = new ThermalGenerator("water-pomp"){{
            requirements(Category.liquid, with(tesoty, 30));
            attribute = SCAttributes.waterSteam;
            displayEfficiencyScale = 1f / 9f;
            minEfficiency = 9f - 0.0001f;
            displayEfficiency = false;
            generateEffect = Fx.turbinegenerate;
            effectChance = 0.04f;
            size = 3;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;

            drawer = new DrawMulti(new DrawDefault(), new DrawBlurSpin("-rotator", 0.6f * 9f){{
                blurThresh = 0.01f;
            }});

            hasLiquids = true;
            outputLiquid = new LiquidStack(water, 5f / 60f / 9f);
            liquidCapacity = 20f;
            researchCost = with(tesoty, 40, latyn, 40);
        }};
        tesotyLargeWall = new Wall("tesoty-large-wall"){{
            requirements(Category.defense, with(tesoty, 4 * 4));
            health = 80 * 4;
            armor = 2f;
            buildCostMultiplier = 8f;
            size = 2;
        }};
    }
}
