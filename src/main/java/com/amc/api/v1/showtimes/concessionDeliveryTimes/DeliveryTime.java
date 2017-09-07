package com.amc.api.v1.showtimes.concessionDeliveryTimes;

import java.util.HashMap;
import java.util.Map;

public class DeliveryTime {

private String deliveryDateTimeUtc;
private String deliveryDateTimeLocal;
private Integer available;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getDeliveryDateTimeUtc() {
return deliveryDateTimeUtc;
}

public void setDeliveryDateTimeUtc(String deliveryDateTimeUtc) {
this.deliveryDateTimeUtc = deliveryDateTimeUtc;
}

public String getDeliveryDateTimeLocal() {
return deliveryDateTimeLocal;
}

public void setDeliveryDateTimeLocal(String deliveryDateTimeLocal) {
this.deliveryDateTimeLocal = deliveryDateTimeLocal;
}

public Integer getAvailable() {
return available;
}

public void setAvailable(Integer available) {
this.available = available;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}


