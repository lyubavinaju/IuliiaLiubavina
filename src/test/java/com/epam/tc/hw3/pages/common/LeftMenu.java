package com.epam.tc.hw3.pages.common;

import com.epam.tc.hw3.pages.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftMenu extends AbstractPage {

    @FindBy(css = ".sidebar-menu.left > li > a")
    private List<WebElement> items;

    public LeftMenu(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> items() {
        return waitForVisibility(items);
    }
}
