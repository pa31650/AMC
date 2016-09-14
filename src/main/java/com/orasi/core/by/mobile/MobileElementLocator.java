package com.orasi.core.by.mobile;

import java.lang.reflect.Field;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import com.orasi.core.by.mobile.internal.ByMobileHelper;

@SuppressWarnings("unused")
public class MobileElementLocator implements ElementLocator {
	  private final WebDriver driver;
	  private final FindByMobile mobileLocator;	  
	  private static ByMobileHelper mobile;
		
	  
	  public MobileElementLocator(final WebDriver driver, final Field field) {
	    this.driver =  driver;
	    this.mobileLocator = field.getAnnotation(FindByMobile.class);
	    mobile = new ByMobileHelper(driver);
	  }
	  
	  //@Override
	  @Override
	public WebElement findElement() {
		  RemoteWebElement element = null;
		  if (!mobileLocator.resourceId().toString().isEmpty()){
			  element = (RemoteWebElement) driver.findElement(By.xpath("//*[@resource-id=['"+mobileLocator.resourceId()+"']"));
		  }
		  return element;
	  }
	  
	  @Override
	@SuppressWarnings({ })// @Override
	  public List<WebElement> findElements() {
		  
		  List<WebElement> elements = null;
		  if (!mobileLocator.resourceId().toString().isEmpty()){
			  elements = driver.findElements(By.xpath("//*[@resource-id=['"+mobileLocator.resourceId()+"']"));
		  }
		  
		  return elements;
	  }
}
