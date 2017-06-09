package com.orasi.selenium.exceptions;

import com.orasi.selenium.OrasiDriver;
import com.orasi.selenium.UIException;

public class TextInElementNotPresentException extends UIException {
    private static final long serialVersionUID = 3407361723082329697L;

    public TextInElementNotPresentException(String message) {
        super(message);
    }

    public TextInElementNotPresentException(String message, OrasiDriver driver) {
        super(message, driver);
    }
}
