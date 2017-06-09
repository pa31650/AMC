package com.orasi.utils;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orasi.utils.TestEnvironment;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class TestTestEnvironment extends TestEnvironment {
    private String application = "application";
    private String browserUnderTest = "html";
    private String browserVersion = "1";
    private String operatingSystem = "windows";
    private String runLocation = "local";
    private String testingEnvironment = "stage";
    private String testingName = "TestEnvironment";
    private String pageURL = "http://orasi.github.io/Chameleon/sites/unitTests/orasi/core/interfaces/element.html";

    @BeforeTest
    public void setup() {
        setReportToMustard(false);
    }

    @Features("Utilities")
    @Stories("TestEnvironment")
    @Title("testEnviroment")
    @Test(groups = "regression")
    public void testEnviroment() {
        TestEnvironment te = new TestEnvironment();
        Assert.assertNotNull(te);
    }

    @Features("Utilities")
    @Stories("TestEnvironment")
    @Title("testEnviromentWithStringConstructor")
    @Test(groups = "regression")
    public void testEnviromentWithStringConstructor() {
        TestEnvironment te = new TestEnvironment(application, browserUnderTest, browserVersion, operatingSystem,
                runLocation, testingEnvironment);
        Assert.assertNotNull(te);
    }

    @Features("Utilities")
    @Stories("TestEnvironment")
    @Title("applicationUnderTest")
    @Test(groups = "regression")
    public void applicationUnderTest() {
        setApplicationUnderTest(application);
        Assert.assertTrue(getApplicationUnderTest().equals(application));
    }

    @Features("Utilities")
    @Stories("TestEnvironment")
    @Title("browserUnderTest")
    @Test(groups = "regression")
    public void browserUnderTest() {
        setBrowserUnderTest(browserUnderTest);
        Assert.assertTrue(getBrowserUnderTest().equals(browserUnderTest));
    }

    @Features("Utilities")
    @Stories("TestEnvironment")
    @Title("browserVersion")
    @Test(groups = "regression")
    public void browserVersion() {
        setBrowserVersion(browserVersion);
        Assert.assertTrue(getBrowserVersion().equals(browserVersion));
    }

    @Features("Utilities")
    @Stories("TestEnvironment")
    @Title("operatingSystem")
    @Test(groups = "regression")
    public void operatingSystem() {
        setOperatingSystem(operatingSystem);
        Assert.assertTrue(getOperatingSystem().equals(operatingSystem));
    }

    @Features("Utilities")
    @Stories("TestEnvironment")
    @Title("runLocation")
    @Test(groups = "regression")
    public void runLocation() {
        setRunLocation(runLocation);
        Assert.assertTrue(getRunLocation().equals(runLocation));
    }

    @Features("Utilities")
    @Stories("TestEnvironment")
    @Title("testEnvironment")
    @Test(groups = "regression")
    public void testEnvironment() {
        setTestEnvironment(testingEnvironment);
        Assert.assertTrue(getTestEnvironment().equals(testingEnvironment));
    }

    @Features("Utilities")
    @Stories("TestEnvironment")
    @Title("testName")
    @Test(groups = "regression")
    public void testName() {
        setTestName(testingName);
        Assert.assertTrue(getTestName().equals(testingName));
    }

    @Features("Utilities")
    @Stories("TestEnvironment")
    @Title("pageURL")
    @Test(groups = "regression")
    public void pageURL() {
        setPageURL(pageURL);
        Assert.assertTrue(getPageURL().equals(pageURL));
    }

    @Features("Utilities")
    @Stories("TestEnvironment")
    @Title("testStart")
    @Test(groups = "regression", dependsOnMethods = { "testEnvironment", "runLocation", "browserUnderTest", "operatingSystem" })
    public void testTestStart() {
        setPageURL(pageURL);
        testStart(testingName);
        Assert.assertTrue(getDriver().getTitle().equals("Unit test site"));

    }

}