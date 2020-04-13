package jacksonModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import jacksonModel.SearchItem;

import java.util.List;

public class SearchMessage {
    @JsonProperty("isSuccessful")
    private boolean isSuccessful;
    @JsonProperty("body")
    private List<SearchItem> body;

    public SearchMessage(boolean isSuccessful, List<SearchItem> body) {
        this.isSuccessful = isSuccessful;
        this.body = body;
    }

    public SearchMessage() {
    }

    @Override
    public String toString() {
        return "SearchMessage{" +
                "isSuccessful=" + isSuccessful +
                ", body=" + body +
                '}';
    }

    @JsonProperty("isSuccessful")
    public boolean isSuccessful() {
        return isSuccessful;
    }

    @JsonProperty("isSuccessful")
    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    @JsonProperty("body")
    public List<SearchItem> getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(List<SearchItem> body) {
        this.body = body;
    }
}
