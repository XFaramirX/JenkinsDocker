package com.goibibo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver setUp(String browserName, String driverLocation, String url) {
        // code that will be invoked when this test is instantiated
        WebDriver driver;
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverLocation);
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", driverLocation);
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;

    }


    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }
}

