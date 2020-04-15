package RestDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScreenDTO {

    @JsonProperty("ScreenNumber")
    private Integer ScreenNumber;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("multiplex")
    private MultiplexDTO multiplex;
    @JsonProperty("movie")
    private MovieDTO movie;
    @JsonProperty("isDeleted")
    private Boolean isDeleted;

    @Override
    public String toString() {
        return "ScreenDTO{" +
                "ScreenNumber=" + ScreenNumber +
                ", id=" + id +
                ", multiplex=" + multiplex +
                ", movie=" + movie +
                ", isDeleted=" + isDeleted +
                '}';
    }

    @JsonProperty("screenNumber")
    public Integer getScreenNumber() {
        return ScreenNumber;
    }

    @JsonProperty("screenNumber")
    public void setScreenNumber(Integer ScreenNumber) {
        this.ScreenNumber = ScreenNumber;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("multiplex")
    public MultiplexDTO getMultiplex() {
        return multiplex;
    }

    @JsonProperty("multiplex")
    public void setMultiplex(MultiplexDTO multiplex) {
        this.multiplex = multiplex;
    }

    @JsonProperty("movie")
    public MovieDTO getMovie() {
        return movie;
    }

    @JsonProperty("movie")
    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    @JsonProperty("isDeleted")
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    @JsonProperty("isDeleted")
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
