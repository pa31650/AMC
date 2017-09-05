package com.amc.api.showtimes;


public class TicketPrice {

private Double price;
private String type;
private String sku;
private Double tax;
private String agePolicy;

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

}