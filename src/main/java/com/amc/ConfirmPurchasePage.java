package com.amc;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orasi.core.interfaces.Button;
import com.orasi.core.interfaces.Label;
import com.orasi.core.interfaces.Link;
import com.orasi.core.interfaces.Listbox;
import com.orasi.core.interfaces.Textbox;
import com.orasi.core.interfaces.impl.internal.ElementFactory;
import com.orasi.utils.OrasiDriver;
import com.orasi.utils.TestReporter;
import com.orasi.utils.dataHelpers.creditCards.CreditCard;
import com.orasi.utils.dataHelpers.creditCards.CreditCards;
import com.orasi.utils.dataHelpers.personFactory.Email;
import com.orasi.utils.dataHelpers.personFactory.Person;
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
	@FindBy(xpath="//span[contains(text(),'Add Gift Card')]") private Link lnkAddGiftCard;
	@FindBy(xpath="//input[@placeholder='Gift Card']") private Textbox txtGCNumber;
	@FindBy(xpath="//input[@placeholder='Pin']") private Textbox txtPin;
	@FindBy(xpath="//button[contains(text(),'Add Gift Card')]") private Button btnAddGiftCard;
	@FindBy(xpath="//a[contains(text(),'Sign In')]") private Button btnSignIn;
				
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
	    lblError.syncEnabled(5,true);
		return lblError.isDisplayed();
	}

	public void confirmPurchasePageComplete(String creditCard, String selectMeal) {
	    
	    switch (selectMeal.toLowerCase()) {
            case "yes":
                //Enter Delivery Info
                if (lstDeliveryTimes.syncVisible(5,false)) {
                    completeDeliveryInfo();
                } 
                break;

            case "no":
                break;
        }
        	    
	    Email email = new Email();
    	
    	String strEmailAddress = email.getEmail();    	
    	
    	// Enter payment info
    	switch (creditCard.toLowerCase()) {
            case "giftcard":
                enterEmail("Paul.Atkins@orasi.com");
                TestReporter.logStep("Paul.Atkins@orasi.com was entered for email address.");
                
                enterGCInfo(CreditCards.getCreditCardByType(creditCard));
                //Click purchase
                clickPurchaseButton();
                break;

            default:

                enterEmail(strEmailAddress);
                TestReporter.logStep(strEmailAddress + " was entered for email address.");
                
                enterCCInfo(CreditCards.getCreditCardByType(creditCard));
                clickPurchaseButton();
                break;
        }
    	  	    	
    	//Click purchase
    	//clickPurchaseButton();
		
	}
	
	private void enterGCInfo(CreditCard creditCard) {
	    lnkAddGiftCard.scrollIntoView();
	    lnkAddGiftCard.click();
	    txtGCNumber.set(creditCard.getCardNumber());
	    txtPin.set(creditCard.getSecurityCode());
	    clickAddGiftCard();
    }

    public void completeDeliveryInfo(){
	    chooseEarliestDeliveryTime();
	    
	    enterOrderName();
	    	    	    
	}
	
	public void chooseEarliestDeliveryTime() { 
	    List<WebElement> options = lstDeliveryTimes.getOptions();
        
        lstDeliveryTimes.selectValue(options.get(1).getAttribute("value")); 
        
        TestReporter.logStep("Option: " + options.get(1).getAttribute("value" + " was selected"));
    }

    public void enterOrderName() {
	    Person person = new Person();
        
        txtOrderName.set(person.getFullName());
        
        TestReporter.logStep("Name: " + person.getFullName() + " was entered for Order Name");
	}
    
    public void clickAddGiftCard() {
        btnAddGiftCard.scrollIntoView();
        btnAddGiftCard.click();
    }
}