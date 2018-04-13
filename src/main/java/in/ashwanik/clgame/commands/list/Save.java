package in.ashwanik.clgame.commands.list;

import in.ashwanik.clgame.Game;
import in.ashwanik.clgame.commands.Command;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.utils.FileUtils;
import in.ashwanik.clgame.utils.SerializationUtil;

import java.io.File;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class Save extends Command {

    public Save(String name, String info) {
        super(name, info);
    }

    @Override
    public void execute(String[] arguments) {
        FileUtils.createBasePath();
        String filePath = FileUtils.getBasePath() + File.separator + System.currentTimeMillis() + ".cer";
        if (!Game.isStarted()) {
            DisplayEngine.getDisplay().displayInRed("\nGame is not started\n");
            return;
        }
        SerializationUtil.serialize(filePath, Game.getGameArena());
        DisplayEngine.getDisplay().displayInWhite("\nGame saved\n");
    }
}
