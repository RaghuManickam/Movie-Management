package RestDTO;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "isSuccessful",
        "body"
})
public class SearchMessage {

    @JsonProperty("isSuccessful")
    private Boolean isSuccessful;
    @JsonProperty("body")
    private List<SearchItem> searchItem = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(Boolean successful) {
        isSuccessful = successful;
    }

    @JsonProperty("isSuccessful")
    public Boolean getIsSuccessful() {
        return isSuccessful;
    }

    @JsonProperty("isSuccessful")
    public void setIsSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    @JsonProperty("body")
    public List<SearchItem> getSearchItem() {
        return searchItem;
    }

    @JsonProperty("body")
    public void setSearchItem(List<SearchItem> searchItem) {
        this.searchItem = searchItem;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
