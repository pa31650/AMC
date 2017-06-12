package com.orasi.selenium.web.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.orasi.selenium.OrasiDriver;
import com.orasi.selenium.elements.Label;

/**
 * Wraps a label on a html form with some behavior.
 */
public class WebLabel extends Webelement implements Label {
    /**
     * Creates an Element for a given WebElement.
     *
     * @param element
     *            element to wrap up
     */
    public WebLabel(WebElement element) {
        super(element);
    }

    public WebLabel(OrasiDriver driver, By by) {
        super(driver, by);
        // element = driver.findWebElement(by);
    }

    @Override
    public String getFor() {
        return getWrappedElement().getAttribute("for");
    }
}