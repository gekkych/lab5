package command;

import java.util.HashMap;

public class HelpCommand extends Command {
    private final HashMap<String, Command> commandMap;
    public HelpCommand(HashMap<String, Command> commandMap) {
        super("help", false, false);
        this.commandMap = commandMap;
    }

    @Override
    public void start(String argument) {
        System.out.println("Доступные команды:");
        for (Command command : commandMap.values()) {
            System.out.println(command.description());
        }
    }

    @Override
    public String description() {
        return this.getName() + " - справка по доступным командам";
    }
}
