package com.epam.tc.hw5.pages.common;

import com.epam.tc.hw5.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Log extends BasePage {
    public Log(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".logs li")
    private List<WebElement> logs;

    public List<WebElement> items() {
        return waitForVisibilityOf(logs);
    }
}
