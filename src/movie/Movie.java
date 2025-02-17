package movie;

import java.util.Date;
import java.util.Objects;

public class Movie implements Comparable<Movie>{
    private final long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int oscarsCount; //Значение поля должно быть больше 0
    private MovieGenre genre; //Поле не может быть null
    private MpaaRating mpaaRating; //Поле может быть null
    private Person director; //Поле может быть null

    protected Movie(long id, String name, int x, Double y, MovieGenre genre, MpaaRating mpaaRating, int oscarsCount, String directorName, int weight, int height) {
        this.id = id;
        setName(name);
        setCoordinates(x, y);
        this.creationDate = new Date();
        setGenre(genre);
        setMpaaRating(mpaaRating);
        this.oscarsCount = oscarsCount;
        setDirector(directorName, weight, height);
    }

    @Override
    public int compareTo(Movie other) {
        return Integer.compare(this.oscarsCount, other.oscarsCount);
    }

    public void setName(String name) {
        Objects.requireNonNull(name, "Строка не должна быть null");
        if (name.isEmpty()) {
            return;
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCoordinates(int x, Double y) { // реализовать проверку на null
        this.coordinates = new Coordinates(x, y);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setOscarsCount(int count) {
        if (count <= 0) {
            return;
        }
        this.oscarsCount = count;
    }

    public void setGenre(MovieGenre genre) { // реализовать проверку на null
        this.genre = genre;
    }

    public void setMpaaRating(MpaaRating rating) { // реализовать проверку на null
        this.mpaaRating = rating;
    }

    public void setDirector(String name, int weight, int height) {
        this.director = new Person(name, weight, height);
    }

    public Person getDirector() {
        return director;
    }

    public long getID() {
        return id;
    }

    public int getOscarsCount() {
        return oscarsCount;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", oscarsCount=" + oscarsCount +
                ", genre=" + genre +
                ", mpaaRating=" + mpaaRating +
                ", director=" + director +
                '}';
    }

}
