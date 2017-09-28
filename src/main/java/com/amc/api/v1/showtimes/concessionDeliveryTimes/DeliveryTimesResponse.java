package com.amc.api.v1.showtimes.concessionDeliveryTimes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryTimesResponse {

private Integer showtimeId;
private List<DeliveryTime> deliveryTimes = null;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Integer getShowtimeId() {
return showtimeId;
}

public void setShowtimeId(Integer showtimeId) {
this.showtimeId = showtimeId;
}

public List<DeliveryTime> getDeliveryTimes() {
return deliveryTimes;
}

public void setDeliveryTimes(List<DeliveryTime> deliveryTimes) {
this.deliveryTimes = deliveryTimes;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}