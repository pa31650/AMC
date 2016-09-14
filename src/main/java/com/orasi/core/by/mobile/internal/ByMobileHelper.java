package com.orasi.core.by.mobile.internal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.orasi.utils.OrasiDriver;

public class ByMobileHelper {

    protected static WebDriver jse = null;

    public ByMobileHelper(WebDriver jse) {
    	if (jse instanceof OrasiDriver) ByMobileHelper.jse = ((OrasiDriver) jse).getWebDriver();
    	else ByMobileHelper.jse = jse;
    }

    
    public static ByMobileResourceId resourceId(String resourceId) {
        return new ByMobileResourceId(resourceId);
    }
    


    public abstract static class BaseBy extends By {

        @SuppressWarnings("rawtypes")
		protected final void errorIfNull(Object o) {
            if (o == null || o instanceof List && ((List) o).size() == 0) {
                throw new NoSuchElementException(this + " didn't have any matching elements at this place in the DOM");
            }
        }

    }
}
