package com.epam.tc.hw5.pages.usertable;

import com.epam.tc.hw5.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ivan extends BasePage {

    @FindBy(id = "ivan")
    private WebElement ivanCheckbox;

    public Ivan(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Ivan clickCheckbox() {
        click(ivanCheckbox);
        return this;
    }
}
