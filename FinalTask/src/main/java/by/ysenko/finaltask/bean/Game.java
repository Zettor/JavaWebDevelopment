package by.ysenko.finaltask.bean;

import java.sql.Timestamp;


public class Game extends Bean {

    public Game() {
    }

    private String name;
    private String imgPath;
    private Genre genre;
    private Integer exclusivity;
    private Timestamp releaseDate;
    private String description;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getExclusivity() {
        return exclusivity;
    }

    public void setExclusivity(Integer exclusivity) {
        this.exclusivity = exclusivity;
    }

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return getName().equals(game.getName()) &&
                getImgPath().equals(game.getImgPath()) &&
                getGenre().equals(game.getGenre()) &&
                getExclusivity().equals(game.getExclusivity()) &&
                getReleaseDate().equals(game.getReleaseDate()) &&
                getDescription().equals(game.getDescription());
    }

    @Override
    public int hashCode() {
        return getName().hashCode()
                + getImgPath().hashCode()
                + getGenre().hashCode()
                + getExclusivity()
                + getReleaseDate().hashCode()
                + getDescription().hashCode();
    }

    public Game(String name, String imgPath, Genre genre, Integer exclusivity, Timestamp releaseDate, String description) {
        this.name = name;
        this.imgPath = imgPath;
        this.genre = genre;
        this.exclusivity = exclusivity;
        this.releaseDate = releaseDate;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", genre=" + genre +
                ", exclusivity=" + exclusivity +
                ", releaseDate=" + releaseDate +
                ", description='" + description + '\'' +
                '}';
    }
}
