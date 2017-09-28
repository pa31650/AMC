package com.amc.api.v2.theatres;

import com.amc.api.AMC;
import com.amc.api.v2.theatres.objects.Theatre;
import com.amc.api.v2.theatres.objects.TheatreResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.orasi.api.restServices.Headers.HeaderType;
import com.orasi.api.restServices.ParameterBuilder.Parameters;
import com.orasi.api.restServices.ParameterBuilder;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Theatres extends AMC{
    private String URL = AMC.URLv2 + "theatres/";
    
    public RestResponse getTheatres() {
        Parameters params = new ParameterBuilder.Parameters();
        
        params.add("page-size", "100");
        RestService rest = new RestService();
        return rest.sendGetRequest(URL, HeaderType.AMC, params.build());
    }
    
    public Integer getTheatreID(String theatreName){
		RestResponse rest = AMC.theatres().getTheatres();
		Integer theatreID = null;
		
		TheatreResponse theatres = rest.mapJSONToObject(TheatreResponse.class);
        
        for (Theatre theatre : theatres.getEmbedded().getTheatres()) {
            if (theatre.getLongName().equals(theatreName)) {
				theatreID = theatre.getId();
        		break;
			}
        }
		return theatreID;
    	
    }

    
    
}