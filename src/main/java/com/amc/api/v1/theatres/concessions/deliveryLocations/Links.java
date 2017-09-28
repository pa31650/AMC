package com.amc.api.v1.theatres.concessions.deliveryLocations;

import java.util.HashMap;
import java.util.Map;

public class Links {

private DeliveryTimes deliveryTimes;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public DeliveryTimes getDeliveryTimes() {
return deliveryTimes;
}

public void setDeliveryTimes(DeliveryTimes deliveryTimes) {
this.deliveryTimes = deliveryTimes;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}


