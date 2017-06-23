package com.orasi.selenium.web.interfaces;

import com.orasi.selenium.web.interfaces.impl.LabelImpl;
import com.orasi.selenium.web.interfaces.impl.internal.ImplementedBy;

/**
 * Interface that wraps a WebElement in Html form label functionality.
 */
@ImplementedBy(LabelImpl.class)
public interface Label extends Element {
    /**
     * @summary - Gets the 'for' attribute on the label.
     *
     * @return string containing value of the 'for' attribute, null if empty.
     */
    String getFor();
}