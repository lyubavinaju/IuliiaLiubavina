package com.epam.tc.hw6.service.webdriver;

import java.util.Locale;
import org.openqa.selenium.WebDriver;

public final class WebDriverProvider {
    private static WebDriver driver;

    private WebDriverProvider() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browserName = System.getProperty("browser.name", "firefox");
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
