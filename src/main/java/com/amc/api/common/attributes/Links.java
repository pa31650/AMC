package com.amc.api.common.attributes;

import java.util.HashMap;
import java.util.Map;

public class Links {

private Self self;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Self getSelf() {
return self;
}

public void setSelf(Self self) {
this.self = self;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

