package src.main.resources;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AMCTests {

    private AndroidDriver<MobileElement> driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

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
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4725/wd/hub"), cap);
        try {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } catch (WebDriverException e) {
            System.out.println("The app failed to open");
        }
    }

    @AfterMethod
    public void End() {
        driver.quit();
    }

    public AndroidDriver<MobileElement> getDriver() {
        return driver;
    }

    public void RunAppInBackground(AndroidDriver<MobileElement> driver) {
        try {
            driver.runAppInBackground(Duration.ofSeconds(1));
        } catch (Exception e) {}
    }
}
