package in.ashwanik.clgame.ui.screens.impl;

import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.ui.screens.Renderer;

/**
 * Created by Ashwani Kumar on 11/04/18.
 */
public class WelcomeScreen implements Renderer {

    @Override
    public void render() {
        DisplayEngine.getDisplay().displayInGreen("------------------------------------------------");
        DisplayEngine.getDisplay().displayInGreen("\t----------------------------------\t");
        DisplayEngine.getDisplay().displayInGreen("\t--------Welcome to Game-----------\t");
        DisplayEngine.getDisplay().displayInGreen("\t----------------------------------\t");
        DisplayEngine.getDisplay().displayInGreen("------------------------------------------------");
        DisplayEngine.getDisplay().displayInGreen("\t\tRun help command to get started\t\t");
    }
}
