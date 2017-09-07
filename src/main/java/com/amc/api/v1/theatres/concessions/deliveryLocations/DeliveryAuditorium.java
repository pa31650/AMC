

package com.amc.api.v1.theatres.concessions.deliveryLocations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryAuditorium {

private Integer auditorium;
private List<DeliveryShowtime> deliveryShowtimes = null;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Integer getAuditorium() {
return auditorium;
}

public void setAuditorium(Integer auditorium) {
this.auditorium = auditorium;
}

public List<DeliveryShowtime> getDeliveryShowtimes() {
return deliveryShowtimes;
}

public void setDeliveryShowtimes(List<DeliveryShowtime> deliveryShowtimes) {
this.deliveryShowtimes = deliveryShowtimes;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}


