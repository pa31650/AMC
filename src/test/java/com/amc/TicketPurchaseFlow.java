package com.amc;


import org.testng.ITestContext;
import org.testng.annotations.*;

import com.orasi.utils.Randomness;
import com.orasi.utils.Sleeper;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.orasi.utils.dataProviders.ExcelDataProvider;
import com.orasi.utils.date.SimpleDate;

import com.orasi.utils.Randomness;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.orasi.utils.dataProviders.ExcelDataProvider;

public class TicketPurchaseFlow extends TestEnvironment{

	// ************* *
	// Data Provider
	// **************
	/*@DataProvider(name = "LoginRoles", parallel=true)
	public Object[][] scenarios() {
			return new ExcelDataProvider("/testdata/sample.xlsx", "Data").getTestData();
	}*/
	
	@BeforeMethod
    @Parameters({ "runLocation", "browserUnderTest", "browserVersion", "operatingSystem", "environment" })
    public void setup(@Optional String runLocation, String browserUnderTest,
	    String browserVersion, String operatingSystem, String environment) {
    	setApplicationUnderTest("BLUESOURCE");
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
        
    @Test
    public void ticketPurchaseFlow(){
    	
    }
    
    
}