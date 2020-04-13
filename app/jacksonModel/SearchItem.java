package jacksonModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchItem {
    @JsonProperty("screens")
    List<ScreenModel> screens;
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
    private boolean isDeleted;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
    @JsonProperty("numberOfScreens")
    private Integer numberOfScreens;
    public SearchItem() {
    }

    public SearchItem(List<ScreenModel> screens, Integer id, String movieName, String url, String category, String producer, String director, String releaseDate, boolean isDeleted, String name, String address, Integer numberOfScreens) {
        this.screens = screens;
        this.id = id;
        this.movieName = movieName;
        this.url = url;
        this.category = category;
        this.producer = producer;
        this.director = director;
        this.releaseDate = releaseDate;
        this.isDeleted = isDeleted;
        this.name = name;
        this.address = address;
        this.numberOfScreens = numberOfScreens;
    }

    @Override
    public String toString() {
        return "SearchItem{" +
                "screens=" + screens +
                ", id=" + id +
                ", movieName='" + movieName + '\'' +
                ", url='" + url + '\'' +
                ", category='" + category + '\'' +
                ", producer='" + producer + '\'' +
                ", director='" + director + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", isDeleted=" + isDeleted +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numberOfScreens=" + numberOfScreens +
                '}';
    }

    public List<ScreenModel> getScreens() {
        return screens;
    }

    public void setScreens(List<ScreenModel> screens) {
        this.screens = screens;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumberOfScreens() {
        return numberOfScreens;
    }

    public void setNumberOfScreens(Integer numberOfScreens) {
        this.numberOfScreens = numberOfScreens;
    }
}
