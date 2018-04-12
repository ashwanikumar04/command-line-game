package in.ashwanik.clgame.ui.screens;

import in.ashwanik.clgame.common.Color;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
public interface GameDisplay {
    void displayInWhite(String text);

    void displayInRed(String text);

    void displayInGreen(String text);

    void display(Color color, String text);

}
