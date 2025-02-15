//Вариант 4326
import command.*;
import exception.InvalidArgumentException;
import movie.MovieDeque;
import movie.MovieGenre;
import movie.MpaaRating;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static final String GECKO = "\uD83E\uDD8E";
    static Scanner scanner = new Scanner(System.in);
    static MovieDeque movies = new MovieDeque();
    static HashMap<String, Command> commandMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(movies.getCreationDate());
        movies.add("Человеческая многоножка", 10, 8.0, MovieGenre.COMEDY, MpaaRating.G, "Том Сикс", 80, 170);
        movies.add("Зелёный слоник", 156, 12.0, MovieGenre.COMEDY, MpaaRating.G, "Светлана Баскова", 50, 175);

        initializeCommands();
        input();
    }

    public static void initializeCommands() {
        ExitCommand exit = new ExitCommand();
        HelpCommand help = new HelpCommand(commandMap);
        ShowCommand show = new ShowCommand(movies);
        RemoveByIdCommand remove_by_id = new RemoveByIdCommand(movies);
        ClearCommand clear = new ClearCommand(movies);
        AddCommand add = new AddCommand(movies, scanner);
        CommandClearTerminal clearTerminal = new CommandClearTerminal();
        commandMap.put(help.getName(), help);
        commandMap.put(exit.getName(), exit);
        commandMap.put(show.getName(), show);
        commandMap.put(clear.getName(), clear);
        commandMap.put(remove_by_id.getName(), remove_by_id);
        commandMap.put(add.getName(), add);
        commandMap.put(clearTerminal.getName(), clearTerminal);

    }

    public static void input() {
        boolean commandFound;
        Command currentCommand;
        System.out.println("Введите help для списка команд");
        while (true) {
            commandFound = false;
            System.out.print(GECKO + " > ");
            String[] input = scanner.nextLine().trim().split(" ");
            String commandName = input[0];
            String argument = input.length > 1 ? input[1] : null;

            if (commandMap.containsKey(commandName)) {
                currentCommand = commandMap.get(commandName);
                commandFound = true;

                if (currentCommand.isRequiresConfirmation()) {
                    if (!confirmCommand(currentCommand)) {
                        continue;
                    }
                }

                try {
                    currentCommand.start(argument);
                } catch (InvalidArgumentException e) {
                    System.out.println(e.getMessage());
                }

                if (currentCommand.isRequiresExit()) {
                    scanner.close();
                    return;
                }
            }

            if (!commandFound) {
                System.out.println("\u001B[31m" + "Команда неопознана" + "\u001B[0m");
            }
        }
    }

    public static boolean confirmCommand(Command command) {
        final String[] CONFIRMATION_WORDS = {"y", "yes"};
        System.out.println("Вы уверены, что хотите выполнить команду " + command.getName() + "? (y/n)");
        System.out.print(GECKO + " > ");
        String input = scanner.nextLine().trim();
        for (String word : CONFIRMATION_WORDS) {
            if (input.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
}