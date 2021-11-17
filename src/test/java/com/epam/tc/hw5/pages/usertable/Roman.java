package com.epam.tc.hw5.pages.usertable;

import com.epam.tc.hw5.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Roman extends BasePage {

    @FindBy(xpath = "//*[@id='roman']//ancestor::tr//option")
    private List<WebElement> types;

    public Roman(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> types() {
        return waitForVisibilityOf(types);
    }
}
