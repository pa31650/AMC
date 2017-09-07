package com.amc.api.v1.concessions;

import java.util.HashMap;
import java.util.Map;

public class Links_ {

private Self_ self;
private HttpsApiAmctheatresComRelsV2Media httpsApiAmctheatresComRelsV2Media;
private HttpsApiAmctheatresComRelsV2Theatre httpsApiAmctheatresComRelsV2Theatre;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Self_ getSelf() {
return self;
}

public void setSelf(Self_ self) {
this.self = self;
}

public HttpsApiAmctheatresComRelsV2Media getHttpsApiAmctheatresComRelsV2Media() {
return httpsApiAmctheatresComRelsV2Media;
}

public void setHttpsApiAmctheatresComRelsV2Media(HttpsApiAmctheatresComRelsV2Media httpsApiAmctheatresComRelsV2Media) {
this.httpsApiAmctheatresComRelsV2Media = httpsApiAmctheatresComRelsV2Media;
}

public HttpsApiAmctheatresComRelsV2Theatre getHttpsApiAmctheatresComRelsV2Theatre() {
return httpsApiAmctheatresComRelsV2Theatre;
}

public void setHttpsApiAmctheatresComRelsV2Theatre(HttpsApiAmctheatresComRelsV2Theatre httpsApiAmctheatresComRelsV2Theatre) {
this.httpsApiAmctheatresComRelsV2Theatre = httpsApiAmctheatresComRelsV2Theatre;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}


