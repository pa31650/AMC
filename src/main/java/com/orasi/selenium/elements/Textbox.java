package com.orasi.selenium.elements;

import com.orasi.selenium.elements.internal.ImplementedBy;
import com.orasi.selenium.web.webelements.WebTextbox;

/**
 * Text field functionality.
 */
@ImplementedBy(WebTextbox.class)
public interface Textbox extends Element {
    /**
     * @see org.openqa.selenium.WebElement#clear()
     */
    @Override
    public void clear();

    /**
     * @param text
     *            - The text to type into the field.
     */
    void set(String text);

    /**
     * @param text
     *            - The text to type into the field.
     */
    void scrollAndSet(String text);

    /**
     * @param text
     *            - The text to type into the field.
     */
    void safeSet(String text);

    /**
     * @param text
     *            - Encoded text to decode then type in the field
     */
    void setSecure(String text);

    /**
     * @param text
     *            - The text to type into the field.
     */
    void safeSetSecure(String text);

    /**
     * @see org.openqa.selenium.WebElement#getText()
     */
    @Override
    public String getText();

    void jsSet(String text);

}