package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import entity.Movie;

import java.util.List;

public class SearchResult {
    List<Movie> body;
    @JsonCreator
    public SearchResult(@JsonProperty("body")List<Movie> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "body=" + body +
                '}';
    }

    public List<Movie> getBody() {
        return body;
    }

    public void setBody(List<Movie> body) {
        this.body = body;
    }
}
