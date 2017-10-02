package com.amc.apk;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orasi.utils.Android;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.dataProviders.JsonDataProvider;

public class LoginTests extends TestEnvironment {

    // ************* *
    // Data Provider
    // **************
    @DataProvider(name = "Login Tests", parallel = true)
    public Object[][] scenarios() {
        return new JsonDataProvider().getData("/json/loginTests.json");
        //return new JsonDataProvider().getData("/json/ticketPurchaseFlow-QA.json");
    }
    
    @BeforeMethod
    @Parameters({ 
        "platformName",
        "mobileOSVersion",
        "deviceName",
        "appPackage",
        "appActivity"
        })
    public void setup(@Optional String platformName,
            String mobileOSVersion, String deviceName, String appPackage, 
            String appActivity) {
        setOperatingSystem(platformName);
        setMobileOSVersion(mobileOSVersion);
        setDeviceID(deviceName);
        setAppPackage(appPackage);
        setAppActivity(appActivity);
        mobileAppTestStart("Login Tests");
        
    }
    
    @Test
    public void confirmSeeAMoviePage() {
        SignInPage signInPage = new SignInPage(getAndroidDriver());
        
        //Set the device location settings
        signInPage.LogInAsGuest();

        //Confirm that the app is on the home screen
        WebDriverWait element = new WebDriverWait(getAndroidDriver(), 20);
        element.until(ExpectedConditions.elementToBeClickable(By.id("com.amc:id/toolbar_title")));
        String seeAMovie_header = getAndroidDriver().findElementById("com.amc:id/toolbar_title").getText();
        if (seeAMovie_header.equals("See a Movie")) {
            System.out.println("The app is on the See A Movie page.");
        } else
            System.out.println("The app is not on the See A Movie page.");
    }
}