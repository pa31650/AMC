package com.orasi.core.by.mobile;
import org.openqa.selenium.WebElement;

import java.util.List;

	public interface FindsByMobileResourceId {
	  WebElement findElementByMobileResourceId(String using);
	  List<WebElement> findElementsByMobileResourceId(String using);
	}

