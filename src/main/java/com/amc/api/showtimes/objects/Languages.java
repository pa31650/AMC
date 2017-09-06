package com.amc.api.showtimes.objects;

import java.util.HashMap;
import java.util.Map;

public class Languages {

private String spoken;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getSpoken() {
return spoken;
}

public void setSpoken(String spoken) {
this.spoken = spoken;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

