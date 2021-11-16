package com.epam.tc.hw5.pages.home;

import com.epam.tc.hw5.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private static final String TITLE = "Home Page";
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HomePage open() {
        driver.navigate().to(URL);
        wait.until(ExpectedConditions.titleIs(TITLE));
        return this;
    }
}
