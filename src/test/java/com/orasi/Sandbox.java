package com.orasi;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Sandbox {

    
    private AndroidDriver<MobileElement> driver;
    
    @Test
    public void test(){
        List<MobileElement> theatres = driver.findElements(By.xpath("//div[contains(@class,'TheatreFinder-theatre--mobile')]//div[contains(@class,'TheatreInfo')]//h4"));
        for (MobileElement theatre : theatres) {
           theatre.getAttribute("value");
            
        }
    }
    public void setUp() throws MalformedURLException {
            
            //Create object of DesiredCapabilities class
            DesiredCapabilities cap = new DesiredCapabilities();
            
            //Set android platformName desired capability
            cap.setCapability("platformName", "ANDROID");
            
            //Set android browserName desired capability
            cap.setCapability("browserName", "chrome");
            
            //Set android version desired capability
            cap.setCapability("version", "5.1");
                        
            //Set android device name desired capability
            cap.setCapability("deviceName", "T01130JFGT");
            
            driver = new AndroidDriver<MobileElement>(new URL("http://192.168.227.2:4444/wd/hub"), cap);
            try {
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            } catch (WebDriverException e) {
                System.out.println("The app failed to open");
            }
        }
    }