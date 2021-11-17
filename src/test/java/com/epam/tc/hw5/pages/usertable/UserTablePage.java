package com.epam.tc.hw5.pages.usertable;

import com.epam.tc.hw5.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserTablePage extends BasePage {
    private final Ivan ivan;
    private final Roman roman;

    public Ivan ivan() {
        return ivan;
    }

    public Roman roman() {
        return roman;
    }

    @FindBy(tagName = "select")
    private List<WebElement> dropdowns;

    @FindBy(css = "#user-table a")
    private List<WebElement> users;

    @FindBy(css = ".user-descr > span")
    private List<WebElement> usersDescriptions;

    @FindBy(css = ".user-descr input[type=checkbox]")
    private List<WebElement> checkboxes;

    @FindBy(css = "#user-table tr > td:first-child")
    private List<WebElement> numbers;

    public UserTablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        ivan = new Ivan(driver);
        roman = new Roman(driver);
    }

    public List<WebElement> dropdowns() {
        return waitForVisibilityOf(dropdowns);
    }

    public List<WebElement> users() {
        return waitForVisibilityOf(users);
    }

    public List<WebElement> usersDescriptions() {
        return waitForVisibilityOf(usersDescriptions);
    }

    public List<WebElement> checkboxes() {
        return waitForVisibilityOf(checkboxes);
    }

    public List<WebElement> numbers() {
        return waitForVisibilityOf(numbers);
    }
}
