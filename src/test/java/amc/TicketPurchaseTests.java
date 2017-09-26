package src.test.java.amc;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import src.main.java.com.amc.*;
import src.main.resources.AMCTests;

import io.appium.java_client.TouchAction;

public class TicketPurchaseTests extends AMCTests {

    @Test
    public void SelectMovie() {

        //Initialize the drivers
        SignInPage signin = new SignInPage(getDriver());
        SeeAMoviePage seeAMovie = new SeeAMoviePage(getDriver());
        TicketSelectionPage ticketselection = new TicketSelectionPage(getDriver());
        PurchasePage purchase = new PurchasePage(getDriver());
        ContactInfoPage contactinfo = new ContactInfoPage(getDriver());
        PaymentPage payment = new PaymentPage(getDriver());

        //Set the device location settings
        System.out.println("TEST BEGIN");
        signin.LogInAsGuest();

        //Confirm that the app is on the home screen
        WebDriverWait element = new WebDriverWait(getDriver(), 10);
        element.until(ExpectedConditions.elementToBeClickable(By.id("com.amc:id/toolbar_title")));
        System.out.println("The test is currently on the home screen.");

        //Close promotional popup at the top of the screen
        seeAMovie.closePopup();

        //Scroll down to Annabelle: Creation
        TouchAction action = new TouchAction(getDriver());
        element.until(ExpectedConditions.elementToBeClickable(seeAMovie.third_movie));

        do {
            action.longPress(seeAMovie.fourth_movie).moveTo(seeAMovie.second_movie).release().perform();
        } while (!(seeAMovie.fifth_movie.isDisplayed()));

        //Click Annabelle: Creation
        seeAMovie.fifth_movie.click();

        //Confirm the app displays No Showtime title
        element.until(ExpectedConditions.presenceOfElementLocated(By.id("com.amc:id/noShowtimesTitle")));
        System.out.println("The movie '" + seeAMovie.selected_movie.getText() + "' is selected.");
        System.out.println("The app displays that no showtimes can be found.");


        //Select Choose Location
        element.until(ExpectedConditions.visibilityOf(seeAMovie.choose_location_btn));
        seeAMovie.choose_location_btn.click();

        //Populate the search bar
        seeAMovie.theater_search.sendKeys("amc classic greensboro 18");
        //Click enter
        getDriver().pressKeyCode(66);


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
            getDriver().quit();
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
        SignInPage signin = new SignInPage(getDriver());
        SeeAMoviePage seeAMovie = new SeeAMoviePage(getDriver());
        FoodAndDrinksPage foodanddrinks = new FoodAndDrinksPage(getDriver());
        TicketSelectionPage ticketselection = new TicketSelectionPage(getDriver());
        PurchasePage purchase = new PurchasePage(getDriver());
        ContactInfoPage contactinfo = new ContactInfoPage(getDriver());
        PaymentPage payment = new PaymentPage(getDriver());
        AMCTests amctests = new AMCTests();

        //Set the device location settings
        System.out.println("TEST BEGIN");
        signin.LogInAsGuest();

        //Confirm that the app is on the home screen
        WebDriverWait element = new WebDriverWait(getDriver(), 10);
        element.until(ExpectedConditions.elementToBeClickable(By.id("com.amc:id/toolbar_title")));
        String home_header = getDriver().findElementById("com.amc:id/toolbar_title").getText();
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
