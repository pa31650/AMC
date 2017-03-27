package com.orasi.exception.automation;

import com.orasi.exception.AutomationException;
import com.orasi.utils.OrasiDriver;

public class ElementNotPresentException extends AutomationException{

    private static final long serialVersionUID = 1865273000586352087L;

    public ElementNotPresentException(String message){
	super(message );
    }

    public ElementNotPresentException(String message, OrasiDriver driver){
	super(message, driver );
    }
}
