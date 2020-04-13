package jacksonModel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScreenModel {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("ScreenNumber")
    private Integer ScreenNumber;
    @JsonProperty("multiplex")
    @JsonBackReference(value = "multiplex")
    private MultiplexModel multiplex;
    @JsonProperty("movie")
    @JsonBackReference(value = "movie")
    private MovieModel movie;
    @JsonProperty("isDeleted")
    private boolean isDeleted;

    public ScreenModel() {
    }

    public ScreenModel(Integer id, Integer screenNumber, MultiplexModel multiplex, MovieModel movie, boolean isDeleted) {
        this.id = id;
        ScreenNumber = screenNumber;
        this.multiplex = multiplex;
        this.movie = movie;
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "ScreenModel{" +
                "id=" + id +
                ", ScreenNumber=" + ScreenNumber +
                ", multiplex=" + multiplex +
                ", movie=" + movie +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScreenNumber() {
        return ScreenNumber;
    }

    public void setScreenNumber(Integer screenNumber) {
        ScreenNumber = screenNumber;
    }

    public MultiplexModel getMultiplex() {
        return multiplex;
    }

    public void setMultiplex(MultiplexModel multiplex) {
        this.multiplex = multiplex;
    }

    public MovieModel getMovie() {
        return movie;
    }

    public void setMovie(MovieModel movie) {
        this.movie = movie;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
