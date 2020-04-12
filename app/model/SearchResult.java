package model;

import entity.Movie;

import java.util.List;

public class SearchResult {
    List<Movie> body;

    public SearchResult(List<Movie> body) {
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
