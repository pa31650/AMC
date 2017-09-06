package com.amc.api.showtimes.objects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowtimesResponse {

private Integer id;
private Integer internalReleaseNumber;
private Integer performanceNumber;
private Integer movieId;
private String movieName;
private String sortableMovieName;
private String genre;
private String showDateTimeUtc;
private String showDateTimeLocal;
private String sellUntilDateTimeUtc;
private Boolean isSoldOut;
private Boolean isAlmostSoldOut;
private Boolean isCanceled;
private String utcOffset;
private Integer theatreId;
private Integer auditorium;
private Integer runTime;
private String mpaaRating;
private String premiumFormat;
private String purchaseUrl;
private String mobilePurchaseUrl;
private String movieUrl;
private Integer wwmReleaseNumber;
private String lastUpdatedDateUtc;
private List<Attribute> attributes = null;
private List<TicketPrice> ticketPrices = null;
private Media media;
private Languages languages;
private Links links;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public Integer getInternalReleaseNumber() {
return internalReleaseNumber;
}

public void setInternalReleaseNumber(Integer internalReleaseNumber) {
this.internalReleaseNumber = internalReleaseNumber;
}

public Integer getPerformanceNumber() {
return performanceNumber;
}

public void setPerformanceNumber(Integer performanceNumber) {
this.performanceNumber = performanceNumber;
}

public Integer getMovieId() {
return movieId;
}

public void setMovieId(Integer movieId) {
this.movieId = movieId;
}

public String getMovieName() {
return movieName;
}

public void setMovieName(String movieName) {
this.movieName = movieName;
}

public String getSortableMovieName() {
return sortableMovieName;
}

public void setSortableMovieName(String sortableMovieName) {
this.sortableMovieName = sortableMovieName;
}

public String getGenre() {
return genre;
}

public void setGenre(String genre) {
this.genre = genre;
}

public String getShowDateTimeUtc() {
return showDateTimeUtc;
}

public void setShowDateTimeUtc(String showDateTimeUtc) {
this.showDateTimeUtc = showDateTimeUtc;
}

public String getShowDateTimeLocal() {
return showDateTimeLocal;
}

public void setShowDateTimeLocal(String showDateTimeLocal) {
this.showDateTimeLocal = showDateTimeLocal;
}

public String getSellUntilDateTimeUtc() {
return sellUntilDateTimeUtc;
}

public void setSellUntilDateTimeUtc(String sellUntilDateTimeUtc) {
this.sellUntilDateTimeUtc = sellUntilDateTimeUtc;
}

public Boolean getIsSoldOut() {
return isSoldOut;
}

public void setIsSoldOut(Boolean isSoldOut) {
this.isSoldOut = isSoldOut;
}

public Boolean getIsAlmostSoldOut() {
return isAlmostSoldOut;
}

public void setIsAlmostSoldOut(Boolean isAlmostSoldOut) {
this.isAlmostSoldOut = isAlmostSoldOut;
}

public Boolean getIsCanceled() {
return isCanceled;
}

public void setIsCanceled(Boolean isCanceled) {
this.isCanceled = isCanceled;
}

public String getUtcOffset() {
return utcOffset;
}

public void setUtcOffset(String utcOffset) {
this.utcOffset = utcOffset;
}

public Integer getTheatreId() {
return theatreId;
}

public void setTheatreId(Integer theatreId) {
this.theatreId = theatreId;
}

public Integer getAuditorium() {
return auditorium;
}

public void setAuditorium(Integer auditorium) {
this.auditorium = auditorium;
}

public Integer getRunTime() {
return runTime;
}

public void setRunTime(Integer runTime) {
this.runTime = runTime;
}

public String getMpaaRating() {
return mpaaRating;
}

public void setMpaaRating(String mpaaRating) {
this.mpaaRating = mpaaRating;
}

public String getPremiumFormat() {
return premiumFormat;
}

public void setPremiumFormat(String premiumFormat) {
this.premiumFormat = premiumFormat;
}

public String getPurchaseUrl() {
return purchaseUrl;
}

public void setPurchaseUrl(String purchaseUrl) {
this.purchaseUrl = purchaseUrl;
}

public String getMobilePurchaseUrl() {
return mobilePurchaseUrl;
}

public void setMobilePurchaseUrl(String mobilePurchaseUrl) {
this.mobilePurchaseUrl = mobilePurchaseUrl;
}

public String getMovieUrl() {
return movieUrl;
}

public void setMovieUrl(String movieUrl) {
this.movieUrl = movieUrl;
}

public Integer getWwmReleaseNumber() {
return wwmReleaseNumber;
}

public void setWwmReleaseNumber(Integer wwmReleaseNumber) {
this.wwmReleaseNumber = wwmReleaseNumber;
}

public String getLastUpdatedDateUtc() {
return lastUpdatedDateUtc;
}

public void setLastUpdatedDateUtc(String lastUpdatedDateUtc) {
this.lastUpdatedDateUtc = lastUpdatedDateUtc;
}

public List<Attribute> getAttributes() {
return attributes;
}

public void setAttributes(List<Attribute> attributes) {
this.attributes = attributes;
}

public List<TicketPrice> getTicketPrices() {
return ticketPrices;
}

public void setTicketPrices(List<TicketPrice> ticketPrices) {
this.ticketPrices = ticketPrices;
}

public Media getMedia() {
return media;
}

public void setMedia(Media media) {
this.media = media;
}

public Languages getLanguages() {
return languages;
}

public void setLanguages(Languages languages) {
this.languages = languages;
}

public Links getLinks() {
return links;
}

public void setLinks(Links links) {
this.links = links;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

