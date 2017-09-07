package com.amc;


import org.testng.ITestContext;
import org.testng.annotations.*;

import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.orasi.utils.dataProviders.JsonDataProvider;

public class TicketPurchaseFlow extends TestEnvironment{
	
	// ************* *
	// Data Provider
	// **************
	@DataProvider(name = "Sample", parallel=true)
	public Object[][] scenarios() {
		return new JsonDataProvider().getData("/json/ticketPurchaseFlow.json");
	}
	
	@BeforeMethod
    @Parameters({ "runLocation", "browserUnderTest", "browserVersion", "operatingSystem", "environment", "mobileOSVersion" })
    public void setup(@Optional String runLocation, String browserUnderTest,
	    String browserVersion, String operatingSystem, String environment, String mobileOSVersion) {
    	setApplicationUnderTest("AMC");
		setBrowserUnderTest(browserUnderTest);
		setBrowserVersion(browserVersion);
		setOperatingSystem(operatingSystem);
		setRunLocation(runLocation);
		setTestEnvironment(environment);
		setThreadDriver(true);
		setMobileOSVersion(mobileOSVersion);
		testStart("TicketPurchaseFlow");
	}
    
    @AfterMethod
    public void close(ITestContext testResults){
    	endTest("TestAlert", testResults);
    }
        
    @Test(dataProvider = "Sample")
    public void ticketPurchaseFlow(
    		String iterationName,String movieTitle,String theatre,String date, String tickets, String creditCard){
    	    	
    	//[Home] Open AMC website
    	HomePage homePage = new HomePage(getDriver());

    	//[Home] Click on Showtimes element
    	homePage.clickShowtimes();
    	
    	//[Showtimes] 
    	ShowtimesPage showtimesPage = new ShowtimesPage(getDriver());
    	
    	//[Showtimes] Selects theatre, movie and date & chooses first showing
    	showtimesPage.showtimesComplete(theatre, movieTitle, date);
    	
    	boolean reservedSeating = showtimesPage.isReservedSeatingAvail();
    	
    	showtimesPage.chooseFirstShowing();
    	    	
    	//[SelectSeat] Choose seat if theatre provides reserved seating service
    	if (reservedSeating) {
			SelectSeatPage selectSeatPage = new SelectSeatPage(getDriver());
			
			Integer intSeats = Integer.valueOf(tickets);
			
			selectSeatPage.chooseOpenSeats(intSeats);
			
			selectSeatPage.btnContinue();
			
		}
    	
    	//[Ticket Type] Select Adult/Child/Senior tickets
    	SelectTicketTypePage selectTicketTypePage = new SelectTicketTypePage(getDriver());
    	
    	//[Ticket Type] Add adult tickets & Continue
    	selectTicketTypePage.selectTicketTypeComplete(tickets);
    	
    	//[Confirm Purchase] Enter email address
    	ConfirmPurchasePage confirmPurchasePage = new ConfirmPurchasePage(getDriver());
    	
    	//[Confirm Purchase] Enter email address and payment details & Purchase
    	confirmPurchasePage.confirmPurchasePageComplete(creditCard);
    	    	
    	//[Confirm Purchase] Check for Error (and output message?)
    	TestReporter.assertTrue(confirmPurchasePage.errorExist(), "Ensuring that the Error label is present after clicking Purchase button with bad cc data.");
    }    
}