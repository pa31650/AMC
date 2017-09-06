package com.amc.api.theatres.objects;

import java.util.HashMap;
import java.util.Map;

public class Location {

private String addressLine1;
private String city;
private String cityUrlSuffixText;
private String postalCode;
private String state;
private String stateName;
private String stateUrlSuffixText;
private String country;
private Double latitude;
private Double longitude;
private String directionsUrl;
private String marketName;
private String marketUrlSuffixText;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getAddressLine1() {
return addressLine1;
}

public void setAddressLine1(String addressLine1) {
this.addressLine1 = addressLine1;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public String getCityUrlSuffixText() {
return cityUrlSuffixText;
}

public void setCityUrlSuffixText(String cityUrlSuffixText) {
this.cityUrlSuffixText = cityUrlSuffixText;
}

public String getPostalCode() {
return postalCode;
}

public void setPostalCode(String postalCode) {
this.postalCode = postalCode;
}

public String getState() {
return state;
}

public void setState(String state) {
this.state = state;
}

public String getStateName() {
return stateName;
}

public void setStateName(String stateName) {
this.stateName = stateName;
}

public String getStateUrlSuffixText() {
return stateUrlSuffixText;
}

public void setStateUrlSuffixText(String stateUrlSuffixText) {
this.stateUrlSuffixText = stateUrlSuffixText;
}

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

public Double getLatitude() {
return latitude;
}

public void setLatitude(Double latitude) {
this.latitude = latitude;
}

public Double getLongitude() {
return longitude;
}

public void setLongitude(Double longitude) {
this.longitude = longitude;
}

public String getDirectionsUrl() {
return directionsUrl;
}

public void setDirectionsUrl(String directionsUrl) {
this.directionsUrl = directionsUrl;
}

public String getMarketName() {
return marketName;
}

public void setMarketName(String marketName) {
this.marketName = marketName;
}

public String getMarketUrlSuffixText() {
return marketUrlSuffixText;
}

public void setMarketUrlSuffixText(String marketUrlSuffixText) {
this.marketUrlSuffixText = marketUrlSuffixText;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

