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
        cap.setCapability("browserName", "Motorola Moto X");

        //Set android version desired capability
        cap.setCapability("version", "5.1");

        //Set android applicationName desired capability
        cap.setCapability("applicationName", "Motorola Moto X");

        //Set android device name desired capability
        cap.setCapability("deviceName", "T01130JFGT");

        //Set android appPackage desired capability
        cap.setCapability("appPackage", "com.android.calculator2");

        //Set android appActivity desired capability
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");

        //Created object of AndroidDriver will all set capabilities
        //Set appium server address and port number
        //Launches calculator app
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4725/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void Sum() {
        //Click on DELETE/CLR button to clear result text box before running test
        //driver.findElement(By.id("com.android.calculator2:id/bt_clear")).click();

        //Click on number 2 button
        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();

        //Click on + button
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();;

        //Click on number 5 button
        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();

        //Click on = button
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();;

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
