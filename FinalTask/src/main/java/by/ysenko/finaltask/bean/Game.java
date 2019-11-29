package by.ysenko.finaltask.bean;

public class Game extends Bean {

    private String name;
    private Genre genre;
    private Integer exclusivity;
    private String releaseDate;



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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
