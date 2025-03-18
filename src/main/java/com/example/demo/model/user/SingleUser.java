package com.example.demo.model.user;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "support"
})
@Generated("jsonschema2pojo")
public class SingleUser {

    @JsonProperty("data")
    private User data;
    @JsonProperty("support")
    private Support support;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("data")
    public User getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(User data) {
        this.data = data;
    }

    @JsonProperty("support")
    public Support getSupport() {
        return support;
    }

    @JsonProperty("support")
    public void setSupport(Support support) {
        this.support = support;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
