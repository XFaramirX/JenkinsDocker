package com.goibibo.page.tasks;

import com.goibibo.page.Base;
import com.goibibo.page.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Tasks {
    WebDriver driver;
    Home homePage;

    @Parameters({"browser", "path", "url"})
    @BeforeClass
    public void setup(String browser, String path, String url) {
        driver = Base.setUp(browser, path, url);
        homePage = PageFactory.initElements(driver, Home.class);


    }

    @AfterClass
    public void tearDown() {
        Base.quitBrowser(driver);
    }


    @Test
    public void searchFlight() {
        homePage.searchFlight("Mumbai", "delhi");
    }


}
