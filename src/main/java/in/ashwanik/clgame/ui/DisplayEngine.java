package in.ashwanik.clgame.ui;

import in.ashwanik.clgame.ui.screens.GameDisplay;

/**
 * Created by jh80 on 13/04/18.
 */
public class DisplayEngine {
    private static DisplayEngine INSTANCE;
    private GameDisplay gameDisplay;
    private static boolean initialized;

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
