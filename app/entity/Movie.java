package entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {
    @OneToMany(fetch = FetchType.EAGER)
    @Where(clause = "isDeleted = 'false'")
    List<Screen> screens;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String movieName;
    private String url;
    private String category;
    private String producer;
    private String director;
    private String releaseDate;
    private boolean isDeleted;

    public Movie(List<Screen> screens, Integer id, String movieName, String url, String category, String producer, String director, String releaseDate, boolean isDeleted) {
        this.screens = screens;
        this.id = id;
        this.movieName = movieName;
        this.url = url;
        this.category = category;
        this.producer = producer;
        this.director = director;
        this.releaseDate = releaseDate;
        this.isDeleted = isDeleted;
    }

    public Movie() {
    }

    public Movie(Integer id) {
        this.id = id;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "screens=" + screens +
                ", id=" + id +
                ", movieName='" + movieName + '\'' +
                ", url='" + url + '\'' +
                ", category='" + category + '\'' +
                ", producer='" + producer + '\'' +
                ", director='" + director + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
