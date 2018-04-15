package in.ashwanik.clgame.commands.list;

import in.ashwanik.clgame.Game;
import in.ashwanik.clgame.commands.Command;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class Debug extends Command {

    public Debug(String name, String info) {
        super(name, info);
    }

    @Override
    public void execute(String[] arguments) {
        if (arguments.length == 0) {
            Game.setDebug(true);
        } else {
            Game.setDebug(arguments[0].equals("true"));
        }
    }

}
