package in.ashwanik.clgame.commands;

import in.ashwanik.clgame.ui.DisplayEngine;

import java.util.Objects;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class CommandExecutor {

    private static Command getCommand(IssuedCommand issuedCommand) {
        Command command = CommandList.get().getCommand(issuedCommand.getCommand());
        if (Objects.isNull(command)) {
            DisplayEngine.getDisplay().displayInRed("Invalid command, displaying the list of commands:");
            return CommandList.getHelp();
        } else {
            return command;
        }
    }

    public static void execute(IssuedCommand issuedCommand) {
        Command command = getCommand(issuedCommand);
        command.execute(issuedCommand.getArgs());
    }
}
