package com.epam.tc.hw7.composite;

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
import org.hamcrest.core.StringContains;

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
        customRadioOdd.select(entity.getCustomRadioOdd());
        customRadioEven.select(entity.getCustomRadioEven());
        colors.select(entity.getColors());
        elements.select(entity.getElements());
        metals.select(entity.getMetals());
        Arrays.stream(entity.getVegetables()).forEach(v -> vegetables.select(v));
    }

    @Override
    public void check(MetalsColorsFormData entity) {
        customRadioOdd.is().selected(entity.getCustomRadioOdd());
        customRadioEven.is().selected(entity.getCustomRadioEven());
        colors.is().selected(entity.getColors());
        metals.is().selected(entity.getMetals());
        elements.is().checked(entity.getElements());
        vegetables.is().text(StringContains.containsString(String.join(", ", entity.getVegetables())));
    }
}
