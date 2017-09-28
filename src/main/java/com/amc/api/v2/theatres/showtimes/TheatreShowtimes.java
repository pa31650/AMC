package com.amc.api.v2.theatres.showtimes;

import java.util.Iterator;
import java.util.List;

import org.codehaus.groovy.classgen.asm.BinaryBooleanExpressionHelper;

import com.amc.api.AMC;
import com.amc.api.v2.theatres.showtimes.objects.Showtime;
import com.amc.api.v2.theatres.showtimes.objects.ShowtimeResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.orasi.api.restServices.Headers.HeaderType;
import com.orasi.api.restServices.ParameterBuilder;
import com.orasi.api.restServices.ParameterBuilder.Parameters;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
@JsonIgnoreProperties(ignoreUnknown = true)

public class TheatreShowtimes extends AMC {
    private String URL = AMC.URLv2 + "theatres/";
    
    public RestResponse getShowtimes(Integer theatreNumber) {
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
    
    public String getFirstMovieName(Integer intTheatreID) {
        RestResponse restResponse = getShowtimes(intTheatreID);
        
        String strMovieName;
        
        ShowtimeResponse showtimeResponse = restResponse.mapJSONToObject(ShowtimeResponse.class);
        
        List<Showtime> showtimes = showtimeResponse.getEmbedded().getShowtimes();
        
        return strMovieName = showtimes.get(0).getMovieName();
         
    }
}