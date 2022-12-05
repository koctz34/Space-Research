package sc.content;

import arc.graphics.Color;
import mindustry.game.Team;

public class SCTeam {
    public static Team bessin, tritons;

    public static void load() {
        bessin = newTeam(70, "bessin", Color.valueOf("b8d15c"));
        tritons = newTeam(71, "tritons", Color.valueOf("497a51"));
    }
    private static Team newTeam(int id, String name, Color color) {
        Team team = Team.get(id);
        team.name = name;
        team.color.set(color);

        team.palette[0] = color;
        team.palette[1] = color.cpy().mul(0.75f);
        team.palette[2] = color.cpy().mul(0.5f);

        for(int i = 0; i < 3; i++){
            team.palettei[i] = team.palette[i].rgba();
        }

        return team;
    }
}
