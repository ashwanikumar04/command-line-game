package in.ashwanik.clgame.commands.list;

import in.ashwanik.clgame.Game;
import in.ashwanik.clgame.commands.Command;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.utils.FileUtils;
import in.ashwanik.clgame.utils.SerializationUtil;

import java.io.File;
import java.util.Objects;

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
        String filePath = FileUtils.getBasePath() + File.pathSeparator + System.currentTimeMillis() + ".cer";
        if (Objects.isNull(Game.getGameArena())) {
            DisplayEngine.getDisplay().displayInRed("Game is not started");
            return;
        }
        SerializationUtil.serialize(filePath, Game.getGameArena());
    }
}
