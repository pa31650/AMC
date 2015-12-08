package com.orasi.utils;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class sandbox extends TestEnvironment{
    @BeforeTest(groups ={"regression", "utils", "dev"})
    @Parameters({ "runLocation", "browserUnderTest", "browserVersion",
	    "operatingSystem", "environment", "deviceName", "deviceOrientation" })
    public void setup(@Optional String runLocation, String browserUnderTest,
	    String browserVersion, String operatingSystem, String environment, String deviceName, String deviceOrientation) {
	setApplicationUnderTest("Test Site");
	setBrowserUnderTest(browserUnderTest);
	setBrowserVersion(browserVersion);
	setOperatingSystem(operatingSystem);
	setRunLocation(runLocation);
	setTestEnvironment(environment);
	setDeviceName(deviceName);
	setDeviceOrientation(deviceOrientation);
	setPageURL("https://bluesourcestaging.herokuapp.com/");
	testStart("TestAppium");
    }
    
    @AfterTest(groups ={"regression", "utils", "dev"})
    public void close(ITestContext context){
	endTest("TestAppium",context);
    }
    
    @Test(groups ={"regression", "utils", "dev"})
    public void isAlertPresent(){
	
	driver.findTextbox(By.id("employee_username")).set("company.admin");
	driver.findTextbox(By.id("employee_password")).set("blah");
	driver.findButton(By.xpath("//input[@value='Login']")).click();
	   
	driver.findLink(By.xpath("//a[text() = 'Logout']")).syncPresent();
    }
}
