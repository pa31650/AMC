package com.orasi.selenium.exceptions;

import com.orasi.selenium.OrasiDriver;
import com.orasi.selenium.UIException;

public class ElementAttributeValueNotMatchingException extends UIException {
    private static final long serialVersionUID = 3407361723082329697L;

    public ElementAttributeValueNotMatchingException(String message) {
        super(message);
    }

    public ElementAttributeValueNotMatchingException(String message, OrasiDriver driver) {
        super(message, driver);
    }
}
