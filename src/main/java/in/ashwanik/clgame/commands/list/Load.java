package in.ashwanik.clgame.commands.list;

import in.ashwanik.clgame.Game;
import in.ashwanik.clgame.commands.Command;
import in.ashwanik.clgame.common.Color;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.messaging.Topics;
import in.ashwanik.clgame.messaging.messages.GameStateMessage;
import in.ashwanik.clgame.messaging.messages.MessageType;
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
            GameArena gameArena = (GameArena) SerializationUtil.deserialize(FileUtils.getBasePath() + File.separator + file);
            if (Objects.isNull(gameArena)) {
                DisplayEngine.getDisplay().displayInRed("\nSome error occurred while loading the last game.\n");
                return;
            }
            DisplayEngine.getDisplay().display(Color.YELLOW, "Loading game\n");
            Game.setGameArena(gameArena);
            EventBus.getInstance().publish(GameStateMessage.builder().messageType(MessageType.GAME_STARTED).topic(Topics.GAME_STATE).build());
        } else {
            DisplayEngine.getDisplay().displayInRed("\nNo saved game is found.\n");
        }
    }
}
