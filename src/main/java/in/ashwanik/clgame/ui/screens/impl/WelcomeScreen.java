package in.ashwanik.clgame.ui.screens.impl;

import in.ashwanik.clgame.ui.screens.GameDisplay;
import in.ashwanik.clgame.ui.screens.Renderer;
import lombok.AllArgsConstructor;

/**
 * Created by Ashwani Kumar on 11/04/18.
 */
@AllArgsConstructor
public class WelcomeScreen implements Renderer {

    private GameDisplay gameDisplay;

    @Override
    public void render() {
        gameDisplay.displayInGreen("------------------------------------------------");
        gameDisplay.displayInGreen("\t----------------------------------\t");
        gameDisplay.displayInGreen("\t--------Welcome to Game-----------\t");
        gameDisplay.displayInGreen("\t----------------------------------\t");
        gameDisplay.displayInGreen("------------------------------------------------");
    }
}
