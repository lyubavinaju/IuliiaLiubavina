package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.composite.MetalsColorsForm;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsColorsPage extends WebPage {

    @Css("form")
    public MetalsColorsForm form;

    @Css(".results li")
    public WebList result;
}
