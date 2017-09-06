package com.amc.api.common.attributes;

import java.util.HashMap;
import java.util.Map;

public class Embedded_ {

private Group group;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Group getGroup() {
return group;
}

public void setGroup(Group group) {
this.group = group;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}


