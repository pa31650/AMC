package com.amc;

import org.openqa.selenium.support.FindBy;

import com.orasi.core.interfaces.Button;
import com.orasi.core.interfaces.Label;
import com.orasi.core.interfaces.Listbox;
import com.orasi.core.interfaces.Textbox;
import com.orasi.core.interfaces.impl.internal.ElementFactory;
import com.orasi.utils.OrasiDriver;
import com.orasi.utils.PageLoaded;
import com.orasi.utils.TestReporter;
import com.orasi.utils.date.DateTimeConversion;

public class ShowtimesPage {
	private OrasiDriver driver = null;
	
	/**Page Elements**/
	@FindBy(xpath="//option[contains(@value,'another')]/..") private Listbox lstTheatreDropdown;
	@FindBy(xpath="//input") private Textbox txtTheatreSearch;
	@FindBy(xpath="//button[contains(text(),'Search')]") private Button btnTheatreSearch;
	@FindBy(xpath="//button[contains(text(),'Select')]") private Button btnTheatreSelect;
	@FindBy(xpath="//option[contains(text(),'Today')]/..") private Listbox lstDate;
	@FindBy(xpath="//option[@value='all']/..") private Listbox lstMovies;
	@FindBy(xpath="//*[contains(@class,'Theatre-Wrapper-First')]//div[@class='Showtime'][1]//a[@class='Btn Btn--default']") private Button btnFirstShowtime;
	@FindBy(xpath="//*[contains(@class,'Theatre-Wrapper-First')][1]//div[contains(@class,'Showtimes-Section-First')][1]//div[contains(text(),'Reserved Seating')]") private Label lblReservedSeating;
		
	/**Constructor**/
	public ShowtimesPage(OrasiDriver driver){
		this.driver = driver;
		ElementFactory.initElements(driver, this);
	}

	/**Page Interactions**/
	public void selectTheatre(String strTheatre){
		lstTheatreDropdown.syncVisible(3);
		
		for(int i=0;i<=2;i++){
		
			try{
				lstTheatreDropdown.select(strTheatre);
				break;
			}
			catch(Exception e){
				TestReporter.logInfo(e.getMessage());
			}
		}				
	}
	
	public void findAnotherTheatre(){
		selectTheatre("Find Another Theatre...");
	}
	
	public void theatreSearch(String strSearch){
		findAnotherTheatre();
		
		PageLoaded.isDomComplete(driver);
		
		txtTheatreSearch.syncVisible(3);
		txtTheatreSearch.set(strSearch);
		
		btnTheatreSearch.syncVisible(3);
		btnTheatreSearch.click();
		
		btnTheatreSelect.syncVisible(3);
		btnTheatreSelect.click();
		
		selectTheatre(strSearch);
	}
		
	public void findGSOTheatre(){
		findAnotherTheatre();
		theatreSearch("27409");	
	}
	
	public void chooseDay(String strDay){
		
		switch (strDay.toUpperCase()) {
		case "TODAY":
			lstDate.select("Today");
			break;
		case "TOMORROW":
			strDay = DateTimeConversion.getDaysOut("1", "yyyy-MM-dd");
			lstDate.selectValue(strDay);
			break;
		default:
			lstDate.selectValue(strDay);
			break;
		}
		
	}

	public void chooseFirstShowing() {
		btnFirstShowtime.click();
		
	}

	public void chooseMovie(String movieTitle) {
		lstMovies.syncVisible(3);
		for(int i=0;i<=2;i++){
		
			try{
				lstMovies.select(movieTitle);
				break;
			}
			catch(Exception e){
				TestReporter.logInfo(e.getMessage());
			}
		}		
	}

	public boolean isReservedSeatingAvail() {
		
		return lblReservedSeating.syncVisible(null,false);
	}
	
	/**Test Functionality**/
	public void showtimesComplete(String theatre,String movieTitle,String date){
		theatreSearch(theatre);
    	
    	TestReporter.log("Theatre: " + theatre + " was selected.");
    	    	
    	//Choose Movie
    	chooseMovie(movieTitle);
    	TestReporter.logStep("Movie Title: " + movieTitle + " was selected.");
    	
    	//Choose Day - "Today" or "YYYY-MM-DD"
    	chooseDay(date);
    	TestReporter.logStep("Date: " + date + " was selected.");
    	
	}
	
}