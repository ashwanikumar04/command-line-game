package in.ashwanik.clgame.commands.list;

import in.ashwanik.clgame.Game;
import in.ashwanik.clgame.commands.Command;
import in.ashwanik.clgame.commands.CommandList;
import in.ashwanik.clgame.models.Armoury;
import in.ashwanik.clgame.models.Weapon;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class Arm extends Command {

    public Arm(String name, String info) {
        super(name, info);
    }

    @Override
    public void execute(String[] arguments) {
        if (validateArguments(arguments)) {
            return;
        }

        List<Weapon> validWeapons = new ArrayList<>();
        if (getValidWeapons(arguments, validWeapons)) {
            return;
        }
        if (Objects.isNull(Game.getGameArena())) {
            DisplayEngine.getDisplay().displayInRed("First create the player");
            return;
        }

        Game.getGameArena().getPlayer().addWeapon(validWeapons.get(0));

        DisplayEngine.getDisplay().displayInWhite("Now start the game");
    }

    private boolean getValidWeapons(String[] arguments, List<Weapon> validWeapons) {
        String weapon = arguments[0];
        if (StringUtils.isNumeric(weapon)) {
            int weaponId = Integer.parseInt(weapon);
            if (weaponId > 0 && weaponId <= Armoury.get().getWeapons().size()) {
                validWeapons.add(Armoury.get().getWeapons().get(weaponId - 1));
            } else {
                DisplayEngine.getDisplay().displayInRed("Invalid weapon is selected.");
                return true;
            }
        } else {
            DisplayEngine.getDisplay().displayInRed("Invalid weapon is selected.");
            return true;
        }
        return false;
    }

    private boolean validateArguments(String[] arguments) {
        if (arguments.length == 0) {
            DisplayEngine.getDisplay().displayInRed("No weapon is selected.\n");
            DisplayEngine.getDisplay().displayInWhite("Arm command: \t " + CommandList.get().getCommand("arm"));
            return true;
        }
        return false;
    }
}
