package in.ashwanik.clgame.commands;

import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.messaging.Topics;
import in.ashwanik.clgame.messaging.messages.CommandMessage;
import in.ashwanik.clgame.messaging.messages.MessageType;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.utils.StringUtils;

import java.io.InputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputStreamCommandParser implements CommandParser {
    private Scanner reader;

    public InputStreamCommandParser(InputStream inputStream) {
        reader = new Scanner(inputStream);
    }

    private void publish(IssuedCommand issuedCommand) {
        EventBus.getInstance().publish(CommandMessage.builder().messageType(MessageType.COMMAND).topic(Topics.COMMAND).payload(issuedCommand).build());
    }

    @Override
    public void publishIssuesCommand() {
        DisplayEngine.getDisplay().displayInGreen("\n:$ ");
        String inputLine;
        if (reader.hasNextLine()) {
            inputLine = reader.nextLine();
            if (StringUtils.isBlank(inputLine)) {
                publish(new IssuedCommand(""));
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(inputLine);

            IssuedCommand issuedCommand = new IssuedCommand(inputLine);
            while (stringTokenizer.hasMoreTokens()) {
                issuedCommand.addToken(stringTokenizer.nextToken());
            }
            publish(issuedCommand);
        }
        publish(new IssuedCommand(""));
    }

}
