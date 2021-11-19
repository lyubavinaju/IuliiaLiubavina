package com.epam.tc.hw6.service.webdriver;

import java.util.Locale;
import org.openqa.selenium.WebDriver;

public final class WebDriverProvider {

    public static final String BROWSER_NAME_KEY = "browser.name";
    public static final String DEFAULT_BROWSER_NAME = "firefox";
    private static WebDriver driver;

    private WebDriverProvider() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browserName = System.getProperty(BROWSER_NAME_KEY, DEFAULT_BROWSER_NAME);
            Browser browser = Browser.valueOf(browserName.toUpperCase(Locale.ROOT));
            driver = WebDriverFactory.createWebDriver(browser);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
