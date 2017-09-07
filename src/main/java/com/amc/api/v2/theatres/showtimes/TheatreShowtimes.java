package com.amc.api.v2.theatres.showtimes;

import com.amc.api.AMC;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.orasi.api.restServices.Headers.HeaderType;
import com.orasi.api.restServices.ParameterBuilder;
import com.orasi.api.restServices.ParameterBuilder.Parameters;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
@JsonIgnoreProperties(ignoreUnknown = true)

public class TheatreShowtimes extends AMC {
    private String URL = AMC.URLv2 + "theatres/";
    
    public RestResponse getShowtimes(String theatreNumber) {
        RestService rest = new RestService();
        return rest.sendGetRequest(URL + theatreNumber + "/showtimes/", HeaderType.AMC);
    }
    
    public RestResponse getShowtimes(Integer theatreNumber, String date, String movieName){
        RestService rest = new RestService();
        Parameters params = new ParameterBuilder.Parameters();
        
        params.add("movie", movieName);
       
        return rest.sendGetRequest(URL + theatreNumber + "/showtimes/" + date, HeaderType.AMC,params.build());
    }
    
    public RestResponse getShowtimes(Integer theatreNumber, String date, String movieName, String pageSize){
    	RestService rest = new RestService();
    	Parameters params = new ParameterBuilder.Parameters();
    	
    	params.add("page-size", pageSize);
    	params.add("movie", movieName);
    	
    	///v2/theatres/610/showtimes/10-22-2014?movie="Lucky Logan"
    	return rest.sendGetRequest(URL + theatreNumber + "/showtimes/" + date, HeaderType.AMC, params.build());
    }
}