package com.amc.api.v2.theatres.objects;

import java.util.HashMap;
import java.util.Map;

public class Next {

private String href;
private Boolean templated;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getHref() {
return href;
}

public void setHref(String href) {
this.href = href;
}

public Boolean getTemplated() {
return templated;
}

public void setTemplated(Boolean templated) {
this.templated = templated;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

