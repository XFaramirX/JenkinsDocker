package com.goibibo.page.tasks;

import com.goibibo.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class Tasks {
    WebDriver driver;
    Home homePage;
    Flights flightsPage;
    FlightReview flightsReviewPage;


    private DatePicker datePicker;


    @Parameters({"browser", "path", "url"})
    @BeforeClass
    public void setup(String browser, String path, String url) {
        driver = Base.setUp(browser, path, url);
        homePage = PageFactory.initElements(driver, Home.class);
        flightsPage = PageFactory.initElements(driver, Flights.class);
        flightsReviewPage = PageFactory.initElements(driver, FlightReview.class);
        datePicker = new DatePicker(driver);

    }

    @AfterClass
    public void tearDown() {
        Base.quitBrowser(driver);
    }

    @Parameters({"destination", "returnLocation"})
    @Test(priority = 1)
    public void searchFlight(String destination, String returnLocation) {
        homePage.searchFlight(destination, returnLocation);
        var dateToSelect = LocalDate.now().plusMonths(2);
        var dateToReturn = LocalDate.now().plusMonths(4);
        datePicker.chooseDate(dateToSelect);
        datePicker.chooseReturn(dateToReturn);
        homePage.search();
    }

    @Test(priority = 2)
    public void selectFlight() {
        flightsPage.sortPrices();
        flightsPage.selectPrice();
        flightsPage.selectFlight();
    }


    @Parameters({"adultfirstName1", "adultmiddleName1", "email", "countryCode", "phoneNumber", "adultTitle", "adultlastName"})
    @Test(priority = 3)
    public void fillTravellerDetails(String adultfirstName1, String adultmiddleName1, String email, String countryCode, String phoneNumber, String adultTitle, String adultlastName) throws InterruptedException {
        flightsReviewPage.fillTravellerDetails(adultfirstName1, adultmiddleName1, email, countryCode, phoneNumber, adultTitle, adultlastName);
        flightsReviewPage.selectSeat();
    }


}
