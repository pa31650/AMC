package com.orasi.selenium.elements;

import com.orasi.selenium.elements.internal.ImplementedBy;
import com.orasi.selenium.web.webelements.WebLabel;

/**
 * Interface that wraps a WebElement in Html form label functionality.
 */
@ImplementedBy(WebLabel.class)
public interface Label extends Element {
    /**
     * @summary - Gets the 'for' attribute on the label.
     *
     * @return string containing value of the 'for' attribute, null if empty.
     */
    String getFor();
}