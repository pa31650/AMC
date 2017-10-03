package com.orasi.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.orasi.exception.AutomationException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Android {
    
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
    
    public static void RunAppInBackground(AndroidDriver<MobileElement> driver) {
        try {
            driver.runAppInBackground(Duration.ofSeconds(1));
        } catch (Exception e) {}
    }

    public static void moveToElement(AndroidDriver<MobileElement> driver, WebElement a, WebElement b, WebElement c) {
        TouchAction action = new TouchAction(driver);
        do {
            action.longPress(a).moveTo(b).release().perform();
        } while (!(c.isDisplayed()));
    }
    
    
    
    public static void mobileDriverSetupApp() throws MalformedURLException{
        //Create object of DesiredCapabilities class
        DesiredCapabilities cap = new DesiredCapabilities();

        //Set android platformName desired capability
        cap.setCapability("platformName", "ANDROID");

        //Set android browserName desired capability
        cap.setCapability("browserName", "Samsung Galaxy S8+");

        //Set android version desired capability
        cap.setCapability("version", "5.1");

        //Set android applicationName desired capability
        cap.setCapability("applicationName", "Samsung Galaxy S8+");

        //Set android device name desired capability
        cap.setCapability("deviceName", "T01130JFGT");

        //Set android appPackage desired capability
        cap.setCapability("appPackage", "com.amc");

        //Set android appActivity desired capability
        cap.setCapability("appActivity", "md5170375cde9c41ccb2cf27dba032a5216.SplashActivity");

        //Created object of AndroidDriver will all set capabilities
        //Set appium server address and port number
        //Launches AMC Theatres app
        //androidDriver = new AndroidDriver<MobileElement>(new URL(getRemoteURL()), cap);
        try {
            //androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } catch (WebDriverException e) {
            System.out.println("The app failed to open");
        }
    }
}
