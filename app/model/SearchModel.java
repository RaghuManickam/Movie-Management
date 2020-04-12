package model;

public class SearchModel {
    String searchString;
    Integer movieOrMulti;

    public SearchModel() {
    }

    public SearchModel(String searchString, Integer movieOrMulti) {
        this.searchString = searchString;
        this.movieOrMulti = movieOrMulti;
    }

    @Override
    public String toString() {
        return "SearchModel{" +
                "searchString='" + searchString + '\'' +
                ", movieOrMulti=" + movieOrMulti +
                '}';
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public Integer getMovieOrMulti() {
        return movieOrMulti;
    }

    public void setMovieOrMulti(Integer movieOrMulti) {
        this.movieOrMulti = movieOrMulti;
    }
}
