package sc.content;

import arc.graphics.Color;
import arc.util.*;
import mindustry.content.StatusEffects;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.weather.*;
import mindustry.world.meta.Attribute;

public class SCWeathers {
    public static Weather windWater, megaRain;

    public static void load() {
        windWater = new ParticleWeather("windWater"){{
            drawParticles = false;
            drawNoise = true;
            noiseColor = Color.valueOf("3269a8");
            useWindVector = true;
            baseSpeed = 3.9f;
            force = 0.2f;
            sound = Sounds.wind;
            soundVol = 0.4f;
            duration = 7f * Time.toMinutes;
        }};
        megaRain = new RainWeather("mega-rain"){{
            attrs.set(Attribute.light, -0.2f);
            attrs.set(Attribute.water, 0.2f);
            status = StatusEffects.wet;
            sound = Sounds.rain;
            yspeed = 1.2f;
            sizeMin = 0.4f;
            sizeMax = 0.9f;
            soundVol = 0.25f;
        }};

    }
}
