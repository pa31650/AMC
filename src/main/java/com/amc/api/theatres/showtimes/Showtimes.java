package com.amc.api.theatres.showtimes;

import com.amc.api.AMC;
import com.amc.api.BaseAPI;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.orasi.api.restServices.Headers.HeaderType;
import com.orasi.api.restServices.ParameterBuilder;
import com.orasi.api.restServices.ParameterBuilder.Parameters;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Showtimes extends BaseAPI {

    public RestResponse getShowtimes(String theatreNumber) {
        RestService rest = new RestService();
        return rest.sendGetRequest(AMC.URL + "/theatres/" + theatreNumber + "/showtimes/", HeaderType.AMC);
    }
    
    public RestResponse getShowtimes(Integer theatreID, String date,String movieName){    	
    	return getShowtimes(theatreID, date, movieName);
    }
    
    public RestResponse getShowtimes(String theatreNumber, String date,String movieName, String pageSize){
    	RestService rest = new RestService();
    	Parameters params = new ParameterBuilder.Parameters();
    	params.add("pagination", pageSize);
    	return rest.sendGetRequest(AMC.URL + "/theatres/" + theatreNumber + "/showtimes/" + date + "/movieName/" + movieName, HeaderType.AMC,params.build());
    }
}