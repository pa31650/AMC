package com.amc;

import org.openqa.selenium.support.FindBy;

import com.orasi.core.interfaces.Button;
import com.orasi.core.interfaces.Element;
import com.orasi.core.interfaces.Label;
import com.orasi.core.interfaces.Link;
import com.orasi.core.interfaces.Textbox;
import com.orasi.core.interfaces.Webtable;
import com.orasi.core.interfaces.impl.internal.ElementFactory;
import com.orasi.utils.OrasiDriver;
import com.orasi.utils.PageLoaded;

public class HomePage {
	private OrasiDriver driver = null;
	
	/**Page Elements**/
	//@FindBy(xpath="//*[@class='PosterContent']//*[text()='" + getMovieTitle() + "']/following::a[1]") private Button btnGetTickets;
	@FindBy(xpath="//a[@href='/showtimes']") private Link lnkShowtimes;
	
	/**Constructor**/
	public HomePage(OrasiDriver driver){
		this.driver = driver;
		ElementFactory.initElements(driver, this);
	}

	/**Page Interactions**/
	/*public void GetTickets(){
		btnGetTickets.click();
	}*/
	public void clickShowtimes(){
		lnkShowtimes.click();
	}
}