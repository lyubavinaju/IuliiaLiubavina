package com.epam.tc.hw7.custom;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.MetalsColorsFormData;
import java.util.Arrays;

public class MetalsColorsForm extends Form<MetalsColorsFormData> {

    @FindBy(name = "custom_radio_odd")
    public RadioButtons customRadioOdd;

    @FindBy(name = "custom_radio_even")
    public RadioButtons customRadioEven;

    @JDropdown(root = "#colors",
               value = ".filter-option",
               list = ".text",
               expand = ".caret")
    public Dropdown colors;

    @Css("#elements-block input")
    public Checklist elements;

    @Css(".metals input")
    public DataListOptions metals;

    @JDropdown(root = "#vegetables",
               value = "button",
               list = "label",
               expand = ".caret")
    public Dropdown vegetables;

    @FindBy(id = "submit-button")
    public Button submit;

    @Override
    public void fill(MetalsColorsFormData entity) {
        customRadioOdd.select(entity.customRadioOdd);
        customRadioEven.select(entity.customRadioEven);
        colors.select(entity.colors);
        elements.select(entity.elements);
        metals.select(entity.metals);
        Arrays.stream(entity.vegetables).forEach(v -> vegetables.select(v));
    }
}
