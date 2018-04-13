package in.ashwanik.clgame.commands.list;

import in.ashwanik.clgame.commands.Command;
import in.ashwanik.clgame.commands.CommandDetail;
import in.ashwanik.clgame.commands.CommandList;
import in.ashwanik.clgame.ui.DisplayEngine;

import java.util.List;

/**
 * Created by jh80 on 13/04/18.
 */
public class Help extends Command {

    public Help(String name, String info) {
        super(name, info);
    }

    @Override
    public void execute(String[] arguments) {
        List<CommandDetail> commandDetails = CommandList.get().getCommands();
        for (CommandDetail commandDetail : commandDetails) {
            DisplayEngine.getDisplay().displayInWhite(commandDetail.toString());
        }
    }
}
