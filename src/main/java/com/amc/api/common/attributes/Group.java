package com.amc.api.common.attributes;

import java.util.HashMap;
import java.util.Map;

public class Group {

private Integer id;
private String name;
private String description;
private Integer sort;
private Links links;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public Integer getSort() {
return sort;
}

public void setSort(Integer sort) {
this.sort = sort;
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

