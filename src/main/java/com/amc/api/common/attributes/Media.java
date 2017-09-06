package com.amc.api.common.attributes;

import java.util.HashMap;
import java.util.Map;

public class Media {

private String logoDynamic;
private String heroDesktopDynamic;
private String heroMobileDynamic;
private String iconDynamic;
private String backgroundDesktopDynamicUrl;
private String backgroundMobileDynamicUrl;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getLogoDynamic() {
return logoDynamic;
}

public void setLogoDynamic(String logoDynamic) {
this.logoDynamic = logoDynamic;
}

public String getHeroDesktopDynamic() {
return heroDesktopDynamic;
}

public void setHeroDesktopDynamic(String heroDesktopDynamic) {
this.heroDesktopDynamic = heroDesktopDynamic;
}

public String getHeroMobileDynamic() {
return heroMobileDynamic;
}

public void setHeroMobileDynamic(String heroMobileDynamic) {
this.heroMobileDynamic = heroMobileDynamic;
}

public String getIconDynamic() {
return iconDynamic;
}

public void setIconDynamic(String iconDynamic) {
this.iconDynamic = iconDynamic;
}

public String getBackgroundDesktopDynamicUrl() {
return backgroundDesktopDynamicUrl;
}

public void setBackgroundDesktopDynamicUrl(String backgroundDesktopDynamicUrl) {
this.backgroundDesktopDynamicUrl = backgroundDesktopDynamicUrl;
}

public String getBackgroundMobileDynamicUrl() {
return backgroundMobileDynamicUrl;
}

public void setBackgroundMobileDynamicUrl(String backgroundMobileDynamicUrl) {
this.backgroundMobileDynamicUrl = backgroundMobileDynamicUrl;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

