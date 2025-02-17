package command;

import movie.MovieDeque;


public class InfoCommand extends Command{
    MovieDeque movies;
    public InfoCommand(MovieDeque movies) {
        super("info", false, false);
        this.movies = movies;
    }

    @Override
    public void start(String arguments) {
        String type = "Тип ArrayDeque";
        String date = "Создано " + movies.getCreationDate();
        String elementCount = "Количество элементов " + movies.getCollection().size();
        System.out.println(type);
        System.out.println(date);
        System.out.println(elementCount);
    }

    @Override
    public String description() {
        return this.getName() + " - информация о коллекции";
    }
}
