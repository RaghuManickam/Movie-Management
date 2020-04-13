package jacksonModel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import play.data.validation.Constraints;

import java.util.List;

public class MovieModel {
    @JsonManagedReference(value = "movie")
    List<ScreenModel> screens;
    @JsonProperty("id")
    private Integer id;
    @Constraints.Required(message = "Movie name not provided")
    @JsonProperty("movieName")
    private String movieName;
    @JsonProperty("url")
    private String url;
    @Constraints.Required(message = "category not provided")
    @JsonProperty("category")
    private String category;
    @Constraints.Required(message = "enter the name of producer")
    @JsonProperty("producer")
    private String producer;
    @Constraints.Required(message = "enter the name of director")
    @JsonProperty("director")
    private String director;
    @Constraints.Required(message = "Please provide the release date")
    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("isDeleted")
    private boolean isDeleted;

    public MovieModel(Integer id) {
        this.id = id;
    }

    public MovieModel(List<ScreenModel> screens, Integer id, @Constraints.Required(message = "Movie name not provided") String movieName, String url, @Constraints.Required(message = "category not provided") String category, @Constraints.Required(message = "enter the name of producer") String producer, @Constraints.Required(message = "enter the name of director") String director, @Constraints.Required(message = "Please provide the release date") String releaseDate, boolean isDeleted) {
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

    public MovieModel() {
    }

    @Override
    public String toString() {
        return "MovieModel{" +
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

    public List<ScreenModel> getScreens() {
        return screens;
    }

    public void setScreens(List<ScreenModel> screens) {
        this.screens = screens;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
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

}
