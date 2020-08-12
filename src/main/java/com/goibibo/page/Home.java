package com.goibibo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
    WebDriver driver;

    public Home(WebDriver ldriver) {
        this.driver = ldriver;
    }

    @FindBy(name = "username")
    WebElement uname;





    public void sortPrices() {
        System.out.println("PRINTED SORTED PRICES");
    }


}
