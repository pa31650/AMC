package com.amc.apk;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orasi.utils.Android;
//import com.orasi.utils.OrasiDriver;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.MobileAppDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.orasi.utils.Android;

public class SignInPage extends TestEnvironment{
    //private OrasiDriver driver = null;
    private AndroidDriver<MobileElement> androidDriver;

    @FindBy(id="com.android.packageinstaller:id/permission_deny_button") private WebElement deny_location;
    @FindBy(id="com.amc:id/continueAsGuestButton") private WebElement continue_as_guest;

    public SignInPage(AndroidDriver<MobileElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
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
        Android.RunAppInBackground(androidDriver);

        //Click continue as guest button
        WebDriverWait element = new WebDriverWait(androidDriver, 20);
        element.until(ExpectedConditions.elementToBeClickable(continue_as_guest));
        continue_as_guest.click();
    }
}