package com.amc;

import org.testng.annotations.Test;

import com.amc.api.AMC;
import com.amc.api.v2.theatres.objects.Theatre;
import com.amc.api.v2.theatres.objects.TheatreResponse;
import com.amc.api.v2.theatres.showtimes.objects.ShowtimeResponse;
import com.orasi.api.restServices.ResponseCodes;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class AMCapiDemo extends AMC{

    @Test
    public void GetShowtimes() {
        RestResponse rest = AMC.showtimes().getShowtimes("59229828");
        TestReporter.logAPI(rest.getStatusCode() == ResponseCodes.OK, "Get showtime: 59229828", rest);        
    }
    
    @Test
    public void GetShowtimesForTheatre() {
    	RestResponse rest = AMC.theatreShowtimes().getShowtimes("7");
    	TestReporter.logAPI(rest.getStatusCode() == ResponseCodes.OK, "Get showtimes for theatre '7'", rest);
    }
    
    @Test
    
    public void GetAllTheatres(){

        RestResponse rest = AMC.theatres().getTheatres();
    	TestReporter.logAPI(rest.getStatusCode() == ResponseCodes.OK, "Get all Theatres", rest);
    	
    	TheatreResponse theatres = rest.mapJSONToObject(TheatreResponse.class);
        
        for (Theatre theatre : theatres.getEmbedded().getTheatres()) {
        System.out.println(theatre.getName()+ " - " + theatre.getId());
        }
        
    }
    
    @Test
    public void GetAdultTicketSKU() {
        
        RestResponse rest = AMC.theatreShowtimes().getShowtimes(7, "09-16-2017", "Logan Lucky");
        ShowtimeResponse theatreshowtimes = rest.mapJSONToObject(ShowtimeResponse.class);
                
        TestReporter.logAPI(rest.getStatusCode() == ResponseCodes.OK, "Get showtimes for theatre id 7, 9/8/2017, Logan Lucky",rest);
        
        String sku = theatreshowtimes.getEmbedded().getShowtimes().get(0).getTicketPrices().get(0).getSku();
        System.out.println(sku);
        
    }
      
    
    
}