package command;

import movie.MovieDeque;
import movie.MovieGenre;
import movie.MpaaRating;

import java.util.Scanner;

public class AddCommand extends Command{
    static final String GECKO = "\uD83E\uDD8E";
    private final MovieDeque movies;
    private final Scanner scanner;
    public AddCommand(MovieDeque movies, Scanner scanner) {
        super("add", false, false);
        this.movies = movies;
        this.scanner = scanner;
    }

    @Override
    public void start(String argument) {
        System.out.println(GECKO + "> Введите название фильма:");
        String name = scanner.nextLine().trim();

        System.out.println(GECKO + "> Введите координату X:");
        int x = Integer.parseInt(scanner.nextLine().trim());

        System.out.println(GECKO + "> Введите координату Y:");
        Double y = Double.parseDouble(scanner.nextLine().trim());

        System.out.println(GECKO + "> Введите жанр фильма:");
        MovieGenre movieGenre = switch (scanner.nextLine().trim().toLowerCase()) {
            case "action" -> MovieGenre.ACTION;
            case "comedy" -> MovieGenre.COMEDY;
            case "science fiction" -> MovieGenre.SCIENCE_FICTION;
            default -> null;
        };

        System.out.println(GECKO + "> Введите возрастной рейтинг фильма");
        MpaaRating mpaaRating = switch (scanner.nextLine().trim().toLowerCase()) {
            case "g" -> MpaaRating.G;
            case "pg" -> MpaaRating.PG;
            case "pg 13" -> MpaaRating.PG_13;
            case "nc 17" -> MpaaRating.NC_17;
            default -> null;
        };

        System.out.println(GECKO + "> Введите имя директора:");
        String directorName = scanner.nextLine().trim();

        System.out.println(GECKO + "> Введите вес режиссёра:");
        int directorWeight = Integer.parseInt(scanner.nextLine().trim());

        System.out.println(GECKO + "> Введите рост режиссёра:");
        int directorHeight = Integer.parseInt(scanner.nextLine().trim());

        movies.add(name, x, y, movieGenre, mpaaRating, directorName, directorWeight, directorHeight);
    }

    @Override
    public String description() {
        return this.getName() + " - добавить новый элемент в коллекцию";
    }
}
