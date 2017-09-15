package src.main.java.com.amc;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactInfoPage {

    private AndroidDriver<MobileElement> driver;

    //Misc elements
    @FindBy(id="com.amc:id/page_title") public WebElement page_header;
    @FindBy(id="com.amc:id/contact_email") public WebElement edit_email;
    @FindBy(id="com.amc:id/button_right") public WebElement save_btn;

    public ContactInfoPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void EnterEmail() {
        WebDriverWait element = new WebDriverWait(driver, 10);
        element.until(ExpectedConditions.visibilityOf(page_header));
        edit_email.sendKeys("gmail@gmail.com");
        save_btn.click();
    }
}
