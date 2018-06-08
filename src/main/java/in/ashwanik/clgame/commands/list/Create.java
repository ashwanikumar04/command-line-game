package in.ashwanik.clgame.commands.list;

import in.ashwanik.clgame.Game;
import in.ashwanik.clgame.commands.Command;
import in.ashwanik.clgame.models.Player;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.ui.screens.GameArena;

/**
 * Created by Ashwani on 08/06/18.
 */
public class Create extends Command {
    public Create(String name, String info) {
        super(name, info);
    }

    @Override
    public void execute(String[] arguments) {
        if (arguments.length == 0) {
            DisplayEngine.getDisplay().displayInRed("No name is given for the character.\n");
            return;
        }
        Player player = new Player(arguments[0], "player", 100);
        GameArena gameArena = new GameArena(2);
        gameArena.setPlayer(player);
        Game.setGameArena(gameArena);
        DisplayEngine.getDisplay().displayInGreen("Now `arm` the character.\n");
    }
}
