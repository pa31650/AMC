package com.amc;




import java.util.Date;

import org.testng.ITestContext;
import org.testng.annotations.*;

import com.amc.api.AMC;
import com.amc.api.BaseAPI;
import com.amc.api.v2.theatres.objects.TheatreResponse;
import com.amc.api.v2.theatres.showtimes.TheatreShowtimes;
import com.amc.api.v2.theatres.showtimes.objects.ShowtimeResponse;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.orasi.api.restServices.ResponseCodes;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.orasi.utils.dataProviders.JsonDataProvider;
import com.orasi.utils.date.DateTimeConversion;

public class TicketPurchaseFlowREST extends BaseAPI{
	
	// ************* *
	// Data Provider
	// **************
	@DataProvider(name = "Sample", parallel=true)
	public Object[][] scenarios() {
		return new JsonDataProvider().getData("/json/apiTicketPurchaseFlow.json");
	}
        
    @Test(dataProvider = "Sample")
    public void apiTicketPurchaseFlow(
    		String iterationName,String movieName,String theatreName,Date date, String tickets, String creditCard){
    	
    	//Finding a Performance/Get sku
        String strDay = DateTimeConversion.convert(date, "dd-MM-yyyy");
        
    	RestResponse rest = AMC.theatreShowtimes().getShowtimes(AMC.theatres().getTheatreID(theatreName), strDay, movieName);
    	
    	ShowtimeResponse theatreshowtimes = rest.mapJSONToObject(ShowtimeResponse.class);

        String sku = theatreshowtimes.getEmbedded().getShowtimes().get(0).getTicketPrices().get(0).getSku();
    	
    	//Creating an empty order
        
    	
    	//Adding tickets
    	
    	//Adding a credit card payment
    	
    	//Committing the order for fulfillment
    	
    }    
}