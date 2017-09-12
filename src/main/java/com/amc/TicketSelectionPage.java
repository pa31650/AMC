package src.main.java.com.amc;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketSelectionPage {

    private AndroidDriver<MobileElement> driver;

    //Misc elements
    @FindBy(xpath="//android.widget.TextView[@text='PLEASE SELECT YOUR SEAT(S)']") public WebElement page_header;
    @FindBy(id="com.amc:id/addAdult") public WebElement add_adult;
    @FindBy(id="com.amc:id/adultLabel") public WebElement adult_header;
    @FindBy(id="com.amc:id/nextButton") public WebElement next_btn;

    public TicketSelectionPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
