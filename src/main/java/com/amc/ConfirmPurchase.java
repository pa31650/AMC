package com.amc;

import org.openqa.selenium.support.FindBy;

import com.orasi.core.interfaces.Button;
import com.orasi.core.interfaces.Element;
import com.orasi.core.interfaces.Label;
import com.orasi.core.interfaces.Link;
import com.orasi.core.interfaces.Listbox;
import com.orasi.core.interfaces.Textbox;
import com.orasi.core.interfaces.Webtable;
import com.orasi.core.interfaces.impl.internal.ElementFactory;
import com.orasi.utils.OrasiDriver;
import com.orasi.utils.PageLoaded;
import com.orasi.utils.dataHelpers.creditCards.CreditCard;
import com.orasi.utils.date.SimpleDate;

import groovyjarjarantlr.collections.List;

public class ConfirmPurchase {
	private OrasiDriver driver = null;
	
	/**Page Elements**/
	@FindBy(xpath="//input[@type='email']") private Textbox txtEmail;
	@FindBy(xpath="//input[@placeholder='Credit Card Number']") private Textbox txtCCNumber;
	@FindBy(xpath="//div[contains(text(),'Exp. Month')]/parent::div/child::select") private Listbox lstExpMonth;
	@FindBy(xpath="//div[contains(text(),'Exp. Year')]/parent::div/child::select") private Listbox lstExpYear;
	@FindBy(xpath="//input[@placeholder='CVV']") private Textbox txtCVV;
	@FindBy(xpath="//input[@placeholder='Zip']") private Textbox txtZip;
	@FindBy(xpath="//button[contains(text(),'Purchase')]") private Button btnPurchase;
	@FindBy(xpath="//h4[contains(text(),'Error')]") private Label lblError;
			
	/**Constructor**/
	public ConfirmPurchase(OrasiDriver driver){
		this.driver = driver;
		ElementFactory.initElements(driver, this);
	}

	/**Page Interactions**/
	public void EnterEmail(String strEmail){
		txtEmail.set(strEmail);
	}
	
	/*public void EnterCCInfo(String strCCNumber,String strExpMonth,String strExpYear,String strCVV,String strZip){
		txtCCNumber.set(strCCNumber);
		lstExpMonth.selectValue(strExpMonth);
		lstExpYear.selectValue(strExpYear);
		txtCVV.set(strCVV);
		txtZip.set(strZip);
	}*/
	
	public void ClickPurchaseButton(){
		btnPurchase.click();
	}

	public void EnterCCInfo(CreditCard creditCard) {
		txtCCNumber.set(creditCard.getCardNumber());
		lstExpMonth.selectValue(creditCard.getExpireMonth());
		lstExpYear.selectValue(creditCard.getExpireYear());
		txtCVV.set(creditCard.getSecurityCode());
		txtZip.set(creditCard.getBillingZip());
		
	}
	
	public boolean ErrorExist(){
		return lblError.isDisplayed();
	}
}