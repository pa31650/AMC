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

public class Showtimes {
	private OrasiDriver driver = null;
	
	/**Page Elements**/
	@FindBy(xpath="//div[@class='Showtimes-Action-Wrapper'][1]//*[@class='Showtimes-Action-Dropdown']") private Listbox lstTheatreDropdown;
	@FindBy(className="TheatreSearchField-input txt--regular") private Textbox txtTheatreSearch;
	@FindBy(className="Btn Btn--secondary TheatreFinder-searchFooter-selectBtn") private Button btnTheatreSearch;
	@FindBy(className="Btn Btn--secondary TheatreFinder-searchFooter-selectBtn") private Button btnTheatreSelect;
	@FindBy(xpath="//div[@class='Showtimes-Action-Wrapper'][2]//*[@class='Showtimes-Action-Dropdown']") private Listbox lstDate;
	@FindBy(xpath="//div[@class='Theatre-Wrapper-First'][1]//section//div[@class='Showtime'][1]//a[@class='Btn Btn--default']") private Button btnFirstShowtime;
		
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
		
		txtTheatreSearch.set(strSearch);
		
		btnTheatreSearch.click();
		
		btnTheatreSelect.click();
	}
		
	public void FindGSOTheatre(){
		FindAnotherTheatre();
		TheatreSearch("27409");	
	}
	
	public void ChooseDay(String strDay){
		if (strDay=="Today") {
			lstDate.select("Today");
		} else {
			lstDate.selectValue(strDay);
		}
	}

	public void ChooseFirstShowing() {
		btnFirstShowtime.click();
		
	}
}