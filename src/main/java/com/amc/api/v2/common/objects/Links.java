package com.amc.api.v2.common.objects;

import java.util.HashMap;
import java.util.Map;

import com.amc.api.v2.theatres.showtimes.objects.Next;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Links {

private Self self;
private HttpsApiAmctheatresComRelsV2Movie httpsApiAmctheatresComRelsV2Movie;
private HttpsApiAmctheatresComRelsV2Theatre httpsApiAmctheatresComRelsV2Theatre;
private HttpsApiAmctheatresComRelsV1SeatingLayout httpsApiAmctheatresComRelsV1SeatingLayout;
private HttpsApiAmctheatresComRelsV2SeatingLayout httpsApiAmctheatresComRelsV2SeatingLayout;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private Next next;

public Self getSelf() {
return self;
}

public void setSelf(Self self) {
this.self = self;
}

public HttpsApiAmctheatresComRelsV2Movie getHttpsApiAmctheatresComRelsV2Movie() {
return httpsApiAmctheatresComRelsV2Movie;
}

public void setHttpsApiAmctheatresComRelsV2Movie(HttpsApiAmctheatresComRelsV2Movie httpsApiAmctheatresComRelsV2Movie) {
this.httpsApiAmctheatresComRelsV2Movie = httpsApiAmctheatresComRelsV2Movie;
}

public HttpsApiAmctheatresComRelsV2Theatre getHttpsApiAmctheatresComRelsV2Theatre() {
return httpsApiAmctheatresComRelsV2Theatre;
}

public void setHttpsApiAmctheatresComRelsV2Theatre(HttpsApiAmctheatresComRelsV2Theatre httpsApiAmctheatresComRelsV2Theatre) {
this.httpsApiAmctheatresComRelsV2Theatre = httpsApiAmctheatresComRelsV2Theatre;
}

public HttpsApiAmctheatresComRelsV1SeatingLayout getHttpsApiAmctheatresComRelsV1SeatingLayout() {
return httpsApiAmctheatresComRelsV1SeatingLayout;
}

public void setHttpsApiAmctheatresComRelsV1SeatingLayout(HttpsApiAmctheatresComRelsV1SeatingLayout httpsApiAmctheatresComRelsV1SeatingLayout) {
this.httpsApiAmctheatresComRelsV1SeatingLayout = httpsApiAmctheatresComRelsV1SeatingLayout;
}

public HttpsApiAmctheatresComRelsV2SeatingLayout getHttpsApiAmctheatresComRelsV2SeatingLayout() {
return httpsApiAmctheatresComRelsV2SeatingLayout;
}

public void setHttpsApiAmctheatresComRelsV2SeatingLayout(HttpsApiAmctheatresComRelsV2SeatingLayout httpsApiAmctheatresComRelsV2SeatingLayout) {
this.httpsApiAmctheatresComRelsV2SeatingLayout = httpsApiAmctheatresComRelsV2SeatingLayout;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

public Next getNext() {
    return next;
}

public void setNext(Next next) {
    this.next = next;
}

}

