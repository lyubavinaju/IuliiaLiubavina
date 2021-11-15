package com.epam.tc.hw3.pages.home;

import com.epam.tc.hw3.pages.AbstractPage;
import com.epam.tc.hw3.pages.common.Header;
import com.epam.tc.hw3.pages.common.LeftMenu;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private final Header header;
    private final LeftMenu leftMenu;
    private final FrameWithButton frameWithButton;

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

    @FindBy(className = "icons-benefit")
    private List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textsUnderImages;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
        header = new Header(driver, this.wait);
        leftMenu = new LeftMenu(driver, this.wait);
        frameWithButton = new FrameWithButton(driver, this.wait);
    }

    public Header header() {
        return header;
    }

    public LeftMenu leftMenu() {
        return leftMenu;
    }

    public FrameWithButton frameWithButton() {
        return frameWithButton;
    }

    public HomePage openLoginMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(loginMenuButton));
        loginMenuButton.click();
        return this;
    }

    private HomePage enterName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(this.name));
        this.name.sendKeys(name);
        return this;
    }

    private HomePage enterPassword(String pass) {
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys(pass);
        return this;
    }

    private HomePage submit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
        return this;
    }

    public HomePage login(String name, String pass) {
        return enterName(name).enterPassword(pass).submit();
    }

    public String username() {
        try {
            wait.until(ExpectedConditions.visibilityOf(username));
            return username.getText();
        } catch (Exception e) {
            return null;
        }
    }

    public List<WebElement> images() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(images));
            return images;
        } catch (Exception e) {
            return List.of();
        }
    }

    public List<WebElement> textsUnderImages() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(textsUnderImages));
            return textsUnderImages;
        } catch (Exception e) {
            return List.of();
        }
    }
}
