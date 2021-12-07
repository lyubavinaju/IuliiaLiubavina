package com.epam.tc.hw7.composite;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;

public class Header extends Section {

    @Css("form")
    public LoginForm loginForm;

    @Css("img#user-icon")
    public UIElement userIcon;

    @Css(".profile-photo [ui=label]")
    public UIElement userName;

    @Css(".logout")
    public WebElement logout;

    @UI(".nav li")
    public Menu navigation;
}
