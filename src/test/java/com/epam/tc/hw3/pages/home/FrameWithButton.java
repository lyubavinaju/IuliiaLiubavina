package com.epam.tc.hw3.pages.home;

import com.epam.tc.hw3.pages.AbstractPage;
import java.util.Optional;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameWithButton extends AbstractPage {
    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(css = "[value='Frame Button']")
    private WebElement button;

    public FrameWithButton(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public FrameWithButton switchToFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        return this;
    }

    public HomePage switchToHomePage() {
        driver.switchTo().defaultContent();
        return new HomePage(driver, wait);
    }

    public boolean isVisible() {
        return waitForVisibility(frame).isPresent();
    }

    public Optional<WebElement> button() {
        return waitForVisibility(button);
    }
}
