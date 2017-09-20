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

import java.time.Duration;

public class FoodAndDrinksPage {

    AndroidDriver<MobileElement> driver;

    //Misc elements
    @FindBy(id="com.amc:id/FoodAndBeverageLanding_OrderAhead_DefaultHeader") public WebElement order_ahead;
    @FindBy(id="com.amc:id/nextButton") public WebElement order_btn;
    @FindBy(id="com.amc:id/FoodAndBeverageLanding_TheatreList") private WebElement select_a_participating_theatre;
    @FindBy(id="com.amc:id/pickerTextToDisplay") private WebElement dropdown_selection;
    @FindBy(id="com.amc:id/concessionItems") private WebElement item_selection;
    @FindBy(id="com.amc:id/selectMovieTitle") private WebElement select_your_movie;

    //special offers
    @FindBy(id="com.amc:id/groupName") private WebElement first_special_offer;

    //M&Ms Caramel
    @FindBy(id="com.amc:id/upsell_image") private WebElement upsell_image;
    @FindBy(id="com.amc:id/noThanksButton") private WebElement no_thanks_btn;

    //select your movie
    @FindBy(id="com.amc:id/auditoriumDropdown") private WebElement auditorium;
    @FindBy(xpath="//android.widget.TextView[@text='Auditorium']") private WebElement auditorium_header;
    @FindBy(xpath="//android.widget.LinearLayout[@clickable='true']") private WebElement first_available;
    @FindBy(id="com.amc:id/movieDropdown") private WebElement movie_and_time;
    @FindBy(xpath="//android.widget.TextView[@text='Movie & Time']") private WebElement movie_and_time_header;
    @FindBy(id="com.amc:id/deliveryTimeTitle") private WebElement select_a_delivery_time_header;

    AMCTests amctests = new AMCTests();

    public FoodAndDrinksPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectTheatre() {
        WebDriverWait element = new WebDriverWait(driver, 10);

        element.until(ExpectedConditions.elementToBeClickable(select_a_participating_theatre));
        select_a_participating_theatre.click();
        dropdown_selection.click();

        amctests.RunAppInBackground(driver);

        element.until(ExpectedConditions.visibilityOf(order_btn));
        order_btn.click();
    }

    public void deliveryToSeat() {
        WebDriverWait element = new WebDriverWait(driver, 10);

        element.until(ExpectedConditions.elementToBeClickable(first_special_offer));
        first_special_offer.click();
        element.until(ExpectedConditions.elementToBeClickable(item_selection));
        item_selection.click();
        dropdown_selection.click();

        amctests.RunAppInBackground(driver);

        order_btn.click();

        element.until(ExpectedConditions.attributeContains(order_btn, "text", "Continue to Purchase"));
        if (order_btn.getText().equals("Continue to Purchase")) {
            order_btn.click();
        } else driver.quit();

        //Click No Thanks for Caramel M&Ms
        if (upsell_image.isDisplayed()) {
            no_thanks_btn.click();
        }

        //Verify app is on the Select Your Movie page
        element.until(ExpectedConditions.visibilityOf(select_your_movie));
        System.out.println("The app is currently on the Select Your Movie page.");

        //Choose auditorium
        auditorium.click();
        element.until(ExpectedConditions.visibilityOf(auditorium_header));
        first_available.click();
        System.out.println("An auditorium has been selected.");
        amctests.RunAppInBackground(driver);

        //Choose movie and time
        movie_and_time.click();
        element.until(ExpectedConditions.visibilityOf(movie_and_time_header));
        first_available.click();
        System.out.println("A movie and time has been selected.");
        amctests.RunAppInBackground(driver);

        element.until(ExpectedConditions.visibilityOf(select_a_delivery_time_header));

    }
}
