package RestDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDTO {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("movieName")
    private String movieName;
    @JsonProperty("url")
    private String url;
    @JsonProperty("category")
    private String category;
    @JsonProperty("producer")
    private String producer;
    @JsonProperty("director")
    private String director;
    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("isDeleted")
    private Boolean isDeleted;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", url='" + url + '\'' +
                ", category='" + category + '\'' +
                ", producer='" + producer + '\'' +
                ", director='" + director + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }

    @JsonProperty("movieName")
    public String getMovieName() {
        return movieName;
    }

    @JsonProperty("movieName")
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("producer")
    public String getProducer() {
        return producer;
    }

    @JsonProperty("producer")
    public void setProducer(String producer) {
        this.producer = producer;
    }

    @JsonProperty("director")
    public String getDirector() {
        return director;
    }

    @JsonProperty("director")
    public void setDirector(String director) {
        this.director = director;
    }

    @JsonProperty("releaseDate")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("releaseDate")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
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
