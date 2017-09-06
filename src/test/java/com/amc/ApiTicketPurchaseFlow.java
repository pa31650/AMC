package com.amc;


import org.testng.ITestContext;
import org.testng.annotations.*;

import com.amc.api.AMC;
import com.amc.api.BaseAPI;
import com.amc.api.theatres.showtimes.Showtimes;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.orasi.utils.dataProviders.JsonDataProvider;

public class ApiTicketPurchaseFlow extends BaseAPI{
	
	// ************* *
	// Data Provider
	// **************
	@DataProvider(name = "Sample", parallel=true)
	public Object[][] scenarios() {
		return new JsonDataProvider().getData("/json/apiTicketPurchaseFlow.json");
	}
        
    @Test(dataProvider = "Sample")
    public void apiTicketPurchaseFlow(
    		String iterationName,String movieName,String theatreName,String date, String tickets, String creditCard){
    	
    	//Finding a Performance
    	Integer theatreID = AMC.theatres().getTheatreID(theatreName);
    	
    	RestResponse rest = AMC.theatres().showtimes().getShowtimes(theatreID, date, movieName);
    	//Creating an empty order
    	
    	//Adding tickets
    	
    	//Adding a credit card payment
    	
    	//Committing the order for fulfillment
    	
    }    
}