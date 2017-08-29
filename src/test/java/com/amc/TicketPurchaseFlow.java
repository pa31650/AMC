package com.amc;


import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.testng.ITestContext;
import org.testng.annotations.*;

import com.orasi.core.interfaces.Button;
import com.orasi.utils.Randomness;
import com.orasi.utils.Sleeper;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
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
	@DataProvider(name = "munkycheez", parallel=true)
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
        
    @Test(dataProvider = "munkycheez")
    public void ticketPurchaseFlow(String movieTitle){
    	//[Home] Open AMC website
    	Homepage homepage = new Homepage(getDriver());
    	
    	String xpathExpression = "//*[@class='PosterContent']//*[text()='" + movieTitle + "']/following::a[1]";
		//click Get Tickets button
    	
    	Button btnGetTickets = getDriver().findButton(By.xpath(xpathExpression));
    	
    	btnGetTickets.click();
    	
    	//[Home] Click Get Tickets for movie
    	//[Movie] Choose time for same day/tomorrow if no more times
    	//[Ticket Type] Select Adult/Child/Senior tickets
    	//[Ticket Type] Continue
    	//[Confirm Purchase] Enter contact info
    	//[Confirm Purchase] Enter payment info
    	//[Confirm Purchase] Click purchase
    	
    }
    
    
}