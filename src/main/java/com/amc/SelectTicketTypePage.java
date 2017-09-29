package com.amc;

import org.openqa.selenium.support.FindBy;

import com.orasi.core.interfaces.Button;
import com.orasi.core.interfaces.Label;
import com.orasi.core.interfaces.Link;
import com.orasi.core.interfaces.impl.internal.ElementFactory;
import com.orasi.utils.OrasiDriver;
import com.orasi.utils.TestReporter;
import com.orasi.utils.TestEnvironment;

public class SelectTicketTypePage {
	private OrasiDriver driver = null;
	
	/**Page Elements**/
	@FindBy(xpath="//*[contains(text(),'Adult')]/parent::div/following-sibling::button") private Button btnAddAdultTicket;
	@FindBy(xpath="//button[contains(text(),'Continue')]") private Button btnContinue;
	@FindBy(xpath="//p[contains(text(), 'seat you requested is no longer available')]") private Label lblSeatUnavailable;
    @FindBy(xpath="//button[@aria-label='close']") private Link lnkCloseModal;
			
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
	
	public boolean IsSeatTaken() {
	    return lblSeatUnavailable.syncEnabled(5, false);
	}

	/**Test Functionality**/
	public boolean selectTicketTypeComplete(String tickets) {
		addAdultTickets(tickets);
    	TestReporter.logStep(tickets + " Adult Ticket was selected.");
    	
    	//Continue
    	ClickContinueButton();
    	
    	if (IsSeatTaken()) {
    	    do {
    	        TestReporter.logStep("Site reports that seat chosen is no longer available.");
    	        
    	        TestReporter.logStep("Close message window");
    	        lnkCloseModal.click();
                
    	        SelectSeatPage selectSeatPage = new SelectSeatPage(driver);
                
                TestReporter.logStep("Refresh page to get latest seat map.");
                driver.navigate().refresh();
                
                TestReporter.logStep("Retry selecting reserved seat(s)");
                selectSeatPage.selectSeatPageComplete(tickets);
                
                TestReporter.logStep("Retry selecting Adult ticket(s)");
                addAdultTickets(tickets);
                
                TestReporter.logStep("Retry clicking Continue button");
                ClickContinueButton();
                
            } while (IsSeatTaken());
        }
    	
    	
    	return IsSeatTaken();
	}
}