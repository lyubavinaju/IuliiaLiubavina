package com.epam.tc.hw5.cucumber.step.exercise1;

import com.epam.tc.hw5.cucumber.step.common.AbstractBaseStep;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class Exercise1Step extends AbstractBaseStep {

    @When("I select {string} checkbox on Different elements page")
    public void selectCheckboxOnDifferentElementsPage(String checkbox) {
        differentElementsPage.findCheckBox(checkbox).ifPresent(WebElement::click);
    }

    @When("I select {string} radio on Different elements page")
    public void selectRadioOnDifferentElementsPage(String radio) {
        differentElementsPage.findRadio(radio).ifPresent(WebElement::click);
    }

    @When("I select {string} in dropdown on Different elements page")
    public void selectInDropdownOnDifferentElementsPage(String color) {
        differentElementsPage.selectColor(color);
    }
}
