package command;

public abstract class Command {
    private final String name;
    private final boolean requiresExit;
    private final boolean requiresConfirmation;

    public Command(String name, boolean requiresConfirmation, boolean requiresExit) {
        this.name = name;
        this.requiresExit = requiresExit;
        this.requiresConfirmation = requiresConfirmation;
    }

    public abstract void start(String argument);
    public abstract String description();

    public String getName() {
        return name;
    }

    public boolean isRequiresExit() {
        return requiresExit;
    }

    public boolean isRequiresConfirmation() {
        return requiresConfirmation;
    }
}