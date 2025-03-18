
package com.example.demo.model.commit;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Verification {

    @JsonProperty("verified")
    private Boolean verified;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("signature")
    private Object signature;
    @JsonProperty("payload")
    private Object payload;
    @JsonProperty("verified_at")
    private Object verifiedAt;

    @JsonProperty("verified")
    public Boolean getVerified() {
        return verified;
    }

    @JsonProperty("verified")
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonProperty("signature")
    public Object getSignature() {
        return signature;
    }

    @JsonProperty("signature")
    public void setSignature(Object signature) {
        this.signature = signature;
    }

    @JsonProperty("payload")
    public Object getPayload() {
        return payload;
    }

    @JsonProperty("payload")
    public void setPayload(Object payload) {
        this.payload = payload;
    }

    @JsonProperty("verified_at")
    public Object getVerifiedAt() {
        return verifiedAt;
    }

    @JsonProperty("verified_at")
    public void setVerifiedAt(Object verifiedAt) {
        this.verifiedAt = verifiedAt;
    }

}
