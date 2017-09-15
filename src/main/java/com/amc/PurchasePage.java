package src.main.java.com.amc;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {

    private AndroidDriver<MobileElement> driver;

    //Misc elements
    @FindBy(id="com.amc:id/contactInfoTitle") public WebElement contactinfo_header;
    @FindBy(id="com.amc:id/contactInfoHintText") public WebElement add_email;
    @FindBy(id="com.amc:id/paymentInfoHintText") public WebElement add_payment;
    @FindBy(id="com.amc:id/purchase_button") public WebElement purchase_btn;

    public PurchasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
