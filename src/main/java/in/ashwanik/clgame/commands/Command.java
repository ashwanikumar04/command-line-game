package in.ashwanik.clgame.commands;

/**
 * Created by jh80 on 13/04/18.
 */

public abstract class Command {

    private final CommandDescription description;

    Command(String name, String info) {
        description = new CommandDescription(name, info);
    }

    public CommandDescription getDescription() {
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
