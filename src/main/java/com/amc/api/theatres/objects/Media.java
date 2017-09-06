package com.amc.api.theatres.objects;

import java.util.HashMap;
import java.util.Map;

public class Media {

private String theatreImageIcon;
private String theatreImageLarge;
private String theatreImageStandard;
private String theatreImageThumbnail;
private String heroDesktopDynamic;
private String heroMobileDynamic;
private String interiorDynamic;
private String exteriorDynamic;
private String promotionDynamic;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getTheatreImageIcon() {
return theatreImageIcon;
}

public void setTheatreImageIcon(String theatreImageIcon) {
this.theatreImageIcon = theatreImageIcon;
}

public String getTheatreImageLarge() {
return theatreImageLarge;
}

public void setTheatreImageLarge(String theatreImageLarge) {
this.theatreImageLarge = theatreImageLarge;
}

public String getTheatreImageStandard() {
return theatreImageStandard;
}

public void setTheatreImageStandard(String theatreImageStandard) {
this.theatreImageStandard = theatreImageStandard;
}

public String getTheatreImageThumbnail() {
return theatreImageThumbnail;
}

public void setTheatreImageThumbnail(String theatreImageThumbnail) {
this.theatreImageThumbnail = theatreImageThumbnail;
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

public String getInteriorDynamic() {
return interiorDynamic;
}

public void setInteriorDynamic(String interiorDynamic) {
this.interiorDynamic = interiorDynamic;
}

public String getExteriorDynamic() {
return exteriorDynamic;
}

public void setExteriorDynamic(String exteriorDynamic) {
this.exteriorDynamic = exteriorDynamic;
}

public String getPromotionDynamic() {
return promotionDynamic;
}

public void setPromotionDynamic(String promotionDynamic) {
this.promotionDynamic = promotionDynamic;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

