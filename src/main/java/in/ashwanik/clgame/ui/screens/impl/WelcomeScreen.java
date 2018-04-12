package in.ashwanik.clgame.ui.screens.impl;

import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.ui.screens.Renderer;
import lombok.AllArgsConstructor;

/**
 * Created by Ashwani Kumar on 11/04/18.
 */
@AllArgsConstructor
public class WelcomeScreen implements Renderer {

    @Override
    public void render() {
        DisplayEngine.getDisplay().displayInGreen("------------------------------------------------");
        DisplayEngine.getDisplay().displayInGreen("\t----------------------------------\t");
        DisplayEngine.getDisplay().displayInGreen("\t--------Welcome to Game-----------\t");
        DisplayEngine.getDisplay().displayInGreen("\t----------------------------------\t");
        DisplayEngine.getDisplay().displayInGreen("------------------------------------------------");
    }
}
