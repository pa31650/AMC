package com.amc.apk;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orasi.utils.Android;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.dataProviders.JsonDataProvider;
import com.orasi.utils.MobileAppDriver;

public class TicketPurchaseTests extends TestEnvironment {

 // ************* *
    // Data Provider
    // **************
    @DataProvider(name = "Login Tests", parallel = false)
    public Object[][] scenarios() {
        return new JsonDataProvider().getData("/json/TicketPurchaseTests.json");
        //return new JsonDataProvider().getData("/json/ticketPurchaseFlow-QA.json");
    }
    
    @BeforeTest
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

    @AfterTest
    public void close(ITestContext testResults) {
        endTest("TestAlert", testResults);
    }
    
    @Test
    public void SelectMovie(){

        //Initialize the drivers
        SignInPage signin = new SignInPage(getAndroidDriver());
        SeeAMoviePage seeAMovie = new SeeAMoviePage(getAndroidDriver());
        TicketSelectionPage ticketselection = new TicketSelectionPage(getAndroidDriver());
        PurchasePage purchase = new PurchasePage(getAndroidDriver());
        //AMCTests amctests = new AMCTests();

        //Set the device location settings
        System.out.println("TEST BEGIN");
        signin.LogInAsGuest();

        //Confirm that the app is on the home screen
        WebDriverWait element = new WebDriverWait(getAndroidDriver(), 10);
        element.until(ExpectedConditions.visibilityOf(seeAMovie.see_a_movie_header));
        System.out.println("The test is currently on the home screen.");

        //Close promotional popup at the top of the screen
        seeAMovie.closePopup();

        //Scroll down to Annabelle: Creation
        element.until(ExpectedConditions.elementToBeClickable(seeAMovie.third_movie));
        Android.moveToElement(getAndroidDriver(), seeAMovie.fourth_movie, seeAMovie.second_movie, seeAMovie.fifth_movie);

        //Click Annabelle: Creation
        seeAMovie.fifth_movie.click();

        //Confirm the app displays No Showtime title
        element.until(ExpectedConditions.visibilityOf(seeAMovie.no_showtimes));
        System.out.println("The movie '" + seeAMovie.selected_movie.getText() + "' is selected.");
        System.out.println("The app displays that no showtimes can be found.");


        //Select Choose Location
        element.until(ExpectedConditions.visibilityOf(seeAMovie.choose_location_btn));
        seeAMovie.choose_location_btn.click();

        //Populate the search bar
        seeAMovie.theater_search.sendKeys("amc classic greensboro 18");
        //Click enter
        getAndroidDriver().pressKeyCode(66);


        //Confirm the search results are visible and click the theater
        element.until(ExpectedConditions.presenceOfElementLocated(By.id("com.amc:id/theatre_view")));
        Reporter.log("The app displays the search result.");
        seeAMovie.amc_gso_18.click();

        //Select the first available showtime and select 1 adult ticket
        element.until(ExpectedConditions.visibilityOf(seeAMovie.first_showtime));
        seeAMovie.first_showtime.click();
        element.until(ExpectedConditions.visibilityOf(ticketselection.page_header));
        ticketselection.add_adult.click();

        //Confirm that 1 adult ticket was selected
        if (ticketselection.adult_header.getAttribute("text").equals("1 Adult")) {
            System.out.println("1 adult ticket was selected.");
        } else {
            System.out.println("The ticket failed to be selected or more than 1 ticket was selected.");
            getAndroidDriver().quit();
        }

        //Confirm visibility of purchase page
        ticketselection.next_btn.click();
        element.until(ExpectedConditions.visibilityOf(purchase.add_email));
        System.out.println("The app is currently on the purchase page.");
        System.out.println("TEST END");
    }

    @Test
    public void SelectTheater() {

        //Initialize the drivers
        SignInPage signin = new SignInPage(getAndroidDriver());
        SeeAMoviePage seeAMovie = new SeeAMoviePage(getAndroidDriver());
        FoodAndDrinksPage foodanddrinks = new FoodAndDrinksPage(getAndroidDriver());
        PurchasePage purchase = new PurchasePage(getAndroidDriver());
        ContactInfoPage contactinfo = new ContactInfoPage(getAndroidDriver());
        PaymentPage payment = new PaymentPage(getAndroidDriver());

        //Set the device location settings
        System.out.println("TEST BEGIN");
        signin.LogInAsGuest();

        //Confirm that the app is on the home screen
        WebDriverWait element = new WebDriverWait(getAndroidDriver(), 10);
        element.until(ExpectedConditions.elementToBeClickable(By.id("com.amc:id/toolbar_title")));
        String home_header = getAndroidDriver().findElementById("com.amc:id/toolbar_title").getText();
        if (home_header.equals("See a Movie")) {
            System.out.println("The app is on the home screen.");
        } else
            System.out.println("The app is not on the home screen.");

        //Close promotional popup at the top of the screen
        seeAMovie.closePopup();

        //Select Food & Drinks page
        seeAMovie.food_and_drinks.click();
        element.until(ExpectedConditions.visibilityOf(foodanddrinks.order_ahead));

        //Select theater and theater seat
        foodanddrinks.selectTheatre();
        foodanddrinks.deliveryToSeat();

        //Confirm visibility of purchase page
        element.until(ExpectedConditions.visibilityOf(purchase.contactinfo_header));
        System.out.println("The app is on the purchase page.");

        //Add email address
        purchase.add_email.click();
        contactinfo.EnterEmail();
        element.until(ExpectedConditions.visibilityOf(purchase.contactinfo_header));

        //Add credit card information
        purchase.add_payment.click();
        payment.AddCreditCard();

        //Confirm visibility of purchase page
        //element.until(ExpectedConditions.visibilityOf(purchase.contactinfo_header));
        //System.out.println("TEST END");
    }
}