package com.epam.tc.hw6.pages;

import java.util.List;
import java.util.Optional;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    protected final WebDriverWait wait;
    protected final WebDriver driver;

    public AbstractPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
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
}
