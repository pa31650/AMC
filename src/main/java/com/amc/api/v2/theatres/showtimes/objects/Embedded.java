package com.amc.api.v2.theatres.showtimes.objects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Embedded {

private List<Showtime> showtimes = null;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public List<Showtime> getShowtimes() {
return showtimes;
}

public void setShowtimes(List<Showtime> showtimes) {
this.showtimes = showtimes;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}