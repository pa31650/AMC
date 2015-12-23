package com.orasi.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WiniumTesting {
	WiniumDriver driver =null;
	DesktopOptions options = new DesktopOptions();
	URL localhost = null;
	String notepad = "C:\\Windows\\System32\\notepad.exe";
	String winiumWindowsApp = "C:\\Users\\Justin\\git\\Winium.Desktop\\src\\TestApps.Tests\\WindowsFormsTestApplication.Tests\\WindowsFormsTestApplication.exe";
	String winiumWpfApp = "C:\\Users\\Justin\\git\\Winium.Desktop\\src\\TestApps.Tests\\WpfTestApplication.Tests\\WpfTestApplication.exe";

	//Showing usability as typical selenium style
	@Test
	public void notepadIndividualElementSearch(){
		setAppPath(notepad);
		driver = new WiniumDriver(localhost,options);
		driver.findElement(By.className("Edit")).sendKeys("Blah");
		driver.findElement(By.name("File")).click();
		driver.findElement(By.name("Exit")).click();
		driver.findElement(By.name("Don't Save")).click();
	}

	/**
	 * Showing usability as  using element context searching to fully qualify an element
	 * This style may prove useful for Windows apps that might use the same names across domains
	 * that could be picked up by the driver 
	 */
	@Test
	public void notepadContextElementSearch(){
		setAppPath(notepad);
		driver = new WiniumDriver(localhost,options);
		
		WebElement notepad = driver.findElement(By.className("Notepad"));
		WebElement menuBar = notepad.findElement(By.id("MenuBar"));
		
		notepad.findElement(By.className("Edit")).sendKeys("Blah");
		menuBar.findElement(By.name("File")).click();
		menuBar.findElement(By.name("File")).findElement(By.name("Exit")).click();
		notepad.findElement(By.name("Don't Save")).click();		
	}
	
	/**
	 * using the Winium Windows app from 
	 * https://github.com/2gis/Winium.Desktop/blob/master/src/TestApps.Tests/WindowsFormsTestApplication.Tests/WindowsFormsTestApplication.exe
	 * Using element search context, we distinguish elements between two tabs
	 */
	@Test
	public void winiumWindowsApp(){
		setAppPath(winiumWindowsApp);
		driver = new WiniumDriver(localhost,options);
		
		//defining elements
		WebElement mainForm = driver.findElement(By.id("Form1")); 
		WebElement mainTab = mainForm .findElement(By.name("TabItem1"));
		WebElement secondaryTab = mainForm .findElement(By.name("TabItem2"));
		
		//Set Text to Blah
		WebElement textbox = mainTab.findElement(By.id("TextBox1"));
		textbox.sendKeys("Blah");
		Assert.assertTrue(textbox.getText().equals("Blah"));
		
		//Interact with Combobox
		WebElement combobox = mainTab.findElement(By.id("TextComboBox"));
		combobox.click();
		combobox.findElement(By.name("Month")).click();
		Assert.assertTrue(combobox.getAttribute("Name").equals("Month"));
		
		//Interact with checkbox
		WebElement checkbox = mainTab.findElement(By.name("IsEnabledTextListBox"));
		checkbox.click();
		Assert.assertFalse(checkbox.isSelected());
		
		/*NOT WORKING
		WebElement textList = mainTab.findElement(By.id("TextListBox"));
		WebElement listOption = textList.findElement(By.name("May"));
		listOption.click();
		Assert.assertTrue(textList.findElement(By.name("May")).isSelected());
		*/			
	}
	
	@BeforeMethod
	public void setup(){
		try {
			localhost = new URL("http://localhost:9999");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("webdriver.winium.driver.desktop", "C:\\Users\\Justin\\Selenium");
	}
	
	@AfterMethod
	public void teardown(){
		try{
			driver.close();
			driver.quit();
		}catch(WebDriverException wde){}
		
	}

	private void setAppPath(String appPath){
		options.setApplicationPath(appPath);
	}
}
