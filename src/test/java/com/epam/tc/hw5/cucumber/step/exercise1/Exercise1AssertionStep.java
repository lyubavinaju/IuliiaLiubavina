package com.epam.tc.hw5.cucumber.step.exercise1;

import com.epam.tc.hw5.cucumber.step.common.AbstractBaseStep;
import io.cucumber.java.en.Then;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;

public class Exercise1AssertionStep extends AbstractBaseStep {

    @Then("I should be logged in as user {string}")
    public void shouldBeLoggedInAsUser(String username) {
        String actualUsername = header.username().orElseThrow();
        Assertions.assertThat(actualUsername).isEqualTo(username);
    }

    @Then("Checkbox {string} should be selected on Different elements page")
    public void checkboxShouldBeSelectedOnDifferentElementsPage(String checkbox) {
        Optional<WebElement> optionalCheckBox = differentElementsPage.findCheckBox(checkbox);
        Assertions.assertThat(optionalCheckBox).isPresent();
        Assertions.assertThat(optionalCheckBox.get().isSelected()).isTrue();
    }

    @Then("Value  {string} should be selected in radio on Different elements page")
    public void valueShouldBeSelectedInRadioOnDifferentElementsPage(String radio) {
        Optional<WebElement> optionalCheckBox = differentElementsPage.findRadio(radio);
        Assertions.assertThat(optionalCheckBox).isPresent();
        Assertions.assertThat(optionalCheckBox.get().isSelected()).isTrue();
    }

    @Then("Value {string} should be selected in dropdown on Different elements page")
    public void valueShouldBeSelectedInDropdownOnDifferentElementsPage(String dropdown) {
        Assertions.assertThat(differentElementsPage.selectedColor().orElseThrow())
                  .isEqualTo(dropdown);
    }
}
