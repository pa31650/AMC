package com.amc.api.v1.concessions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcessionsResponse {

private String name;
private String displayName;
private String nutritionalInfo;
private String size;
private Double price;
private Double tax;
private String sku;
private Integer prepTime;
private Integer theatreId;
private Integer concessionId;
private Media media;
private List<Discount> discounts = null;
private Embedded embedded;
private Links_ links;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getDisplayName() {
return displayName;
}

public void setDisplayName(String displayName) {
this.displayName = displayName;
}

public String getNutritionalInfo() {
return nutritionalInfo;
}

public void setNutritionalInfo(String nutritionalInfo) {
this.nutritionalInfo = nutritionalInfo;
}

public String getSize() {
return size;
}

public void setSize(String size) {
this.size = size;
}

public Double getPrice() {
return price;
}

public void setPrice(Double price) {
this.price = price;
}

public Double getTax() {
return tax;
}

public void setTax(Double tax) {
this.tax = tax;
}

public String getSku() {
return sku;
}

public void setSku(String sku) {
this.sku = sku;
}

public Integer getPrepTime() {
return prepTime;
}

public void setPrepTime(Integer prepTime) {
this.prepTime = prepTime;
}

public Integer getTheatreId() {
return theatreId;
}

public void setTheatreId(Integer theatreId) {
this.theatreId = theatreId;
}

public Integer getConcessionId() {
return concessionId;
}

public void setConcessionId(Integer concessionId) {
this.concessionId = concessionId;
}

public Media getMedia() {
return media;
}

public void setMedia(Media media) {
this.media = media;
}

public List<Discount> getDiscounts() {
return discounts;
}

public void setDiscounts(List<Discount> discounts) {
this.discounts = discounts;
}

public Embedded getEmbedded() {
return embedded;
}

public void setEmbedded(Embedded embedded) {
this.embedded = embedded;
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


