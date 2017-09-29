package com.amc;

import java.util.List;

import org.eclipse.jetty.websocket.common.events.annotated.OptionalSessionCallableMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.orasi.core.interfaces.Button;
import com.orasi.core.interfaces.Listbox;
import com.orasi.core.interfaces.impl.internal.ElementFactory;
import com.orasi.utils.OrasiDriver;
import com.orasi.utils.TestReporter;

public class FoodDrinksPage {
	private OrasiDriver driver = null;
	
	/**Page Elements**/
	@FindBy(xpath=("//a[contains(text(),'Meals')]")) private Button btnMealsMenu;
	@FindBy(xpath=("//a[contains(text(),'Special Offers')]")) private Button btnSpecialOffersMenu;
	@FindBy(xpath=("//a[contains(text(),'Combos')]")) private Button btnCombosMenu;
	@FindBy(xpath=("//a[contains(text(),'Popcorn')]")) private Button btnPopcornMenu;
	@FindBy(xpath=("//a[contains(text(),'Drinks')]")) private Button btnDrinksMenu;
	@FindBy(xpath=("//a[contains(text(),'Treats')]")) private Button btnTreatsMenu;
	@FindBy(xpath=("//a[contains(text(),'Shares')]")) private Button btnSharesMenu;
	@FindBy(xpath=("//button[contains(text(),'Continue to Purchase')]")) private Button btnContinue;
	@FindBy(xpath=("//div[@class='FDPromoModal-Content']//a[contains(text(),'No Thanks')]")) private Button btnPromoNoThanks;
	@FindBy(xpath=("//i[contains(@class,'arrow-right')]")) private Button btnArrowRight;
		
	/**Constructor**/
	public FoodDrinksPage(OrasiDriver driver){
		this.driver = driver;
		ElementFactory.initElements(driver, this);
	}

	/**Page Interactions**/
	public void NavigatetoMealsTab() {
	    if (btnMealsMenu.syncEnabled(5,false)) {
	        btnMealsMenu.click();
        } else {
           btnArrowRight.syncEnabled(5,true);
           btnArrowRight.click();
           
           btnMealsMenu.syncEnabled();
           btnMealsMenu.click();
        }	    
	}
	
	private String GetAriaControls(Button button){

	    return button.getAttribute("aria-controls");
	    
	}
	
	public void ChooseFirstItemMeals(){
	    String strAriaControls = GetAriaControls(btnMealsMenu);
	    
	    
	    String xpathExpressionButton = "//div[contains(@id,'" + strAriaControls + "')]//div[contains(@class,'LoadingContainer-inline')][1]//button[contains(@aria-label,'Expand')]";
	    Button btnCustomize = driver.findButton(By.xpath(xpathExpressionButton));
	    
	    btnCustomize.syncEnabled();
	    btnCustomize.click();
	    
	    String xpathExpressionListbox = "//div[contains(@id,'" + strAriaControls + "')]//select[1]";
	    Listbox lstOption = driver.findListbox(By.xpath(xpathExpressionListbox));
	    List<WebElement> options = lstOption.getOptions();
	    
	    //lstOption.scrollIntoView();
	    lstOption.selectValue(options.get(1).getAttribute("value"));
	    
	    TestReporter.logStep("Option: " + options.get(1).getAttribute("value") + " was selected.");
	    
	    String xpathExpressionAddtoOrder = "//div[contains(@id,'" + strAriaControls + "')]//div[contains(@class,'LoadingContainer-inline')][1]//button[contains(@class,'submit')]";
	    Button btnAddtoOrder = driver.findButton(By.xpath(xpathExpressionAddtoOrder));
	    
	    /*Actions actions = new Actions(driver);
	    actions.moveToElement(btnAddtoOrder);
	    actions.perform();*/
	    
	    btnCustomize.scrollIntoView();
	    //btnAddtoOrder.jsClick();
	    btnAddtoOrder.click();
	    
	    ClickContinuetoPurchase();
	    
	    if(btnPromoNoThanks.syncEnabled(3,false)){
	        btnPromoNoThanks.click();
	    }
	}
	
	public void ClickContinuetoPurchase() {
	    //btnContinue.focusClick();
	    btnContinue.click();
	}
	
}