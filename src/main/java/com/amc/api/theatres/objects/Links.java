package com.amc.api.theatres.objects;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {

	
	private Self self;
	private Next next;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Self getSelf() {
return self;
}

public void setSelf(Self self) {
this.self = self;
}

public Next getNext() {
return next;
}

public void setNext(Next next) {
this.next = next;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

