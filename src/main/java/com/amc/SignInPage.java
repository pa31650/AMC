package com.amc;

import java.util.ResourceBundle;

import org.openqa.selenium.support.FindBy;

import com.orasi.core.interfaces.Button;
import com.orasi.core.interfaces.Textbox;
import com.orasi.core.interfaces.impl.internal.ElementFactory;
import com.orasi.utils.Constants;
import com.orasi.utils.OrasiDriver;

public class SignInPage {
	private OrasiDriver driver = null;
	private ResourceBundle userCredentialRepo = ResourceBundle.getBundle(Constants.USER_CREDENTIALS_PATH);
	
	/**Page Elements**/
	@FindBy(xpath="//form[contains(@class,'Login')]//input[@type='email']") private Textbox txtLoginEmail;
	@FindBy(xpath="//form[contains(@class,'Login')]//input[@type='password']") private Textbox txtLoginPassword;
	@FindBy(xpath="//form[contains(@class,'Login')]//input[@type='submit']") private Button btnSignIn;
			
	/**Constructor**/
	public SignInPage(OrasiDriver driver){
		this.driver = driver;
		ElementFactory.initElements(driver, this);
	}

	/**Page Interactions**/
	public void SignIn(){
	    txtLoginEmail.syncEnabled(5,true);
	    txtLoginEmail.set(userCredentialRepo.getString("MEMBER_EMAIL"));
	    txtLoginPassword.set(userCredentialRepo.getString("PASSWORD"));
	    btnSignIn.click();
	}
}