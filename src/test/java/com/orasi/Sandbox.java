package com.orasi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.testng.annotations.Test;

import com.amc.api.AMC;
import com.amc.api.theatres.objects.Theatre;
import com.amc.api.theatres.objects.TheatreResponse;
import com.orasi.api.restServices.ResponseCodes;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sandbox {

    @Test
    public void GetShowtimes() {
        RestResponse rest = AMC.showtimes().getShowtime("59229828");
        TestReporter.logAPI(rest.getStatusCode() == ResponseCodes.OK, "Get showtime: 59229828", rest);        
    }
    
    @Test
    public void GetShowtimesForTheatre() {
    	RestResponse rest = AMC.theatres().showtimes().getShowtimes("6");
    	TestReporter.logAPI(rest.getStatusCode() == ResponseCodes.OK, "Get showtimes for theatre '6'", rest);
    }
    
    @Test
    
    public void GetAllTheatres(){
    	//Get SKU for Adult Ticket
    	RestResponse rest = AMC.theatres().getTheatres();
    	TestReporter.logAPI(rest.getStatusCode() == ResponseCodes.OK, "Get all Theatres", rest);
    	
    	TheatreResponse theatres = rest.mapJSONToObject(TheatreResponse.class);
        
        for (Theatre theatre : theatres.getEmbedded().getTheatres()) {
        System.out.println(theatre.getName()+ " - " + theatre.getId());
        }
        
    }
    
    
    
    
}