package com.goibibo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightReview {
    WebDriver driver;

    public FlightReview(WebDriver ldriver) {
        this.driver = ldriver;
    }

    @FindBy(id = "Adulttitle1")
    WebElement adultTitleField;

    @FindBy(id = "AdultfirstName1")
    WebElement firstName;

    @FindBy(id = "AdultmiddleName1")
    WebElement middleName;

    @FindBy(id = "AdultlastName1")
    WebElement adultlastNameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "mobilecode")
    WebElement mobileCodeField;

    @FindBy(id = "mobile")
    WebElement mobileField;

    @FindBy(id = "risk-trip")
    WebElement riskRadioButton;

    @FindBy(xpath = "//form[@id='travellerForm']/div[2]/button")
    WebElement proceedButton;


    @FindBy(xpath = "//*[contains(text(),'OK')]")
    WebElement webCheckInModalButton;


    @FindBy(xpath = "//*[contains(text(),'Proceed To Payment')]")
    WebElement proceedToPayButton;


    @FindBy(id = "tab_wallet")
    WebElement amazonWallet;


    public void fillTravellerDetails(String adultfirstName1, String adultmiddleName1, String email, String countryCode, String phoneNumber, String adultTitle, String adultlastName) {

        Select element = new Select(adultTitleField);
        element.selectByVisibleText(adultTitle);


        firstName.sendKeys(adultfirstName1);
        middleName.sendKeys(adultmiddleName1);
        emailField.sendKeys(email);
        mobileField.sendKeys(phoneNumber);
        riskRadioButton.click();
        adultlastNameField.sendKeys(adultlastName);


        System.out.println("Enter User details");
        proceedButton.click();


    }


    public void selectSeat() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webCheckInModalButton));
        webCheckInModalButton.click();
        proceedToPayButton.click();

        wait.until(ExpectedConditions.visibilityOf(amazonWallet));
        amazonWallet.click();

    }

}
