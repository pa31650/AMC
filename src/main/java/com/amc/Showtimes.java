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
import com.orasi.utils.TestReporter;
import com.orasi.utils.date.DateTimeConversion;
import com.orasi.utils.date.SimpleDate;

import groovyjarjarantlr.collections.List;

public class Showtimes {
	private OrasiDriver driver = null;
	
	/**Page Elements**/
	@FindBy(xpath="//div[@class='Showtimes-Action-Wrapper'][1]//*[@class='Showtimes-Action-Dropdown']") private Listbox lstTheatreDropdown;
	@FindBy(xpath="//input") private Textbox txtTheatreSearch;
	@FindBy(xpath="//button[contains(text(),'Search')]") private Button btnTheatreSearch;
	@FindBy(xpath="//button[contains(text(),'Select')]") private Button btnTheatreSelect;
	@FindBy(xpath="//div[@class='Showtimes-Action-Wrapper'][2]//*[@class='Showtimes-Action-Dropdown']") private Listbox lstDate;
	@FindBy(xpath="//div[@class='Showtimes-Action-Wrapper'][3]//*[@class='Showtimes-Action-Dropdown']") private Listbox lstMovies;
	@FindBy(xpath="//*[contains(@class,'Theatre-Wrapper-First')]//div[@class='Showtime'][1]//a[@class='Btn Btn--default']") private Button btnFirstShowtime;
		
	/**Constructor**/
	public Showtimes(OrasiDriver driver){
		this.driver = driver;
		ElementFactory.initElements(driver, this);
	}

	/**Page Interactions**/
	public void SelectTheatre(String strTheatre){
		lstTheatreDropdown.select(strTheatre);
	}
	
	public void FindAnotherTheatre(){
		SelectTheatre("Find Another Theatre...");
	}
	
	public void TheatreSearch(String strSearch){
		FindAnotherTheatre();
		
		txtTheatreSearch.syncVisible(3);
		txtTheatreSearch.set(strSearch);
		
		btnTheatreSearch.syncVisible(3);
		btnTheatreSearch.click();
		
		btnTheatreSelect.syncVisible(3);
		btnTheatreSelect.click();
	}
		
	public void FindGSOTheatre(){
		FindAnotherTheatre();
		TheatreSearch("27409");	
	}
	
	public void ChooseDay(String strDay){
		
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

	public void ChooseFirstShowing() {
		btnFirstShowtime.click();
		
	}

	public void ChooseMovie(String movieTitle) {
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
}