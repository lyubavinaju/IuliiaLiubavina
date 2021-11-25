package com.epam.tc.hw7;

import static com.epam.tc.hw7.pages.BasePage.header;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.pages.BasePage;
import com.epam.tc.hw7.pages.HomePage;
import com.epam.tc.hw7.pages.MetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    public static BasePage basePage;
    public static HomePage homePage;
    public static MetalsColorsPage metalsColorsPage;

    public static void login(User user) {
        if (!header.loginForm.isDisplayed()) {
            header.userIcon.click();
        }
        header.loginForm.loginAs(user);
    }

    public static void logout() {
        if (!header.logout.isDisplayed()) {
            header.userIcon.click();
        }
        header.logout.click();
    }
}
