package com.goibibo.page.tasks;

import com.goibibo.page.Base;
import com.goibibo.page.DatePicker;
import com.goibibo.page.Home;
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

    private DatePicker datePicker;


    @Parameters({"browser", "path", "url"})
    @BeforeClass
    public void setup(String browser, String path, String url) {
        driver = Base.setUp(browser, path, url);
        homePage = PageFactory.initElements(driver, Home.class);
        datePicker = new DatePicker(driver);

    }

    @AfterClass
    public void tearDown() {
        Base.quitBrowser(driver);
    }


    @Test(priority = 1)
    public void searchFlight() {
        homePage.searchFlight("Mumbai", "delhi");
        var dateToSelect = LocalDate.now().plusMonths(7);
        var dateToReturn = LocalDate.now().plusMonths(9);
        datePicker.chooseDate(dateToSelect);
        datePicker.chooseReturn(dateToReturn);
        homePage.search();
    }


}
