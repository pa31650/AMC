package com.amc.api.v1.theatres.concessions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Embedded {

private List<Concession> concessions = null;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public List<Concession> getConcessions() {
return concessions;
}

public void setConcessions(List<Concession> concessions) {
this.concessions = concessions;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}


