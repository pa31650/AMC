package com.amc;

import org.openqa.selenium.support.FindBy;

import com.orasi.core.interfaces.Label;
import com.orasi.core.interfaces.impl.internal.ElementFactory;
import com.orasi.utils.OrasiDriver;
import com.orasi.utils.TestReporter;

public class ThankYou {
	private OrasiDriver driver = null;
	
	/**Page Elements**/
	@FindBy(xpath="//h6[@aria-labelledby='Checkout']") Label lblThankYou;
	@FindBy(xpath="//div[@class='media-body']") Label lblMovieInfo;
		
	/**Constructor**/
	public ThankYou(OrasiDriver driver){
		this.driver = driver;
		ElementFactory.initElements(driver, this);
	}

	/**Page Interactions**/
	public boolean verifyThankYou() {
	    return lblThankYou.isDisplayed();
	}
	
	public void reportThankYouPage() {
	    TestReporter.logStep(lblMovieInfo.getText());
	}
	
}