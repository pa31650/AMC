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
import com.orasi.utils.date.SimpleDate;

public class SelectTicketType {
	private OrasiDriver driver = null;
	
	/**Page Elements**/
	@FindBy(xpath="//*[contains(text(),'Adult')]/parent::div/following-sibling::button") private Button btnAddAdultTicket;
	@FindBy(xpath="//button[contains(text(),'Continue')]") private Button btnContinue;
			
	/**Constructor**/
	public SelectTicketType(OrasiDriver driver){
		this.driver = driver;
		ElementFactory.initElements(driver, this);
	}

	/**Page Interactions**/
	public void AddAdultTicket() {
		btnAddAdultTicket.click();
			
	}
	
	public void AddAdultTickets(int intTickets){
		for (int i = 0; i < intTickets; i++) {
			AddAdultTicket();
		}
	}
	
	public void ClickContinueButton(){
		btnContinue.click();
	}
}