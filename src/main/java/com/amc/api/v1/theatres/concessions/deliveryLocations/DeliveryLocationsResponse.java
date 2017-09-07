package com.amc.api.v1.theatres.concessions.deliveryLocations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryLocationsResponse {

private Integer theatreId;
private List<DeliveryAuditorium> deliveryAuditorium = null;
private Links_ links;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Integer getTheatreId() {
return theatreId;
}

public void setTheatreId(Integer theatreId) {
this.theatreId = theatreId;
}

public List<DeliveryAuditorium> getDeliveryAuditorium() {
return deliveryAuditorium;
}

public void setDeliveryAuditorium(List<DeliveryAuditorium> deliveryAuditorium) {
this.deliveryAuditorium = deliveryAuditorium;
}

public Links_ getLinks() {
return links;
}

public void setLinks(Links_ links) {
this.links = links;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}


