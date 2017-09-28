package com.amc.api.v1.theatres.concessions;

import java.util.HashMap;
import java.util.Map;

public class ConcessionsResponse {

private Integer pageSize;
private Integer pageNumber;
private Integer count;
private Embedded embedded;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Integer getPageSize() {
return pageSize;
}

public void setPageSize(Integer pageSize) {
this.pageSize = pageSize;
}

public Integer getPageNumber() {
return pageNumber;
}

public void setPageNumber(Integer pageNumber) {
this.pageNumber = pageNumber;
}

public Integer getCount() {
return count;
}

public void setCount(Integer count) {
this.count = count;
}

public Embedded getEmbedded() {
return embedded;
}

public void setEmbedded(Embedded embedded) {
this.embedded = embedded;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}


