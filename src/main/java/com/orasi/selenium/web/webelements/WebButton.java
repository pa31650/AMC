package com.orasi.selenium.web.webelements;

import static com.orasi.utils.TestReporter.interfaceLog;
import static com.orasi.utils.TestReporter.logFailure;
import static com.orasi.utils.TestReporter.logTrace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.orasi.AutomationException;
import com.orasi.selenium.OrasiDriver;
import com.orasi.selenium.elements.Button;
import com.orasi.selenium.web.by.angular.ByNG;

/**
 * Wraps a label on a html form with some behavior.
 */
public class WebButton extends Webelement implements Button {
    // private java.util.Date date= new java.util.Date();
    /**
     * Creates a Element for a given WebElement.
     *
     * @param element
     *            - element to wrap up
     */
    public WebButton(WebElement element) {
        super(element);

    }

    public WebButton(OrasiDriver driver, By by) {
        super(driver, by);
        // element = driver.findWebElement(by);
    }

    public WebButton(OrasiDriver driver, ByNG by) {
        super(driver, by);
        // element = driver.findWebElement(by);
    }

    @Override
    public void click() {
        logTrace("Entering ButtonImpl#click");
        try {
            logTrace("Attempting to invoke method [ Click ] on element [ " + by.toString() + " ] ");
            getWrappedElement().click();
        } catch (RuntimeException rte) {
            interfaceLog("Clicked Button [ <b>" + getElementLocatorInfo() + "</b>]", true);
            throw rte;
        }

        interfaceLog("Clicked Button [ <b>" + getElementLocatorInfo() + "</b>]");
        logTrace("Successfully invoked method [ Click ] on element [ " + by.toString() + " ] ");
        logTrace("Exiting ButtonImpl#click");
    }

    @Override
    public void jsClick() {
        logTrace("Entering ButtonImpl#jsClick");
        try {
            logTrace("Attempting to executed [ jsClick ] on element [ " + by.toString() + " ] ");
            getWrappedDriver().executeJavaScript("arguments[0].click();", getWrappedElement());
            logTrace("Successfully executed [ jsClick ] on element [ " + by.toString() + " ] ");
        } catch (RuntimeException rte) {
            logFailure("Clicked Button [ <b>" + getElementLocatorInfo() + "</b>]");
            logTrace("Failed to execute [ jsClick ] on element [ " + by.toString() + " ] ");
            logTrace("Exiting ButtonImpl#jsClick");
            throw new AutomationException(rte.getMessage(), driver);
        }
        interfaceLog("Clicked Button [ <b>" + getElementLocatorInfo() + "</b>]");
        logTrace("Exiting ButtonImpl#jsClick");

    }
}