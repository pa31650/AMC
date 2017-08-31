package com.amc;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;

import org.apache.commons.collections.functors.ForClosure;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.orasi.core.interfaces.Button;
import com.orasi.core.interfaces.Checkbox;
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

public class SelectSeatPage {
	String strBestSeat = "C4";
	
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
		}	
	}
	
	public List findOpenSeats(int intSeats){
		List<String> seats = new ArrayList();
		String strSeat = strBestSeat;
		
		for (int i = 0; i < intSeats; i++) {
			String openSeat = findOpenSeat(strSeat);
			
			seats.add(openSeat);
			strSeat = moveNextSeat(strSeat);
		}
		return seats;
	}
	
	public String findOpenSeat(String startSeat){
		String strSeat = startSeat;
		
		while (!isSeatOpen(strSeat)) {
			moveNextSeat(strSeat);
		}
		
		return strSeat;
	}
	
	public boolean isSeatOpen(String strSeat){
		//Check attributes of Seat passed in
		String xpathExpression = "//*[contains(@aria-label,'Available')]//span[contains(text(),'" + strSeat + "')]";
		Checkbox chkSeat = driver.findCheckbox(By.xpath(xpathExpression));
		
		return chkSeat.isEnabled();
	}
	
	public boolean isSeat(String strSeat){
		String xpathExpression = "//span[contains(text(),'" + strSeat + "')]";
		Element elmSeat = driver.findElement(By.xpath(xpathExpression));
		
		return elmSeat.isEnabled();
	}
	
	public boolean isSeatSelected(String strSeat){
		String xpathExpression = "//*[contains(@class,'is-selected')]//span[contains(text(),'" + strSeat + "')]";
		Checkbox chkSeat = driver.findCheckbox(By.xpath(xpathExpression));
		
		return chkSeat.isEnabled();
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
			strSeatRow = String.valueOf(nextValue);
			strSeat =  strSeatRow + strSeatNumber;
		}
		
		return strSeat;
	}
}