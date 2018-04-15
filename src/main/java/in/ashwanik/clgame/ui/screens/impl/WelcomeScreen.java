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
        DisplayEngine.getDisplay().displayInGreen("\n\t----------------------------------\t");
        DisplayEngine.getDisplay().displayInGreen("\n\t--------Welcome to Game-----------\t");
        DisplayEngine.getDisplay().displayInGreen("\n\t----------------------------------\t");
        DisplayEngine.getDisplay().displayInGreen("\n------------------------------------------------");
        DisplayEngine.getDisplay().displayInGreen("\nThis game has a simple setup. There are two cells each containing an enemy.\n" +
                "You start in one of the cells." +
                "\n These two cells are connected to a main hall which also has a monster.\n" +
                " You can win the game once you reach to the ground connected to the main hall.\n" +
                "But you need to kill at least two enemies two reach the ground");
        DisplayEngine.getDisplay().displayInGreen("\n------------------------------------------------");
        DisplayEngine.getDisplay().displayInGreen("\n\t\tRun help command to get started\t\t\n");
    }
}
