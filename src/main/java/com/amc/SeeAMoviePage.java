package src.main.java.com.amc;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SeeAMoviePage {

    private AndroidDriver<MobileElement> driver;

    //Misc elements
    @FindBy(id="com.amc:id/event_close_icon") private WebElement popup_close;
    @FindBy(id="com.amc:id/display_remind_me") private WebElement popup_remind_later;
    @FindBy(id="com.amc:id/button1") public WebElement choose_location_btn;
    @FindBy(id="com.amc:id/search_src_text") public WebElement theater_search;
    @FindBy(id="com.amc:id/theatre_view") public WebElement amc_gso_18;
    @FindBy(xpath="//android.widget.Button[@clickable='true']") public WebElement first_showtime;
    @FindBy(id="com.amc:id/seatsSelectedLabel") public WebElement seats_header;
    @FindBy(id="com.amc:id/food_drink") public WebElement food_and_drinks;

    //List of movies
    @FindBy(xpath="//android.widget.ImageView[@content-desc='Wind River']") public WebElement wind_river;
    @FindBy(xpath="//android.widget.ImageView[@content-desc='It']") public WebElement it;
    @FindBy(xpath="//android.widget.ImageView[@content-desc='mother!']") public WebElement mother;

    public SeeAMoviePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void closePopup() {

        popup_close.click();
        popup_remind_later.click();

    }
}