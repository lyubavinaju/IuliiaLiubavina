package com.epam.tc.hw7;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.custom.Header;
import com.epam.tc.hw7.custom.LoginForm;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.pages.HomePage;
import com.epam.tc.hw7.pages.MetalsColorsPage;
import org.openqa.selenium.WebElement;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    public static HomePage homePage;
    public static MetalsColorsPage metalsColorsPage;

    @Css("form")
    public static LoginForm loginForm;

    @Css("header")
    public static Header header;

    @Css("img#user-icon")
    public static UIElement userIcon;

    @Css(".profile-photo [ui=label]")
    public static UIElement userName;

    @Css(".logout")
    public static WebElement logout;

    public static void login(User user) {
        if (!loginForm.isDisplayed()) {
            userIcon.click();
        }
        loginForm.loginAs(user);
    }

    public static void logout() {
        if (!logout.isDisplayed()) {
            userIcon.click();
        }
        logout.click();
    }
}
