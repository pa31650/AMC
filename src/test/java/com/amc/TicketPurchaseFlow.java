package com.amc;


import java.sql.Array;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
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
		//return new ExcelDataProvider("/testdata/sample.xlsx", "Data").getTestData();
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
    public void ticketPurchaseFlow(String iterationName,String movieTitle,String theatre,String date, int tickets, String creditCard){
    	    	
    	//[Home] Open AMC website
    	Homepage homepage = new Homepage(getDriver());

    	//[Home] Click Get Tickets for movie
		String xpathExpression = "//*[@class='PosterContent']//*[text()='" + movieTitle + "']/following::a[1]";
    	
    	Button btnGetTickets = getDriver().findButton(By.xpath(xpathExpression));
    	
    	btnGetTickets.click();

    	//[Showtimes] Choose theatre
    	Showtimes showtimes = new Showtimes(getDriver());
    	    	 	
    	showtimes.TheatreSearch(theatre);
    	
    	//[Showtimes] Choose Day - "Today" or "YYYY-MM-DD"
    	showtimes.ChooseDay(date);
    	
    	//[Showtimes] Choose first showtime of the day at selected theatre
    	showtimes.ChooseFirstShowing();
    	
    	//[Ticket Type] Select Adult/Child/Senior tickets
    	SelectTicketType selectTicketType = new SelectTicketType(getDriver());
    	
    	selectTicketType.AddAdultTickets(tickets);
    	
    	//[Ticket Type] Continue
    	selectTicketType.ClickContinueButton();
    	
    	//[Confirm Purchase] Enter email address
    	ConfirmPurchase confirmPurchase = new ConfirmPurchase(getDriver());
    	
    	Email email = new Email();
    	    	
    	confirmPurchase.EnterEmail(email.getEmail());
    	
    	//[Confirm Purchase] Enter payment info
    	CreditCards creditCards = new CreditCards();
    	
    	switch (creditCard.toUpperCase()) {
		case "MC":
			confirmPurchase.EnterCCInfo(creditCards.MASTERCARD());
			break;
		case "MASTERCARD":
			confirmPurchase.EnterCCInfo(creditCards.MASTERCARD());
			break;
		case "VISA":
			confirmPurchase.EnterCCInfo(creditCards.VISA());
			break;
		case "VISA_EXPIRED":
			confirmPurchase.EnterCCInfo(creditCards.VISA_EXPIRED());
			break;
		default:
			confirmPurchase.EnterCCInfo(creditCards.MASTERCARD());
			break;
		}
    	
    	confirmPurchase.EnterCCInfo(creditCards.VISA_EXPIRED());
    	
    	//[Confirm Purchase] Click purchase
    	confirmPurchase.ClickPurchaseButton();
    	
    	//[Confirm Purchase] Check for Error (and output message?)
    	TestReporter.assertTrue(confirmPurchase.ErrorExist(), "Ensuring that the Error label is present after clicking Purchase button with bad cc data.");
    }
    
    
}