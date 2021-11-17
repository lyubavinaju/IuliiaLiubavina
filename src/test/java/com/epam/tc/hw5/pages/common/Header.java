package com.epam.tc.hw5.pages.common;

import com.epam.tc.hw5.pages.BasePage;
import com.epam.tc.hw5.pages.diffelements.DifferentElementsPage;
import com.epam.tc.hw5.pages.usertable.UserTablePage;
import java.util.Optional;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends BasePage {
    private static final String DIFF_ELEMENTS = "Different Elements";
    private static final String USER_TABLE = "User Table";

    @FindBy(className = "uui-profile-menu")
    private WebElement loginMenuButton;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className = "uui-button")
    private WebElement submitButton;

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(css = ".m-l8 .dropdown-toggle")
    private WebElement service;

    @FindBy(css = ".m-l8 a[href^='different-elements']")
    private WebElement differentElements;

    @FindBy(css = ".m-l8 a[href^='user-table']")
    private WebElement userTable;

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Header openLoginMenu() {
        click(loginMenuButton);
        return this;
    }

    private Header enterName(String name) {
        waitForElementToBeClickable(this.name).ifPresent(n -> n.sendKeys(name));
        return this;
    }

    private Header enterPassword(String pass) {
        waitForElementToBeClickable(password).ifPresent(p -> p.sendKeys(pass));
        return this;
    }

    private Header submit() {
        click(submitButton);
        return this;
    }

    public Header login(String name, String pass) {
        return enterName(name).enterPassword(pass).submit();
    }

    public Optional<String> username() {
        return waitForVisibilityOf(username).map(WebElement::getText);
    }

    public Header openService() {
        click(service);
        return this;
    }

    public DifferentElementsPage differentElementsPage() {
        click(differentElements);
        return new DifferentElementsPage(driver);
    }

    public UserTablePage userTablePage() {
        click(userTable);
        return new UserTablePage(driver);
    }

    public BasePage clickToPage(String pageName) {
        switch (pageName.trim()) {
            case DIFF_ELEMENTS:
                return differentElementsPage();
            case USER_TABLE:
                return userTablePage();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
