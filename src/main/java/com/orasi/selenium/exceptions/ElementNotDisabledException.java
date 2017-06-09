package com.orasi.selenium.exceptions;

import com.orasi.selenium.OrasiDriver;
import com.orasi.selenium.UIException;

public class ElementNotDisabledException extends UIException {
    private static final long serialVersionUID = 624614577584686540L;

    public ElementNotDisabledException(String message) {
        super(message);
    }

    public ElementNotDisabledException(String message, OrasiDriver driver) {
        super(message, driver);
    }
}
