package com.goibibo.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class Home {
    WebDriver driver;

    public Home(WebDriver ldriver) {
        this.driver = ldriver;
    }

    @FindBy(id = "gosuggest_inputSrc")
    WebElement source;

    @FindBy(id = "gosuggest_inputDest")
    WebElement destination;

    @FindBy(id = "gi_search_btn")
    WebElement searchButton;


    @FindBy(id = "react-autosuggest-1-suggestion--0")
    WebElement suggestion;

    @FindBy(xpath = ".//*[@role='listbox']/li")
    List<WebElement> suggestionList;

    


    public void searchFlight(String sourceName, String destinationName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        System.out.println("Searching Flights");

        source.sendKeys(sourceName);
        wait.until(ExpectedConditions.visibilityOf(suggestion));
        source.sendKeys(Keys.DOWN);
        source.sendKeys(Keys.ENTER);


        destination.sendKeys(destinationName);
        wait.until(ExpectedConditions.visibilityOf(suggestion));
        destination.sendKeys(Keys.DOWN);
        destination.sendKeys(Keys.ENTER);


        searchButton.click();


    }


}
