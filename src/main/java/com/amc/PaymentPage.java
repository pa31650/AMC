package src.main.java.com.amc;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.main.resources.AMCTests;

public class PaymentPage {

    private AndroidDriver<MobileElement> driver;

    //Misc elements
    @FindBy(id="com.amc:id/page_title") private WebElement page_header;
    @FindBy(id="com.amc:id/new_card_number") private WebElement card_number;
    @FindBy(id="com.amc:id/button_right") private WebElement apply_to_order;
    @FindBy(id="com.amc:id/add_credit_card") private WebElement add_new;
    @FindBy(id="com.amc:id/new_card_month_selector") private WebElement month;
    @FindBy(id="com.amc:id/new_card_year_selector") private WebElement year;
    @FindBy(id="com.amc:id/new_card_cvv") private WebElement cvv;
    @FindBy(id="com.amc:id/new_card_zip") private WebElement zip;
    @FindBy(id="com.amc:id/view_notification_title_text") public WebElement credit_card_error_msg;

    //Months
    @FindBy(xpath="//android.widget.TextView[@text='Oct (10)']") private WebElement October;

    //Years
    @FindBy(xpath="//android.widget.TextView[@text='2020']") private WebElement year_2020;

    AMCTests amctests = new AMCTests();

    public PaymentPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void AddCreditCard() {
        WebDriverWait element = new WebDriverWait(driver, 10);
        element.until(ExpectedConditions.visibilityOf(page_header));
        add_new.click();
        card_number.sendKeys("5848145133721278");
        month.click();
        element.until(ExpectedConditions.elementToBeClickable(October));
        October.click();

        amctests.RunAppInBackground(driver);

        year.click();
        element.until(ExpectedConditions.elementToBeClickable(year_2020));
        year_2020.click();

        amctests.RunAppInBackground(driver);

        cvv.sendKeys("123");
        zip.sendKeys("22222");

        apply_to_order.click();

        element.until(ExpectedConditions.visibilityOf(credit_card_error_msg));
        if (credit_card_error_msg.isDisplayed()) {
            System.out.println("The credit card is not valid.");
            System.out.println("TEST END");
            driver.quit();
        }
    }
}
