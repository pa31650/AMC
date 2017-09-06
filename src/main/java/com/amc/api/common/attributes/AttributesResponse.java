package com.amc.api.common.attributes;

import java.util.HashMap;
import java.util.Map;

public class AttributesResponse {

private Embedded embedded;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

