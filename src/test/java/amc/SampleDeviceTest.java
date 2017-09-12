package src.test.java.amc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SampleDeviceTest {
    private AppiumDriver<MobileElement> driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        //Create object of DesiredCapabilities class
        DesiredCapabilities cap = new DesiredCapabilities();

        //Set android platformName desired capability
        cap.setCapability("platformName", "ANDROID");

        //Set android browserName desired capability
        cap.setCapability("browserName", "Samsung Galaxy S8+");

        //Set android version desired capability
        cap.setCapability("version", "7.0");

        //Set android applicationName desired capability
        cap.setCapability("applicationName", "Samsung Galaxy S8+");

        //Set android device name desired capability
        cap.setCapability("deviceName", "988a5b313834344c53");

        //Set android appPackage desired capability
        cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");

        //Set android appActivity desired capability
        cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

        //Created object of AndroidDriver will all set capabilities
        //Set appium server address and port number
        //Launches calculator app
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4725/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void Sum() {
        //Click on DELETE/CLR button to clear result text box before running test
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_clear")).click();

        //Click on number 2 button
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_02")).click();

        //Click on + button
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();;

        //Click on number 5 button
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_05")).click();

        //Click on = button
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();;

        //Get result from result text box
        String result = driver.findElement(By.className("android.widget.EditText")).getText();

        try {
            Assert.assertEquals(result, "7");
            System.out.println("The expected result is correct.");
        } catch (AssertionError e) {
            System.out.println("The expected result is incorrect.");
        }
    }

    @AfterMethod
    public void End() {
        driver.quit();
    }
}
