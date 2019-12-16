package by.ysenko.finaltask.bean;

import java.sql.Timestamp;

public class Game extends Bean {

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
}
