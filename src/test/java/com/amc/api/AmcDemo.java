package com.amc.api;

import org.testng.annotations.Test;

import com.amc.api.AMC;
import com.amc.api.v2.showtimes.objects.ShowtimesResponse;
import com.amc.api.v2.theatres.objects.Theatre;
import com.amc.api.v2.theatres.objects.TheatreResponse;
import com.amc.api.v2.theatres.showtimes.objects.ShowtimeResponse;
import com.orasi.api.restServices.ResponseCodes;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;
import com.sun.jna.platform.win32.OaIdl.DATE;
import com.orasi.utils.date.*;

public class AmcDemo extends AMC{

    @Test
    public void GetShowtimes() {       
        RestResponse rest = AMC.showtimes().getShowtimes("59229828");
        TestReporter.logAPI(rest.getStatusCode() == ResponseCodes.OK, "Get showtime: 59229828", rest);        
    }
    
    @Test
    public void GetShowtimesForTheatre() {
    	RestResponse rest = AMC.theatreShowtimes().getShowtimes(7);
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
        String strToday = DateTimeConversion.getDaysOut("0", "MM-dd-YYYY");
        Integer intTheatreID = AMC.theatres().getTheatreID("AMC Esquire 7");
        String strMovieName = AMC.theatreShowtimes().getFirstMovieName(intTheatreID);
        
        RestResponse rest = AMC.theatreShowtimes().getShowtimes(intTheatreID, strToday, strMovieName);
        
        ShowtimeResponse theatreshowtimes = rest.mapJSONToObject(ShowtimeResponse.class);
        
        TestReporter.logAPI(rest.getStatusCode() == ResponseCodes.OK, "Get showtimes for theatre id " + intTheatreID + ", " + strToday + ", " + strMovieName, rest);
        
        String sku = theatreshowtimes.getEmbedded().getShowtimes().get(0).getTicketPrices().get(0).getSku();
        TestReporter.logStep("Get Adult SKU for theatre id " + intTheatreID + ", " + strToday + ", " + strMovieName);
        TestReporter.logStep(sku);
        
        
    }
      
    
    
}