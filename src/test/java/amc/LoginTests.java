package src.test.java.amc;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import src.main.resources.AMCTests;
import src.main.java.com.amc.SignInPage;

public class LoginTests extends AMCTests {

    @Test
    public void confirmSeeAMoviePage() {
        SignInPage signin = new SignInPage(getDriver());

        //Set the device location settings
        signin.LogInAsGuest();

        //Confirm that the app is on the home screen
        WebDriverWait element = new WebDriverWait(getDriver(), 20);
        element.until(ExpectedConditions.elementToBeClickable(By.id("com.amc:id/toolbar_title")));
        String seeAMovie_header = getDriver().findElementById("com.amc:id/toolbar_title").getText();
        if (seeAMovie_header.equals("See a Movie")) {
            System.out.println("The app is on the See A Movie page.");
        } else
            System.out.println("The app is not on the See A Movie page.");
    }
}
