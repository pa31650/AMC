package com.amc.api.v2.common.objects;

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
private String posterThumbnail;
private String posterStandard;
private String posterLarge;
private String posterDynamic;
private String posterAlternateDynamic;
private String poster3DDynamic;
private String posterIMAXDynamic;
private String trailerTeaserDynamic;
private String trailerAlternateDynamic;

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

public String getPosterThumbnail() {
    return posterThumbnail;
}

public void setPosterThumbnail(String posterThumbnail) {
    this.posterThumbnail = posterThumbnail;
}

public String getPosterStandard() {
    return posterStandard;
}

public void setPosterStandard(String posterStandard) {
    this.posterStandard = posterStandard;
}

public String getPosterLarge() {
    return posterLarge;
}

public void setPosterLarge(String posterLarge) {
    this.posterLarge = posterLarge;
}

public String getPosterDynamic() {
    return posterDynamic;
}

public void setPosterDynamic(String posterDynamic) {
    this.posterDynamic = posterDynamic;
}

public String getPosterAlternateDynamic() {
    return posterAlternateDynamic;
}

public void setPosterAlternateDynamic(String posterAlternateDynamic) {
    this.posterAlternateDynamic = posterAlternateDynamic;
}

public String getPoster3DDynamic() {
    return poster3DDynamic;
}

public void setPoster3DDynamic(String poster3dDynamic) {
    poster3DDynamic = poster3dDynamic;
}

public String getPosterIMAXDynamic() {
    return posterIMAXDynamic;
}

public void setPosterIMAXDynamic(String posterIMAXDynamic) {
    this.posterIMAXDynamic = posterIMAXDynamic;
}

public String getTrailerTeaserDynamic() {
    return trailerTeaserDynamic;
}

public void setTrailerTeaserDynamic(String trailerTeaserDynamic) {
    this.trailerTeaserDynamic = trailerTeaserDynamic;
}

public String getTrailerAlternateDynamic() {
    return trailerAlternateDynamic;
}

public void setTrailerAlternateDynamic(String trailerAlternateDynamic) {
    this.trailerAlternateDynamic = trailerAlternateDynamic;
}

}

