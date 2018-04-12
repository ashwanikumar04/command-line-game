package in.ashwanik.clgame.ui.screens;

import in.ashwanik.clgame.Player;
import in.ashwanik.clgame.messaging.Message;
import in.ashwanik.clgame.messaging.Subscriber;
import in.ashwanik.clgame.ui.DisplayEngine;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
@Getter
@Setter
public class GameArena implements Serializable, Subscriber {
    private static final long serialVersionUID = -6158956787090431591L;
    private Player player;

    public GameArena() {

    }

    public void updateDisplay() {
        displayPlayerHud();
    }

    private void displayPlayerHud() {
        if (player != null) {
            DisplayEngine.getDisplay().displayInGreen("Hud: " + player.getHealth());
        }
    }

    @Override
    public void receive(Message message) {
        DisplayEngine.getDisplay().displayInGreen(message.getPayload().toString());
    }
}
