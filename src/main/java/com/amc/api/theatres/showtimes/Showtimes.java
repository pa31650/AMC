package com.amc.api.theatres.showtimes;

import com.amc.api.AMC;
import com.orasi.api.restServices.Headers.HeaderType;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;

public class Showtimes {
    public RestResponse getShowtimes(String theatreNumber) {
        RestService rest = new RestService();
        return rest.sendGetRequest(AMC.URL + "/theatres/" + theatreNumber + "/showtimes/", HeaderType.AMC);
    }
}