package com.orasi.selenium.elements;

import com.orasi.selenium.elements.internal.ImplementedBy;
import com.orasi.selenium.web.webelements.WebButton;

/**
 * Interface that wraps a WebElement in Button functionality.
 */
@ImplementedBy(WebButton.class)
public interface Button extends Element {
    /**
     * @summary - Click the button using the default Selenium click
     */
    @Override
    public void click();

    /**
     * @summary - Click the button using a JavascriptExecutor click
     * @param driver
     *            - Current active WebDriver object
     */
    @Override
    public void jsClick();

}