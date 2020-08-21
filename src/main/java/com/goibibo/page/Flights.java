package com.goibibo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Flights {
    WebDriver driver;

    public Flights(WebDriver ldriver) {
        this.driver = ldriver;
    }

    @FindBy(id = "PRICE")
    WebElement price;


    public void sortPrices() {
        System.out.println("Displaying flights");
        price.click();

    }


}
