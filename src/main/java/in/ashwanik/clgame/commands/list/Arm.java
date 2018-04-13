package in.ashwanik.clgame.commands.list;

import in.ashwanik.clgame.Game;
import in.ashwanik.clgame.commands.Command;
import in.ashwanik.clgame.commands.CommandList;
import in.ashwanik.clgame.models.Armoury;
import in.ashwanik.clgame.models.Player;
import in.ashwanik.clgame.models.Weapon;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.ui.screens.GameArena;
import in.ashwanik.clgame.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class Arm extends Command {

    public Arm(String name, String info) {
        super(name, info);
    }

    @Override
    public void execute(String[] arguments) {
        if (arguments.length == 0) {
            DisplayEngine.getDisplay().displayInRed("No weapon is selected.\n");
            DisplayEngine.getDisplay().displayInWhite("Arm command: \t " + CommandList.get().getCommand("arm"));
            return;
        }

        List<Weapon> validWeapons = new ArrayList<>();
        for (String arg : arguments) {
            if (StringUtils.isNumeric(arg)) {
                int weaponId = Integer.parseInt(arg);
                if (weaponId > 0 && weaponId <= Armoury.get().getWeapons().size()) {
                    validWeapons.add(Armoury.get().getWeapons().get(weaponId - 1));
                } else {
                    DisplayEngine.getDisplay().displayInRed("Invalid weapon is selected.");
                    return;
                }
            } else {
                DisplayEngine.getDisplay().displayInRed("Invalid weapon is selected.");
                return;
            }
        }

        Player player = new Player("player", "player", 100, validWeapons);
        GameArena gameArena = new GameArena();
        gameArena.setPlayer(player);
        Game.setGameArena(gameArena);
        DisplayEngine.getDisplay().displayInWhite("Now start the game");
    }
}
