package in.ashwanik.clgame.ui.screens.impl;

import in.ashwanik.clgame.common.Color;
import in.ashwanik.clgame.ui.screens.GameDisplay;

import java.io.Serializable;

/**
 * https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
 */
public class ConsoleDisplay implements GameDisplay, Serializable {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final long serialVersionUID = -2177245013496959920L;

    @Override
    public void displayInWhite(String text) {
        System.out.print(ANSI_WHITE + text);
    }

    @Override
    public void displayInRed(String text) {
        System.out.print(ANSI_RED + text);
    }

    @Override
    public void displayInGreen(String text) {
        System.out.print(ANSI_GREEN + text);
    }

    @Override
    public void display(Color color, String text) {
        String colorCode;
        switch (color) {
            case GREEN:
                colorCode = ANSI_GREEN;
                break;
            case RED:
                colorCode = ANSI_RED;
                break;
            case WHITE:
                colorCode = ANSI_WHITE;
                break;
            case YELLOW:
                colorCode = ANSI_YELLOW;
                break;
            case BLACK:
                colorCode = ANSI_BLACK;
                break;
            case NONE:
            default:
                colorCode = ANSI_RESET;
        }
        System.out.print(colorCode + text);
    }
}
