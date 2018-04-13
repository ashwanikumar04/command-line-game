package in.ashwanik.clgame.commands;

import in.ashwanik.clgame.commands.list.Help;
import in.ashwanik.clgame.commands.list.Load;
import in.ashwanik.clgame.commands.list.Quit;
import in.ashwanik.clgame.commands.list.Save;

import java.util.*;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class CommandList {
    private static CommandList LIST;
    private final Map<String, Command> commandsMap = new HashMap<>();

    private CommandList() {
    }

    public static CommandList get() {
        if (Objects.isNull(LIST)) {
            throw new IllegalStateException("Command list is not initialized");
        }
        return LIST;
    }

    public static void initCommands() {
        CommandList commandList = new CommandList();
        commandList.addCommand(new Help("help", "Lists all the supported commands"));
        commandList.addCommand(new Quit("quit", "Quit the game"));
        commandList.addCommand(new Save("save", "Save the game"));
        commandList.addCommand(new Load("load", "Load the last saved game."));
        LIST = commandList;
    }

    public static Command getHelp() {
        return get().getCommand("help");
    }

    public Command getCommand(String token) {
        return commandsMap.get(token.toLowerCase(Locale.ENGLISH));
    }

    private void addCommand(Command command) {
        String name = command.getDescription().getName().toLowerCase(Locale.ENGLISH);
        if (commandsMap.containsKey(name)) {
            throw new IllegalArgumentException("Tried to add '" + name + "' multiple times.");
        }
        commandsMap.put(name, command);
    }

    public List<CommandDetail> getCommands() {
        List<CommandDetail> details = new ArrayList<>(commandsMap.size());
        for (Command command : commandsMap.values()) {
            details.add(command.getDescription());
        }
        return details;
    }

}
