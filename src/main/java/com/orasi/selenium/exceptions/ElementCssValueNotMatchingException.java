package com.orasi.selenium.exceptions;

import com.orasi.selenium.OrasiDriver;
import com.orasi.selenium.UIException;

public class ElementCssValueNotMatchingException extends UIException {
    private static final long serialVersionUID = 3407361723082329697L;

    public ElementCssValueNotMatchingException(String message) {
        super(message);
    }

    public ElementCssValueNotMatchingException(String message, OrasiDriver driver) {
        super(message, driver);
    }
}
