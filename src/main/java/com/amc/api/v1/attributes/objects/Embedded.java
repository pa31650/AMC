package com.amc.api.v1.attributes.objects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Embedded {

private List<Attribute> attributes = null;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public List<Attribute> getAttributes() {
return attributes;
}

public void setAttributes(List<Attribute> attributes) {
this.attributes = attributes;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}


