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
    @FindBy(id="com.amc:id/header_title") public WebElement selected_movie;
    @FindBy(id="com.amc:id/toolbar_title") public WebElement see_a_movie_header;
    @FindBy(id="com.amc:id/noShowtimesTitle") public WebElement no_showtimes;

    //List of movies
    @FindBy(xpath="//android.widget.RelativeLayout[@index='0']") public WebElement first_movie;
    @FindBy(xpath="//android.widget.RelativeLayout[@index='1']") public WebElement second_movie;
    @FindBy(xpath="//android.widget.RelativeLayout[@index='2']") public WebElement third_movie;
    @FindBy(xpath="//android.widget.RelativeLayout[@index='3']") public WebElement fourth_movie;
    @FindBy(xpath="//android.widget.RelativeLayout[@index='4']") public WebElement fifth_movie;


    public SeeAMoviePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void closePopup() {

        popup_close.click();
        popup_remind_later.click();

    }
}