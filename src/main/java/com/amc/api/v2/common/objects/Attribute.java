package com.amc.api.v2.common.objects;

import java.util.HashMap;
import java.util.Map;

public class Attribute {

private String code;
private String name;
private String description;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getCode() {
return code;
}

public void setCode(String code) {
this.code = code;
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

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

