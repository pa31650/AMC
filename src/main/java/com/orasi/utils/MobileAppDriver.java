package com.orasi.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class MobileAppDriver {
    /*
     * Define fields to be used by an OrasiDriver
     */
    private AndroidDriver<MobileElement> androidDriver;
    
    public MobileAppDriver() {
    }
    
    /**
     * Method to return the current OrasiDriver
     * Example usage: getDriver().getDriver();
     *
     * @return - current OrasiDriver
     */
    public AndroidDriver<MobileElement> getAndroidDriver() {
        return androidDriver;
    }
    
    public static void RunAppInBackground(AndroidDriver<MobileElement> androidDriver) {
        try {
            androidDriver.runAppInBackground(Duration.ofSeconds(1));
        } catch (Exception e) {}
    }

    public static void moveToElement(AndroidDriver<MobileElement> androidDriver, WebElement a, WebElement b, WebElement c) {
        TouchAction action = new TouchAction(androidDriver);
        do {
            action.longPress(a).moveTo(b).release().perform();
        } while (!(c.isDisplayed()));
    }
    
    

}
