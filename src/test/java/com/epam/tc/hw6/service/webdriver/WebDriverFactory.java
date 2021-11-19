package com.epam.tc.hw6.service.webdriver;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class WebDriverFactory {
    private static final String HUB = "http://192.168.0.16:4444/wd/hub";

    private WebDriverFactory() {
    }

    public static WebDriver createWebDriver(final Browser browser) {
        Capabilities capabilities;
        switch (browser) {
            case CHROME:
                capabilities = createChromeCapabilities();
                break;
            case FIREFOX:
                capabilities = createFirefoxCapabilities();
                break;
            default:
                throw new UnsupportedBrowserException();
        }
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(HUB), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
        return driver;
    }

    private static Capabilities createChromeCapabilities() {
        return new ChromeOptions();
    }

    private static Capabilities createFirefoxCapabilities() {
        return new FirefoxOptions();
    }
}
