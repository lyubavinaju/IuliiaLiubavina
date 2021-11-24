package com.epam.tc.hw7.custom;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class Header extends Section {

    @UI(".nav li")
    public Menu navigation;
}
