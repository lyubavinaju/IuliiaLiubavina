package com.epam.tc.hw3.pages.common;

import com.epam.tc.hw3.pages.AbstractPage;
import com.epam.tc.hw3.pages.diffelements.DifferentElementsPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends AbstractPage {
    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li > a")
    private List<WebElement> items;

    @FindBy(xpath = "//*[contains(@class, 'dropdown-toggle') and contains(normalize-space(.), 'Service')]")
    private WebElement service;

    @FindBy(xpath = "//*[contains(@class, 'dropdown-menu')]/li/a[contains(normalize-space(.), 'Different elements')]")
    private WebElement differentElements;

    public Header(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> items() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(items));
            return items;
        } catch (Exception e) {
            return List.of();
        }
    }

    public Header openService() {
        wait.until(ExpectedConditions.elementToBeClickable(service));
        service.click();
        return this;
    }

    public DifferentElementsPage differentElementsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(differentElements));
        differentElements.click();
        return new DifferentElementsPage(driver, wait);
    }
}
