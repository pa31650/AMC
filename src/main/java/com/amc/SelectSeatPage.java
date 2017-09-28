package com.amc;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.orasi.core.interfaces.Button;
import com.orasi.core.interfaces.Checkbox;
import com.orasi.core.interfaces.Element;
import com.orasi.core.interfaces.Label;
import com.orasi.core.interfaces.Link;
import com.orasi.core.interfaces.impl.internal.ElementFactory;
import com.orasi.utils.OrasiDriver;
import com.orasi.utils.TestReporter;

public class SelectSeatPage {
	String strBestSeat = "A3";
	
	private OrasiDriver driver = null;

	/**Page Elements**/
	@FindBy(xpath="//button[contains(text(),'Continue')]") private Button btnContinue;
		
	/**Constructor**/
	public SelectSeatPage(OrasiDriver driver){
		this.driver = driver;
		ElementFactory.initElements(driver, this);
	}

	/**Page Interactions**/
	public void btnContinue(){
		btnContinue.click();
	}
	public void chooseOpenSeats(Integer intSeats){
		List<String> seats = findOpenSeats(intSeats);
		
		for (String seat : seats) {
			String xpathExpression = "//span[contains(text(),'" + seat + "')]";
			Element elmSeat = driver.findElement(By.xpath(xpathExpression));
			elmSeat.click();
			TestReporter.logStep("Seat " + seat + " was selected.");
		}	
		TestReporter.logStep(intSeats + " seat(s) were selected.");
	}
	
	public List<String> findOpenSeats(int intSeats){
		List<String> seats = new ArrayList<String>();
		String strSeat = strBestSeat;
		
		for (int i = 0; i < intSeats; i++) {
			String openSeat = findOpenSeat(strSeat);
			
			seats.add(openSeat);
			strSeat = moveNextSeat(openSeat);
		}
		return seats;
	}
	
	public String findOpenSeat(String startSeat){
		String strSeat = startSeat;
		
		while (!isSeatOpen(strSeat)) {
			strSeat = moveNextSeat(strSeat);
		}
		
		return strSeat;
	}
	
	public boolean isSeatOpen(String strSeat){
		//Check attributes of Seat passed in
		String xpathExpression = "//*[contains(@aria-label,'Available')]//span[contains(text(),'" + strSeat + "')]";
		Checkbox chkSeat = driver.findCheckbox(By.xpath(xpathExpression));
		
		return chkSeat.syncVisible(1,false);
	}
	
	public boolean isSeat(String strSeat){
		String xpathExpression = "//span[contains(text(),'" + strSeat + "')]";
		Element elmSeat = driver.findElement(By.xpath(xpathExpression));
		
		return elmSeat.syncVisible(1,false);
	}
	
	public boolean isSeatSelected(String strSeat){
		String xpathExpression = "//*[contains(@class,'is-selected')]//span[contains(text(),'" + strSeat + "')]";
		Checkbox chkSeat = driver.findCheckbox(By.xpath(xpathExpression));
		
		return chkSeat.syncVisible(1,false);
	}
	
	public String moveNextSeat(String strSeat){
		
		//Split seat
		String strSeatRow = String.valueOf(strSeat.charAt(0));//fix this it's not getting C only C4
		String strSeatNumber = strSeat.substring(1);

		//Convert number to int
		int seatnumber = Integer.parseInt(strSeatNumber);
		
		//Add 1 to int
		seatnumber = seatnumber + 1;
		
		//Convert back to string
		strSeatNumber = String.valueOf(seatnumber);
		
		//UnSplit
		strSeat = strSeatRow + strSeatNumber;
		
		//Verify the seat is valid
		while (!isSeat(strSeat)) {
			char value = strSeatRow.charAt(0);
			int nextValue = (int)value + 1; // find the int value plus 1
			
			char x = (char)nextValue;
			strSeatRow = String.valueOf(x);
			strSeatNumber = "1";
			strSeat =  strSeatRow + strSeatNumber;
		}
		
		return strSeat;
	}
	
	public void selectSeatPageComplete(String tickets) {
	    
        Integer intSeats = Integer.valueOf(tickets);
    
        chooseOpenSeats(intSeats);
    
        btnContinue();
	    
	}
	
    	
	
}