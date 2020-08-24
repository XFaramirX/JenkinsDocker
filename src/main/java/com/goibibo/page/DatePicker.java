package com.goibibo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class DatePicker {

    private WebDriver driver;

    private By openCalendarButton = By.id("departureCalendar");
    private By openReturnButton = By.id("returnCalendar");
    private By calendar = By.className("DayPicker");
    private By period = By.className("DayPicker-Month");
    private By leftArrow = By.className("DayPicker-NavButton--prev");
    private By rightArrow = By.className("DayPicker-NavButton--next");
    private By day_FORMAT = By.xpath("//div[@class=\"DayPicker-Day\"]");
    private By today = By.className("DayPicker-Day--selected");


    private static WebElement element = null;
    private static List<WebElement> elements = null;


    public DatePicker(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseDate(LocalDate date) {

        open();
        chooseMonth(date);
        chooseDay(date.getDayOfMonth());

    }

    public void chooseReturn(LocalDate date) {

        driver.findElement(openReturnButton).click();
        chooseMonth(date);
        chooseDay(date.getDayOfMonth());
    }

    public LocalDate getSelectedDate() {
        var fields = driver.findElement(calendar).getAttribute("selectedday").split("-");
        return LocalDate.of(
                Integer.parseInt(fields[0]),
                Integer.parseInt(fields[1]) + 1,
                Integer.parseInt(fields[2]));
    }

    public void chooseDay(int dayOfMonth) {
        elements = driver.findElements(day_FORMAT);
        for (WebElement element : elements) {
            if (element.getText().contains(String.valueOf(dayOfMonth))) {
                element.click();
                break;
            }

        }

    }

    public void chooseMonth(LocalDate date) {
        var currentPeriod = getCurrentPeriod();
        long monthsAway = ChronoUnit.MONTHS.between(currentPeriod, date.withDayOfMonth(1));

        By arrow = monthsAway < 0 ? leftArrow : rightArrow;

        for (int i = 0; i < Math.abs(monthsAway); i++) {
            driver.findElement(arrow).click();
        }
    }

    public LocalDate getCurrentPeriod() {
        String currentDay = driver.findElement(today).getText().substring(0, 2);
        var currentPeriod = driver.findElement(period).getText().split(" ");
        var currentYear = currentPeriod[1].substring(0, 4);

        return LocalDate.of(
                Integer.parseInt(currentYear),
                Month.valueOf(currentPeriod[0].toUpperCase()), Integer.parseInt(currentDay));
    }

    public void open() {
        if (!isCalendarOpen()) {
            driver.findElement(openCalendarButton).click();

        }
    }

    public boolean isCalendarOpen() {
        boolean exists = driver.findElements(calendar).size() != 0;

        if (exists) {
            return driver.findElement(calendar).isDisplayed();
        } else {
            return false;
        }

    }
}