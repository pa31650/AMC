package com.amc;


import java.sql.Array;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import com.orasi.core.interfaces.Button;
import com.orasi.utils.Randomness;
import com.orasi.utils.Sleeper;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.orasi.utils.dataHelpers.creditCards.CreditCards;
import com.orasi.utils.dataHelpers.personFactory.Email;
import com.orasi.utils.dataHelpers.personFactory.Person;
import com.orasi.utils.dataProviders.CSVDataProvider;
import com.orasi.utils.dataProviders.ExcelDataProvider;
import com.orasi.utils.dataProviders.JsonDataProvider;
import com.orasi.utils.date.SimpleDate;

import com.orasi.utils.Randomness;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.orasi.utils.dataProviders.ExcelDataProvider;

public class TicketPurchaseFlow extends TestEnvironment{
	
	// ************* *
	// Data Provider
	// **************
	@DataProvider(name = "Sample", parallel=true)
	public Object[][] scenarios() {
		return new JsonDataProvider().getData("/json/ticketPurchaseFlow.json");
	}
	
	@BeforeMethod
    @Parameters({ "runLocation", "browserUnderTest", "browserVersion", "operatingSystem", "environment" })
    public void setup(@Optional String runLocation, String browserUnderTest,
	    String browserVersion, String operatingSystem, String environment) {
    	setApplicationUnderTest("AMC");
		setBrowserUnderTest(browserUnderTest);
		setBrowserVersion(browserVersion);
		setOperatingSystem(operatingSystem);
		setRunLocation(runLocation);
		setTestEnvironment(environment);
		setThreadDriver(true);
		testStart("TicketPurchaseFlow");
	}
    
    @AfterMethod
    public void close(ITestContext testResults){
    	endTest("TestAlert", testResults);
    }
        
    @Test(dataProvider = "Sample")
    public void ticketPurchaseFlow(String iterationName,String movieTitle,String theatre,String date, String tickets, String creditCard){
    	    	
    	//[Home] Open AMC website
    	HomePage homePage = new HomePage(getDriver());

    	//[Home] Click on Showtimes element
    	homePage.clickShowtimes();
    	
    	//[Showtimes] Choose theatre
    	ShowtimesPage showtimesPage = new ShowtimesPage(getDriver());
    	
    	showtimesPage.theatreSearch(theatre);
    	
    	TestReporter.log("Theatre: " + theatre + " was selected.");
    	    	
    	//[Showtimes] Choose Movie
    	showtimesPage.chooseMovie(movieTitle);
    	TestReporter.logStep("Movie Title: " + movieTitle + " was selected.");
    	
    	//[Showtimes] Choose Day - "Today" or "YYYY-MM-DD"
    	showtimesPage.chooseDay(date);
    	TestReporter.logStep("Date: " + date + " was selected.");
    	
    	boolean reservedSeating = showtimesPage.isReservedSeatingAvail();
    	
    	//[Showtimes] Choose first showtime of the day at selected theatre
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
    	
    	selectTicketTypePage.addAdultTickets(tickets);
    	TestReporter.logStep(tickets + " Adult Ticket was selected.");
    	
    	//[Ticket Type] Continue
    	selectTicketTypePage.ClickContinueButton();
    	
    	//[Confirm Purchase] Enter email address
    	ConfirmPurchasePage confirmPurchasePage = new ConfirmPurchasePage(getDriver());
    	
    	Email email = new Email();
    	    	
    	confirmPurchasePage.enterEmail(email.getEmail());
    	TestReporter.logStep(email.getEmail() + " was entered for email address.");
    	
    	//[Confirm Purchase] Enter payment info
    	CreditCards creditCards = new CreditCards();
    	
    	switch (creditCard.toUpperCase()) {
		case "MC":
			confirmPurchasePage.enterCCInfo(creditCards.MASTERCARD());
			break;
		case "MASTERCARD":
			confirmPurchasePage.enterCCInfo(creditCards.MASTERCARD());
			break;
		case "VISA":
			confirmPurchasePage.enterCCInfo(creditCards.VISA());
			break;
		case "VISA_EXPIRED":
			confirmPurchasePage.enterCCInfo(creditCards.VISA_EXPIRED());
			break;
		default:
			confirmPurchasePage.enterCCInfo(creditCards.MASTERCARD());
			break;
		}
    	    	
    	//[Confirm Purchase] Click purchase
    	confirmPurchasePage.clickPurchaseButton();
    	
    	//[Confirm Purchase] Check for Error (and output message?)
    	TestReporter.assertTrue(confirmPurchasePage.errorExist(), "Ensuring that the Error label is present after clicking Purchase button with bad cc data.");
    }    
}