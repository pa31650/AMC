package com.amc.api.v1.theatres.concessions.deliveryLocations;

import java.util.HashMap;
import java.util.Map;

public class DeliveryShowtime {

private Integer id;
private Integer performanceNumber;
private Integer movieId;
private String movieName;
private String showDateTimeUtc;
private String showDateTimeLocal;
private Links links;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public Integer getPerformanceNumber() {
return performanceNumber;
}

public void setPerformanceNumber(Integer performanceNumber) {
this.performanceNumber = performanceNumber;
}

public Integer getMovieId() {
return movieId;
}

public void setMovieId(Integer movieId) {
this.movieId = movieId;
}

public String getMovieName() {
return movieName;
}

public void setMovieName(String movieName) {
this.movieName = movieName;
}

public String getShowDateTimeUtc() {
return showDateTimeUtc;
}

public void setShowDateTimeUtc(String showDateTimeUtc) {
this.showDateTimeUtc = showDateTimeUtc;
}

public String getShowDateTimeLocal() {
return showDateTimeLocal;
}

public void setShowDateTimeLocal(String showDateTimeLocal) {
this.showDateTimeLocal = showDateTimeLocal;
}

public Links getLinks() {
return links;
}

public void setLinks(Links links) {
this.links = links;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}


