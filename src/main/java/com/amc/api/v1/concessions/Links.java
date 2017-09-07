package com.amc.api.v1.concessions;

import java.util.HashMap;
import java.util.Map;

public class Links {

private Self self;
private HttpsApiAmctheatresComRelsV1Concessions httpsApiAmctheatresComRelsV1Concessions;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Self getSelf() {
return self;
}

public void setSelf(Self self) {
this.self = self;
}

public HttpsApiAmctheatresComRelsV1Concessions getHttpsApiAmctheatresComRelsV1Concessions() {
return httpsApiAmctheatresComRelsV1Concessions;
}

public void setHttpsApiAmctheatresComRelsV1Concessions(HttpsApiAmctheatresComRelsV1Concessions httpsApiAmctheatresComRelsV1Concessions) {
this.httpsApiAmctheatresComRelsV1Concessions = httpsApiAmctheatresComRelsV1Concessions;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}


