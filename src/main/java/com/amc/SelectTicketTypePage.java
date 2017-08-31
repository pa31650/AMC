package com.amc;

import org.openqa.selenium.support.FindBy;

import com.orasi.core.interfaces.Button;
import com.orasi.core.interfaces.impl.internal.ElementFactory;
import com.orasi.utils.OrasiDriver;
import com.orasi.utils.TestReporter;

public class SelectTicketTypePage {
	private OrasiDriver driver = null;
	
	/**Page Elements**/
	@FindBy(xpath="//*[contains(text(),'Adult')]/parent::div/following-sibling::button") private Button btnAddAdultTicket;
	@FindBy(xpath="//button[contains(text(),'Continue')]") private Button btnContinue;
			
	/**Constructor**/
	public SelectTicketTypePage(OrasiDriver driver){
		this.driver = driver;
		ElementFactory.initElements(driver, this);
	}

	/**Page Interactions**/
	public void addAdultTicket() {
		btnAddAdultTicket.click();
			
	}
	
	public void addAdultTickets(String tickets){
		int intTickets = Integer.valueOf(tickets);
		
		for (int i = 0; i < intTickets; i++) {
			addAdultTicket();
		}
	}
	
	public void ClickContinueButton(){
		btnContinue.click();
	}

	/**Test Functionality**/
	public void selectTicketTypeComplete(String tickets) {
		addAdultTickets(tickets);
    	TestReporter.logStep(tickets + " Adult Ticket was selected.");
    	
    	//Continue
    	ClickContinueButton();
		
	}
}