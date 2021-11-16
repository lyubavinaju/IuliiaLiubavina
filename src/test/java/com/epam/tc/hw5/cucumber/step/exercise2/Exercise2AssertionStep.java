package com.epam.tc.hw5.cucumber.step.exercise2;

import com.epam.tc.hw5.cucumber.step.common.AbstractBaseStep;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;

public class Exercise2AssertionStep extends AbstractBaseStep {
    private void checkCountOfElements(List<WebElement> elements, int count) {
        Assertions.assertThat(elements).hasSize(count);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        checkCountOfElements(userTablePage.dropdowns(), count);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        checkCountOfElements(userTablePage.users(), count);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        checkCountOfElements(userTablePage.usersDescriptions(), count);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        checkCountOfElements(userTablePage.checkboxes(), count);
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainFollowingValues(List<Map<String, String>> table) {
        List<String> expectedNumbers = new ArrayList<>();
        List<String> expectedUsers = new ArrayList<>();
        List<String> expectedDescriptions = new ArrayList<>();
        table.forEach(user -> {
            expectedNumbers.add(user.get("Number"));
            expectedUsers.add(user.get("User"));
            expectedDescriptions.add(user.get("Description"));
        });

        List<String> numbers = userTablePage.numbers().stream().map(WebElement::getText).collect(
            Collectors.toList());
        List<String> users = userTablePage.users().stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> descriptions =
            userTablePage.usersDescriptions().stream().map(d -> d.getAttribute("textContent")).collect(
                Collectors.toList());

        Assertions.assertThat(numbers).isEqualTo(expectedNumbers);
        Assertions.assertThat(users).isEqualTo(expectedUsers);
        Assertions.assertThat(descriptions).isEqualTo(expectedDescriptions);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(List<Map<String, String>> table) {
        List<String> expectedTypes = new ArrayList<>();
        table.forEach(m -> expectedTypes.add(m.get("Dropdown Values")));
        List<String> types =
            userTablePage.roman().types().stream().map(WebElement::getText).collect(Collectors.toList());
        Assertions.assertThat(types).isEqualTo(expectedTypes);
    }
}
