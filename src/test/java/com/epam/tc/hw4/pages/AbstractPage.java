package com.epam.tc.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    protected WebDriverWait wait;
    protected WebDriver driver;

    public AbstractPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
