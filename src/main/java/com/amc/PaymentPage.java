package src.main.java.com.amc;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    private AndroidDriver<MobileElement> driver;

    //Misc elements
    @FindBy(id="com.amc:id/page_title") public WebElement page_header;
    @FindBy(id="com.amc:id/new_card_number") public WebElement card_number;
    @FindBy(id="com.amc:id/button_right") public WebElement apply_to_order;
    @FindBy(id="com.amc:id/add_credit_card") public WebElement add_new;
    @FindBy(xpath="//com.amc:id/new_card_month_selector/android:id/text1") public WebElement month;

    public PaymentPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void AddCreditCard() {
        WebDriverWait element = new WebDriverWait(driver, 10);
        element.until(ExpectedConditions.visibilityOf(page_header));
        add_new.click();
        card_number.sendKeys("4737034022610167");
        month.sendKeys("Oct (10)");
    }
}
