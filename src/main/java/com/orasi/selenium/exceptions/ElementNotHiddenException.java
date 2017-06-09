package com.orasi.selenium.exceptions;

import com.orasi.selenium.OrasiDriver;
import com.orasi.selenium.UIException;

public class ElementNotHiddenException extends UIException {

    private static final long serialVersionUID = 1865273000586352087L;

    public ElementNotHiddenException(String message) {
        super(message);
    }

    public ElementNotHiddenException(String message, OrasiDriver driver) {
        super(message, driver);
    }
}
