package in.ashwanik.clgame.commands.list;

import in.ashwanik.clgame.Game;
import in.ashwanik.clgame.commands.Command;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.ui.screens.GameArena;
import in.ashwanik.clgame.utils.FileUtils;
import in.ashwanik.clgame.utils.SerializationUtil;
import in.ashwanik.clgame.utils.StringUtils;

import java.io.File;
import java.util.Objects;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class Load extends Command {

    public Load(String name, String info) {
        super(name, info);
    }

    @Override
    public void execute(String[] arguments) {
        String file = FileUtils.getLatestFile();
        if (!StringUtils.isBlank(file)) {
            GameArena gameArena = (GameArena) SerializationUtil.deserialize(FileUtils.getBasePath() + File.pathSeparator + file);
            if (Objects.isNull(gameArena)) {
                DisplayEngine.getDisplay().displayInRed("Some error occurred while loading the last game.");
                return;
            }
            Game.setGameArena(gameArena);
        } else {
            DisplayEngine.getDisplay().displayInRed("No saved game is found.");
        }
    }
}
