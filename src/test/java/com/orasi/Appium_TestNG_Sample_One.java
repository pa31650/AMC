package com.orasi;
		import org.testng.annotations.Test;
		import io.appium.java_client.MobileElement;
		import io.appium.java_client.android.AndroidDriver;
		import org.testng.annotations.BeforeMethod;
		import org.testng.annotations.Parameters;
		import java.io.File;
		import java.net.MalformedURLException;
		import java.net.URL;
		import java.util.concurrent.TimeUnit;
		import org.openqa.selenium.remote.CapabilityType;
		import org.openqa.selenium.remote.DesiredCapabilities;
		import org.testng.annotations.AfterMethod;
	public class Appium_TestNG_Sample_One {
		private static AndroidDriver<MobileElement> driver;
 
		@Test
		public void f() {
		}
 
		@Parameters({ "deviceName_","UDID_","platformVersion_", "URL_" })
		@BeforeMethod
		public void beforeMethod(String deviceName_,String UDID_,String platformVersion_,String URL_) throws MalformedURLException, InterruptedException {
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "/Apps/Amazon/");
			File app = new File(appDir, "in.amazon.mShop.android.shopping.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability("deviceName", deviceName_);
			capabilities.setCapability("udid", UDID_);
			capabilities.setCapability("platformVersion", platformVersion_);
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
			capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
			driver = new AndroidDriver<MobileElement>(new URL("http://"+URL_), capabilities);
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			Thread.sleep(10000);
		}
 
		@AfterMethod
		public void afterMethod() {
		}
}