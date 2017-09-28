package com.amc;

import org.testng.ITestContext;
import org.testng.annotations.*;

import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.orasi.utils.dataProviders.JsonDataProvider;

public class TicketPurchaseFlowNegative extends TestEnvironment {

    // ************* *
    // Data Provider
    // **************
    @DataProvider(name = "Ticket Purchase Flow (negative)", parallel = true)
    public Object[][] scenarios() {
        return new JsonDataProvider().getData("/json/ticketPurchaseFlow-negative.json");
    }

    @BeforeMethod
    @Parameters({ "runLocation", "browserUnderTest", "browserVersion", "operatingSystem", "environment", "mobileOSVersion", "deviceID" })
    public void setup(@Optional String runLocation, String browserUnderTest,
            String browserVersion, String operatingSystem, String environment, String mobileOSVersion, String deviceID) {
        setApplicationUnderTest("AMC");
        setBrowserUnderTest(browserUnderTest);
        setBrowserVersion(browserVersion);
        setOperatingSystem(operatingSystem);
        setRunLocation(runLocation);
        setTestEnvironment(environment);
        setThreadDriver(true);
        setMobileOSVersion(mobileOSVersion);
        setDeviceID(deviceID);
        testStart(testName);
        TestReporter.logStep("Test Name: " + testName.toString());
    }

    @AfterMethod
    public void close(ITestContext testResults) {
        endTest("TestAlert", testResults);
    }

    @Test(dataProvider = "Ticket Purchase Flow (negative)")
    public void ticketPurchaseFlow(
            String iterationName, String movieTitle, String theatre, String date, String tickets, String creditCard, String selectMeal) {
        
        // [Home] Open AMC website
        TestReporter.logStep("Navigate to AMC homepage");
        HomePage homePage = new HomePage(getDriver());

        // [Home] Click on Showtimes element
        TestReporter.logStep("Click on Showtimes element");
        homePage.clickShowtimes();

        // [Showtimes]
        ShowtimesPage showtimesPage = new ShowtimesPage(getDriver());

        // [Showtimes] Selects theatre, movie and date & chooses first showing
        TestReporter.logStep("Selects theatre: "+ theatre +", movie: " + movieTitle + " and date: " + date);
        showtimesPage.showtimesComplete(theatre, movieTitle, date);

        boolean reservedSeating = showtimesPage.isReservedSeatingAvail();
        TestReporter.logStep("Is Reserved Seating available? " + reservedSeating);
        
        TestReporter.logStep("Choosing first available showing");
        showtimesPage.chooseFirstShowing();

        // [SelectSeat] Choose seat if theatre provides reserved seating service
        if (reservedSeating) {
            SelectSeatPage selectSeatPage = new SelectSeatPage(getDriver());
            
            TestReporter.logStep("Choosing " + tickets + " available seats");
            selectSeatPage.selectSeatPageComplete(tickets);
            
        }

        // [Ticket Type] Select Adult/Child/Senior tickets
        SelectTicketTypePage selectTicketTypePage = new SelectTicketTypePage(getDriver());

        // [Ticket Type] Add adult tickets & Continue
        TestReporter.logStep("Adding "+ tickets + " Adult tickets to order");
        selectTicketTypePage.selectTicketTypeComplete(tickets);

        switch (selectMeal.toLowerCase()) {
            case "yes":
                // [Food & Drinks] Select food item from Meals tab
                FoodDrinksPage foodDrinksPage = new FoodDrinksPage(getDriver());

                // [Food & Drinks] Move to meals tab
                TestReporter.logStep("Move to meals tab");
                foodDrinksPage.NavigatetoMealsTab();

                // [Food & Drinks] Choose first option
                TestReporter.logStep("Choose first option");
                foodDrinksPage.ChooseFirstItemMeals();
                break;

            case "no":
                break;
        }

        // [Confirm Purchase] Enter email address
        ConfirmPurchasePage confirmPurchasePage = new ConfirmPurchasePage(getDriver());

        // [Confirm Purchase] Enter email address and payment details & Purchase
        TestReporter.logStep("Enter email address and payment details & Purchase");
        confirmPurchasePage.confirmPurchasePageComplete(creditCard, selectMeal);

        // [Confirm Purchase] Check for Error (and output message?)
        TestReporter.assertTrue(confirmPurchasePage.errorExist(), "Ensuring that the Error label is present after clicking Purchase button with bad cc data.");

    }
}