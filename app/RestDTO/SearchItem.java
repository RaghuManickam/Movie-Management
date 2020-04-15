package RestDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchItem {

    @JsonProperty("screens")
    private List<ScreenDTO> screens = null;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("movieName")
    private Object movieName;
    @JsonProperty("url")
    private Object url;
    @JsonProperty("category")
    private Object category;
    @JsonProperty("producer")
    private Object producer;
    @JsonProperty("director")
    private Object director;
    @JsonProperty("releaseDate")
    private Object releaseDate;
    @JsonProperty("isDeleted")
    private Boolean isDeleted;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
    @JsonProperty("numberOfScreens")
    private Integer numberOfScreens;

    @Override
    public String toString() {
        return "SearchItem{" +
                "screens=" + screens +
                ", id=" + id +
                ", movieName=" + movieName +
                ", url=" + url +
                ", category=" + category +
                ", producer=" + producer +
                ", director=" + director +
                ", releaseDate=" + releaseDate +
                ", isDeleted=" + isDeleted +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numberOfScreens=" + numberOfScreens +
                '}';
    }

    @JsonProperty("screens")
    public List<ScreenDTO> getScreens() {
        return screens;
    }

    @JsonProperty("screens")
    public void setScreens(List<ScreenDTO> screens) {
        this.screens = screens;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("movieName")
    public Object getMovieName() {
        return movieName;
    }

    @JsonProperty("movieName")
    public void setMovieName(Object movieName) {
        this.movieName = movieName;
    }

    @JsonProperty("url")
    public Object getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(Object url) {
        this.url = url;
    }

    @JsonProperty("category")
    public Object getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Object category) {
        this.category = category;
    }

    @JsonProperty("producer")
    public Object getProducer() {
        return producer;
    }

    @JsonProperty("producer")
    public void setProducer(Object producer) {
        this.producer = producer;
    }

    @JsonProperty("director")
    public Object getDirector() {
        return director;
    }

    @JsonProperty("director")
    public void setDirector(Object director) {
        this.director = director;
    }

    @JsonProperty("releaseDate")
    public Object getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("releaseDate")
    public void setReleaseDate(Object releaseDate) {
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

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("numberOfScreens")
    public Integer getNumberOfScreens() {
        return numberOfScreens;
    }

    @JsonProperty("numberOfScreens")
    public void setNumberOfScreens(Integer numberOfScreens) {
        this.numberOfScreens = numberOfScreens;
    }

}
