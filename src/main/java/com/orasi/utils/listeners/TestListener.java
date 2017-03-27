package com.orasi.utils.listeners;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.internal.ConstructorOrMethod;
import org.testng.xml.XmlSuite;

import com.orasi.api.restServices.v1.VersionOne;
import com.orasi.api.soapServices.core.SoapService;
import com.orasi.utils.Constants;
import com.orasi.utils.OrasiDriver;
import com.orasi.utils.Preamble;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.orasi.utils.mustard.Mustard;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class TestListener extends TestListenerAdapter implements IReporter, IInvokedMethodListener2 {
    private OrasiDriver driver = null;
    private String runLocation = "";
    private String testEnvironment = "";
    private boolean reportToMustard = false;
    private void init(ITestResult result){

	Object currentClass = result.getInstance();
	reportToMustard = ((TestEnvironment) currentClass).isReportingToMustard();
	try{
	    runLocation = ((TestEnvironment) currentClass).getRunLocation().toLowerCase();	
	    testEnvironment = ((TestEnvironment) currentClass).getTestEnvironment().toLowerCase();	
	}catch (Exception e){}

	try{
	    driver = ((TestEnvironment) currentClass).getDriver();
	}catch (Exception e){}

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
	if(method.isTestMethod()){
	    init(testResult);		
	    String testId = "";
	    String[] stories;
	    String status = testResult.isSuccess() ? "Passed" : "Failed";
	    
	    TestCaseId testIdAnnotation = getTestCaseIdAnnotation(method);
	    if(testIdAnnotation != null){
		testId = testIdAnnotation.value();
	    }

	    Stories storiesAnnotation = getStoriesAnnotation(method);
	    if(storiesAnnotation != null){
		stories = storiesAnnotation.value();
	    }

	    VersionOne.data().test(testId).updateStatus(status);

	    if(!testResult.isSuccess() && driver != null){ 
		String slash = Constants.DIR_SEPARATOR;

		String destDir = Constants.SCREENSHOT_FOLDER + slash + testResult.getInstanceName().replace(".", slash);

		Reporter.setCurrentTestResult(testResult);

		WebDriver augmentDriver= driver.getWebDriver();
		if(!(augmentDriver instanceof HtmlUnitDriver)){
		    if (runLocation == "remote" ){
			augmentDriver = new Augmenter().augment(driver.getWebDriver());
		    }

		    new File(destDir).mkdirs();
		    DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ssaa");

		    String destFile = dateFormat.format(new Date()) + ".png";

		    //Capture a screenshot for TestNG reporting
		    TestReporter.logScreenshot(augmentDriver, destDir + slash + destFile, slash, runLocation);
		    //Capture a screenshot for Allure reporting
		    failedScreenshot(augmentDriver);
		}		
	    }

	    if(reportToMustard) Mustard.postResultsToMustard(driver, testResult, runLocation );
	}
    }

    @Override
    public void onTestFailure(ITestResult result) {
	    }

    @Override
    public void onTestSkipped(ITestResult result) {
	
    }

    @Override
    public void onTestSuccess(ITestResult result) {
	
    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites,
	    List<ISuite> suites, String outputDirectory) {
	// TODO Auto-generated method stub

    }

    @Attachment(type = "image/png")
    public static byte[] failedScreenshot(WebDriver driver) {
	return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private Preamble getPreambleAnnotation(IInvokedMethod method) {
	if (!method.isTestMethod()) {
	    return null;
	}
	ConstructorOrMethod com = method.getTestMethod().getConstructorOrMethod();
	if (com.getMethod() == null) {
	    return null;
	}
	Method  m = com.getMethod();
	Preamble annotation = m.getAnnotation(Preamble.class);
	return annotation;
    }

    private TestCaseId getTestCaseIdAnnotation(IInvokedMethod method) {
	if (!method.isTestMethod()) {
	    return null;
	}
	ConstructorOrMethod com = method.getTestMethod().getConstructorOrMethod();
	if (com.getMethod() == null) {
	    return null;
	}
	Method  m = com.getMethod();
	TestCaseId annotation = m.getAnnotation(TestCaseId.class);
	return annotation;
    }


    private Stories getStoriesAnnotation(IInvokedMethod method) {
	if (!method.isTestMethod()) {
	    return null;
	}
	ConstructorOrMethod com = method.getTestMethod().getConstructorOrMethod();
	if (com.getMethod() == null) {
	    return null;
	}
	Method  m = com.getMethod();
	Stories annotation = m.getAnnotation(Stories.class);
	return annotation;
    }

    @Override
    public void beforeInvocation(IInvokedMethod method,
	    ITestResult testResult) {
	// TODO Auto-generated method stub

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
	Preamble preamble = getPreambleAnnotation(method);
	if (preamble != null) {
	    System.out.println(preamble.author());
	    System.out.println(preamble.summary());
	    System.out.println(preamble.testId());
	}
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult,
	    ITestContext context) {
	// TODO Auto-generated method stub

    }
}
