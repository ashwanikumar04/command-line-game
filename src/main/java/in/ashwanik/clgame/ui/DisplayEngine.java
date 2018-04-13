package in.ashwanik.clgame.ui;

import in.ashwanik.clgame.ui.screens.GameDisplay;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class DisplayEngine {
    private static DisplayEngine INSTANCE;
    private static boolean initialized;
    private GameDisplay gameDisplay;

    private DisplayEngine(GameDisplay gameDisplay) {
        this.gameDisplay = gameDisplay;
    }

    public static void init(GameDisplay gameDisplay) {
        if (!initialized) {
            INSTANCE = new DisplayEngine(gameDisplay);
            initialized = true;
        }
    }

    public static GameDisplay getDisplay() {
        return INSTANCE.gameDisplay;
    }


}
