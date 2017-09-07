package com.amc.api.v2.theatres.objects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Embedded {

private List<Theatre> theatres = null;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public List<Theatre> getTheatres() {
return theatres;
}

public void setTheatres(List<Theatre> theatres) {
this.theatres = theatres;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

