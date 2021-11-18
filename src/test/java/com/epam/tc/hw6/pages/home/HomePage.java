package com.epam.tc.hw6.pages.home;

import com.epam.tc.hw6.pages.AbstractPage;
import com.epam.tc.hw6.pages.common.Header;
import com.epam.tc.hw6.pages.common.LeftMenu;
import java.util.List;
import java.util.Optional;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy(className = "benefit-txt")
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
        click(loginMenuButton);
        return this;
    }

    private HomePage enterName(String name) {
        waitForElementToBeClickable(this.name).ifPresent(n -> n.sendKeys(name));
        return this;
    }

    private HomePage enterPassword(String pass) {
        waitForElementToBeClickable(password).ifPresent(p -> p.sendKeys(pass));
        return this;
    }

    private HomePage submit() {
        click(submitButton);
        return this;
    }

    public HomePage login(String name, String pass) {
        return enterName(name).enterPassword(pass).submit();
    }

    public Optional<String> username() {
        return waitForVisibilityOf(username).map(WebElement::getText);
    }

    public List<WebElement> images() {
        return waitForVisibilityOf(images);
    }

    public List<WebElement> textsUnderImages() {
        return waitForVisibilityOf(textsUnderImages);
    }
}
