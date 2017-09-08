package com.amc;

import org.apache.poi.ss.formula.functions.Choose;
import org.openqa.selenium.WebElement;
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
import com.orasi.utils.TestReporter;
import com.orasi.utils.dataHelpers.creditCards.CreditCard;
import com.orasi.utils.dataHelpers.creditCards.CreditCards;
import com.orasi.utils.dataHelpers.personFactory.Email;
import com.orasi.utils.dataHelpers.personFactory.Person;
import com.orasi.utils.date.SimpleDate;
import java.util.List;

public class ConfirmPurchasePage {
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
	@FindBy(xpath="//input[@placeholder='Order Name']") private Textbox txtOrderName;
	@FindBy(xpath="//option[contains(text(),'Select Time')]/..") private Listbox lstDeliveryTimes;
			
	/**Constructor**/
	public ConfirmPurchasePage(OrasiDriver driver){
		this.driver = driver;
		ElementFactory.initElements(driver, this);
	}

	/**Page Interactions**/
	public void enterEmail(String strEmail){
		txtEmail.set(strEmail);
	}
	
	public void clickPurchaseButton(){
		btnPurchase.click();
	}

	public void enterCCInfo(CreditCard creditCard) {
		txtCCNumber.set(creditCard.getCardNumber());
		lstExpMonth.selectValue(creditCard.getExpireMonth());
		lstExpYear.selectValue(creditCard.getExpireYear());
		txtCVV.set(creditCard.getSecurityCode());
		txtZip.set(creditCard.getBillingZip());
		
	}
	
	public boolean errorExist(){
		return lblError.isDisplayed();
	}

	public void confirmPurchasePageComplete(String creditCard) {
    	Email email = new Email();
    	
    	String strEmailAddress = email.getEmail();
    	enterEmail(strEmailAddress);
    	
    	TestReporter.logStep(strEmailAddress + " was entered for email address.");
    	
    	//Enter Delivery Info
    	completeDeliveryInfo();
    	
    	// Enter payment info  	
    	enterCCInfo(CreditCards.getCreditCardByType(creditCard));
    	    	    	
    	//Click purchase
    	clickPurchaseButton();
		
	}
	
	public void completeDeliveryInfo(){
	    chooseEarliestDeliveryTime();
	    
	    enterOrderName();
	    	    	    
	}
	
	public void chooseEarliestDeliveryTime() { 
	    List<WebElement> options = lstDeliveryTimes.getOptions();
        
        lstDeliveryTimes.selectValue(options.get(1).getAttribute("value"));   
    }

    public void enterOrderName() {
	    Person person = new Person();
        
        txtOrderName.set(person.getFullName());
	}
}