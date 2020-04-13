package model;

import java.util.List;

public class SearchResult {
    private List<SearchItem> body;
    private boolean isSuccessful;

    public SearchResult(List<SearchItem> body, boolean isSuccessful) {
        this.body = body;
        this.isSuccessful = isSuccessful;
    }

    public SearchResult() {
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "body=" + body +
                ", isSuccessful=" + isSuccessful +
                '}';
    }

    public List<SearchItem> getBody() {
        return body;
    }

    public void setBody(List<SearchItem> body) {
        this.body = body;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }
}
