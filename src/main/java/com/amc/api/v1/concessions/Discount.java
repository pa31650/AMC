package com.amc.api.v1.concessions;

import java.util.HashMap;
import java.util.Map;

public class Discount {

private Integer id;
private String type;
private String method;
private Integer referenceProductId;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getMethod() {
return method;
}

public void setMethod(String method) {
this.method = method;
}

public Integer getReferenceProductId() {
return referenceProductId;
}

public void setReferenceProductId(Integer referenceProductId) {
this.referenceProductId = referenceProductId;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}


