package com.epam.tc.hw4.pages.common;

import com.epam.tc.hw4.pages.AbstractPage;
import com.epam.tc.hw4.pages.diffelements.DifferentElementsPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends AbstractPage {
    @FindBy(css = ".m-l8 > li > a")
    private List<WebElement> items;

    @FindBy(css = ".m-l8 .dropdown-toggle")
    private WebElement service;

    @FindBy(css = ".m-l8 .dropdown-menu :nth-child(8) > a")
    private WebElement differentElements;

    public Header(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> items() {
        return waitForVisibilityOf(items);
    }

    public Header openService() {
        click(service);
        return this;
    }

    public DifferentElementsPage differentElementsPage() {
        click(differentElements);
        return new DifferentElementsPage(driver, wait);
    }
}
