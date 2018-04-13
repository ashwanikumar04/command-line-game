package in.ashwanik.clgame.commands;

import in.ashwanik.clgame.utils.CollectionsUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class IssuedCommand {
    private final String stringRepresentation;
    private final List<String> tokens;

    IssuedCommand(String issuedCommand) {
        this.stringRepresentation = issuedCommand;
        this.tokens = new ArrayList<>();
    }

    void addToken(String token) {
        tokens.add(token);
    }

    String getCommand() {
        return CollectionsUtil.isEmpty(tokens) ? "" : tokens.get(0);
    }

    String[] getArgs() {
        if (CollectionsUtil.isEmpty(tokens)) {
            return new String[0];
        } else {
            String[] tokenArray = tokens.toArray(new String[tokens.size()]);
            int argumentCount = tokens.size() - 1;
            String[] arguments = new String[tokens.size() - 1];
            System.arraycopy(tokenArray, 1, arguments, 0, argumentCount);
            return arguments;
        }
    }
}
