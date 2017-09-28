package com.amc.api.v2.theatres.showtimes.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.amc.api.v2.common.objects.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShowtimeResponse {

private Integer pageSize;
private Integer pageNumber;
private Integer count;
private String lastUpdatedDateUtc;
@JsonProperty("_links")
private Links links;
@JsonProperty("_embedded")
private Embedded embedded;

public Integer getPageSize() {
return pageSize;
}

public void setPageSize(Integer pageSize) {
this.pageSize = pageSize;
}

public Integer getPageNumber() {
return pageNumber;
}

public void setPageNumber(Integer pageNumber) {
this.pageNumber = pageNumber;
}

public Integer getCount() {
return count;
}

public void setCount(Integer count) {
this.count = count;
}

public String getLastUpdatedDateUtc() {
return lastUpdatedDateUtc;
}

public void setLastUpdatedDateUtc(String lastUpdatedDateUtc) {
this.lastUpdatedDateUtc = lastUpdatedDateUtc;
}

public Links getLinks() {
return links;
}

public void setLinks(Links links) {
this.links = links;
}

public Embedded getEmbedded() {
return embedded;
}

public void setEmbedded(Embedded embedded) {
this.embedded = embedded;
}

}

