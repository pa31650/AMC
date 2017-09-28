package com.amc.api.v1.attributes.objects;

import java.util.HashMap;
import java.util.Map;

public class Attribute {

private String code;
private String name;
private Object abbreviation;
private String shortDescription;
private String longDescription;
private String url;
private Integer sort;
private Boolean appliesToMovie;
private Boolean appliesToShowtime;
private Boolean appliesToTheatre;
private Media media;
private Embedded_ embedded;
private Links_ links;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getCode() {
return code;
}

public void setCode(String code) {
this.code = code;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Object getAbbreviation() {
return abbreviation;
}

public void setAbbreviation(Object abbreviation) {
this.abbreviation = abbreviation;
}

public String getShortDescription() {
return shortDescription;
}

public void setShortDescription(String shortDescription) {
this.shortDescription = shortDescription;
}

public String getLongDescription() {
return longDescription;
}

public void setLongDescription(String longDescription) {
this.longDescription = longDescription;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public Integer getSort() {
return sort;
}

public void setSort(Integer sort) {
this.sort = sort;
}

public Boolean getAppliesToMovie() {
return appliesToMovie;
}

public void setAppliesToMovie(Boolean appliesToMovie) {
this.appliesToMovie = appliesToMovie;
}

public Boolean getAppliesToShowtime() {
return appliesToShowtime;
}

public void setAppliesToShowtime(Boolean appliesToShowtime) {
this.appliesToShowtime = appliesToShowtime;
}

public Boolean getAppliesToTheatre() {
return appliesToTheatre;
}

public void setAppliesToTheatre(Boolean appliesToTheatre) {
this.appliesToTheatre = appliesToTheatre;
}

public Media getMedia() {
return media;
}

public void setMedia(Media media) {
this.media = media;
}

public Embedded_ getEmbedded() {
return embedded;
}

public void setEmbedded(Embedded_ embedded) {
this.embedded = embedded;
}

public Links_ getLinks() {
return links;
}

public void setLinks(Links_ links) {
this.links = links;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

