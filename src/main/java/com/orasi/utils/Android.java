package com.orasi.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.orasi.exception.AutomationException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Android extends TestEnvironment{
    
    private AndroidDriver<MobileElement> androidDriver;
    protected ResourceBundle appURLRepository = ResourceBundle.getBundle(Constants.ENVIRONMENT_URL_PATH);
    protected String mobileHubURL = appURLRepository.getString("MOBILE_HUB_URL");
    
    public AndroidDriver<MobileElement> getAndroidDriver() {
        return androidDriver;
    }
    
    public void setup(DesiredCapabilities caps){
        try {
            new AndroidDriver<MobileElement>(new URL(mobileHubURL), caps);
        } catch (MalformedURLException e) {
            throw new AutomationException("Could not generate the moblile remote driver", e);
        }
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
