package com.orasi.selenium.elements;

import com.orasi.selenium.elements.internal.ImplementedBy;
import com.orasi.selenium.web.webelements.WebLink;

/**
 * Interface that wraps a WebElement in Link functionality.
 */
@ImplementedBy(WebLink.class)
public interface Link extends Element {

    /**
     * @summary - Click the button using the default Selenium click
     */
    @Override
    public void click();

    /**
     * @summary - Click the link using a JavascriptExecutor click
     */
    @Override
    public void jsClick();

    public String getURL();
}