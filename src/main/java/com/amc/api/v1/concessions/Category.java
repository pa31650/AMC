package com.amc.api.v1.concessions;

import java.util.HashMap;
import java.util.Map;

public class Category {

private String name;
private Integer level;
private Integer sortOrder;
private Integer productSortOrder;
private Media_ media;
private Links links;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Integer getLevel() {
return level;
}

public void setLevel(Integer level) {
this.level = level;
}

public Integer getSortOrder() {
return sortOrder;
}

public void setSortOrder(Integer sortOrder) {
this.sortOrder = sortOrder;
}

public Integer getProductSortOrder() {
return productSortOrder;
}

public void setProductSortOrder(Integer productSortOrder) {
this.productSortOrder = productSortOrder;
}

public Media_ getMedia() {
return media;
}

public void setMedia(Media_ media) {
this.media = media;
}

public Links getLinks() {
return links;
}

public void setLinks(Links links) {
this.links = links;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}


