package src.main.java.com.amc;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignInPage {

    AndroidDriver<MobileElement> driver;

    @FindBy(id="com.android.packageinstaller:id/permission_deny_button") private WebElement deny_location;
    @FindBy(id="com.amc:id/continueAsGuestButton") private WebElement continue_as_guest;

    public SignInPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void LogInAsGuest() {

        //Set the device location settings
        try {
            deny_location.click();
            deny_location.click();
        } catch (Exception e) {
            System.out.println("Device location settings are already set.");
        }

        //Allows driver to find elements after closing the location alert
        try {
            driver.runAppInBackground(Duration.ofSeconds(1));
        } catch (Exception e) {}

        //Click continue as guest button
        WebDriverWait element = new WebDriverWait(driver, 20);
        element.until(ExpectedConditions.elementToBeClickable(continue_as_guest));
        continue_as_guest.click();
    }
}