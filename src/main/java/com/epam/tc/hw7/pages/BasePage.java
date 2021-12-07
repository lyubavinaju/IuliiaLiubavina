package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.composite.Header;

public class BasePage extends WebPage {
    @Css("header")
    public static Header header;
}
