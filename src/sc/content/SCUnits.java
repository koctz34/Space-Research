package sc.content;

import arc.graphics.Color;
import arc.graphics.g2d.Lines;
import arc.math.*;
import arc.math.geom.Rect;
import mindustry.content.*;
import mindustry.entities.Effect;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.gen.*;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.type.unit.TankUnitType;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.stroke;

public class SCUnits {
    public static UnitType
    //tanks
    tanker, titanos, titaner,
    //legs
    acrolis, acro, ac,
    tres;

    public static void load(){
        acrolis = new UnitType("acrolis"){{
            speed = 0.5f;
            hitSize = 8f;
            health = 150;
            weapons.add(new Weapon("acrolis-weapon"){{
                reload = 10f;
                x = 0f;
                y = 0f;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(3f, 4){{
                    width = 5f;
                    height = 7f;
                    lifetime = 80f;
                    trailLength = 27;
                    trailWidth = 2.5f;
                }};
            }});
            constructor = MechUnit::create;
        }};
        acro = new UnitType("acro"){{
            speed = 0.4f;
            hitSize = 12f;
            health = 190;
            weapons.add(new Weapon("acro-weapon"){{
                reload = 8f;
                x = 0f;
                y = 0f;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(3f, 9){{
                    shootEffect = new MultiEffect(Fx.shootSmallColor, new Effect(9, e -> {
                        color(Color.red, e.color, e.fin());
                        stroke(0.7f + e.fout());
                        Lines.square(e.x, e.y, e.fin() * 5f, e.rotation + 45f);

                        Drawf.light(e.x, e.y, 23f, e.color, e.fout() * 0.7f);
                    }));
                    collidesTiles = true;
                    backColor = hitColor = Pal.redDust;
                    frontColor = Color.red;
                    lifetime = 50f;
                    width = height = 9f;
                    trailLength = 27;
                    trailWidth = 2.5f;
                    trailEffect = Fx.overdriven;
                    trailColor = backColor;
                    trailInterp = Interp.slope;
                    shrinkX = 0.6f;
                    shrinkY = 0.2f;
                    hitEffect = despawnEffect = new MultiEffect(Fx.hitSquaresColor, new WaveEffect(){{
                        colorFrom = colorTo = Pal.redDust;
                        sizeTo = splashDamageRadius + 2f;
                        lifetime = 9f;
                        strokeFrom = 2f;
                    }});
                }};
            }});
            constructor = MechUnit::create;
        }};
        ac = new UnitType("ac"){{
            speed = 0.3f;
            hitSize = 18f;
            health = 220;
            weapons.add(new Weapon("ac-weapon"){{
                reload = 7f;
                x = 0f;
                y = 0f;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(3f, 16){{
                    shootEffect = new MultiEffect(Fx.shootSmallColor, new Effect(9, e -> {
                        color(Color.red, e.color, e.fin());
                        stroke(0.7f + e.fout());
                        Lines.square(e.x, e.y, e.fin() * 5f, e.rotation + 45f);

                        Drawf.light(e.x, e.y, 23f, e.color, e.fout() * 0.7f);
                    }));
                    collidesTiles = true;
                    backColor = hitColor = Pal.redDust;
                    frontColor = Color.red;
                    lifetime = 70f;
                    width = height = 9f;
                    trailLength = 29;
                    trailWidth = 2.7f;
                    trailEffect = Fx.overdriven;
                    trailColor = backColor;
                    trailInterp = Interp.slope;
                    shrinkX = 0.6f;
                    shrinkY = 0.2f;
                    hitEffect = despawnEffect = new MultiEffect(Fx.hitSquaresColor, new WaveEffect(){{
                        colorFrom = colorTo = Pal.redDust;
                        sizeTo = splashDamageRadius + 4f;
                        lifetime = 12f;
                        strokeFrom = 2f;
                    }});
                }};
            }});
            constructor = MechUnit::create;
        }};
        tanker = new TankUnitType("tanker"){{
            hitSize = 12f;
            treadPullOffset = 3;
            speed = 0.75f;
            rotateSpeed = 3.5f;
            health = 90;
            armor = 4f;
            itemCapacity = 10;
            treadRects = new Rect[]{new Rect(12 - 32f, 7 - 32f, 14, 51)};
            researchCostMultiplier = 0f;

            weapons.add(new Weapon("tanker-weapon"){{
                layerOffset = 0.0001f;
                reload = 70f;
                shootY = 4.5f;
                recoil = 1f;
                rotate = true;
                rotateSpeed = 1.9f;
                mirror = false;
                x = 0f;
                y = 0f;
                heatColor = Color.valueOf("f9350f");
                cooldownTime = 30f;

                bullet = new BasicBulletType(4f, 30){{
                    sprite = "missile-large";
                    smokeEffect = Fx.shootBigSmoke;
                    shootEffect = Fx.shootBigColor;
                    width = 6f;
                    height = 9f;
                    lifetime = 40f;
                    hitSize = 12f;
                    hitColor = backColor = trailColor = Color.valueOf("feb380");
                    frontColor = Color.white;
                    trailWidth = 1.6f;
                    trailLength = 7;
                    despawnEffect = hitEffect = Fx.hitBulletColor;
                }};
            }});
            constructor = TankUnit::create;
        }};
        titanos = new TankUnitType("titanos"){{
            hitSize = 18f;
            treadPullOffset = 3;
            speed = 0.60f;
            rotateSpeed = 3.5f;
            health = 130;
            armor = 4f;
            itemCapacity = 20;
            treadRects = new Rect[]{new Rect(12 - 32f, 7 - 32f, 14, 51)};
            researchCostMultiplier = 0f;

            weapons.add(new Weapon("titanos-weapon"){{
                reload = 80f;
                shootY = 4.5f;
                recoil = 1.5f;
                rotate = true;
                rotateSpeed = 1.9f;
                mirror = false;
                x = -2f;
                y = 0f;
                heatColor = Color.valueOf("f9350f");
                cooldownTime = 30f;

                bullet = new BasicBulletType(4f, 40){{
                    sprite = "missile-large";
                    smokeEffect = Fx.shootBigSmoke;
                    shootEffect = Fx.shootBigColor;
                    width = 6f;
                    height = 9f;
                    lifetime = 50f;
                    hitSize = 10f;
                    hitColor = backColor = trailColor = Color.valueOf("feb380");
                    frontColor = Color.white;
                    trailWidth = 1.6f;
                    trailLength = 5;
                    despawnEffect = hitEffect = Fx.hitBulletColor;
                }};

            }});
            weapons.add(new Weapon("titanos-weapon"){{
                reload = 80f;
                shootY = 4.5f;
                recoil = 1.5f;
                rotate = true;
                rotateSpeed = 1.9f;
                mirror = false;
                x = 2f;
                y = 0f;
                heatColor = Color.valueOf("f9350f");
                cooldownTime = 30f;

                bullet = new BasicBulletType(4f, 40){{
                    sprite = "missile-large";
                    smokeEffect = Fx.shootBigSmoke;
                    shootEffect = Fx.shootBigColor;
                    width = 6f;
                    height = 9f;
                    lifetime = 50f;
                    hitSize = 10f;
                    hitColor = backColor = trailColor = Color.valueOf("feb380");
                    frontColor = Color.white;
                    trailWidth = 1.6f;
                    trailLength = 5;
                    despawnEffect = hitEffect = Fx.hitBulletColor;
                }};

            }});
            constructor = TankUnit::create;
        }};
        titaner = new TankUnitType("titaner"){{
            hitSize = 21f;
            treadPullOffset = 3;
            speed = 0.50f;
            rotateSpeed = 3.5f;
            health = 170;
            armor = 4f;
            itemCapacity = 30;
            treadRects = new Rect[]{new Rect(12 - 32f, 7 - 32f, 14, 51)};
            researchCostMultiplier = 0.6f;

            weapons.add(new Weapon("titaner-weapon"){{
                reload = 60f;
                shootY = 4.5f;
                recoil = 1.5f;
                rotate = true;
                rotateSpeed = 1.9f;
                mirror = false;
                x = -2f;
                y = 0f;
                heatColor = Color.valueOf("f9350f");
                cooldownTime = 30f;

                bullet = new BasicBulletType(4f, 40){{
                    sprite = "missile-large";
                    smokeEffect = Fx.shootBigSmoke;
                    shootEffect = Fx.shootBigColor;
                    width = 8f;
                    height = 9f;
                    lifetime = 50f;
                    hitSize = 10f;
                    hitColor = backColor = trailColor = Color.valueOf("feb380");
                    frontColor = Color.white;
                    trailWidth = 1.8f;
                    trailLength = 5;
                    despawnEffect = hitEffect = Fx.hitBulletColor;
                }};
                constructor = TankUnit::create;
            }});
            weapons.add(new Weapon("titaner-weapon"){{
                reload = 60f;
                shootY = 4.5f;
                recoil = 1.5f;
                rotate = true;
                rotateSpeed = 1.9f;
                mirror = false;
                x = 2f;
                y = 0f;
                heatColor = Color.valueOf("f9350f");
                cooldownTime = 30f;

                bullet = new BasicBulletType(4f, 40){{
                    sprite = "missile-large";
                    smokeEffect = Fx.shootBigSmoke;
                    shootEffect = Fx.shootBigColor;
                    width = 8f;
                    height = 9f;
                    lifetime = 50f;
                    hitSize = 10f;
                    hitColor = backColor = trailColor = Color.valueOf("feb380");
                    frontColor = Color.white;
                    trailWidth = 1.8f;
                    trailLength = 5;
                    despawnEffect = hitEffect = Fx.hitBulletColor;
                }};

            }});
            constructor = TankUnit::create;
        }};
        tres = new UnitType("tres"){{
            health = 100;
            armor = 2;
            hitSize = 10;
            speed = 0.8f;
            flying = false;
            canBoost = false;
            mineTier = 2;
            mineSpeed = 7f;
            buildSpeed = 2f;
            weapons.add(new Weapon("tres-weapon"){{
                shootSound = Sounds.missile;
                mirror = false;
                x = 0f;
                y = 1f;
                shootY = 4f;
                reload = 60f;
                cooldownTime = 42f;
                heatColor = Pal.turretHeat;

                bullet = new ArtilleryBulletType(3f, 20){{
                    shootEffect = new MultiEffect(Fx.shootSmallColor, new Effect(9, e -> {
                        color(Color.red, e.color, e.fin());
                        stroke(0.7f + e.fout());
                        Lines.square(e.x, e.y, e.fin() * 5f, e.rotation + 45f);

                        Drawf.light(e.x, e.y, 23f, e.color, e.fout() * 0.7f);
                    }));

                    collidesTiles = true;
                    backColor = hitColor = Pal.redDust;
                    frontColor = Color.red;

                    knockback = 0.8f;
                    lifetime = 50f;
                    width = height = 9f;
                    splashDamageRadius = 10f;
                    splashDamage = 10f;

                    trailLength = 27;
                    trailWidth = 2.5f;
                    trailEffect = Fx.overdriven;
                    trailColor = backColor;

                    trailInterp = Interp.slope;

                    shrinkX = 0.6f;
                    shrinkY = 0.2f;

                    hitEffect = despawnEffect = new MultiEffect(Fx.hitSquaresColor, new WaveEffect(){{
                        colorFrom = colorTo = Pal.redDust;
                        sizeTo = splashDamageRadius + 2f;
                        lifetime = 9f;
                        strokeFrom = 2f;
                    }});
                }};
            }});
            constructor = LegsUnit::create;
        }};
    }
}
