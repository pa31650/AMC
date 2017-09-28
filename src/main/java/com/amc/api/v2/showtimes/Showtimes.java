package com.amc.api.v2.showtimes;

import com.amc.api.AMC;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.orasi.api.restServices.Headers.HeaderType;

public class Showtimes {
    
    private String URL = AMC.URLv2 + "showtimes/";
    
    public RestResponse getShowtimes(String showtimeID) {
        RestService rest = new RestService();
        return rest.sendGetRequest(URL + showtimeID, HeaderType.AMC);
    }

}
