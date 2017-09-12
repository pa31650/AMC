package src.test.java.amc;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import src.main.resources.AMCTests;
import src.main.java.com.amc.SeeAMoviePage;
import src.main.java.com.amc.SignInPage;

import io.appium.java_client.TouchAction;

public class TicketPurchaseTests extends AMCTests {

    @Test
    public void GenericTicketFlow() {

        SignInPage signin = new SignInPage(getDriver());
        SeeAMoviePage seeAMovie = new SeeAMoviePage(getDriver());

        //Set the device location settings
        signin.LogInAsGuest();

        //Confirm that the app is on the home screen
        WebDriverWait element = new WebDriverWait(getDriver(), 20);
        element.until(ExpectedConditions.elementToBeClickable(By.id("com.amc:id/toolbar_title")));
        String home_header = getDriver().findElementById("com.amc:id/toolbar_title").getText();
        if (home_header.equals("See a Movie")) {
            System.out.println("The app is on the home screen.");
        } else
            System.out.println("The app is not on the home screen.");

        //Close promotional popup at the top of the screen
        seeAMovie.closePopup();

        //Scroll down to Annabelle: Creation
        TouchAction action = new TouchAction(getDriver());
        element.until(ExpectedConditions.elementToBeClickable(seeAMovie.wind_river));
        action.longPress(seeAMovie.wind_river).moveTo(seeAMovie.home_again).release().perform();

        //Click Annabelle: Creation
        seeAMovie.annabelle_creation.click();

        //Confirm the app displays No Showtime title
        try {
            element.until(ExpectedConditions.presenceOfElementLocated(By.id("com.amc:id/noShowtimesTitle")));
            System.out.println("The app displays that no showtimes can be found.");
        } catch (TimeoutException te) {
            System.out.println("The page failed to load.");
        }

        //Select Choose Location
        seeAMovie.choose_location_btn.click();

        //Populate the search bar
        seeAMovie.theater_search.sendKeys("amc classic greensboro 18");
        //Click enter
        getDriver().pressKeyCode(66);


        //Confirm the search results are visible and click the theater
        try {
            element.until(ExpectedConditions.presenceOfElementLocated(By.id("com.amc:id/theatre_view")));
            System.out.println("The app displays the search result.");
            seeAMovie.amc_gso_18.click();
        } catch (TimeoutException te) {
            System.out.println("The page failed to load.");
        }

    }
}
