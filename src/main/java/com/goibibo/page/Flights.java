package com.goibibo.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Flights {
    WebDriver driver;

    public Flights(WebDriver ldriver) {
        this.driver = ldriver;
    }

    @FindBy(id = "PRICE")
    List<WebElement> price;


    @FindBy(className = "fltbook")
    WebElement books;

    @FindBy(xpath = "//input[@type='radio' and @value='on']")
    List<WebElement> radioButtons;


    @FindBy(xpath = "//*[@xpath='40']")
    WebElement radioButtonReturn;


    public void sortPrices() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(books));
        price.get(0).click();
        price.get(1).click();
    }


    public void selectPrice() {

        var button = radioButtons.get(2);
        var buttonRight = radioButtons.get(12);


        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click()", button);
        ex.executeScript("arguments[0].click()", buttonRight);

        System.out.println("Selecting Highest Price");

    }


    public void selectFlight() {
        System.out.println("Selecting Flight");
        books.click();
    }


}
