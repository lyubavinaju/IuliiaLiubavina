package com.epam.tc.hw5.pages;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static final int FIFTEEN_HUNDRED_MILLIS = 1500;
    protected final WebDriverWait wait;
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(FIFTEEN_HUNDRED_MILLIS));
    }

    protected List<WebElement> waitForVisibilityOf(List<WebElement> webElements) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
            return webElements;
        } catch (TimeoutException e) {
            return List.of();
        }
    }

    protected Optional<WebElement> waitForVisibilityOf(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException e) {
            return Optional.empty();
        }
        return Optional.of(webElement);
    }

    protected Optional<WebElement> waitForElementToBeClickable(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException e) {
            return Optional.empty();
        }
        return Optional.of(webElement);
    }

    protected void click(WebElement webElement) {
        waitForElementToBeClickable(webElement).ifPresent(WebElement::click);
    }

    public String title() {
        return driver.getTitle();
    }
}
