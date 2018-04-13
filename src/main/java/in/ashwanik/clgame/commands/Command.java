package in.ashwanik.clgame.commands;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */

public abstract class Command {

    private final CommandDetail description;

    public Command(String name, String info) {
        description = new CommandDetail(name, info);
    }

    public CommandDetail getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Command command = (Command) object;
        return description.getName().equals(command.description.getName());
    }

    @Override
    public int hashCode() {
        return description.getName().hashCode();
    }

    public abstract void execute(String[] arguments);

    @Override
    public String toString() {
        return description.toString();
    }

}
