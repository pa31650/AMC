package com.amc.api.showtimes.objects;

import java.util.HashMap;
import java.util.Map;

public class TicketPrice {

private Double price;
private String type;
private String sku;
private Double tax;
private String agePolicy;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Double getPrice() {
return price;
}

public void setPrice(Double price) {
this.price = price;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getSku() {
return sku;
}

public void setSku(String sku) {
this.sku = sku;
}

public Double getTax() {
return tax;
}

public void setTax(Double tax) {
this.tax = tax;
}

public String getAgePolicy() {
return agePolicy;
}

public void setAgePolicy(String agePolicy) {
this.agePolicy = agePolicy;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}