package com.amc.api.theatres;

import com.amc.api.AMC;
import com.amc.api.theatres.objects.Theatre;
import com.amc.api.theatres.objects.TheatreResponse;
import com.amc.api.theatres.showtimes.Showtimes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.orasi.api.restServices.Headers.HeaderType;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Theatres {

	
    public Showtimes showtimes() {
        return new Showtimes();
    }

    public RestResponse getTheatres() {
        RestService rest = new RestService();
        return rest.sendGetRequest(AMC.URL + "/theatres", HeaderType.AMC);
    }
    
    public Integer getTheatreID(String theatreName){
		RestResponse rest = AMC.theatres().getTheatres();
		Integer theatreID = null;
		
		TheatreResponse theatres = rest.mapJSONToObject(TheatreResponse.class);
        
        for (Theatre theatre : theatres.getEmbedded().getTheatres()) {
        	if (theatre.getLongName() == theatreName) {
				theatreID = theatre.getId();
        		break;
			}
        }
		return theatreID;
    	
    }
}