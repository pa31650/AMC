package com.amc.api.v1.theatres.concessions;

import java.util.HashMap;
import java.util.Map;

public class Media {

private String imageSmall;
private String imageLarge;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getImageSmall() {
return imageSmall;
}

public void setImageSmall(String imageSmall) {
this.imageSmall = imageSmall;
}

public String getImageLarge() {
return imageLarge;
}

public void setImageLarge(String imageLarge) {
this.imageLarge = imageLarge;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

