package in.ashwanik.clgame.commands;

import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.utils.StringUtils;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CommandParser {
    private Scanner reader;

    public CommandParser() {
        reader = new Scanner(System.in);
    }

    public IssuedCommand getIssuedCommand() {
        DisplayEngine.getDisplay().displayInGreen(":$: ");
        String inputLine;
        inputLine = reader.nextLine();
        if (StringUtils.isBlank(inputLine)) {
            return new IssuedCommand("");
        }
        StringTokenizer stringTokenizer = new StringTokenizer(inputLine);

        IssuedCommand issuedCommand = new IssuedCommand(inputLine);
        while (stringTokenizer.hasMoreTokens()) {
            issuedCommand.addToken(stringTokenizer.nextToken());
        }
        return issuedCommand;
    }

}
