package com.orasi.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orasi.utils.debugging.Colors;
import com.orasi.utils.debugging.Highlight;
import com.orasi.utils.listeners.TestListener;

import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

@Listeners(TestListener.class)
public class sandbox extends TestEnvironment{
    //@FindBy(xpath="//div[@role='button'][text()='Done']", "Done") private Button btnDone;
        
        @BeforeMethod( alwaysRun=true)
       public void setup() {
            setPageURL("https://docs.google.com/forms/u/0/");
    		setApplicationUnderTest("Toyota");
    		setBrowserUnderTest("chrome");
    		setBrowserVersion("");
    		setOperatingSystem("windows 10");
    		setRunLocation("local");
    		setTestEnvironment("");
    		testStart("Sandbox");
    		getDriver().debug().setHighlightOnSync(true);
    		getDriver().debug().setReporterPrintToConsole(true);
    		getDriver().debug().setReporterLogLevel(TestReporter.INFO);
        }
        
        
      /*  @Test
        public void main(){
            getDriver().findTextbox(By.id("Email")).syncVisible();
            getDriver().findTextbox(By.id("Email")).setSecure("ZXB5b24zMTg1NDJAaG90bWFpbC5jb20=");
            getDriver().findButton(By.id("next")).click();
            

            getDriver().findTextbox(By.id("Passwd")).syncVisible();
            getDriver().findTextbox(By.id("Passwd")).setSecure("ZXB5b252ZWdldGE=");
            getDriver().findButton(By.id("signIn")).click();
            
            if( getDriver().findButton(By.xpath("//div[@role='button'][text()='Done']")).syncVisible(3,false)){
        	getDriver().findButton(By.xpath("//div[@role='button'][text()='Done']")).click();
            }
            
            getDriver().findElement(By.xpath("//img[@src='https://ssl.gstatic.com/docs/templates/thumbnails/forms-blank.png']")).syncVisible();            
            getDriver().findElement(By.xpath("//img[@src='https://ssl.gstatic.com/docs/templates/thumbnails/forms-blank.png']")).click();
            
            getDriver().findTextbox(By.xpath("//input[@aria-label='Document title']")).syncVisible();
            getDriver().findTextbox(By.xpath("//input[@aria-label='Document title']")).click();
            getDriver().findTextbox(By.xpath("//input[@aria-label='Document title']")).set("blah3");
            getDriver().findTextbox(By.xpath("//input[@aria-label='Document title']")).sendKeys(Keys.TAB);
            
            //validate textbox updated by checking the element it read from
            //getDriver().findTextbox(By.xpath("//*[contains(@class,'freebirdFormeditorViewHeaderTitleSizer')][text()='blah3']")).syncVisible();
            getDriver().findTextbox(By.xpath("//*[contains(@class,'quantumWizTextinputPapertextareaEl')]")).getText();
          //  TestReporter.logScreenshot(getDriver());
        }
        
*/        
        @Stories("Demo")
        @TestCaseId("1056")
        @Test
        public void main2(){
            TestReporter.assertTrue(false, "blah");
        }
        @AfterMethod
        public void cleanup(ITestContext testResults){
            endTest(testName, testResults);
        }
}