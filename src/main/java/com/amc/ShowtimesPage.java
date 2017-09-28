package com.amc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	@FindBy(xpath="//input[contains(@class,'TheatreSearchField-input')]") private Textbox txtTheatreSearch;
	@FindBy(xpath="//button[contains(text(),'Search')]") private Button btnTheatreSearch;
	@FindBy(xpath="//button[contains(text(),'Select')]") private Button btnTheatreSelect;
	@FindBy(xpath="//option[contains(text(),'Today')]/..") private Listbox lstDate;
	@FindBy(xpath="//option[@value='all']/..") private Listbox lstMovies;
	@FindBy(xpath="//*[contains(@class,'Theatre-Wrapper-First')]//div[@class='Showtime'][1]//a[@class='Btn Btn--default']") private Button btnFirstShowtime;
	@FindBy(xpath="//*[contains(@class,'Theatre-Wrapper-First')][1]//div[contains(@class,'Showtimes-Section-First')][1]//div[contains(text(),'Reserved Seating')]") private Label lblReservedSeating;
	@FindBy(xpath="//*[contains(@class,'No-Showtimes-First')]//p") private Label lblNoShowtimes;
	@FindBy(xpath="//i[contains(@alt,'Submit Search')]") private Button btnAltSearch;
		
	/**Constructor**/
	public ShowtimesPage(OrasiDriver driver){
		this.driver = driver;
		ElementFactory.initElements(driver, this);
	}

	/**Page Interactions**/
	public void selectTheatre(String strTheatre){
	    PageLoaded.isDomComplete(driver);
		
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
	    PageLoaded.isDomComplete(driver);
	    
		selectTheatre("Find Another Theatre...");
		TestReporter.logStep("Find Another Theatre... was selected.");
	}
	
	public void theatreSearch(String strSearch){
	    PageLoaded.isDomComplete(driver);
		findAnotherTheatre();
		
		PageLoaded.isDomComplete(driver);
		
		txtTheatreSearch.syncVisible(10);
		txtTheatreSearch.set(strSearch);
		TestReporter.logStep(strSearch + " was entered into the search box.");
		
		if (btnTheatreSearch.syncVisible(5,false)) {
		    btnTheatreSearch.click();
        } else {
            btnAltSearch.click();
        }
			
		if (btnTheatreSelect.syncVisible(5,false)) {
		    btnTheatreSelect.click();
        } else {
            //Get a list of theatre names displayed
            List<WebElement> theatres = driver.findWebElements(By.xpath("//div[contains(@class,'TheatreFinder-theatre--mobile')]//div[contains(@class,'TheatreInfo')]//h4"));
            for (WebElement theatre : theatres) {
                //Iterate through them and match lcase with strtheatre
                //new String(theatre.getText().toLowerCase()).equals(strSearch.toLowerCase());
                if (new String(theatre.getText().toLowerCase()).equals(strSearch.toLowerCase())) {
                    //click matching one
                    theatre.click();
                    break;
                } 
            }
        }
				
		//selectTheatre(strSearch);
	}
		
	public void findGSOTheatre(){
	    PageLoaded.isDomComplete(driver);
		findAnotherTheatre();
		theatreSearch("27409");	
	}
	
	public void chooseDay(String strDay){
	    PageLoaded.isDomComplete(driver);
	    lstDate.syncEnabled(10);
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

	public boolean chooseFirstShowing() {
	    PageLoaded.isDomComplete(driver);
		boolean blnFirstShow;
	    if (lblNoShowtimes.syncEnabled(5,false)) {
            TestReporter.logStep("No Showings available at preferred theatre");
            blnFirstShow = false;
        } else {
            btnFirstShowtime.click();
            TestReporter.logStep("First Showing of the day chosen.");
            blnFirstShow = true;
        }
		return blnFirstShow;
		
	}

	public void chooseMovie(String movieTitle) {
	    PageLoaded.isDomComplete(driver);
		
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
	    PageLoaded.isDomComplete(driver);
		return lblReservedSeating.syncVisible(1,false);
	}
	
	/**Test Functionality**/
	public void showtimesComplete(String theatre,String movieTitle,String date){
	    PageLoaded.isDomComplete(driver);
		theatreSearch(theatre);
    	
    	TestReporter.logStep("Theatre: " + theatre + " was selected.");
    	    	
    	//Choose Movie
    	chooseMovie(movieTitle);
    	TestReporter.logStep("Movie Title: " + movieTitle + " was selected.");
    	
    	//Choose Day - "Today" or "YYYY-MM-DD"
    	chooseDay(date);
    	TestReporter.logStep("Date: " + date + " was selected.");
    	
	}
	
}