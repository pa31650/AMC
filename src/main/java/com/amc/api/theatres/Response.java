package com.amc.api.theatres;


public class Response {

private Integer pageSize;
private Integer pageNumber;
private Integer count;
private Links links;
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

